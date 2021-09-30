package com.mediatechassignment.base

import android.view.View

interface ItemClickListener {
    fun onItemClick(position: Int, view: View)
    fun onItemLongClick(position: Int, view: View)
}