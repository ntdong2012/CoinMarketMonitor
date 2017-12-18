package dinostudio.coinmarketmonitor.base.contract;

import dinostudio.coinmarketmonitor.base.core.BasePresenter;
import dinostudio.coinmarketmonitor.base.core.BaseView;
import dinostudio.coinmarketmonitor.model.CoinInfo;
import dinostudio.coinmarketmonitor.model.CoinInfoAud;
import dinostudio.coinmarketmonitor.model.CoinInfoBrl;
import dinostudio.coinmarketmonitor.model.CoinInfoCad;
import dinostudio.coinmarketmonitor.model.CoinInfoCny;
import dinostudio.coinmarketmonitor.model.CoinInfoEur;
import dinostudio.coinmarketmonitor.model.CoinInfoGbp;
import dinostudio.coinmarketmonitor.model.CoinInfoHkd;
import dinostudio.coinmarketmonitor.model.CoinInfoInr;
import dinostudio.coinmarketmonitor.model.CoinInfoJpy;
import dinostudio.coinmarketmonitor.model.CoinInfoKrw;
import dinostudio.coinmarketmonitor.model.CoinInfoMxn;
import dinostudio.coinmarketmonitor.model.CoinInfoRub;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/8/17.
 */

public interface CoinDetailContact {

    interface View extends BaseView {

        void onGetCoinInfoSuccess(CoinInfo coinInfo);

        void onGetCoinInfoSuccess(CoinInfoAud coinInfoAud);

        void onGetCoinInfoSuccess(CoinInfoBrl coinInfoBrl);

        void onGetCoinInfoSuccess(CoinInfoCad coinInfoCad);

        void onGetCoinInfoSuccess(CoinInfoCny coinInfoCny);

        void onGetCoinInfoSuccess(CoinInfoEur coinInfo);

        void onGetCoinInfoSuccess(CoinInfoGbp coinInfo);

        void onGetCoinInfoSuccess(CoinInfoHkd coinInfo);

        void onGetCoinInfoSuccess(CoinInfoInr coinInfo);

        void onGetCoinInfoSuccess(CoinInfoJpy coinInfo);

        void onGetCoinInfoSuccess(CoinInfoKrw coinInfo);

        void onGetCoinInfoSuccess(CoinInfoMxn coinInfo);

        void onGetCoinInfoSuccess(CoinInfoRub coinInfo);

    }


    interface Presenter extends BasePresenter<View> {

        void setPriceValue(String str);

        void getCoinInfoFromServer(String coinId);

        void getCoinInfo(String coinId);
    }
}
