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
import androidx.recyclerview.widget.LinearLayoutManager
import com.timsmith.lostangeles.R
import com.timsmith.lostangeles.databinding.MainFragmentBinding
import com.timsmith.lostangeles.features.greet.app.Cart
import com.timsmith.lostangeles.features.greet.app.adapters.TripAdapter
import com.timsmith.lostangeles.features.greet.app.models.Ledger
import com.timsmith.lostangeles.features.greet.app.models.MainGate
import com.timsmith.lostangeles.features.greet.app.models.Trip
import com.timsmith.lostangeles.features.greet.app.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.*
import java.util.*
import javax.inject.Inject

class MainFragment : Fragment() {

    @Inject
    lateinit var mainViewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding
    private lateinit var linearLayoutManager: LinearLayoutManager
    private var adapter = TripAdapter(listOf())
    private var carts = ArrayList<Cart>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        linearLayoutManager = LinearLayoutManager(activity)
        binding.trips.layoutManager = linearLayoutManager
        binding.trips.adapter = adapter


        binding.message.setOnClickListener {
            mainViewModel.getFamilyList().observe(viewLifecycleOwner, Observer { familyGroups ->
                Ledger.clear()
                Log.d(this@MainFragment.javaClass.canonicalName, "Family list count: ${ familyGroups.count() }")
                val gate = MainGate(LinkedList(familyGroups))
                val bob = Cart("Bob")
                val alice = Cart("Alice")
                carts.add(bob)
                carts.add(alice)

                while (gate.hasGroups()) {
                    gate.getNextGroup()?.let { family ->
                        val firstFreeCart = carts.firstOrNull() { it.timeLeftOnRoute == 0 }
                        firstFreeCart?.takeGroup(family)
                        for (cart in carts) {
                            cart.decrementTimeByOne()
                        }
                    }
                }
                val trips = Ledger.getTrips()
                adapter.setTripList(trips)
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