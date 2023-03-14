package com.example.illabank.feature.splash

import android.content.Intent
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.illabank.R
import com.example.illabank.databinding.ActivitySplashBinding
import com.example.illabank.feature.base.BaseActivity
import com.example.illabank.feature.dashboard.DashboardActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {

    override val viewModel by viewModels<SplashViewModel>()

    override fun getLayoutRes(): Int {
        return R.layout.activity_splash
    }

    override fun initViewModel(viewModel: SplashViewModel) {
        binding.viewModel = viewModel
        lifecycleScope.launchWhenStarted {

            viewModel.navigationFlow.collect { navigationValue ->
                if (navigationValue) {
                    startActivity(
                        Intent(
                            this@SplashActivity, DashboardActivity::class.java
                        )
                    )
                    finish()
                }
            }

        }
    }


}