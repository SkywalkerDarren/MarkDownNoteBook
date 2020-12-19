package io.github.skywalkerdarren.markdownnotebook.ui.notes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.liveData
import io.github.skywalkerdarren.markdownnotebook.model.Event
import io.github.skywalkerdarren.markdownnotebook.ui.base.BaseViewModel

class NotesViewModel(private val state: SavedStateHandle) : BaseViewModel() {

    private val mLiveData = MutableLiveData<NotesViewState>()
    private var mViewState = NotesViewState(
        text = Event("This is notes Fragment")
    )
    val text = liveData {
        mLiveData.value = mViewState
        emitSource(mLiveData)
    }
}