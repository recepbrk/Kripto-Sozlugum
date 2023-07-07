package com.example.buygulama.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.buygulama.R
import com.example.buygulama.databinding.ActivityForgotPasswordBinding
import com.google.firebase.auth.FirebaseAuth
import es.dmoral.toasty.Toasty

class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    private lateinit var binding: ActivityForgotPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email= findViewById<EditText>(R.id.edttxt_forgot)

        auth= FirebaseAuth.getInstance()
        binding.btnKaydet.setOnClickListener {
            val mail=email.text.toString()
            auth.sendPasswordResetEmail(mail)
                .addOnCompleteListener{ task->
                    Toasty.success(this, "Şifre Sıfırlama Gönderildi !", Toast.LENGTH_SHORT, true).show();
                    val intent= Intent(applicationContext,Login::class.java)
                    startActivity(intent)
                    finish()
                }


                .addOnFailureListener{
                    Toast.makeText(this,it.toString(), Toast.LENGTH_LONG)
                        .show()
                }
        }





    }
}