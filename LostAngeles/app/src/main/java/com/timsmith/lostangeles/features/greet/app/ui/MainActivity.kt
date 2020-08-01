package com.timsmith.lostangeles.features.greet.app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.timsmith.lostangeles.LostAngelesApplication
import com.timsmith.lostangeles.R
import com.timsmith.lostangeles.shared.di.components.CampsiteComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var campsiteComponent: CampsiteComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        campsiteComponent = (applicationContext as LostAngelesApplication).appComponent.campsiteComponent().create()
        campsiteComponent.inject(this)
        setContentView(R.layout.main_activity)
    }
}