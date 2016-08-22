package com.fightzhao.news.module.news.model;

import com.fightzhao.news.R;
import com.fightzhao.news.app.App;
import com.fightzhao.news.callback.RequestCallback;
import com.fightzhao.news.greendao.NewsChannelTable;
import com.fightzhao.news.greendao.NewsChannelTableDao;
import com.fightzhao.news.utils.SpUtil;
import com.socks.library.KLog;

import org.greenrobot.greendao.query.Query;

import java.util.Arrays;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * fightzhao on 16/8/22.
 * Function :
 */
public class INewsInteractorImpl implements INewsInteractor<List<NewsChannelTable>> {
    @Override
    public Subscription operateChannelDb(final RequestCallback<List<NewsChannelTable>> callback) {
        return Observable.create(new Observable.OnSubscribe<List<NewsChannelTable>>() {
            @Override
            public void call(Subscriber<? super List<NewsChannelTable>> subscriber) {
                final NewsChannelTableDao dao = ((App) App.getContext()).getDaoSession().getNewsChannelTableDao();
                KLog.e("初始化了数据库了吗？ " + SpUtil.readBoolean("initDb"));

                if (!SpUtil.readBoolean("initDb")) {
                    List<String> channelName = Arrays.asList(App.getContext().getResources().getStringArray(R.array.news_channel));
                    List<String> channelId = Arrays.asList(App.getContext().getResources().getStringArray(R.array.news_channel_id));

                    for (int i = 0; i < channelName.size(); i++)
                        SpUtil.writeBoolean("initDb", true);
                    KLog.e("数据库初始化完毕！");
                }

                final Query<NewsChannelTable> build = dao.queryBuilder()
                        .where(NewsChannelTableDao.Properties.NewsChannelSelect.eq(true))
                        .orderAsc(NewsChannelTableDao.Properties.NewsChannelIndex).build();
                subscriber.onNext(build.list());
                subscriber.onCompleted();

            }
        }).
                subscribeOn(Schedulers.io())//事件发生
                .observeOn(AndroidSchedulers.mainThread())//事件消费
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        callback.beforeRequest();
                    }
                })//消费前准备
                .subscribe(new Subscriber<List<NewsChannelTable>>() {
                    @Override
                    public void onCompleted() {
                        callback.requestComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        KLog.e(e.getLocalizedMessage() + "\n" + e);
                        callback.requestError(e.getLocalizedMessage() + "\n" + e);
                    }

                    @Override
                    public void onNext(List<NewsChannelTable> newsChannelTables) {
                        callback.requestSuccess(newsChannelTables);
                    }
                })//注册
                ;
    }
}
