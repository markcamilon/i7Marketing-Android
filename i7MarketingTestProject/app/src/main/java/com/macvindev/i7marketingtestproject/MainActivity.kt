package com.macvindev.i7marketingtestproject

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ServerTimestamp
import java.time.LocalDateTime


class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentDateTime = LocalDateTime.now()
        val db = FirebaseFirestore.getInstance()

        //MainActivity
        data class LogIn(val buttonID: String, val timeIn: String)

        val buttonOne = findViewById<Button>(R.id.buttonOne)
        buttonOne.setOnClickListener {

            val logData = LogIn("Button One Pressed", currentDateTime.toString())
            db.collection("logIn").document()
                .set(logData)
                .addOnSuccessListener {
                    Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }

            gotoLogList()


        }

        val buttonTwo = findViewById<Button>(R.id.buttonTwo)
        buttonTwo.setOnClickListener {
            val logData = LogIn("Button Two Pressed", currentDateTime.toString())
            db.collection("logIn").document()
                .set(logData)
                .addOnSuccessListener {
                    Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }
            gotoLogList()
        }

        val buttonThree = findViewById<Button>(R.id.buttonThree)
        buttonThree.setOnClickListener {
            val logData = LogIn("Button One Three", currentDateTime.toString())
            db.collection("logIn").document()
                .set(logData)
                .addOnSuccessListener {
                    Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }
            gotoLogList()
        }

        val buttonFour = findViewById<Button>(R.id.buttonFour)
        buttonFour.setOnClickListener {
            val logData = LogIn("Button Four Pressed", currentDateTime.toString())
            db.collection("logIn").document()
                .set(logData)
                .addOnSuccessListener {
                    Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }
            gotoLogList()
        }

    }
    fun gotoLogList(){
        val intent = Intent(this, LogLists::class.java)
        startActivity(intent)
    }
}