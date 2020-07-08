package info.user.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

val Fragment.app get() = appCompatActivity.app

val Fragment.appCompatActivity get() = activity as AppCompatActivity
