package com.mitime.modules.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.library.widgets.ui_base.BaseActivity;
import com.mitime.R;

/**
 * 该页面为用户登陆页面<br/>
 * 作者：LZHS<br/>
 * 时间： 2017/12/11 09:34<br/>
 * 邮箱：1050629507@qq.com
 */
public class LoginActivity extends BaseActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_login);
    }
}
