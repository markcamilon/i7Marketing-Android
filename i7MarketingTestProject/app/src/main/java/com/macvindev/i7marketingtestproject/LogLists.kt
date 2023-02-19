package com.macvindev.i7marketingtestproject

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class LogLists : AppCompatActivity() {

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_lists)

        val display = supportActionBar
        display?.title = "Log List"
        display?.setDisplayHomeAsUpEnabled(true)


        val db = FirebaseFirestore.getInstance()
        val collectionRef = db.collection("logIn").orderBy("timeIn")

        // getting the recyclerview by its id
        val myRecyclerView = findViewById<RecyclerView>(R.id.myRecyclerView)
        // this creates a vertical layout Manager
        myRecyclerView.layoutManager = LinearLayoutManager(this)


        val dataList = mutableListOf<LogInData>()
        collectionRef.get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val data = document.toObject(LogInData::class.java)
                    dataList.add(data)
                }
                val adapter = CustomAdapter(dataList)
                myRecyclerView.adapter = adapter
                adapter.notifyDataSetChanged()
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}