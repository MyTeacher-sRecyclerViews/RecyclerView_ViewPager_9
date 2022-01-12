package com.example.recyclerview_viewpager_9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_viewpager_9.adapter.CustomAdapter
import com.example.recyclerview_viewpager_9.model.User

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        val users = addedListUsers()
        refreshAdapter(users)
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)

        recyclerView.setOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val activePosition = layoutManager.findFirstVisibleItemPosition()
                if (activePosition == RecyclerView.NO_POSITION) return
                Toast.makeText(this@MainActivity, "Active Position", Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun addedListUsers(): ArrayList<User> {
        val users = ArrayList<User>()

        for (i in 0..20) {
            users.add(User("Android", "$i"))
        }
        return users
    }

    private fun refreshAdapter(user: ArrayList<User>) {
        val adapter = CustomAdapter(this, user)
        recyclerView.adapter = adapter
    }
}
