package com.timsmith.lostangeles.features.greet.app.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.timsmith.lostangeles.R
import com.timsmith.lostangeles.databinding.RecyclerviewItemRowBinding
import com.timsmith.lostangeles.features.greet.app.models.Trip
import com.timsmith.lostangeles.features.greet.app.ui.DetailsFragmentArgs
import com.timsmith.lostangeles.features.greet.app.ui.MainFragmentDirections

class TripAdapter(private var trips: List<Trip>) : RecyclerView.Adapter<TripAdapter.TripHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripHolder {
        val tripBinding = DataBindingUtil.inflate<RecyclerviewItemRowBinding>(LayoutInflater.from(parent.context), R.layout.recyclerview_item_row, parent, false)
        return TripHolder(tripBinding)
    }

    override fun getItemCount(): Int = trips.size

    override fun onBindViewHolder(holder: TripHolder, position: Int) {
        val trip = trips[position]
        holder.bindTrip(trip)
    }

    fun setTripList(trips: java.util.ArrayList<Trip>) {
        this.trips = trips
        notifyDataSetChanged()
    }


    class TripHolder(private val rowBinding: RecyclerviewItemRowBinding) : RecyclerView.ViewHolder(rowBinding.root), View.OnClickListener {

        private lateinit var trip: Trip
        init {
            rowBinding.root.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            val action = MainFragmentDirections.goToDetails(trip)
            Navigation.findNavController(rowBinding.root).navigate(action)
        }

        fun bindTrip(trip: Trip) {
            this.trip = trip
            rowBinding.trip = trip
        }

        companion object {
            //5
            private val PHOTO_KEY = "PHOTO"
        }
    }

}
