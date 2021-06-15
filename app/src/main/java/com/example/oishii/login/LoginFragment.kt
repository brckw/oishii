package com.example.oishii.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.oishii.MainActivity
import com.example.oishii.OishiiApplication
import com.example.oishii.R
import com.example.oishii.database.AppDatabase
import com.example.oishii.databinding.LoginFragmentBinding
import com.example.oishii.utils.Navigation
import com.example.oishii.utils.showHide


class LoginFragment : Fragment() {

    private lateinit var loginText: TextView
    private lateinit var createAccount: TextView
    private lateinit var continueWithoutAccount: TextView
    private lateinit var viewModel: LoginViewModel
    private lateinit var database: AppDatabase
    private lateinit var navController: NavController
    private lateinit var toolBar: androidx.appcompat.widget.Toolbar

    private var _binding: LoginFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = LoginFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)


        loginText = binding.loginTextview
        createAccount = binding.createAccountTextview
        continueWithoutAccount = binding.withOutUserTextview
        navController = findNavController()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            saveAndLeaveGuestAccount(continueWithoutAccount)
    }


    override fun onStart() {
        super.onStart()
        toolBar = requireActivity().findViewById<androidx.appcompat.widget.Toolbar>(R.id.my_toolbar)
        showHide(toolBar)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    fun saveAndLeaveGuestAccount(view: View){
        view.setOnClickListener{
            navController.navigate(Navigation.LOGIN_TO_FIRST.path)
            viewModel.makeNewUser(false,null,null)
            showHide(toolBar)
        }
    }

}