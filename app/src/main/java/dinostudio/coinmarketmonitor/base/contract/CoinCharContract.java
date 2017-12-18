package dinostudio.coinmarketmonitor.base.contract;

import dinostudio.coinmarketmonitor.base.core.BasePresenter;
import dinostudio.coinmarketmonitor.base.core.BaseView;
import dinostudio.coinmarketmonitor.model.AlarmInfo;
import dinostudio.coinmarketmonitor.model.CharData;
import dinostudio.coinmarketmonitor.model.CoinInfo;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/8/17.
 */

public interface CoinCharContract {

    interface View extends BaseView {

        void onGetCharDataSuccess(CharData charData);

        void onGetCharDataError(String str);

        void onGetCoinInfoSuccess(CoinInfo info);

        void onGetAlarmInfoSuccess(AlarmInfo alarmInfo);
    }


    interface Presenter extends BasePresenter<View> {

        void getCharDataByType(String coinId, int type);

        void getCoinInfo(String coinId);

        AlarmInfo getAlarmInfo(String coinId);

        void onUpdateAlarmInfo(String coinId, boolean above, boolean bellow, float aboveVl,
                               float belowValue);
    }
}
