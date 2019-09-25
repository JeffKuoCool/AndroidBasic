package com.ztlj.intellectparty;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.hwangjr.rxbus.annotation.Subscribe;
import com.ztlj.common.BaseActivity;
import com.ztlj.common.constants.RouterConstants;
import com.ztlj.common.manager.RouterManager;
import com.ztlj.common.model.RxbusEvent;
import com.ztlj.intellectparty.databinding.ActivityMainBinding;
public class MainActivity extends BaseActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setEvent();
    }

    private void setEvent() {
        mBinding.router.setOnClickListener(home -> {
            RouterManager.navigation(RouterConstants.HOME_PATH);
        });
    }

    @Subscribe
    public void receiveEvent(RxbusEvent rxbusEvent){
        mBinding.router.setText("RxbusEvent");
    }
}
