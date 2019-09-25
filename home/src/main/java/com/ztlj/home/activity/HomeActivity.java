package com.ztlj.home.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hwangjr.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.ztlj.common.BaseActivity;
import com.ztlj.common.constants.RouterConstants;
import com.ztlj.common.constants.RxbusConstants;
import com.ztlj.common.model.RxbusEvent;
import com.ztlj.home.R;
import com.ztlj.home.databinding.ActivityHomeBinding;

/**
 * @date: 2019-09-24
 * @autror: guojian
 * @description:
 */
@Route(path = RouterConstants.HOME_PATH)
public class HomeActivity extends BaseActivity {

    private ActivityHomeBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        mBinding.tvEvent.setOnClickListener(post -> {
            RxBus.get().post(new RxbusEvent(RxbusConstants.EVENT_POST));
        });
    }

    @Subscribe
    public void receiveEvent(Object rxbusEvent){
        mBinding.tvEvent.setText("RxbusEvent");
    }

}
