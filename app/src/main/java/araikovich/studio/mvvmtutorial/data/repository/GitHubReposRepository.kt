package araikovich.studio.mvvmtutorial.data.repository

import araikovich.studio.mvvmtutorial.data.model.GitHubRepoModel

interface GitHubReposRepository {

    fun getRepos(): List<GitHubRepoModel>?
}