package araikovich.studio.mvvmtutorial.data.model

import com.google.gson.annotations.SerializedName

data class GitHubRepoModel(
    val id: Int,
    val name: String,
    val description: String,
    val avatarUrl: String,
    val login: String
)