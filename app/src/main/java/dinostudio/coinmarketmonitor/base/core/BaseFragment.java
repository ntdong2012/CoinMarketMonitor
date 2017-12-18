package dinostudio.coinmarketmonitor.base.core;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import dinostudio.coinmarketmonitor.base.apps.CoinApps;
import dinostudio.coinmarketmonitor.base.dj.component.DaggerFragmentComponent;
import dinostudio.coinmarketmonitor.base.dj.component.FragmentComponent;
import dinostudio.coinmarketmonitor.base.dj.module.FragmentModule;
import dinostudio.coinmarketmonitor.base.utils.SnackbarUtil;


/**
 * Created by nguyenthanhdong0109@gmail.com on 5/21/17.
 */

public abstract class BaseFragment<T extends BasePresenter> extends SimpleFragment implements BaseView {

    @Inject
    protected T mPresenter;

    protected FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .appComponent(CoinApps.getAppComponent(true))
                .fragmentModule(getFragmentModule())
                .build();
    }

    protected FragmentModule getFragmentModule() {
        return new FragmentModule(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initInject();
        mPresenter.attachView(this);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
//        DLogUtils.d("onDestroyView");
        if (mPresenter != null) mPresenter.detachView();
        super.onDestroyView();
    }

    @Override
    public void showErrorMsg(String msg) {
        SnackbarUtil.show(((ViewGroup) getActivity().findViewById(android.R.id.content)).getChildAt(0), msg);
    }

    @Override
    public void useNightMode(boolean isNight) {

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
