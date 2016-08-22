package com.fightzhao.news.module.news.view.view;

import com.fightzhao.news.base.BaseView;
import com.fightzhao.news.greendao.NewsChannelTable;

import java.util.List;

/**
 * fightzhao on 16/8/22.
 * Function : 新闻视图接口,完成初始化ViewPager
 */
public interface INewsView extends BaseView {

    void initViewPager(List<NewsChannelTable> newsChannels);

    void initRxBusEvent();
}
