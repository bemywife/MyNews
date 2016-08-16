package com.fightzhao.news.base;

import com.fightzhao.news.callback.RequestCallback;
import com.socks.library.KLog;

import rx.Subscription;

/**
 * fightzhao on 16/8/9.
 * Function : Presenter的实现类,必须持有View和Data
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
        KLog.e(msg);
        // TODO: 16/8/11 用户角度出发,要不要Toast 
        mView.toast(msg);
        mView.showRequest();
        mView.hideProgress();
    }

    @Override
    public void requestComplete() {
        mView.hideProgress();
    }

    @Override
    public void requestSuccess(D data) {

    }
}
