package com.example.buygulama.OnBoarding.Screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.buygulama.R
import kotlinx.android.synthetic.main.fragment_first_screen.view.*
import kotlinx.android.synthetic.main.fragment_second_screnn.view.*


class SecondScrenn : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_second_screnn, container, false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        view.next2.setOnClickListener {
            viewPager?.currentItem = 2
        }
        view.back2.setOnClickListener {
            if (viewPager != null) {
                viewPager?.currentItem = viewPager.currentItem - 1
            }

        }
        return view
    }

}