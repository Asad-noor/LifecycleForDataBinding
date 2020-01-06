package com.example.lifecyclefordatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.lifecyclefordatabinding.databinding.ActivityMainBinding
import com.example.lifecyclefordatabinding.util.inTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).let {
            it.setLifecycleOwner(this)
            it.viewModel = viewModel
        }

        btn_test.setOnClickListener {
            addTestFragment()
        }
    }

    private fun addTestFragment() {
        supportFragmentManager.inTransaction({
            add(R.id.fragment_container, TestFragment(), "testFragment")
        }, isAddToBack = false)
    }
}
