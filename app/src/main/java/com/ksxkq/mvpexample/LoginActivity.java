package com.ksxkq.mvpexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import static com.ksxkq.mvpexample.R.id.password_et;
import static com.ksxkq.mvpexample.R.id.username_et;

public class LoginActivity extends AppCompatActivity implements LoginContract.View, View.OnClickListener {

    private EditText mUsernameEt;
    private EditText mPasswordEt;
    private ProgressBar mLoadingPb;
    private Button mLoginBtn;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        loginPresenter = new LoginPresenter(this);
    }

    @Override
    @Nullable
    public String getUsername() {
        return mUsernameEt.getText().toString();
    }

    @Override
    @Nullable
    public String getPassword() {
        return mPasswordEt.getText().toString();
    }

    @Override
    public void showLoading(int visibility) {
        mLoadingPb.setVisibility(visibility);
    }

    @Override
    public void loginFailed() {
        Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        mUsernameEt = (EditText) findViewById(username_et);
        mPasswordEt = (EditText) findViewById(password_et);
        mLoadingPb = (ProgressBar) findViewById(R.id.loading_pb);
        mLoginBtn = (Button) findViewById(R.id.login_btn);

        mLoginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn:
                loginPresenter.login();
                break;
        }
    }
}
