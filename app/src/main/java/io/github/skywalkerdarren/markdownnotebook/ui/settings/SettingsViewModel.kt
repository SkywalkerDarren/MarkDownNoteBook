package io.github.skywalkerdarren.markdownnotebook.ui.settings

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.liveData
import io.github.skywalkerdarren.markdownnotebook.model.Event
import io.github.skywalkerdarren.markdownnotebook.ui.base.BaseViewModel

class SettingsViewModel(private val state: SavedStateHandle) : BaseViewModel() {

    private val mLiveData = MutableLiveData<SettingsViewState>()
    private var mViewState = SettingsViewState(
        text = Event("This is settings Fragment")
    )
    val liveData = liveData {
        mLiveData.value = mViewState
        emitSource(mLiveData)
    }
}