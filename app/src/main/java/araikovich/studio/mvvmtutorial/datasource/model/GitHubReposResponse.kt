package araikovich.studio.mvvmtutorial.datasource.model

import com.google.gson.annotations.SerializedName

data class GitHubRepoResponse(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("owner") val owner: GitGubRepoOwnerResponse? = null
)

data class GitGubRepoOwnerResponse(
    @SerializedName("avatar_url") val avatarUrl: String? = null,
    @SerializedName("login") val login: String? = null
)