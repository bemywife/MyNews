package com.fightzhao.news.module.news.view.fragment;

import android.os.Bundle;
import android.view.View;

import com.fightzhao.news.base.BaseFragment;

/**
 * fightzhao on 16/8/22.
 * Function :
 */
public class NewsFragment extends BaseFragment{

    protected static final String NEWS_ID = "news_id";
    protected static final String NEWS_TYPE = "news_type";
    protected static final String POSITION = "position";


    @Override
    protected void initView(View fragmentRootView) {

    }

    public static NewsFragment newInstance(String newsId, String newsType, int position) {
        NewsFragment fragment = new NewsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(NEWS_ID, newsId);
        bundle.putString(NEWS_TYPE, newsType);
        bundle.putInt(POSITION, position);
        fragment.setArguments(bundle);
        return fragment;
    }
}
