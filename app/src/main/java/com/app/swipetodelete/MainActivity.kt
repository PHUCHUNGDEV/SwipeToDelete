package com.app.swipetodelete

import android.R
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.swipetodelete.component.DemoSwipeRecyclerViewAdapter
import com.app.swipetodelete.component.SwipeRecyclerViewManager
import com.app.swipetodelete.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var demoSwipeRecyclerViewAdapter: DemoSwipeRecyclerViewAdapter
    private lateinit var binding: ActivityMainBinding
    private lateinit var list: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handleRecyclerView()
    }

    private fun handleRecyclerView() {
        list = ArrayList()
        list.add("Item 1")
        list.add("Item 2")
        list.add("Item 3")
        list.add("Item 4")
        list.add("Item 5")
        list.add("Item 6")
        list.add("Item 7")


        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this.applicationContext)
        demoSwipeRecyclerViewAdapter =
            DemoSwipeRecyclerViewAdapter(list)


        val swipeRecyclerViewAdapter = SwipeRecyclerViewManager(rightCallback, leftCallback)


        // Setting background colours
        swipeRecyclerViewAdapter.setBackgroundColorLeft(ColorDrawable(Color.RED))
        swipeRecyclerViewAdapter.setBackgroundColorRight(ColorDrawable(Color.GREEN))


        // Setting Icons
        swipeRecyclerViewAdapter.setIconRight(ContextCompat.getDrawable(this, R.drawable.ic_delete))
        swipeRecyclerViewAdapter.setIconLeft(ContextCompat.getDrawable(this, R.drawable.ic_secure))
        swipeRecyclerViewAdapter.setIconSizeMultiplier(2)


        //Set Text
        swipeRecyclerViewAdapter.setTextLeft("LEFT")
        swipeRecyclerViewAdapter.setTextRight("RIGHT")


        //Set text size
        swipeRecyclerViewAdapter.setTextSize(60)


        //Set text colour
        swipeRecyclerViewAdapter.setTextColor(Color.BLACK)


        // Attach to the Recycler View Adapter
        binding.rvSwipe.setAdapter(demoSwipeRecyclerViewAdapter)
        demoSwipeRecyclerViewAdapter.notifyDataSetChanged()

    }

    private val leftCallback: SwipeRecyclerViewManager.SwipeCallbackLeft =
        object : SwipeRecyclerViewManager.SwipeCallbackLeft {
            override fun onLeftSwipe(position: Int) {
                Toast.makeText(
                    applicationContext,
                    "You swiped to the Left on the item ",
                    Toast.LENGTH_LONG
                ).show()
                demoSwipeRecyclerViewAdapter.notifyDataSetChanged()
            }
        }


    private val rightCallback: SwipeRecyclerViewManager.SwipeCallbackRight =
        object : SwipeRecyclerViewManager.SwipeCallbackRight {
            override fun onRightSwipe(position: Int) {

                Toast.makeText(
                    applicationContext,
                    "You swiped to the Right on the item : ",
                    Toast.LENGTH_LONG
                ).show()
                demoSwipeRecyclerViewAdapter.notifyDataSetChanged()
            }
        }


    private val onItemClickListener: DemoSwipeRecyclerViewAdapter.OnItemClickListener =
        object : DemoSwipeRecyclerViewAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                Toast.makeText(
                    applicationContext,
                    "You clicked on the item ",
                    Toast.LENGTH_LONG
                ).show()
                demoSwipeRecyclerViewAdapter.notifyDataSetChanged()
            }
        }

}