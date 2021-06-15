package com.example.oishii.simpleFragments

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.oishii.R
import com.example.oishii.databinding.FragmentInfoMenuBinding
import com.example.oishii.utils.Navigation
import com.example.oishii.utils.navigate
import com.example.oishii.utils.navigateUp


class InfoMenuFragment : Fragment() {

    private lateinit var kontakt: TextView
    private lateinit var exitInfoMenu: ImageView
    private lateinit var navController: NavController
    private lateinit var toolBar: androidx.appcompat.widget.Toolbar
    private lateinit var notificationManager: NotificationManager
    private lateinit var profileText: TextView
    private var _binding: FragmentInfoMenuBinding? = null
    private val binding get() = _binding!!

    private val channelID = "viktig_noti"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInfoMenuBinding.inflate(inflater, container, false)
        navController = findNavController()

        kontakt = binding.kontaktTextview
        exitInfoMenu = binding.redXImageview
        profileText = binding.loginTextview
        toolBar = requireActivity().findViewById<androidx.appcompat.widget.Toolbar>(R.id.my_toolbar)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notificationManager =
            requireActivity().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        createNotificationChannel()
        navigateUp(navController, exitInfoMenu, toolBar, false)

        kontakt.setOnClickListener {
            createAndSendNotification()
        }
            navigate(navController,profileText,Navigation.INFO_TO_PROFILE.path,toolBar)

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            "viktig_noti",
            "Important message",
            NotificationManager.IMPORTANCE_HIGH
        )
        channel.description = "only Highly important messages"
        channel.enableLights(true)
        channel.lightColor = Color.RED
        channel.enableVibration(true)
        channel.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 600, 200, 300)

        notificationManager.createNotificationChannel(channel)
    }


    private fun createAndSendNotification() {
        val notificationId = 99

        val notification = Notification.Builder(activity, channelID)
            .setContentTitle("Alpha")
            .setContentText("app is still in development")
            .setSmallIcon(R.drawable.oishii_logo)
            .setChannelId(channelID)
            .build()

        notificationManager.notify(notificationId, notification)
    }
}


