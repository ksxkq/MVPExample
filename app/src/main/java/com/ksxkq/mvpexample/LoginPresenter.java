package com.ksxkq.mvpexample;

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

    private LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void login() {
        view.showLoading(View.VISIBLE);
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
                        String name = view.getUsername();
                        String pass = view.getPassword();
                        view.loginSuccess();
                        view.showLoading(View.GONE);
                    }
                });
    }
}
