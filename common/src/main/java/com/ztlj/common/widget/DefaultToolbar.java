package com.ztlj.common.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.ztlj.common.R;

/**
 * @date: 2019-10-08
 * @autror: guojian
 * @description:
 */
public class DefaultToolbar extends Toolbar {

    private TextView mTitleTv;
    private TextView mStartTv;
    private TextView mEndTv;

    public DefaultToolbar(Context context) {
        this(context, null);
    }

    public DefaultToolbar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, R.attr.toolbarStyle);
    }

    public DefaultToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(getContext(), R.layout.toolbar_default, this);
        mTitleTv = findViewById(R.id.tvTitle);
        mStartTv = findViewById(R.id.tvStart);
        mEndTv = findViewById(R.id.tvEnd);

        mStartTv.setOnClickListener(back -> {
            if (context instanceof Activity) {
                ((Activity) context).finish();
            }
        });
    }

    @Deprecated
    @Override
    public void setTitle(CharSequence title) {
        mTitleTv.setText(title);
    }

    @Deprecated
    @Override
    public void setSubtitle(CharSequence subtitle) {
    }

    public void setStartText(@Nullable CharSequence title) {
        if (!TextUtils.isEmpty(title)) {
            mStartTv.setVisibility(View.VISIBLE);
            mStartTv.setText(title);
        } else {
            mStartTv.setVisibility(View.GONE);
        }
    }

    public void setNavigationImageIcon(int drawable) {
        setNavigationIcon(drawable);
    }

    /**
     * 设置左侧文字旁边图标
     *
     * @param drawableId 图标ID
     */
    public void setStartTextDrawable(int drawableId) {
        if (mStartTv.getVisibility() != VISIBLE) return;
        if (!getResources().getDrawable(drawableId).isVisible()) {
            return;
        }
        Drawable drawable = getResources().getDrawable(drawableId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        mStartTv.setCompoundDrawables(null, null, drawable, null);
    }

    public void setBackIcon(int res) {
        mStartTv.setVisibility(View.VISIBLE);
        Drawable drawable = getResources().getDrawable(res);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        mStartTv.setCompoundDrawables(drawable, null, null, null);
    }

    public void setEndIcon(int res) {
        mEndTv.setVisibility(View.VISIBLE);
        Drawable drawable = getResources().getDrawable(res);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        mEndTv.setCompoundDrawables(null, null, drawable, null);
    }

    public void setEndText(@Nullable CharSequence title) {
        if (!TextUtils.isEmpty(title)) {
            mEndTv.setVisibility(View.VISIBLE);
            mEndTv.setText(title);
        } else {
            mEndTv.setVisibility(View.GONE);
        }
    }

    public TextView getTitleTv() {
        return mTitleTv;
    }

    public TextView getStartTv() {
        return mStartTv;
    }

    public TextView getEndTv() {
        return mEndTv;
    }

}
