package com.muzafferatmaca.tmdb_movie_app.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.muzafferatmaca.tmdb_movie_app.MainActivity
import com.muzafferatmaca.tmdb_movie_app.R

abstract class BaseFragment<binding : ViewDataBinding> : Fragment() {

    abstract val layoutId: Int
    lateinit var binding: binding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (::binding.isInitialized) {
            return binding.root
        }
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pageSettings()
    }

    private fun pageSettings() {  with(activity as MainActivity) {
            when (layoutId) {
                R.layout.fragment_home -> {

                }
                R.layout.fragment_movie_detail -> {

                }
                R.layout.fragment_person_detail -> {

                }
                R.layout.fragment_splash -> {

                }
            }
        }
    }


}