package com.mediatechassignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.PagerAdapter
import com.mediatechassignment.R
import com.mediatechassignment.model.DataListModel
import java.util.*

class DataImagesAdapter(
    private var context: Context,
    private var arrayList: ArrayList<DataListModel>?
) : PagerAdapter() {

    override fun getCount(): Int {
        return arrayList?.size ?: 0
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView: View = layoutInflater.inflate(R.layout.images_item_layout, container, false)!!
        val imageView = itemView.findViewById<ImageView>(R.id.image)
        if (arrayList?.get(position)?.mainImage != 0) {
            imageView.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    arrayList?.get(position)?.mainImage!!
                )
            )
        }
        container.addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }

}