package io.github.skywalkerdarren.markdownnotebook.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.liveData
import io.github.skywalkerdarren.markdownnotebook.ui.base.BaseViewModel

class DetailViewModel(private val state: SavedStateHandle) : BaseViewModel() {
    private val mLiveData = MutableLiveData<DetailViewState>()
    private var mViewState = DetailViewState()
    val liveData = liveData {
        mLiveData.value = mViewState
        emitSource(mLiveData)
    }
}