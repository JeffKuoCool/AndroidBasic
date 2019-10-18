package com.ztlj.intellectparty

import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager

import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import com.ztlj.common.BaseActivity
import com.ztlj.common.adapter.TabPageAdapter
import com.ztlj.common.constants.RouterConstants
import com.ztlj.common.interfaces.NetworkStateListener
import com.ztlj.common.manager.RouterManager
import com.ztlj.common.model.TabEntity
import com.ztlj.common.receiver.NetworkReceiver
import com.ztlj.intellectparty.databinding.ActivityMainBinding
import com.ztlj.intellectparty.fragment.HomeFragment
import com.ztlj.intellectparty.fragment.MessageFragment
import com.ztlj.intellectparty.fragment.MineFragment
import com.ztlj.intellectparty.fragment.MoreFragment

import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

import java.util.ArrayList

class MainActivity : BaseActivity() {

    private var mBinding: ActivityMainBinding? = null
    private val mTitles = arrayOf("首页", "更多", "消息", "我的")
    private val mIconUnselectIds = intArrayOf(R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
    private val mIconSelectIds = intArrayOf(R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher)
    private val mTabEntities = ArrayList<CustomTabEntity>()
    private val mFragments = ArrayList<Fragment>()
    private var netReceiver: NetworkReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(mBinding!!.toolbar)

        for (i in mTitles.indices) {
            mTabEntities.add(TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]))
        }
        setTabLayout()
        setFragments()
        mBinding!!.viewPager.adapter = TabPageAdapter(supportFragmentManager, mFragments)
        setEvent()

        initReceiver()
    }

    /**
     * 注册网络监听的广播
     */
    private fun initReceiver() {
        netReceiver = NetworkReceiver(object : NetworkStateListener {
            override fun mobile() {

            }

            override fun wifi() {

            }

            override fun none() {

            }
        })
        netReceiver!!.register(this)
    }

    private fun setFragments() {
        mFragments.add(HomeFragment())
        mFragments.add(MoreFragment())
        mFragments.add(MessageFragment())
        mFragments.add(MineFragment())
    }

    private fun setEvent() {
        mBinding!!.router.setOnClickListener { home ->
            //            RouterManager.navigation(RouterConstants.HOME_PATH);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun receiveEvent(rxbusEvent: Any) {
        mBinding!!.router.text = "RxbusEvent"
    }

    private fun setTabLayout() {
        mBinding!!.tab.setTabData(mTabEntities)
        mBinding!!.tab.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                mBinding!!.viewPager.currentItem = position
            }

            override fun onTabReselect(position: Int) {

            }
        })

        mBinding!!.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                mBinding!!.tab.currentTab = position
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        if (netReceiver != null) {
            unregisterReceiver(netReceiver)
            netReceiver = null
        }
    }
}
