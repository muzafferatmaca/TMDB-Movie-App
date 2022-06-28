package com.muzafferatmaca.tmdb_movie_app.utils

import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

fun hideSoftKeyboard(fragment: Fragment) {
    if (fragment.activity!!.getCurrentFocus() == null){
        return
    }
    val inputMethodManager = fragment.activity!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(fragment.activity!!.getCurrentFocus()!!.getWindowToken(), 0)
}