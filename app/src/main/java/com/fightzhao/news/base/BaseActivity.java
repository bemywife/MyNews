package com.fightzhao.news.base;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;

import com.fightzhao.news.utils.slidr.model.SlidrInterface;

import rx.Observable;

/**
 * fightzhao on 16/8/12.
 * Function : Activity的基类
 */
public  class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView{
    /**
     * 将代理类通用行为抽取出来
     */
    protected  T mPresenter;

    /**
     * 标示该activity是否可滑动退出,默认false
     */
    protected boolean mEnableSlidr;

    /**
     * 布局Id
     */
    protected int mContentViewId;

    /**
     * 是否存在NavigationView
     */
    protected boolean mHasNavigationView;

    /**
     * 滑动布局
     */
    protected DrawerLayout mDrawerLayout;

    /**
     * 侧滑导航布局
     */
    protected NavigationView mNavigationView;

    /**
     * 菜单的id
     */
    private int mMenuId;

    /**
     * Toolbar标题
     */
    private int mToolbarTitle;

    /**
     * 默认选中的菜单项
     */
    private int mMenuDefaultCheckedItem;

    /**
     * Toolbar左侧按钮的样式
     */
    private int mToolbarIndicator;

    /**
     * 控制滑动与否的接口
     */
    protected SlidrInterface mSlidrInterface;


    /**
     * 结束Activity的可观测对象
     */
    private Observable<Boolean> mFinishObservable;

    /**
     * 跳转的类
     */
    private Class mClass;



    @Override
    public void toast(String msg) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showRequest() {

    }
}
