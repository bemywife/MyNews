package com.fightzhao.news.module.news.view.activity;

import com.fightzhao.news.R;
import com.fightzhao.news.app.ActivityFragmentInject;
import com.fightzhao.news.app.AppManager;
import com.fightzhao.news.base.BaseActivity;
import com.fightzhao.news.greendao.NewsChannelTable;
import com.fightzhao.news.module.news.presenter.INewsPresenter;
import com.fightzhao.news.module.news.presenter.INewsPresenterImpl;
import com.fightzhao.news.module.news.view.view.INewsView;
import com.fightzhao.news.utils.ViewUtil;

import java.util.List;

@ActivityFragmentInject(contentViewId = R.layout.activity_news,
        menuId = R.menu.menu_news,
        hasNavigationView = true,
        toolbarTitle = R.string.news,
        toolbarIndicator = R.mipmap.ic_list_white,
        menuDefaultCheckedItem = R.id.action_news)
public class NewsActivity  extends BaseActivity<INewsPresenter> implements INewsView {
    @Override
    protected void initView() {
        // 设了默认的windowBackground使得冷启动没那么突兀，这里再设置为空减少过度绘制
        getWindow().setBackgroundDrawable(null);
        ViewUtil.quitFullScreen(this);

        AppManager.getAppManager().orderNavActivity(getClass().getName(), false);

        mPresenter = new INewsPresenterImpl(this);
    }

    @Override
    public void initViewPager(List<NewsChannelTable> newsChannels) {

    }

    @Override
    public void initRxBusEvent() {

    }
}

