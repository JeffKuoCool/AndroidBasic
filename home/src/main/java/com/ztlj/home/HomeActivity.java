package com.ztlj.home;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.databinding.DataBindingUtil;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ztlj.common.BaseActivity;
import com.ztlj.common.constants.RouterConstants;
import com.ztlj.home.databinding.ActivityHomeBinding;

/**
 * @date: 2019-09-24
 * @autror: guojian
 * @description:
 */
class HomeActivity extends BaseActivity {

    private ActivityHomeBinding mBinding;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);

    }
}
