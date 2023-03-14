package com.example.illabank.feature.dashboard

import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.viewpager.widget.ViewPager
import com.example.illabank.R
import com.example.illabank.databinding.ActivityDashboardBinding
import com.example.illabank.feature.base.BaseActivity
import com.example.illabank.feature.dashboard.adapter.LiveShowCarouselPagerAdapter
import com.example.illabank.feature.dashboard.adapter.TrainersAdapter
import com.example.illabank.utils.TextChangeWatcher
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : BaseActivity<ActivityDashboardBinding, DashboardViewModel>() {

    override val viewModel by viewModels<DashboardViewModel>()
    private lateinit var trainerCarouselPagerAdapter: LiveShowCarouselPagerAdapter
    private lateinit var trainersRecyclerViewAdapter: TrainersAdapter

    override fun getLayoutRes(): Int {
        return R.layout.activity_dashboard
    }

    override fun initViewModel(viewModel: DashboardViewModel) {
        binding.viewModel = viewModel
        initViewPager()
        initRecyclerView()
        initListeners()

        fetchData()
    }

    private fun fetchData() {
        viewModel.fetchTrainers()
        viewModel.fetchLiveShows()
    }

    private fun initRecyclerView() {
        trainersRecyclerViewAdapter = TrainersAdapter { }

        viewModel.trainerListData.observe(this) {
            trainersRecyclerViewAdapter.setItems(it)
        }
        binding.rvCarousel.run {
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = trainersRecyclerViewAdapter
        }
    }

    private fun initListeners() {
        binding.vpCarousel.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                binding.tlCircleIndicator.selectTab(binding.tlCircleIndicator.getTabAt(position))
            }
        })

        binding.etSearch.addTextChangedListener(TextChangeWatcher {
            trainersRecyclerViewAdapter.filter.filter(it)
        })
        binding.etSearch.setOnClickListener {
            binding.motionLayout.transitionToEnd()
            binding.motionLayout.requestFocus()
        }
        binding.etSearch.setOnEditorActionListener(
            TextView.OnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    //binding.etSearch.hideKeyboard()
                    return@OnEditorActionListener true
                }
                false
            }
        )
        binding.etSearch.setOnFocusChangeListener { _, hasFocus ->
            run {
                if (hasFocus) {
                    binding.motionLayout.transitionToEnd()
                }
            }
        }
    }

    private fun initViewPager() {
        trainerCarouselPagerAdapter = LiveShowCarouselPagerAdapter()
        binding.vpCarousel.adapter = trainerCarouselPagerAdapter
        binding.tlCircleIndicator.setupWithViewPager(binding.vpCarousel, true)

        binding.vpCarousel.clipToPadding = false
        binding.vpCarousel.setPadding(30, 30, 30, 30)
        binding.vpCarousel.pageMargin = 30

        viewModel.liveShowsData.observe(this) {
            trainerCarouselPagerAdapter.setItems(it)
        }

    }
}