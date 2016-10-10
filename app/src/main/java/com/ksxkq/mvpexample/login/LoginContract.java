package com.ksxkq.mvpexample.login;

import com.ksxkq.mvpexample.BasePresenter;
import com.ksxkq.mvpexample.BaseView;

/**
 * OnePiece
 * Created by xukq on 10/10/16.
 */

public interface LoginContract {

    interface View extends BaseView<Presenter> {

        String getUsername();

        String getPassword();

        void showLoading(int visibility);

        void loginFailed();

        void loginSuccess();

    }

    interface Presenter extends BasePresenter {

        void login();

    }

}
