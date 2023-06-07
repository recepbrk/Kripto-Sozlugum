package com.example.buygulama.Fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.buygulama.Activity.EditProfileActivity
import com.example.buygulama.Activity.MainActivity
import com.example.buygulama.R
import com.example.buygulama.Activity.SSSActivity
import kotlinx.android.synthetic.main.fragment_profil.*
import kotlinx.android.synthetic.main.fragment_thind_screen.*

class ProfilFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val intent = Intent()
        val email = intent.getStringExtra("email")
        val emailTextView: TextView = view.findViewById(R.id.accountProfileEmail)
        emailTextView.text = "email +$email"



        cıkıs.setOnClickListener {
            val builder = AlertDialog.Builder(view.context)
            builder.setTitle("")
            builder.setMessage("Uygulamadan Çıkış Yapmak İstiyor musunuz ?")


            builder.setPositiveButton("EVET") { dialog, which ->
                val intent = Intent(Intent.ACTION_MAIN)
                intent.addCategory(Intent.CATEGORY_HOME)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)

            }

            builder.setNegativeButton("HAYIR") { dialog, which ->

            }

            builder.setNeutralButton("İptal") { dialog, which ->

            }
            builder.show()

        }

        bildir.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_SENDTO,
                Uri.fromParts("mailto", "recepgzelr@gmail.com", null)
            )
            startActivity(Intent.createChooser(intent, "Send Mail.."))
        }
        referans.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.okx.com/tr/join/64007714")
                )
            )
        }
        edit_profile.setOnClickListener {
            startActivity(Intent(context, EditProfileActivity::class.java))
        }

        faq.setOnClickListener {
            val intent = Intent(requireContext(), SSSActivity::class.java)
            startActivity(intent)
        }
        share.setOnClickListener {
            val shareIntent: Intent = Intent(Intent.ACTION_SEND)
            shareIntent.setType("text/plain")
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Insert Subject here")
            val app_url = " https://play.google.com/store/apps/details?id=my.example.javatpoint"
            shareIntent.putExtra(Intent.EXTRA_TEXT, app_url)
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }
    }


}