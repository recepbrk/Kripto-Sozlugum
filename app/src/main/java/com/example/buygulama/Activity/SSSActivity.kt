package com.example.buygulama.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.OvershootInterpolator
import android.widget.ImageButton
import at.blogc.android.views.ExpandableTextView
import com.example.buygulama.R

class SSSActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sssactivity)

        val expantableTextview = findViewById<ExpandableTextView>(R.id.expandableTextView)
        val toogle = findViewById<ImageButton>(R.id.imageButton)

        expantableTextview.setAnimationDuration(750L)
        expantableTextview.setInterpolator(OvershootInterpolator())

        toogle.setOnClickListener {
            if (expantableTextview.isExpanded) {
                expantableTextview.collapse()
                toogle.setImageResource(R.drawable.assagi)
            } else {
                expantableTextview.expand()
                toogle.setImageResource(R.drawable.yukari)
            }
        }
        val expantableTextview1 = findViewById<ExpandableTextView>(R.id.expandableTextView1)
        val toogle1 = findViewById<ImageButton>(R.id.imageButton1)

        expantableTextview1.setAnimationDuration(750L)
        expantableTextview1.setInterpolator(OvershootInterpolator())

        toogle1.setOnClickListener {
            if (expantableTextview1.isExpanded) {
                expantableTextview1.collapse()
                toogle1.setImageResource(R.drawable.assagi)
            } else {
                expantableTextview1.expand()
                toogle1.setImageResource(R.drawable.yukari)
            }
        }
        val expantableTextview2 = findViewById<ExpandableTextView>(R.id.expandableTextView2)
        val toogle2 = findViewById<ImageButton>(R.id.imageButton2)

        expantableTextview2.setAnimationDuration(750L)
        expantableTextview2.setInterpolator(OvershootInterpolator())

        toogle2.setOnClickListener {
            if (expantableTextview2.isExpanded) {
                expantableTextview2.collapse()
                toogle2.setImageResource(R.drawable.assagi)
            } else {
                expantableTextview2.expand()
                toogle2.setImageResource(R.drawable.yukari)
            }
        }
        val expantableTextview3 = findViewById<ExpandableTextView>(R.id.expandableTextView3)
        val toogle3 = findViewById<ImageButton>(R.id.imageButton3)

        expantableTextview3.setAnimationDuration(750L)
        expantableTextview3.setInterpolator(OvershootInterpolator())

        toogle3.setOnClickListener {
            if (expantableTextview3.isExpanded) {
                expantableTextview3.collapse()
                toogle3.setImageResource(R.drawable.assagi)
            } else {
                expantableTextview3.expand()
                toogle3.setImageResource(R.drawable.yukari)
            }
        }
        val expantableTextview4 = findViewById<ExpandableTextView>(R.id.expandableTextView4)
        val toogle4 = findViewById<ImageButton>(R.id.imageButton4)

        expantableTextview4.setAnimationDuration(750L)
        expantableTextview4.setInterpolator(OvershootInterpolator())

        toogle4.setOnClickListener {
            if (expantableTextview4.isExpanded) {
                expantableTextview4.collapse()
                toogle4.setImageResource(R.drawable.assagi)
            } else {
                expantableTextview4.expand()
                toogle4.setImageResource(R.drawable.yukari)
            }
        }
    }
}