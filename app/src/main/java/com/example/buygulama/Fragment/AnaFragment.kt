package com.example.buygulama.Fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.buygulama.Adapter.Adapter
import com.example.buygulama.Data.PodcastData

import com.example.buygulama.R


class AnaFragment : Fragment(), Adapter.MyClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var PodcastList: ArrayList<PodcastData>
    private lateinit var adapter: Adapter
    private lateinit var webView: WebView
    private val URL = "https://tr.tradingview.com/chart/?symbol=BITSTAMP%3ABTCUSD"
    private lateinit var webview_haber: WebView
    private val HABER_URL = "https://tr.tradingview.com/markets/cryptocurrencies/news/"




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_ana, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList = ArrayList<SlideModel>()


        imageList.add(SlideModel(R.drawable.slider1, ScaleTypes.CENTER_INSIDE))
        imageList.add(SlideModel(R.drawable.slider2, ScaleTypes.CENTER_INSIDE))
        imageList.add(SlideModel(R.drawable.slider3, ScaleTypes.CENTER_INSIDE))
        imageList.add(SlideModel(R.drawable.slider4, ScaleTypes.CENTER_INSIDE))
        imageList.add(SlideModel(R.drawable.slider5, ScaleTypes.CENTER_INSIDE))
        imageList.add(SlideModel(R.drawable.slider6, ScaleTypes.CENTER_INSIDE))
        val imageSlider = view.findViewById<ImageSlider>(R.id.image_slider)
        imageSlider.setImageList(imageList)



        recyclerView = view.findViewById(R.id.recyclerview)
        PodcastList = ArrayList()
        PodcastList.add(PodcastData( R.drawable.mg, "Merkeziyetsiz Gelecek",  "Doğancan Ertaş, Furkan Saatcioğlu"))
        PodcastList.add(PodcastData(R.drawable.km, "Kripto Mevsimi", "Kerem ve Tufan"))
        PodcastList.add(PodcastData(R.drawable.fo, "Finansal Özgürlük", "Finansal Özgürlük\n"))
        PodcastList.add(PodcastData(R.drawable.podcast, "Borsada bi' Başına", "İlker"))
        adapter = Adapter(PodcastList, this@AnaFragment)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)





        webView = view.findViewById<WebView>(R.id.webview)
        webView.apply {
            loadUrl(URL)
            webViewClient = WebViewClient()
            requestDisallowInterceptTouchEvent(true)
            webView.isHorizontalScrollBarEnabled = false
            webView.isVerticalScrollBarEnabled = false
            settings.javaScriptEnabled = true

        }


    }

    override fun onClick(position: Int) {
        when (position) {

            0 -> startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://open.spotify.com/show/2xrt1iSzCw4IMBODhf2gqa")
                )
            )
            1 -> startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://open.spotify.com/show/1v59H26lyck7tpDmpP7d6U")
                )
            )
            2 -> startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://open.spotify.com/show/0OgzwJ8BSYcjl61cRMttAf")
                )
            )
            3 -> startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://open.spotify.com/show/4xjp1qTtO8wpgBtuSppwbJ")
                )
            )
        }
    }

}