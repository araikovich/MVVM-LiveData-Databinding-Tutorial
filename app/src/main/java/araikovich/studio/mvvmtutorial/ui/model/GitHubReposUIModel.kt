package araikovich.studio.mvvmtutorial.ui.model

data class GitHubReposUIModel(
    val id: Int,
    val name: String,
    val description: String,
    val avatarUrl: String,
    val login: String,
    val backgroundRes: Int
)