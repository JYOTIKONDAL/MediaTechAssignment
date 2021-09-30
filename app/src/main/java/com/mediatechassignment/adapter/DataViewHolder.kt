package com.mediatechassignment.adapter

import androidx.core.content.ContextCompat
import com.mediatechassignment.base.BaseViewHolder
import com.mediatechassignment.databinding.DataItemLayoutBinding
import com.mediatechassignment.databinding.ImagesItemLayoutBinding
import com.mediatechassignment.model.DataListModel


class DataViewHolder(
    private var dataItemLayoutBinding: DataItemLayoutBinding
) : BaseViewHolder<DataListModel>(dataItemLayoutBinding.root) {

    override fun bindItem(item: DataListModel) {
        dataItemLayoutBinding.image.setImageDrawable(
            ContextCompat.getDrawable(
                containerView.context,
                item.image
            )
        )
        dataItemLayoutBinding.textLabel.text = item.labelName
    }

}