package com.dailymanager.dailymanager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter

class ViewPagerAdapter : PagerAdapter() {
    private val arrayImage =
        listOf(R.drawable.slider1e, R.drawable.slider2, R.drawable.slider3)

    override fun getCount(): Int {
        return arrayImage.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view =
            LayoutInflater.from(container.context).inflate(R.layout.loginslider, container, false)
        val imageSlider: ImageView = view.findViewById(R.id.iv_imageSlider_id)
        val txtImageSlider: ImageView = view.findViewById(R.id.iv_textSlider_id)
        imageSlider.setImageResource(arrayImage[position])
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(container)
    }
}