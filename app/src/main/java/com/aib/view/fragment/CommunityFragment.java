package com.aib.view.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;

import com.aib.view.fragment.BaseFragment;
import com.atguigu.shoppingmall.R;
import com.atguigu.shoppingmall.community.adapter.CommunityViewPagerAdapter;
import com.atguigu.shoppingmall.databinding.FragmentCommunityBinding;

import org.jetbrains.annotations.Nullable;

public class CommunityFragment extends BaseFragment<FragmentCommunityBinding> {
    private ImageButton ibCommunityIcon;
    private TabLayout tablayout;
    private ViewPager viewPager;
    private ImageButton ibCommunityMessage;

    @Override
    public int getResId() {
        return R.layout.fragment_community;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        ibCommunityIcon = (ImageButton) binding.getRoot().findViewById(R.id.ib_community_icon);
        tablayout = (TabLayout) binding.getRoot().findViewById(R.id.tablayout);
        viewPager = (ViewPager) binding.getRoot().findViewById(R.id.view_pager);
        ibCommunityMessage = (ImageButton) binding.getRoot().findViewById(R.id.ib_community_message);

        CommunityViewPagerAdapter adapter = new CommunityViewPagerAdapter(getFragmentManager());
        viewPager.setAdapter(adapter);
        tablayout.setVisibility(View.VISIBLE);
        tablayout.setupWithViewPager(viewPager);
    }
}
