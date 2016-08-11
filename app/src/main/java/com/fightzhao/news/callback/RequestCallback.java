package com.fightzhao.news.callback;

/**
 * fightzhao on 16/8/9.
 * Function : 网络监听的基类
 */
public interface RequestCallback<D> {
    /**
     * 请求之前调用
     */
    void beforeRequest();

    /**
     * 请求错误调用
     *
     * @param msg
     */
    void requestError(String msg);

    /**
     * 请求完成时调用
     */
    void requestComplete();

    /**
     * 请求成功时候调用
     *
     * @param data
     */
    void requestSuccess(D data);
}
