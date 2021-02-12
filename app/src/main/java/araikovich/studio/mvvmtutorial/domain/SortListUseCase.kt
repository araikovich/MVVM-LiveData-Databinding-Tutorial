package araikovich.studio.mvvmtutorial.domain

import araikovich.studio.mvvmtutorial.ui.model.GitHubReposUIModel

class SortListUseCase {

    fun execute(list: MutableList<GitHubReposUIModel>): List<GitHubReposUIModel> {
        list.sortByDescending { it.id }
        return list
    }
}