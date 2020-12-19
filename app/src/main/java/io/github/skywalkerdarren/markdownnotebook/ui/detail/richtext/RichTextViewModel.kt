package io.github.skywalkerdarren.markdownnotebook.ui.detail.richtext

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.liveData
import io.github.skywalkerdarren.markdownnotebook.ui.base.BaseViewModel

class RichTextViewModel(private val state: SavedStateHandle) : BaseViewModel() {
    private val mLiveData = MutableLiveData<RichTextViewState>()
    private var mViewState = RichTextViewState()
    val liveData = liveData {
        mLiveData.value = mViewState
        emitSource(mLiveData)
    }
}