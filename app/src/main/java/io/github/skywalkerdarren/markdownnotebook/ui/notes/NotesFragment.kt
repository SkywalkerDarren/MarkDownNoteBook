package io.github.skywalkerdarren.markdownnotebook.ui.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import io.github.skywalkerdarren.markdownnotebook.databinding.FragmentNotesBinding
import io.github.skywalkerdarren.markdownnotebook.ui.base.BaseFragment

class NotesFragment : BaseFragment() {

    private val homeViewModel by viewModels<NotesViewModel>()
    private var binding: FragmentNotesBinding? = null
    override val TAG = "NotesFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotesBinding.inflate(layoutInflater, container, false)
        homeViewModel.text.observe(viewLifecycleOwner, ::handleViewState)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.rvNotes?.adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun handleViewState(viewState: NotesViewState) {
        viewState.text?.handleIfNotHandled {
            binding?.textHome?.text = it
        }
    }
}