package araikovich.studio.mvvmtutorial.domain.mapper

import araikovich.studio.mvvmtutorial.R
import araikovich.studio.mvvmtutorial.data.model.GitHubRepoModel
import araikovich.studio.mvvmtutorial.ui.model.GitHubReposUIModel

class GitHubReposModelToUIMapper {

    fun map(models: List<GitHubRepoModel>?): List<GitHubReposUIModel>? {
        return models?.let {
            models.map {
                GitHubReposUIModel(
                    it.id,
                    it.name,
                    it.description,
                    it.avatarUrl,
                    it.login,
                    R.drawable.ic_launcher_foreground
                )
            }
        }
    }
}