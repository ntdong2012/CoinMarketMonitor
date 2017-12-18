package dinostudio.coinmarketmonitor.base.core;

import android.support.v7.app.AppCompatDelegate;
import android.view.ViewGroup;

import javax.inject.Inject;

import dinostudio.coinmarketmonitor.base.apps.CoinApps;
import dinostudio.coinmarketmonitor.base.dj.component.ActivityComponent;
import dinostudio.coinmarketmonitor.base.dj.component.DaggerActivityComponent;
import dinostudio.coinmarketmonitor.base.dj.module.ActivityModule;
import dinostudio.coinmarketmonitor.base.utils.SnackbarUtil;


/**
 * Created by nguyenthanhdong0109@gmail.com on 4/27/17.
 */


public abstract class BaseActivity<T extends BasePresenter> extends SimpleActivity implements BaseView {

    @Inject
    protected T mPresenter;

    protected ActivityComponent getActivityComponent(boolean isNeedResfresh) {
        return DaggerActivityComponent.builder()
                .appComponent(CoinApps.getAppComponent(isNeedResfresh))
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        initInject();
        if (mPresenter != null)
            mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    @Override
    public void showErrorMsg(String msg) {
        SnackbarUtil.show(((ViewGroup) findViewById(android.R.id.content)).getChildAt(0), msg);
    }

    @Override
    public void useNightMode(boolean isNight) {
        if (isNight) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO);
        }
        recreate();
    }

    @Override
    public void stateError() {
    }

    @Override
    public void stateLoading() {
    }

    @Override
    public void stateMain() {
    }

    protected abstract void initInject();
}
