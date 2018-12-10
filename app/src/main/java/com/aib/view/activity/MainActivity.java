package com.aib.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.aib.view.activity.BaseActivity;
import com.aib.view.fragment.BaseFragment;
import com.aib.viewmodel.HomeViewModel;
import com.atguigu.shoppingmall.R;
import com.atguigu.shoppingmall.databinding.ActivityMainBinding;
import com.aib.view.fragment.HomeFragment;
import com.atguigu.shoppingmall.type.fragment.TypeFragment;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

import javax.inject.Inject;


public class MainActivity extends BaseActivity<ActivityMainBinding> {
    @Inject
    public HomeViewModel vm;
    private ArrayList<BaseFragment> fragments;
    private int position;
    private TypeFragment typeFragment;
    private BaseFragment mContext;

    private void initFragment() {
        fragments = new ArrayList<>();
        typeFragment = new TypeFragment();
        HomeFragment homeFragment = new HomeFragment();
        fragments.add(homeFragment);
//        fragments.add(typeFragment);
//        fragments.add(new CommunityFragment());
//        fragments.add(new ShoppingCartFragment());
//        fragments.add(new UserFragment());
    }

    private void initListener() {
        binding.rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:
                        position = 0;
//                        dismissAnmiation();
//                        typeFragment.hideFragment();
                        break;
                    case R.id.rb_type:

                        position = 1;
//                        dismissAnmiation();
                        //初始化数据
//                        int currentTab = typeFragment.getCurrentTab();
//                        if (currentTab == 0) {
//                            if (typeFragment.listFragment != null) {
//                                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                                transaction.show(typeFragment.listFragment).commit();
//                            }
//                        } else {
//                            if (typeFragment.tagFragment != null) {
//                                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                                transaction.show(typeFragment.tagFragment).commit();
//                            }
//                        }
                        break;
                    case R.id.rb_community:
                        position = 2;
//                        typeFragment.hideFragment();

                        break;
                    case R.id.rb_cart:
                        position = 3;

//                        fragments.remove(fragments.get(3));
//                        ShoppingCartFragment cartFragment = new ShoppingCartFragment();
//                        fragments.add(3, cartFragment);
//
//                        typeFragment.hideFragment();
                        break;
                    case R.id.rb_user:
                        position = 4;
//                        dismissAnmiation();
//                        typeFragment.hideFragment();
                        break;
                }

                BaseFragment baseFragment = getFragment(position);
                switchFragment(mContext, baseFragment);
            }
        });

        binding.rgMain.check(R.id.rb_home);
    }


    /**
     * @param position
     * @return
     */
    private BaseFragment getFragment(int position) {
        if (fragments != null && fragments.size() > 0) {
            BaseFragment baseFragment = fragments.get(position);
            return baseFragment;
        }
        return null;
    }

    private void switchFragment(Fragment fromFragment, BaseFragment nextFragment) {
        if (mContext != nextFragment) {
            mContext = nextFragment;
            if (nextFragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //判断nextFragment是否添加
                if (!nextFragment.isAdded()) {
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.add(R.id.frameLayout, nextFragment).commit();
                } else {
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.show(nextFragment).commit();
                }
            }
        }
    }

    @Override
    public int getResId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initFragment();
        initListener();
    }
}
