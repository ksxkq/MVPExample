package com.ksxkq.mvpexample.login;

import android.view.View;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * OnePiece
 * Created by xukq on 10/10/16.
 */

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View mLoginView;

    public LoginPresenter(LoginContract.View loginView) {
        mLoginView = loginView;
        mLoginView.setPresenter(this);
    }

    @Override
    public void login() {
        mLoginView.showLoading(View.VISIBLE);
        Observable.create(new Observable.OnSubscribe<Object>() {
            @Override
            public void call(Subscriber<? super Object> subscriber) {
                subscriber.onNext(subscriber);
                subscriber.onCompleted();
            }
        })
                .delay(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Object>() {
                    @Override
                    public void call(Object o) {
                        String name = mLoginView.getUsername();
                        String pass = mLoginView.getPassword();
                        mLoginView.loginSuccess();
                        mLoginView.showLoading(View.GONE);
                    }
                });
    }

    @Override
    public void subscribe() {
        // TODO: 10/10/16 rxjava
    }

    @Override
    public void unsubscribe() {
        // TODO: 10/10/16 rxjava
    }
}
