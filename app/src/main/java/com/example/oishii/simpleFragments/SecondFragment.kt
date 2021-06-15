package com.example.oishii.simpleFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.oishii.databinding.FragmentSecondBinding
import com.example.oishii.utils.Navigation
import com.example.oishii.utils.navigate

class SecondFragment : Fragment() {

    private lateinit var delivery: ImageView
    private lateinit var pickUp: ImageView
    private lateinit var navController: NavController

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        navController = findNavController()

        pickUp = binding.pickUpImageview
        delivery = binding.deliveryImageview

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigate(navController,pickUp, Navigation.SECOND_TO_MENU.path,null)
        navigate(navController,delivery,Navigation.SECOND_TO_MENU.path,null)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}