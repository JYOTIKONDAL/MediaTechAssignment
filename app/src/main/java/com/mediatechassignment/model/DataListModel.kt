package com.mediatechassignment.model

import com.mediatechassignment.extensions.empty

data class DataListModel(
    var image: Int = 0,
    var labelName: String = String.empty,
    var mainImage: Int = 0,
    var position: Int = 0
)