package araikovich.studio.mvvmtutorial.datasource

import araikovich.studio.mvvmtutorial.datasource.api.GitHubReposApi
import retrofit2.Retrofit

class GitHubReposRemoteDataSource(private val retrofit: Retrofit) {

    fun getGitHubRepos() =
        retrofit.create(GitHubReposApi::class.java).getReposByName().execute().body()
}