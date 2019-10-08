package com.ztlj.intellectparty;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.ztlj.common.BaseActivity;
import com.ztlj.common.adapter.TabPageAdapter;
import com.ztlj.common.constants.RouterConstants;
import com.ztlj.common.manager.RouterManager;
import com.ztlj.common.model.TabEntity;
import com.ztlj.intellectparty.databinding.ActivityMainBinding;
import com.ztlj.intellectparty.fragment.HomeFragment;
import com.ztlj.intellectparty.fragment.MessageFragment;
import com.ztlj.intellectparty.fragment.MineFragment;
import com.ztlj.intellectparty.fragment.MoreFragment;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding mBinding;
    private String[] mTitles = {"首页", "更多", "消息", "我的"};
    private int[] mIconUnselectIds = {
            R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private int[] mIconSelectIds = {
            R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        setTabLayout();
        setFragments();
        mBinding.viewPager.setAdapter(new TabPageAdapter(getSupportFragmentManager(), mFragments));

        setEvent();
    }

    private void setFragments() {
        mFragments.add(new HomeFragment());
        mFragments.add(new MoreFragment());
        mFragments.add(new MessageFragment());
        mFragments.add(new MineFragment());
    }

    private void setEvent() {
        mBinding.router.setOnClickListener(home -> {
            RouterManager.navigation(RouterConstants.HOME_PATH);
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void receiveEvent(Object rxbusEvent) {
        mBinding.router.setText("RxbusEvent");
    }

    private void setTabLayout() {
        mBinding.tab.setTabData(mTabEntities);
        mBinding.tab.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mBinding.viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        mBinding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mBinding.tab.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

}
