package com.syawal.androidbeginnersubmissionapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Teams(
    val name: String,
    val photo: String,
    val desc: String,
) : Parcelable
