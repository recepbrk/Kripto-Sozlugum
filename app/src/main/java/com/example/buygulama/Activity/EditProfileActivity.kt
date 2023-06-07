package com.example.buygulama.Activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.buygulama.EditProfileModel
import com.example.buygulama.R
import com.example.buygulama.databinding.ActivityEditProfileBinding
import com.google.firebase.database.*
import es.dmoral.toasty.Toasty


private lateinit var binding: ActivityEditProfileBinding
private lateinit var database: DatabaseReference

class EditProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //veri ekleme
        binding.registerBtn.setOnClickListener {
            val firstname = binding.name.text.toString()
            val surname = binding.surname.text.toString()
            val number = binding.number.text.toString()
            val datebirth = binding.date.text.toString()
            val username = binding.username.text.toString()


            database = FirebaseDatabase.getInstance().getReference("Users")
            val user = EditProfileModel(firstname, surname, number, datebirth, username)
            database.child(username).setValue(user).addOnSuccessListener {


                Toasty.success(this, "Kayıt Başarılı!", Toast.LENGTH_SHORT, true).show();
            }

            //veri okuma

            var getdata = object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {

                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            }
        }


    }
}