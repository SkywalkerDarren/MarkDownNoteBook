package io.github.skywalkerdarren.markdownnotebook.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import io.github.skywalkerdarren.markdownnotebook.databinding.ActivityDetailBinding
import io.github.skywalkerdarren.markdownnotebook.ui.base.BaseActivity

class DetailActivity : BaseActivity() {
    private val viewModel by viewModels<DetailViewModel>()
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}