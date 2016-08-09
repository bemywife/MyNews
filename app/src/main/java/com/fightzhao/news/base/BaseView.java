package com.fightzhao.news.base;

/**
 * fightzhao on 16/8/9.
 * Function : 视图的基类
 */
public interface BaseView {
    void toast(String msg);

    void showProgress();

    void hideProgress();

    void showRequest();
}
