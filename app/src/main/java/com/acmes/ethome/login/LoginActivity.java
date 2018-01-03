package com.acmes.ethome.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import com.acmes.ethome.ETHomeActivity;
import com.acmes.ethome.R;
import com.acmes.ethome.mode.request.LoginRequest;
import com.acmes.simpleandroid.mvc.model.SimpleResponse;
import com.acmes.simpleandroid.utils.Utils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by fishyu on 2018/1/2.
 */

public class LoginActivity extends ETHomeActivity<LoginMode> implements View.OnClickListener {

    @Override
    protected LoginMode createMode() {
        return LoginMode.getInstance();
    }

    @BindView(R.id.user_name)
    EditText mUserName;


    @BindView(R.id.user_password)
    EditText mUserPassword;


    @BindView(R.id.submit_button)
    View mButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
    }


    @Override
    public void onRequestStart(Object requestTag) {
        super.onRequestStart(requestTag);
        if ("login".equals(requestTag)) {
            mButton.setClickable(false);
        }
    }


    @Override
    public void onResponse(Object requestTag, SimpleResponse response) {
        super.onResponse(requestTag, response);
        if ("login".equals(requestTag)) {
            mButton.setClickable(true);
        }

        Utils.showToast(response.getMessage() + " " + response.getData());
    }


    @Override
    public void onFailure(Object requestTag, Throwable exception) {
        super.onFailure(requestTag, exception);
        if ("login".equals(requestTag)) {
            mButton.setClickable(true);
        }
    }

    @OnClick(R.id.submit_button)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submit_button:
                getModel().login(new LoginRequest(mUserName.getText().toString(), mUserPassword.getText().toString()));
                break;
        }
    }


}