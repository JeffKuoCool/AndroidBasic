package com.ztlj.home.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ztlj.common.BaseActivity;
import com.ztlj.common.constants.RouterConstants;
import com.ztlj.common.constants.RxbusConstants;
import com.ztlj.common.model.RxbusEvent;
import com.ztlj.home.R;
import com.ztlj.home.databinding.ActivityHomeBinding;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
            EventBus.getDefault().post(new RxbusEvent(RxbusConstants.EVENT_POST));
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void receiveEvent(Object rxbusEvent){
        mBinding.tvEvent.setText("RxbusEvent");
    }

}
