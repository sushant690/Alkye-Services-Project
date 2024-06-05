package com.example.alkyeservices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alkyeservices.databinding.ActivityMain2Binding
import com.google.android.material.navigation.NavigationBarView

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private lateinit var horizontalAdapter: RandomAdapter
    private lateinit var verticalAdapter: RandomAdapter
    private lateinit var thirdAdapter: RandomAdapter
    private lateinit var cardDataList: MutableList<CardData>
    private lateinit var initialVerticalList: List<CardData>
    private lateinit var thirdCardDataList: List<CardData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize cardDataList with 10 card data
        cardDataList = mutableListOf<CardData>().apply {
            val cardData = CardData("⚫ technology", "Step Into Tomorrow: Exploring Spatial Computng's Impact On Industries And The Metaverse!", "26 Feb 2024")
            repeat(10) {
                add(cardData)
            }
        }

        // Initialize thirdCardDataList with different card data
        thirdCardDataList = mutableListOf<CardData>().apply {
            val thirdCardData = CardData("The Ultimate Guide To Simplifying Your Routine With Generative AI Automation!", "", "")
            repeat(10) {
                add(thirdCardData)
            }
        }

        // Setup Horizontal RecyclerView
        horizontalAdapter = RandomAdapter(cardDataList, RandomAdapter.VIEW_TYPE_HORIZONTAL)
        binding.recyclerViewA.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewA.adapter = horizontalAdapter

        // Setup Vertical RecyclerView with only 4 items initially
        initialVerticalList = cardDataList.take(4)
        verticalAdapter = RandomAdapter(initialVerticalList, RandomAdapter.VIEW_TYPE_VERTICAL)
        binding.recyclerViewB.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewB.adapter = verticalAdapter

        // Setup third RecyclerView
        thirdAdapter = RandomAdapter(thirdCardDataList, RandomAdapter.VIEW_TYPE_THIRD)
        binding.recyclerViewC.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewC.adapter = thirdAdapter

        // Set onClickListener for the View All button
        binding.btnViewAll.setOnClickListener {
            // Display all 10 items in the vertical RecyclerView
            verticalAdapter = RandomAdapter(cardDataList, RandomAdapter.VIEW_TYPE_VERTICAL)
            binding.recyclerViewB.adapter = verticalAdapter
            binding.btnViewAll.visibility = View.GONE
        }
    }
}