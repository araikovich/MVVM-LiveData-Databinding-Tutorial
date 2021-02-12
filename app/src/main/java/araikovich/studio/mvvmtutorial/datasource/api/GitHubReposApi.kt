package araikovich.studio.mvvmtutorial.datasource.api

import araikovich.studio.mvvmtutorial.datasource.model.GitHubRepoResponse
import retrofit2.Call
import retrofit2.http.GET

interface GitHubReposApi {

    @GET("orgs/square/repos")
    fun getReposByName(): Call<List<GitHubRepoResponse>>
}