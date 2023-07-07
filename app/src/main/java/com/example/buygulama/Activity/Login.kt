package com.example.buygulama.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.buygulama.R
import com.example.buygulama.databinding.ActivityGirisBinding
import com.google.firebase.auth.FirebaseAuth
import es.dmoral.toasty.Toasty

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityGirisBinding
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGirisBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.kayTTxt.setOnClickListener {
            startActivity(Intent(this, Register::class.java))
        }


        binding.btnKaydet.setOnClickListener {

            performSignUp()

        }

        binding.textView11.setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }
    }

    private fun performSignUp() {
        firebaseAuth = FirebaseAuth.getInstance()
        val email = findViewById<EditText>(R.id.edttxt_forgot)
        val pass = findViewById<EditText>(R.id.KayitParola)

        if (email.text.isEmpty() || pass.text.isEmpty()) {
            Toasty.info(this, "Lütfen Tüm Alanları Doldurun.", Toast.LENGTH_SHORT, true).show();
            return
        }
        val inputmail = email.text.toString()
        val inputpassword = pass.text.toString()

        firebaseAuth.signInWithEmailAndPassword(inputmail, inputpassword)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    val intent = Intent(this, MainActivity::class.java)

                    intent.putExtra("email", email.text.toString())


                    startActivity(intent)
                    Toasty.success(this, "Giriş Başarılı!", Toast.LENGTH_SHORT, true).show();
                } else {
                    Toasty.error(this, "Giriş Başarısız..", Toast.LENGTH_SHORT, true).show();
                }
            }

            .addOnFailureListener {

                Toasty.error(this, "error${it.localizedMessage}.", Toast.LENGTH_SHORT, true).show();
            }
    }
}