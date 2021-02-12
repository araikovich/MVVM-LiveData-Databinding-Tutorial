package araikovich.studio.mvvmtutorial.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import araikovich.studio.mvvmtutorial.data.mapper.GitHubReposResponseToModelMapper
import araikovich.studio.mvvmtutorial.data.repository.impl.GitHubReposRepositoryImpl
import araikovich.studio.mvvmtutorial.datasource.GitHubReposRemoteDataSource
import araikovich.studio.mvvmtutorial.domain.GetGitHubReposUseCase
import araikovich.studio.mvvmtutorial.domain.SortListUseCase
import araikovich.studio.mvvmtutorial.domain.mapper.GitHubReposModelToUIMapper
import araikovich.studio.mvvmtutorial.ui.model.GitHubReposUIModel
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {

    val reposLiveData = MutableLiveData<List<GitHubReposUIModel>>()

    val getGitHubReposUseCase: GetGitHubReposUseCase = GetGitHubReposUseCase(
        GitHubReposRepositoryImpl(
            GitHubReposRemoteDataSource(
                Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .addConverterFactory(
                        GsonConverterFactory.create(
                            GsonBuilder().setLenient().create()
                        )
                    )
                    .build()
            ),
            GitHubReposResponseToModelMapper()
        ),
        GitHubReposModelToUIMapper()
    )

    val sortUseCase = SortListUseCase()

    fun getGitHubRepos() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getGitHubReposUseCase.execute()
            withContext(Dispatchers.Main) {
                result?.also { repos ->
                    reposLiveData.postValue(repos)
                }
            }
        }
    }

    fun sortList() {
        reposLiveData.postValue(sortUseCase.execute(reposLiveData.value as MutableList))
    }
}