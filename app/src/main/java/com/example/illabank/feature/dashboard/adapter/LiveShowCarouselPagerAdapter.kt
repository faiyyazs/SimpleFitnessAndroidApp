package com.example.illabank.feature.dashboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.example.illabank.R
import com.example.illabank.databinding.ItemCarouselBinding
import com.example.illabank.domain.model.LiveShow

class LiveShowCarouselPagerAdapter : PagerAdapter() {

    private var dataList: List<LiveShow> = arrayListOf()

    override fun getCount(): Int {
        return dataList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as CardView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as CardView)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding = DataBindingUtil.inflate<ItemCarouselBinding>(
            LayoutInflater.from(container.context),
            R.layout.item_carousel,
            container,
            false
        )

        binding.ivCarousel.setImageResource(dataList[position].carouselImage)
        container.addView(binding.root)
        return binding.root
    }


    fun setItems(items: List<LiveShow>) {
        dataList = items
        notifyDataSetChanged()
    }

}