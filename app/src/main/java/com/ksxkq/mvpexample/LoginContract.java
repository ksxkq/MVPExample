package com.ksxkq.mvpexample;

/**
 * OnePiece
 * Created by xukq on 10/10/16.
 */

public interface LoginContract {

    interface View {

        String getUsername();

        String getPassword();

        void showLoading(int visibility);

        void loginFailed();

        void loginSuccess();

    }

    interface Presenter {

        void login();

    }

}
