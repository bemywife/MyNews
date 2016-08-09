package com.fightzhao.news.base;

import com.fightzhao.news.callback.RequestCallback;

import rx.Subscription;

/**
 * fightzhao on 16/8/9.
 * Function :
 */
public class BasePresenterImpl<V extends BaseView, D> implements BasePresenter, RequestCallback<D> {

    protected Subscription mSubscription;
    protected V mView;

    public BasePresenterImpl(V view) {
        this.mView = view;
    }

    @Override
    public void onResume() {

    }

    /**
     * 清理,防止内存泄露
     */
    @Override
    public void onDestroy() {
        if (mSubscription != null && !mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
        mView = null;
    }

    @Override
    public void beforeRequest() {
            mView.showProgress();
    }

    @Override
    public void requestError(String msg) {
        
    }

    @Override
    public void requestComplete() {

    }

    @Override
    public void requusetSuccess(D data) {

    }
}
