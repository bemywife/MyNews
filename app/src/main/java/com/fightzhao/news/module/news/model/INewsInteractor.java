package com.fightzhao.news.module.news.model;

import com.fightzhao.news.callback.RequestCallback;

import rx.Subscription;

/**
 * fightzhao on 16/8/22.
 * Function : 新闻Model层接口
 */
public interface INewsInteractor<T> {
    /**
     *
     * @param callback
     * @return 返回 Subscription,以便于防止内存泄露
     */
    Subscription operateChannelDb(RequestCallback<T> callback);
}
