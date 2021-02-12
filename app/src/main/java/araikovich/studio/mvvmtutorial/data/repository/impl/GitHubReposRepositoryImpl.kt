package araikovich.studio.mvvmtutorial.data.repository.impl

import araikovich.studio.mvvmtutorial.data.mapper.GitHubReposResponseToModelMapper
import araikovich.studio.mvvmtutorial.data.model.GitHubRepoModel
import araikovich.studio.mvvmtutorial.data.repository.GitHubReposRepository
import araikovich.studio.mvvmtutorial.datasource.GitHubReposRemoteDataSource

class GitHubReposRepositoryImpl(
    private val remoteDataSource: GitHubReposRemoteDataSource,
    private val gitHubReposResponseToModelMapper: GitHubReposResponseToModelMapper
) : GitHubReposRepository {

    override fun getRepos(): List<GitHubRepoModel>? {
        return gitHubReposResponseToModelMapper.map(remoteDataSource.getGitHubRepos().orEmpty())
    }
}