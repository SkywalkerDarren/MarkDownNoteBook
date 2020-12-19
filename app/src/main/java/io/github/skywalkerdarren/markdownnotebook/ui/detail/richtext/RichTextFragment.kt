package io.github.skywalkerdarren.markdownnotebook.ui.detail.richtext

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import io.github.skywalkerdarren.markdownnotebook.databinding.FragmentRichTextBinding
import io.github.skywalkerdarren.markdownnotebook.ui.base.BaseFragment

class RichTextFragment : BaseFragment() {

    companion object {
        fun newInstance() = RichTextFragment()
    }

    private val viewModel by viewModels<RichTextViewModel>()
    private lateinit var binding: FragmentRichTextBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRichTextBinding.inflate(inflater, container, false)
        return binding.root
    }
}