package com.salman.chapter3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class School(var image: Int, val name: String) : Parcelable
