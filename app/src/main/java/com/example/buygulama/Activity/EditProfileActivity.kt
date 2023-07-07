package com.example.buygulama.Activity

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.buygulama.EditProfileModel
import com.example.buygulama.R
import com.example.buygulama.databinding.ActivityEditProfileBinding
import com.google.firebase.database.*
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_edit_profile.*


private lateinit var binding: ActivityEditProfileBinding


class EditProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sp = this.getSharedPreferences("Account", Context.MODE_PRIVATE)
        register_btn.setOnClickListener {
            val input_name = name.text.toString()
            val input_surname = surname.text.toString()
            val input_number = number.text.toString()
            val input_date = date.text.toString()
            val input_username = username.text.toString()

            val editor = sp.edit()
            editor.putString("name", input_name)
            editor.putString("surname", input_surname)
            editor.putString("number", input_number)
            editor.putString("date", input_date)
            editor.putString("username", input_username)
            editor.commit()
            val sp = this.getSharedPreferences("Account", Context.MODE_PRIVATE)

            val km = sp.getString("mail", "$input_name")
            val ks = sp.getString("sifre", "$input_surname")
            val kn = sp.getString("numara", "$input_number")
            val ka = sp.getString("adres", "$input_date")
            val kg = sp.getString("gun", "$input_username")

            name.setText("$km")
            surname.setText("$ks")
            number.setText("$kn")
            date.setText("$ka")
            username.setText("$kg")


        }
        }
}