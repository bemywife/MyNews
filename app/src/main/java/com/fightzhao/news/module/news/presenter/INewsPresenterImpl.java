package com.fightzhao.news.module.news.presenter;

import com.fightzhao.news.base.BasePresenterImpl;
import com.fightzhao.news.greendao.NewsChannelTable;
import com.fightzhao.news.module.news.model.INewsInteractor;
import com.fightzhao.news.module.news.model.INewsInteractorImpl;
import com.fightzhao.news.module.news.view.view.INewsView;

import java.util.List;

/**
 * fightzhao on 16/8/22.
 * Function : 新闻代理接口实现
 * 1.继承BasePresenterImpl<V,D>,持有View和Data,implements INewsPresenter 进行功能扩展</>
 * 2.要持有model:mNewsInteractor,并在构造器中初始化
 * 3.观察者初始化
 * 4.持有的View进行通知更行页面
 */
public class INewsPresenterImpl extends BasePresenterImpl<INewsView,List<NewsChannelTable>> implements INewsPresenter {

    private INewsInteractor<List<NewsChannelTable>> mNewsInteractor;


    public INewsPresenterImpl(INewsView view) {
        super(view);
        mNewsInteractor =  new INewsInteractorImpl();
        mSubscription = mNewsInteractor.operateChannelDb(this);
        mView.initRxBusEvent();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void requestSuccess(List<NewsChannelTable> data) {
        mView.initViewPager(data);
    }

    @Override
    public void operateChannelDb() {
        mSubscription = mNewsInteractor.operateChannelDb(this);
    }
}
