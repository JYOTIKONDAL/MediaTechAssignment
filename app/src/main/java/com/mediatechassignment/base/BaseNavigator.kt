package com.mediatechassignment.base

import com.mediatechassignment.extensions.empty

interface BaseNavigator {

    fun prepareAlert(title: Int, messageResourceId: Int = 0, message: String = String.empty) {}
    fun setProgressVisibility(visibility: Int) {}

}