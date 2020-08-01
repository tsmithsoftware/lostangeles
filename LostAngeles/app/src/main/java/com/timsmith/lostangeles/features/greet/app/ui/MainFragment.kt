package com.timsmith.lostangeles.features.greet.app.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.timsmith.lostangeles.R
import com.timsmith.lostangeles.databinding.MainFragmentBinding
import com.timsmith.lostangeles.features.greet.app.Cart
import com.timsmith.lostangeles.features.greet.app.models.Ledger
import com.timsmith.lostangeles.features.greet.app.models.MainGate
import com.timsmith.lostangeles.features.greet.app.viewmodels.MainViewModel
import java.util.*
import javax.inject.Inject

class MainFragment : Fragment() {

    @Inject
    lateinit var mainViewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        binding.message.setOnClickListener {
            mainViewModel.getFamilyList().observe(viewLifecycleOwner, Observer {
                Log.d(this@MainFragment.javaClass.canonicalName, "Family list count: ${ it.count() }")
                val gate = MainGate(LinkedList(it))
                Cart.startAndWriteToLedger(gate)
                val trips = Ledger.getTrips()
                for (trip in trips) {
                    Log.d(this@MainFragment.javaClass.simpleName, "$trip")
                }
                Log.d(this@MainFragment.javaClass.simpleName, "Ledge count: ${ trips.size }")
            })
        }
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).campsiteComponent.inject(this)
    }

}