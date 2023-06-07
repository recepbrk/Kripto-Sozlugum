package com.example.buygulama.OnBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.buygulama.OnBoarding.Screen.FirstScreen
import com.example.buygulama.OnBoarding.Screen.SecondScrenn
import com.example.buygulama.OnBoarding.Screen.ThirdScreen
import com.example.buygulama.R
import kotlinx.android.synthetic.main.fragment_view_pager.view.*


class ViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view =inflater.inflate(R.layout.fragment_view_pager, container, false)

        val fragmentList = arrayListOf<Fragment>(
        FirstScreen(),
            SecondScrenn(),
            ThirdScreen()

        )
        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )
            view.viewPager.adapter=adapter

        return view
    }


}