package com.fightzhao.news.base;

/**
 * fightzhao on 16/8/9.
 * Function : 代理的基类接口
 */
public interface BasePresenter {
    /**
     * 重新开始
     */
    void onResume();

    /**
     * 刷新
     */
    void onDestroy();

}
