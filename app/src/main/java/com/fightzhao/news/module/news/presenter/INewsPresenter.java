package com.fightzhao.news.module.news.presenter;

import com.fightzhao.news.base.BasePresenter;

/**
 * fightzhao on 16/8/22.
 * Function : 新闻代理接口
 */
public interface INewsPresenter extends BasePresenter{
    /**
     * 频道排序或增删变化后调用此方法更新数据库
     */
    void operateChannelDb();
}
