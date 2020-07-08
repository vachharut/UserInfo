package info.user.utils

import androidx.appcompat.app.AppCompatActivity
import info.user.app.App

val AppCompatActivity.app get() = application as App
