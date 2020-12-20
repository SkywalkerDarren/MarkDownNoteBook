package io.github.skywalkerdarren.markdownnotebook.ui.base

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    protected open val TAG = "BaseFragment"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}