package dinostudio.coinmarketmonitor.base.contract;

import java.util.List;

import dinostudio.coinmarketmonitor.base.core.BasePresenter;
import dinostudio.coinmarketmonitor.base.core.BaseView;
import dinostudio.coinmarketmonitor.model.CoinDisplayInfo;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/7/17.
 */

public interface HomeContract {

    interface View extends BaseView {

        void onGetCoinInfoSuccess(List<CoinDisplayInfo> list);

        void onGetCoinInfoError();

        void onRequestUpdateToFast();
    }


    interface Presenter extends BasePresenter<View> {

        void getCoinInfo();

        void resetUpdateTime();

        boolean getNotificationVibrate();

        boolean getNotificationSound();

        int getAutoRefreshTime();

        boolean getAutoRefresh();

        void setPriceValue(String priceValue);

        String getPriceValue();

        void updateFavoriteCoin(CoinDisplayInfo coinDisplayInfo, boolean isFavorite);

    }

}
