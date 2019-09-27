package com.ztlj.intellectparty;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.ztlj.common.BaseActivity;
import com.ztlj.common.constants.RouterConstants;
import com.ztlj.common.manager.RouterManager;
import com.ztlj.intellectparty.databinding.ActivityMainBinding;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void receiveEvent(Object rxbusEvent){
        mBinding.router.setText("RxbusEvent");
    }
}
