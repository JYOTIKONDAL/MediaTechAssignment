package com.mediatechassignment.ui

import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.mediatechassignment.BR
import com.mediatechassignment.R
import com.mediatechassignment.adapter.DataImagesAdapter
import com.mediatechassignment.adapter.DataRecyclerViewAdapter
import com.mediatechassignment.base.BaseActivity
import com.mediatechassignment.databinding.ActivityMainBinding
import com.mediatechassignment.model.DataListModel
import com.mediatechassignment.navigator.MainActivityNavigator
import com.mediatechassignment.viewmodel.MainActivityViewModel


class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>(),
    MainActivityNavigator {
    private var productImagesAdapter: DataImagesAdapter? = null
    private var dataList: ArrayList<DataListModel> = ArrayList()
    private var linearLayoutManager: LinearLayoutManager? = null
    private var dataRecyclerViewAdapter: DataRecyclerViewAdapter? = null
    private var selectedListToDisplay: ArrayList<DataListModel> = ArrayList()
    private var uniqueImagesList: ArrayList<DataListModel> = ArrayList()
    private var filteredList: ArrayList<DataListModel> = ArrayList()

    override val viewModel: Class<MainActivityViewModel>
        get() = MainActivityViewModel::class.java

    override fun getBindingVariable(): Int {
        return BR.mainViewModel
    }

    override val layoutId: Int
        get() = R.layout.activity_main

    override fun initUserInterface() {
        injectedViewModel.setNavigator(this)
        makeADynamicList()
        setAdapter()
        setListeners()
    }

    private fun setAdapter() {
        //set view pager adater
        uniqueImagesList.addAll(dataList.distinctBy { it.mainImage })
        productImagesAdapter = DataImagesAdapter(this, uniqueImagesList)
        viewDataBinding.viewPager.adapter = productImagesAdapter
        viewDataBinding.tabLayout.setupWithViewPager(viewDataBinding.viewPager, true)

        // seta data listing adapter
        dataRecyclerViewAdapter = DataRecyclerViewAdapter()
        viewDataBinding.dataListing.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            linearLayoutManager = layoutManager as LinearLayoutManager
            adapter = dataRecyclerViewAdapter
        }

        viewDataBinding.viewPager.setCurrentItem(0, false)
        selectedListToDisplay.addAll(dataList.filter { it.position == 0 })
        dataRecyclerViewAdapter?.setItems(selectedListToDisplay)
    }

    /**
     * method to set listeners
     */
    private fun setListeners() {
        viewDataBinding.viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                selectedListToDisplay = ArrayList()
                selectedListToDisplay.addAll(dataList.filter { it.position == position })
                dataRecyclerViewAdapter?.setItems(selectedListToDisplay)
            }
        })

        viewDataBinding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String): Boolean {
                filteredList = ArrayList()
                if (s != "") {
                    filteredList.addAll(selectedListToDisplay.filter { it.labelName.contains(s,ignoreCase = true) })
                    dataRecyclerViewAdapter?.setItems(filteredList)
                } else {
                    dataRecyclerViewAdapter?.setItems(selectedListToDisplay)
                }
                return false
            }

            override fun onQueryTextChange(s: String): Boolean {
                if (s == "") {
                    dataRecyclerViewAdapter?.setItems(selectedListToDisplay)
                }
                return false
            }
        })
    }

    /**
     * method to generate a dynamic list
     */
    private fun makeADynamicList() {
        var data1 = DataListModel(
            R.drawable.ic_launcher_background,
            resources.getString(R.string.labelA1),
            R.drawable.first_background,
            0
        )
        dataList.add(data1)
        data1 = DataListModel(
            R.drawable.ic_launcher_background,
            resources.getString(R.string.labelA2),
            R.drawable.first_background,
            0
        )
        dataList.add(data1)
        data1 = DataListModel(
            R.drawable.ic_launcher_background,
            resources.getString(R.string.labelA3),
            R.drawable.first_background,
            0
        )
        dataList.add(data1)
        data1 = DataListModel(
            R.drawable.ic_launcher_background,
            resources.getString(R.string.labelA4),
            R.drawable.first_background,
            0
        )
        dataList.add(data1)
        data1 = DataListModel(
            R.drawable.ic_launcher_background,
            resources.getString(R.string.labelA5),
            R.drawable.first_background,
            0
        )
        dataList.add(data1)

        data1 = DataListModel(
            R.drawable.ic_launcher_background,
            resources.getString(R.string.labelB1),
            R.drawable.second_background,
            1
        )
        dataList.add(data1)
        data1 = DataListModel(
            R.drawable.ic_launcher_background,
            resources.getString(R.string.labelB2),
            R.drawable.second_background,
            1
        )
        dataList.add(data1)
        data1 = DataListModel(
            R.drawable.ic_launcher_background,
            resources.getString(R.string.labelB3),
            R.drawable.second_background,
            1
        )
        dataList.add(data1)
        data1 = DataListModel(
            R.drawable.ic_launcher_background,
            resources.getString(R.string.labelB4),
            R.drawable.second_background,
            1
        )
        dataList.add(data1)
        data1 = DataListModel(
            R.drawable.ic_launcher_background,
            resources.getString(R.string.labelB5),
            R.drawable.second_background,
            1
        )
        dataList.add(data1)

        data1 = DataListModel(
            R.drawable.ic_launcher_background,
            resources.getString(R.string.labelC1),
            R.drawable.third_background,
            2
        )
        dataList.add(data1)
        data1 = DataListModel(
            R.drawable.ic_launcher_background,
            resources.getString(R.string.labelC2),
            R.drawable.third_background,
            2
        )
        dataList.add(data1)
        data1 = DataListModel(
            R.drawable.ic_launcher_background,
            resources.getString(R.string.labelC3),
            R.drawable.third_background,
            2
        )
        dataList.add(data1)
        data1 = DataListModel(
            R.drawable.ic_launcher_background,
            resources.getString(R.string.labelC4),
            R.drawable.third_background,
            2
        )
        dataList.add(data1)
        data1 = DataListModel(
            R.drawable.ic_launcher_background,
            resources.getString(R.string.labelC5),
            R.drawable.third_background,
            2
        )
        dataList.add(data1)
    }
}