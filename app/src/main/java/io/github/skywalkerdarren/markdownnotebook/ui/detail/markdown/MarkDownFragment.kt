package io.github.skywalkerdarren.markdownnotebook.ui.detail.markdown

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import io.github.skywalkerdarren.markdownnotebook.databinding.FragmentMarkDownBinding
import io.github.skywalkerdarren.markdownnotebook.ui.base.BaseFragment

class MarkDownFragment : BaseFragment() {

    companion object {
        fun newInstance() = MarkDownFragment()
    }

    private val viewModel by viewModels<MarkDownViewModel>()
    private lateinit var binding: FragmentMarkDownBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMarkDownBinding.inflate(inflater, container, false)
        return binding.root
    }
}