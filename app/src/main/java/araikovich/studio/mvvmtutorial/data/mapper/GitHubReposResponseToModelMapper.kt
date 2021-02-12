package araikovich.studio.mvvmtutorial.data.mapper

import araikovich.studio.mvvmtutorial.data.model.GitHubRepoModel
import araikovich.studio.mvvmtutorial.datasource.model.GitHubRepoResponse
import araikovich.studio.mvvmtutorial.domain.utils.orZero

class GitHubReposResponseToModelMapper {

    fun map(responses: List<GitHubRepoResponse>?): List<GitHubRepoModel>? {
        return responses?.let {
            responses.map {
                GitHubRepoModel(
                    it.id.orZero(),
                    it.name.orEmpty(),
                    it.description.orEmpty(),
                    it.owner?.avatarUrl.orEmpty(),
                    it.owner?.login.orEmpty()
                )
            }
        }
    }
}