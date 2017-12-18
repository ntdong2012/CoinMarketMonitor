package dinostudio.coinmarketmonitor.presenter;

import javax.inject.Inject;

import dinostudio.coinmarketmonitor.base.contract.CoinCharContract;
import dinostudio.coinmarketmonitor.base.core.RxPresenter;
import dinostudio.coinmarketmonitor.base.model.DataManager;
import dinostudio.coinmarketmonitor.base.utils.Common;
import dinostudio.coinmarketmonitor.base.utils.CommonSubscriber;
import dinostudio.coinmarketmonitor.base.utils.RxUtil;
import dinostudio.coinmarketmonitor.base.utils.Utils;
import dinostudio.coinmarketmonitor.model.AlarmInfo;
import dinostudio.coinmarketmonitor.model.CharData;
import dinostudio.coinmarketmonitor.model.CoinInfo;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/8/17.
 */

public class CoinCharPresenter extends RxPresenter<CoinCharContract.View> implements CoinCharContract.Presenter {


    private DataManager mDataManager;

    @Override
    public void getCoinInfo(String coinId) {
        CoinInfo info = mDataManager.getCoinInfoById(coinId);
        mView.onGetCoinInfoSuccess(info);
    }

    @Inject
    public CoinCharPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void onUpdateAlarmInfo(String coinId, boolean above, boolean bellow, float aboveVl, float belowValue) {
        mDataManager.onUpdateAlarmInfo(coinId, above, bellow, aboveVl, belowValue);
    }

    @Override
    public AlarmInfo getAlarmInfo(String coinId) {
        AlarmInfo info = mDataManager.getAlarmInfo(coinId);
        return info;
    }

    @Override
    public void getCharDataByType(String coinId, int type) {

        String url = "https://graphs.coinmarketcap.com/currencies/" + coinId + "/";
        switch (type) {
            case Common.CHAR_TIME_VALUE.DAY:
                url = url + Utils.getTimeForChar(-1) + "/" + Utils.getCurrentTimeForChar();
                break;
            case Common.CHAR_TIME_VALUE.WEEK:
                url = url + Utils.getTimeForChar(-7) + "/" + Utils.getCurrentTimeForChar();
                break;
            case Common.CHAR_TIME_VALUE.MONTH:
                url = url + Utils.getTimeForChar(-30) + "/" + Utils.getCurrentTimeForChar();
                break;
            case Common.CHAR_TIME_VALUE.YEAR:
                url = url + Utils.getTimeForChar(-365) + "/" + Utils.getCurrentTimeForChar();
                break;
            default:
                break;

        }
        addSubscribe(mDataManager.getCharDataByType(url)
                .compose(RxUtil.<CharData>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<CharData>(mView) {
                    @Override
                    public void onNext(CharData charData) {
                        mView.onGetCharDataSuccess(charData);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.fillInStackTrace();
                        mView.onGetCharDataError(e.getMessage());
                    }
                })
        );
    }
}

