package com.example.userform

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.userform.databinding.ActivityUserInformationBinding

class UserInformation : AppCompatActivity() {
    private lateinit var binding: ActivityUserInformationBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

//
//        val intent = intent
//        val  name = intent.getStringExtra("name")
//        binding.info.editText.toString()=""
        val fname = intent.getStringExtra("First Name")
        val lname = intent.getStringExtra("last Name")
        val mobno = intent.getStringExtra("Mobile Number")
        val almobno = intent.getStringExtra("Alternative Mobile Number")
        val emailid = intent.getStringExtra("Email-id")
        val gender= intent.getStringExtra("Gender")
        val hobbies= intent.getStringExtra("Hobbies")
        binding.info.text = " Name:-  $fname $lname \n Phone No:-  $mobno \n Alternative Phone No :- $almobno  \n Email :- $emailid  \n Gender :-  $gender \n Hobbies :- $hobbies"


    }
}