package com.example.buygulama.Fragment


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.buygulama.*
import com.example.buygulama.Activity.*


class FormasyonFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        return
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_formasyon, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val boga_card = view.findViewById<CardView>(R.id.boga_card)
        val cardview_bear = view.findViewById<CardView>(R.id.card_bear)
        val cardview_devam = view.findViewById<CardView>(R.id.cardview_devam)
        val cardview_flag = view.findViewById<CardView>(R.id.cardview_flag)
        val cardview_üçgen = view.findViewById<CardView>(R.id.cardview_üçgen)
        val takoz = view.findViewById<CardView>(R.id.takoz)
        val cardview_dip = view.findViewById<CardView>(R.id.cardview_dip)
        val cardview_omuz = view.findViewById<CardView>(R.id.cardview_omuz)


        boga_card.setOnClickListener {

            val intent = Intent(requireContext(), boga_donus::class.java)
            startActivity(intent)

        }

        cardview_bear.setOnClickListener {

            val intent = Intent(requireContext(), ayi_donus::class.java)
            startActivity(intent)

        }
        cardview_devam.setOnClickListener {

            val intent = Intent(requireContext(), devam::class.java)
            startActivity(intent)

        }
        cardview_flag.setOnClickListener {

            val intent = Intent(requireContext(), bayraklar::class.java)
            startActivity(intent)

        }
        cardview_üçgen.setOnClickListener {

            val intent = Intent(requireContext(), ucgen::class.java)
            startActivity(intent)

        }
        takoz.setOnClickListener {

            val intent = Intent(requireContext(), Wedge::class.java)
            startActivity(intent)

        }
        cardview_dip.setOnClickListener {

            val intent = Intent(requireContext(), ikitepe::class.java)
            startActivity(intent)

        }
        cardview_omuz.setOnClickListener {
            val intent = Intent(requireContext(), omuz::class.java)
            startActivity(intent)
        }


    }

}