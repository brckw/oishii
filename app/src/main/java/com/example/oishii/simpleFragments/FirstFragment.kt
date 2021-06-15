package com.example.oishii.simpleFragments

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.oishii.*
import com.example.oishii.database.AppDatabase
import com.example.oishii.database.User
import com.example.oishii.databinding.FragmentFirstBinding
import com.example.oishii.utils.Navigation
import com.example.oishii.utils.navigate
import com.example.oishii.utils.navigateUp


class FirstFragment : Fragment() {


    private lateinit var eatAtRestaurant: ImageView
    private lateinit var takeAway: ImageView
    private lateinit var navController: NavController
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        navController = findNavController()
        takeAway = binding.takeAwayImageView
        eatAtRestaurant = binding.eatAtRestaurantImageview


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigate(navController, takeAway, Navigation.FIRST_TO_SECOND.path, null)
        navigate(navController, eatAtRestaurant, Navigation.FIRST_TO_MENU.path, null)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}