package com.mediatechassignment.base

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import java.util.*

abstract class BaseActivity<VDB : ViewDataBinding, BVM : BaseViewModel<*>> :
    AppCompatActivity() {

    lateinit var injectedViewModel: BVM

    lateinit var viewDataBinding: VDB

    abstract val viewModel: Class<BVM>

    abstract fun getBindingVariable(): Int

    @get:LayoutRes
    abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        executeDataBinding()
        initUserInterface()
    }

    /**
     * method to hide keyboard
     */
    fun hideKeyboardFrom(context: Context, view: View) {
        val imm: InputMethodManager =
            context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun applyOverrideConfiguration(overrideConfiguration: Configuration) {
        val locale = Locale("en")
        overrideConfiguration.setLocale(locale)
        super.applyOverrideConfiguration(overrideConfiguration)
    }

    protected abstract fun initUserInterface()

    fun executeDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, layoutId)
        injectedViewModel = ViewModelProvider(this).get(viewModel)
        viewDataBinding.setVariable(getBindingVariable(), injectedViewModel)
        viewDataBinding.executePendingBindings()
    }
}