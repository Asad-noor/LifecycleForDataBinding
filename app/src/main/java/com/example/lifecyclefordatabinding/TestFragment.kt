package com.example.lifecyclefordatabinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.lifecyclefordatabinding.databinding.FragmentTestBinding

class TestFragment: Fragment() {

    private val viewModel: TestFragmentViewModel by lazy { ViewModelProviders.of(this).get(TestFragmentViewModel::class.java) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
        DataBindingUtil.inflate<FragmentTestBinding>(
            inflater,
            R.layout.fragment_test,
            container,
            false).also {

        it.setLifecycleOwner(this)
        it.viewModel = viewModel
    }.root
}