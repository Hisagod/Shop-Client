package com.aib.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.aib.viewmodel.LoginViewModel;
import com.atguigu.shoppingmall.R;
import com.atguigu.shoppingmall.databinding.ActivityLoginBinding;
import com.blankj.utilcode.util.ActivityUtils;

import org.jetbrains.annotations.Nullable;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> implements View.OnClickListener {
    private ImageButton ibLoginBack;
    private EditText etLoginPwd;
    private ImageButton ibLoginVisible;
    private Button btnLogin;
    private ImageButton ib_weibo;
    private ImageButton ib_qq;
    private ImageButton ib_wechat;
    private int count;
    @Inject
    LoginViewModel vm;

    private void findViews() {
        ibLoginBack = (ImageButton) findViewById(R.id.ib_login_back);
        etLoginPwd = (EditText) findViewById(R.id.et_login_pwd);
        ibLoginVisible = (ImageButton) findViewById(R.id.ib_login_visible);
        btnLogin = (Button) findViewById(R.id.btn_login);
        ib_weibo = (ImageButton) findViewById(R.id.ib_weibo);
        ib_qq = (ImageButton) findViewById(R.id.ib_qq);
        ib_wechat = (ImageButton) findViewById(R.id.ib_wechat);

        ibLoginBack.setOnClickListener(this);
        ibLoginVisible.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        ib_weibo.setOnClickListener(this);
        ib_qq.setOnClickListener(this);
        ib_wechat.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == ibLoginBack) {
            finish();
        } else if (v == ibLoginVisible) {

            count++;
            if (count % 2 == 0) {
                ibLoginVisible.setBackgroundResource(R.drawable.new_password_drawable_invisible);
                etLoginPwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            } else {
                ibLoginVisible.setBackgroundResource(R.drawable.new_password_drawable_visible);
                etLoginPwd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);

            }
        }
    }

    @Override
    public int getResId() {
        return R.layout.activity_login;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        findViews();

    }

    /**
     * 进入注册页面
     *
     * @param view
     */
    public void register(View view) {
        ActivityUtils.startActivity(RegisterActivity.class);
    }
}
