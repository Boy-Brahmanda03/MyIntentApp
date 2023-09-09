package com.example.myintentapp

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MoveWithObjectActivitiy : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    private lateinit var tvObject: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object_activitiy)

        tvObject = findViewById(R.id.tv_object_received)

        val person = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Person>(EXTRA_PERSON, Person::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Person>(EXTRA_PERSON)
        }

        if (person != null){
            val text = "Name : ${person.name}.\nAge : ${person.age}.\nEmail : ${person.email}.\nCity : ${person.city}"
            tvObject.text = text
        }
    }
}