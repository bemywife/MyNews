package com.fightzhao.news.module.news.view.activity;

import com.fightzhao.news.R;
import com.fightzhao.news.app.ActivityFragmentInject;
import com.fightzhao.news.base.BaseActivity;

@ActivityFragmentInject(contentViewId = R.layout.activity_news,
        menuId = R.menu.menu_news,
        hasNavigationView = true,
        toolbarTitle = R.string.news,
        toolbarIndicator = R.mipmap.ic_list_white,
        menuDefaultCheckedItem = R.id.action_news)
public class NewsActivity extends BaseActivity {
    @Override
    protected void initView() {

    }
}

