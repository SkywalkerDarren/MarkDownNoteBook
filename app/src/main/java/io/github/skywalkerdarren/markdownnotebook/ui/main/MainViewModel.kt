package io.github.skywalkerdarren.markdownnotebook.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.liveData
import io.github.skywalkerdarren.markdownnotebook.ui.base.BaseViewModel

class MainViewModel(private val state: SavedStateHandle) : BaseViewModel() {
    private val mLiveData = MutableLiveData<MainViewState>()
    private var mViewState = MainViewState()
    val liveData = liveData {
        mLiveData.value = mViewState
        emitSource(mLiveData)
    }
}