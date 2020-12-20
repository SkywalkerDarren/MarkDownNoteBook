package io.github.skywalkerdarren.markdownnotebook.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import io.github.skywalkerdarren.markdownnotebook.databinding.FragmentSettingsBinding
import io.github.skywalkerdarren.markdownnotebook.ui.base.BaseFragment

class SettingsFragment : BaseFragment() {

    private val settingsViewModel by viewModels<SettingsViewModel>()
    private lateinit var binding: FragmentSettingsBinding
    override val TAG = "SettingsFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(layoutInflater, container, false)
        settingsViewModel.liveData.observe(viewLifecycleOwner, ::handleViewState)
        return binding.root
    }

    private fun handleViewState(viewState: SettingsViewState) {
        viewState.text?.handleIfNotHandled {
            binding.textSlideshow.text = it
        }
    }
}