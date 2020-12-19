package io.github.skywalkerdarren.markdownnotebook.ui.trash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.liveData
import io.github.skywalkerdarren.markdownnotebook.model.Event
import io.github.skywalkerdarren.markdownnotebook.ui.base.BaseViewModel

class TrashViewModel(private val state: SavedStateHandle) : BaseViewModel() {

    private val mLiveData = MutableLiveData<TrashViewState>()
    private var mViewState = TrashViewState(
        text = Event("This is trash Fragment")
    )
    val liveData = liveData {
        mLiveData.value = mViewState
        emitSource(mLiveData)
    }
}