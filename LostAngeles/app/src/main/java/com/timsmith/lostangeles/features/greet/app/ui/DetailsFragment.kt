package com.timsmith.lostangeles.features.greet.app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.timsmith.lostangeles.R
import com.timsmith.lostangeles.databinding.TripDetailsBinding

class DetailsFragment: Fragment() {
    lateinit var binding: TripDetailsBinding
    val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  DataBindingUtil.inflate(inflater, R.layout.trip_details, container, false)
        binding.trip = args.Trip
        return binding.root
    }
}