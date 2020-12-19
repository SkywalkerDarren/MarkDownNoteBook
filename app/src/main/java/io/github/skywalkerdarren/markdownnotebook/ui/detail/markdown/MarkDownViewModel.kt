package io.github.skywalkerdarren.markdownnotebook.ui.detail.markdown

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.liveData
import io.github.skywalkerdarren.markdownnotebook.ui.base.BaseViewModel

class MarkDownViewModel(private val state: SavedStateHandle) : BaseViewModel() {
    private val mLiveData = MutableLiveData<MarkDownViewState>()
    private var mViewState = MarkDownViewState()
    val liveData = liveData {
        mLiveData.value = mViewState
        emitSource(mLiveData)
    }
}