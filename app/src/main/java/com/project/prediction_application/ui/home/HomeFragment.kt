package com.project.prediction_application.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.project.prediction_application.R
import com.project.prediction_application.common_helper.DefaultHelper
import com.project.prediction_application.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {



    private lateinit var homeViewModel: HomeViewModel
    private var mBinding: FragmentHomeBinding? = null
    private val binding get() = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        mBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("getDeviceId: ${DefaultHelper.getDeviceId(context)} ")
        setAdapter()
    }


    private fun setAdapter() {

        mBinding?.viewPager?.offscreenPageLimit = 1
        val adapter = ViewPagerAdapter(childFragmentManager, context as FragmentActivity)
        mBinding?.viewPager?.adapter = adapter
        mBinding?.tabLayout?.setupWithViewPager(mBinding?.viewPager)
        mBinding?.viewPager?.currentItem = 0


        mBinding?.viewPager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                /*when (position) {
                    0 -> {
                        AboutUsFragment()
                    }
                    1 -> {
                        PrivacyPolicyFragment()
                    }
                    2 -> {
                        TermsConditionFragment()
                    }
                }*/
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })
        adapter.notifyDataSetChanged()
    }


    class ViewPagerAdapter(fragmentManager: FragmentManager, val context: Context) :
        FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {


        override fun getItem(position: Int): Fragment {
            var fragment: Fragment? = null
            /*when (position) {
                0 -> fragment = AboutUsFragment()
                1 -> fragment = PrivacyPolicyFragment()
                2 -> fragment = TermsConditionFragment()

            }
            return fragment!!*/
            return MatchListFragment()

        }

        override fun getCount(): Int {
            return 3
        }

        override fun getPageTitle(position: Int): CharSequence? {
            var title: String? = null
            when (position) {
                0 -> title = context.getString(R.string.toolbar_cricket)
                1 -> title = context.getString(R.string.toolbar_football)
                2 -> title = context.getString(R.string.toolbar_basketball)
            }
            return title
        }

        override fun getItemPosition(`object`: Any): Int {
            return super.getItemPosition(`object`)

        }


        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

    }
}