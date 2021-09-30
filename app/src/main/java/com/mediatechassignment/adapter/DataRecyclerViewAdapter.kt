package com.mediatechassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mediatechassignment.base.BaseRecyclerAdapter
import com.mediatechassignment.base.BaseViewHolder
import com.mediatechassignment.databinding.DataItemLayoutBinding
import com.mediatechassignment.model.DataListModel

class DataRecyclerViewAdapter(
) : BaseRecyclerAdapter<DataListModel>() {

    // start OVERRIDDEN
    override fun createBaseViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<DataListModel> {
        return DataViewHolder(
            DataItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }
    //endregion
}