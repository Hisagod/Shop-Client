package com.aib.view.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.atguigu.shoppingmall.R;
import com.atguigu.shoppingmall.databinding.FragmentTypeBinding;
import com.atguigu.shoppingmall.type.fragment.ListFragment;
import com.atguigu.shoppingmall.type.fragment.TagFragment;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TypeFragment extends BaseFragment<FragmentTypeBinding> {
    private TabLayout segmentTabLayout;
    private ImageView iv_type_search;
    private FrameLayout fl_type;
    private List<BaseFragment> fragmentList;
    private Fragment tempFragment;
    public ListFragment listFragment;
    public TagFragment tagFragment;

    @Override
    public void onResume() {
        super.onResume();
//        HLP
//        switchFragment(tempFragment, fragmentList.get(0));
    }

    public void switchFragment(Fragment fromFragment, BaseFragment nextFragment) {
        if (tempFragment != nextFragment) {
            tempFragment = nextFragment;
            if (nextFragment != null) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                //判断nextFragment是否添加
                if (!nextFragment.isAdded()) {
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }

                    transaction.add(R.id.fl_type, nextFragment, "tagFragment").commit();
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

    private void initFragment() {
        fragmentList = new ArrayList<>();
        listFragment = new ListFragment();
        tagFragment = new TagFragment();

//        fragmentList.add(listFragment);
//        fragmentList.add(tagFragment);

//        switchFragment(tempFragment, fragmentList.get(0));
    }


    @Override
    public int getResId() {
        return R.layout.fragment_type;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        segmentTabLayout = binding.getRoot().findViewById(R.id.tl_1);
        iv_type_search = (ImageView) binding.getRoot().findViewById(R.id.iv_type_search);
        fl_type = (FrameLayout) binding.getRoot().findViewById(R.id.fl_type);

        initFragment();

        String[] titles = {"分类", "标签"};

        //BY HLP
//        segmentTabLayout.setTabData(titles);
//
//        segmentTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
//            @Override
//            public void onTabSelect(int position) {
//                switchFragment(tempFragment, fragmentList.get(position));
//            }
//
//            @Override
//            public void onTabReselect(int position) {
//
//            }
//        });

    }
}
