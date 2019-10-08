package com.ztlj.intellectparty.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.ztlj.common.BaseFragment;
import com.ztlj.intellectparty.R;
import com.ztlj.intellectparty.databinding.FragmentMessageBinding;
import com.ztlj.intellectparty.databinding.FragmentMineBinding;

/**
 * @date: 2019-10-08
 * @autror: guojian
 * @description:
 */
public class MineFragment extends BaseFragment {

    private FragmentMineBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_mine, container, false);
        return mBinding.getRoot();
    }
}
