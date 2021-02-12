package araikovich.studio.mvvmtutorial.domain

import araikovich.studio.mvvmtutorial.data.mapper.GitHubReposResponseToModelMapper
import araikovich.studio.mvvmtutorial.data.repository.GitHubReposRepository
import araikovich.studio.mvvmtutorial.domain.mapper.GitHubReposModelToUIMapper
import araikovich.studio.mvvmtutorial.ui.model.GitHubReposUIModel

class GetGitHubReposUseCase(
    private val gitHubReposRepository: GitHubReposRepository,
    private val gitHubReposModelToUIMapper: GitHubReposModelToUIMapper
) {

    suspend fun execute(): List<GitHubReposUIModel>? {
        return gitHubReposModelToUIMapper.map(gitHubReposRepository.getRepos())
    }
}