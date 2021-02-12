package araikovich.studio.mvvmtutorial.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import araikovich.studio.mvvmtutorial.R
import araikovich.studio.mvvmtutorial.databinding.ViewHolderGitHubRepoBinding
import araikovich.studio.mvvmtutorial.ui.model.GitHubReposUIModel

class GitHubReposAdapter : RecyclerView.Adapter<GitHubRepoViewHolder>() {

    private val items = mutableListOf<GitHubReposUIModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        GitHubRepoViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_git_hub_repo, parent, false)
        )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: GitHubRepoViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun updateAdapter(newList: List<GitHubReposUIModel>) {
        items.clear()
        items.addAll(newList)
        notifyDataSetChanged()
    }
}

class GitHubRepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = DataBindingUtil.bind<ViewHolderGitHubRepoBinding>(view)!!

    fun bind(model: GitHubReposUIModel) {
        binding.gitHubRepo = model
    }
}