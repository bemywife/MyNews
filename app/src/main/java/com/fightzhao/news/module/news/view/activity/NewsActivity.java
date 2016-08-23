package com.fightzhao.news.module.news.view.activity;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.fightzhao.news.R;
import com.fightzhao.news.app.ActivityFragmentInject;
import com.fightzhao.news.app.AppManager;
import com.fightzhao.news.base.BaseActivity;
import com.fightzhao.news.base.BaseFragment;
import com.fightzhao.news.greendao.NewsChannelTable;
import com.fightzhao.news.module.news.presenter.INewsPresenter;
import com.fightzhao.news.module.news.presenter.INewsPresenterImpl;
import com.fightzhao.news.module.news.view.fragment.NewsFragment;
import com.fightzhao.news.module.news.view.view.INewsView;
import com.fightzhao.news.utils.ViewUtil;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

import java.util.ArrayList;
import java.util.List;

@ActivityFragmentInject(contentViewId = R.layout.activity_news,
        menuId = R.menu.menu_news,
        hasNavigationView = true,
        toolbarTitle = R.string.news,
        toolbarIndicator = R.mipmap.ic_list_white,
        menuDefaultCheckedItem = R.id.action_news)
public class NewsActivity extends BaseActivity<INewsPresenter> implements INewsView {
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
        final MagicIndicator magicIndicator = (MagicIndicator) findViewById(R.id.magic_indicator);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        List<BaseFragment> fragments = new ArrayList<>();

        //自定义分Fragment
        final List<String> title = new ArrayList<>();


        if (newsChannels != null) {
            // 有除了固定的其他频道被选中，添加
            for (NewsChannelTable news : newsChannels) {
                final NewsFragment fragment = NewsFragment
                        .newInstance(news.getNewsChannelId(), news.getNewsChannelType(),
                                news.getNewsChannelIndex());

                fragments.add(fragment);
                title.add(news.getNewsChannelName());
            }


            // 当前页始终定位到中间--->类似于网易新闻客户端
            final CommonNavigator commonNavigator = new CommonNavigator(this);
            commonNavigator.setFollowTouch(false);
            commonNavigator.setEnablePivotScroll(true);
            commonNavigator.setScrollPivotX(0.15f);
            commonNavigator.setAdapter(new CommonNavigatorAdapter() {
                @Override
                public int getCount() {
                    return title == null ? 0 : title.size();
                }

                @Override
                public IPagerTitleView getItemView(Context context, final int index) {
                    ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
                    colorTransitionPagerTitleView.setText(title.get(index));
                    colorTransitionPagerTitleView.setNormalColor(Color.WHITE);
                    colorTransitionPagerTitleView.setSelectedColor(Color.RED);
                    colorTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            viewPager.setCurrentItem(index);
                        }
                    });
                    return colorTransitionPagerTitleView;
                }

                @Override
                public IPagerIndicator getIndicator(Context context) {
                    LinePagerIndicator indicator = new LinePagerIndicator(context);
                    List<String> colorList = new ArrayList<String>();
                    colorList.add("#ff4a42");
                    indicator.setColorList(colorList);
                    return indicator;
                }
            });
            magicIndicator.setNavigator(commonNavigator);


            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    magicIndicator.onPageScrolled(position, positionOffset, positionOffsetPixels);
                }

                @Override
                public void onPageSelected(int position) {
                    magicIndicator.onPageSelected(position);
                }

                @Override
                public void onPageScrollStateChanged(int state) {
                    magicIndicator.onPageScrollStateChanged(state);
                }
            });

        }
    }

    @Override
    public void initRxBusEvent() {

    }
}

