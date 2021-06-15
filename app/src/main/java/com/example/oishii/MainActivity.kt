package com.example.oishii

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.findNavController
import androidx.room.Database
import com.example.oishii.database.AppDatabase
import com.example.oishii.databinding.ActivityMainBinding
import com.example.oishii.utils.Navigation
import com.example.oishii.utils.navigate
import com.example.oishii.utils.navigateUp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

open class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var backArrow: ImageView
    private lateinit var infoMenu: ImageView
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        infoMenu = binding.infoMenuImageview
        backArrow = binding.backArrowImageview

        toolbar = binding.myToolbar
        toolbar.bringToFront()
        navController = findNavController(R.id.nav_host_fragment_content_main)

            navigate(navController, infoMenu, Navigation.INFO_MENU.path, toolbar)
            navigateUp(navController, backArrow, null, false)
        }

    }







