package com.example.oishii.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.oishii.R


class MenuFragment : Fragment() {


    private lateinit var viewModel: MenuViewModel
    private lateinit var recyclerview: RecyclerView
    private lateinit var parentAdapter: CategoryAdapter
    private lateinit var dishLayoutManager: LinearLayoutManager
    private lateinit var menuTypeText: TextView
    private lateinit var progressBar: ProgressBar
    var isTakeAway: Boolean? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
        val view = inflater.inflate(R.layout.menu_fragment, container, false)

        menuTypeText = view.findViewById(R.id.menu_type_textView)
        recyclerview = view.findViewById(R.id.category_recyclerView)
        progressBar = view.findViewById(R.id.loader_progressBar)

        // boolean from navigation to track what menu too display
        isTakeAway = getArguments()?.getBoolean("isTakeAway")

        setMenuText(isTakeAway)
        initDishList()

        return view
    }



    private fun initDishList() {
        viewModel.fetchMenuFromApi(progressBar,isTakeAway){ menuItems ->
            parentAdapter = CategoryAdapter(menuItems)
            recyclerview.adapter = parentAdapter
            dishLayoutManager = LinearLayoutManager(context)
            recyclerview.layoutManager = dishLayoutManager
        }
    }

    private fun setMenuText(isTakeAway: Boolean?){
        if (isTakeAway == true){
            menuTypeText.text = getString(R.string.take_away)
        } else {
            menuTypeText.text = getString(R.string.dine_inne)
        }
    }


}