package com.example.passion945fmabntv.ONBOARDING_SCREEN

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.abntvpassio945fm.OnBoardingScreenScreen.OnboardingItem
import com.example.passion945fmabntv.MAIN_SCREEN.MainActivity3
import com.example.passion945fmabntv.R

class ONBOARDING : AppCompatActivity() {
    private lateinit var onboardingItemsAdapter: OnboardingItemsAdapter
    private lateinit var indicatorsContainers: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)
        setOnBoarding()
        setUpIndicators()

    }

    private fun setOnBoarding(){
        onboardingItemsAdapter= OnboardingItemsAdapter(
            listOf(
                OnboardingItem(
                    onboardingIamge = R.drawable.passionfm,
                    onboardingText = "Passion 94.5 Fm is a Premium Talk, Urban News, \n& Sports Radio Station, in Uyo, Nigeria."
                ),
                OnboardingItem(
                    onboardingIamge = R.drawable.abn,
                    onboardingText = "strengthen broadcast services with creative, " +
                            "innovative ,value driven and people oriented programs " +
                            "to meet the yearnings of the people"
                )
            )
        )
        val onBoardingViewPager=findViewById<ViewPager2>(R.id.viewPager2)
        onBoardingViewPager.adapter=onboardingItemsAdapter

        onBoardingViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
        (onBoardingViewPager.getChildAt(0) as RecyclerView)
            .overScrollMode= RecyclerView
            .OVER_SCROLL_ALWAYS


        findViewById<Button>(R.id.button).setOnClickListener{
            navigateToHomeActivity()
        }
    }
    private fun setUpIndicators(){
        indicatorsContainers=findViewById(R.id.indicatorsContainer)
        val indicators= arrayOfNulls<ImageView>(onboardingItemsAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(8,0,8,0)
        for (i in indicators.indices){
            indicators[i]= ImageView(applicationContext)
            indicators[i]?.let {
                it.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active_background
                    )
                )
            }
        }

    }
    private  fun navigateToHomeActivity(){
        startActivity(Intent(applicationContext, MainActivity3::class.java))
        finish()
    }
    private fun setCurrentIndicator(position:Int){
        val childCount=indicatorsContainers.childCount
        for (i in 0 until childCount){
            val imageView=indicatorsContainers.getChildAt(i) as ImageView
            if (i==position){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active_background

                    )
                )
            }else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive_background
                    )
                )
            }
        }

    }
}