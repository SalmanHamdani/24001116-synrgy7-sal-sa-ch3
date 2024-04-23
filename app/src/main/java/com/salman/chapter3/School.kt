package com.salman.chapter3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class School(val name: String, val imageUrl: String, val description: String) : Parcelable
