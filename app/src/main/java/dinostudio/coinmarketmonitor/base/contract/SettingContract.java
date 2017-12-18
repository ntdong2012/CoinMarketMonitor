package dinostudio.coinmarketmonitor.base.contract;

import dinostudio.coinmarketmonitor.base.core.BasePresenter;
import dinostudio.coinmarketmonitor.base.core.BaseView;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/12/17.
 */

public interface SettingContract {

    interface View extends BaseView {

    }


    interface Presenter extends BasePresenter<View> {

        boolean getAlarmSound();

        boolean getAlarmVibration();

        boolean getAutoRefresh();

        void setAlarmSound(boolean isEnable);

        void setAlarmVibration(boolean isEnable);

        void setAutoRefresh(boolean isEnable);

        int getAutoRefreshTime();

        void setAutoRefreshTime(int time);

        void displayOnlyFavoriteCoin(boolean isDisplayOnly);

        void displayFavoriteCoinFirst(boolean isDisplayFirst);

        boolean isDisplayOnlyFavoriteCoin();

        boolean isDisplayFavoriteCoinFirst();

    }
}
