package dinostudio.coinmarketmonitor.presenter;

import javax.inject.Inject;

import dinostudio.coinmarketmonitor.base.contract.SettingContract;
import dinostudio.coinmarketmonitor.base.core.RxPresenter;
import dinostudio.coinmarketmonitor.base.model.DataManager;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/12/17.
 */

public class SettingPresenter extends RxPresenter<SettingContract.View> implements SettingContract.Presenter {

    private DataManager mDataManager;

    @Inject
    public SettingPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }


    @Override
    public void displayOnlyFavoriteCoin(boolean isDisplayOnly) {
        mDataManager.displayOnlyFavoriteCoin(isDisplayOnly);
    }

    @Override
    public void displayFavoriteCoinFirst(boolean isDisplayFirst) {
        mDataManager.displayFavoriteCoinFirst(isDisplayFirst);
    }

    @Override
    public boolean isDisplayOnlyFavoriteCoin() {
        return mDataManager.isDisplayOnlyFavoriteCoin();
    }

    @Override
    public boolean isDisplayFavoriteCoinFirst() {
        return mDataManager.isDisplayFavoriteCoinFirst();
    }

    @Override
    public void setAutoRefreshTime(int time) {
        mDataManager.setAutoRefreshTime(time);
    }

    @Override
    public void setAutoRefresh(boolean isEnable) {
        mDataManager.setAutoRefresh(isEnable);
    }

    @Override
    public void setAlarmVibration(boolean isEnable) {
        mDataManager.setAlarmVibration(isEnable);
    }

    @Override
    public void setAlarmSound(boolean isEnable) {
        mDataManager.setAlarmSound(isEnable);
    }

    @Override
    public int getAutoRefreshTime() {
        return mDataManager.getAutoRefreshTime();
    }

    @Override
    public boolean getAutoRefresh() {
        return mDataManager.getAutoRefresh();
    }

    @Override
    public boolean getAlarmVibration() {
        return mDataManager.getAlarmVibration();
    }

    @Override
    public boolean getAlarmSound() {
        return mDataManager.getAlarmSound();
    }
}
