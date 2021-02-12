package araikovich.studio.mvvmtutorial.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import araikovich.studio.mvvmtutorial.R
import araikovich.studio.mvvmtutorial.databinding.ActivityMainBinding
import araikovich.studio.mvvmtutorial.ui.adapter.GitHubReposAdapter
import araikovich.studio.mvvmtutorial.ui.model.GitHubReposUIModel

/**
 *
 */
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private var adapter: GitHubReposAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        observeGitHubRepos()
        setupAdapter()
        setupListeners()
        viewModel.getGitHubRepos()
    }

    private fun observeGitHubRepos() {
        viewModel.reposLiveData.observe(this, Observer {
            updateGitHubRepos(it)
        })
    }

    private fun setupAdapter() {
        adapter = GitHubReposAdapter()
        binding.rvRepos.adapter = adapter
        binding.rvRepos.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun updateGitHubRepos(items: List<GitHubReposUIModel>) {
        adapter?.updateAdapter(items)
    }

    private fun setupListeners() {
        binding.btnSort.setOnClickListener {
            viewModel.sortList()
        }
    }
}