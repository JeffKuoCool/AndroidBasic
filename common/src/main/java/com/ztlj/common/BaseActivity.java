package com.ztlj.common;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.ViewTreeObserver;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.OnKeyboardListener;

import org.greenrobot.eventbus.EventBus;

/**
 * @date: 2019-09-23
 * @autror: guojian
 * @description:
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        ARouter.getInstance().inject(this);
    }

    /**
     * 沉浸式状态栏
     */
    protected void initImmersionBar() {
        ImmersionBar.with(this)
                .statusBarDarkFont(true)
                .keyboardEnable(true)  //解决软键盘与底部输入框冲突问题，默认为false，还有一个重载方法，可以指定软键盘mode
                .keyboardMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)  //单独指定软键盘模式
                .setOnKeyboardListener(new OnKeyboardListener() {    //软键盘监听回调，keyboardEnable为true才会回调此方法
                    @Override
                    public void onKeyboardChange(boolean isPopup, int keyboardHeight) {
                        //isPopup为true，软键盘弹出，为false，软键盘关闭
                    }
                })
                .init();
    }


    @Override
    protected void onStart() {
        super.onStart();
        initImmersionBar();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
