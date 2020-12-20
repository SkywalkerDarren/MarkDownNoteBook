package io.github.skywalkerdarren.markdownnotebook.ui.trash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import io.github.skywalkerdarren.markdownnotebook.databinding.FragmentTrashBinding
import io.github.skywalkerdarren.markdownnotebook.ui.base.BaseFragment

class TrashFragment : BaseFragment() {

    private val trashViewModel by viewModels<TrashViewModel>()
    private lateinit var binding: FragmentTrashBinding
    override val TAG = "TrashFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTrashBinding.inflate(layoutInflater, container, false)
        trashViewModel.liveData.observe(viewLifecycleOwner, ::handleViewState)
        return binding.root
    }

    private fun handleViewState(viewState: TrashViewState) {
        viewState.text?.handleIfNotHandled {
            binding.textGallery.text = it
        }
    }
}