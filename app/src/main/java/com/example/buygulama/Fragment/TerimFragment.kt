package com.example.buygulama.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.buygulama.Adapter.KelimelerAdapter
import com.example.buygulama.Data.DatabaseCopyHelper
import com.example.buygulama.Data.Kelimeler
import com.example.buygulama.Data.Kelimelerdao
import com.example.buygulama.Data.VeritabaniYardimcisi
import com.example.buygulama.R
import kotlinx.android.synthetic.main.fragment_terim.*


class TerimFragment : Fragment() {

    private lateinit var kelimelerListe: ArrayList<Kelimeler>
    private lateinit var adapter: KelimelerAdapter
    private lateinit var vt: VeritabaniYardimcisi
    lateinit var searchView: android.widget.SearchView
    override fun onCreate(savedInstanceState: Bundle?) {
        veritabaniKopyala()
        super.onCreate(savedInstanceState)


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_terim, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(requireContext())

        vt = VeritabaniYardimcisi(requireContext())

        kelimelerListe = Kelimelerdao().tumKelimeler(vt)



        adapter = KelimelerAdapter(requireContext(), kelimelerListe)

        rv.adapter = adapter
        val searchView = view.findViewById<android.widget.SearchView>(R.id.searchView)


        searchView.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                arama(query)


                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {

                arama(newText)

                return false
            }

        })
    }


    fun veritabaniKopyala() {
        val copyHelper = DatabaseCopyHelper(requireContext())
        try {
            copyHelper.createDataBase()
            copyHelper.openDataBase()
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    fun arama(aramaKelime: String) {
        kelimelerListe = Kelimelerdao().aramaYap(vt, aramaKelime)

        adapter = KelimelerAdapter(requireContext(), kelimelerListe)

        rv.adapter = adapter
    }

}