package com.example.buygulama.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.buygulama.Data.WordData
import com.example.buygulama.Activity.DetailsActivity
import com.example.buygulama.R

class   WordAdapter(private val mcontext:Context, private val word_List:List<WordData>)
    :RecyclerView.Adapter<WordAdapter.CardTasarimTutucu> () {


    inner class CardTasarimTutucu(tasarim: View) : RecyclerView.ViewHolder(tasarim) {
        var kelime_kart: CardView
        var textViewİngilizce: TextView
        var textViewTurkce: TextView

        init {
            kelime_kart = tasarim.findViewById(R.id.kelime_card)
            textViewİngilizce = tasarim.findViewById(R.id.textViewİngilizce)
            textViewTurkce = tasarim.findViewById(R.id.textViewTurkce)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim = LayoutInflater.from(mcontext).inflate(R.layout.card_tasarim, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun getItemCount(): Int {
        return word_List.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val kelime = word_List.get(position)
        holder.textViewİngilizce.text = kelime.kelime_turkce
        holder.textViewTurkce.text = kelime.kelime_anlam

        holder.kelime_kart.setOnClickListener {

            val intent=Intent(mcontext, DetailsActivity::class.java)

            intent.putExtra("nesne",kelime)

            mcontext.startActivity(intent)

        }
    }
}