package com.example.buygulama.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.buygulama.databinding.ActivityKayitBinding
import com.google.firebase.auth.FirebaseAuth
import es.dmoral.toasty.Toasty

class KayitActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKayitBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKayitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.button.setOnClickListener {
            val email = binding.emailET.text.toString()
            val pass = binding.passEt.text.toString()
            val confirmPass = binding.confirmpassET.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {

                if (pass == confirmPass) {

                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            startActivity(Intent(this, GirisActivity::class.java))
                        } else {
                            Toasty.error(this, it.exception.toString(), Toast.LENGTH_SHORT, true)
                                .show();
                        }
                    }

                } else {
                    Toasty.error(this, "Parolalar Eşleşmedi.", Toast.LENGTH_SHORT, true).show();
                }

            } else {
                Toasty.info(this, "Tüm Alanları Doldurunuz.", Toast.LENGTH_SHORT, true).show();
            }
        }

    }
}