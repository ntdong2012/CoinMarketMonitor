package dinostudio.coinmarketmonitor.presenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dinostudio.coinmarketmonitor.base.contract.HomeContract;
import dinostudio.coinmarketmonitor.base.core.RxPresenter;
import dinostudio.coinmarketmonitor.base.model.DataManager;
import dinostudio.coinmarketmonitor.base.utils.CommonSubscriber;
import dinostudio.coinmarketmonitor.base.utils.DLogUtils;
import dinostudio.coinmarketmonitor.base.utils.RxUtil;
import dinostudio.coinmarketmonitor.base.utils.Utils;
import dinostudio.coinmarketmonitor.model.CoinDisplayInfo;
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
 * Created by nguyenthanhdong0109@gmail.com on 12/7/17.
 */

public class HomePresenter extends RxPresenter<HomeContract.View> implements HomeContract.Presenter {

    private DataManager mDataManager;


    boolean verifyTimeUpdate() {
        long lastUpdate = mDataManager.getTimeUpdateCoinInfo();
        long currentTime = Utils.getCurrentTime();
        if (currentTime - lastUpdate > 5 * 60 * 1000) return true;
        return false;
    }

    @Override
    public boolean getNotificationSound() {
        return mDataManager.getAlarmSound();
    }

    @Override
    public boolean getNotificationVibrate() {
        return mDataManager.getAlarmVibration();
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
    public void updateFavoriteCoin(CoinDisplayInfo coinDisplayInfo, boolean isFavorite) {
        switch (coinDisplayInfo.getPriceType()) {
            case "USD":
                mDataManager.updateFavoriteCoinInfo(coinDisplayInfo, isFavorite);
                break;
            case "AUD":
                mDataManager.updateFavoriteCoinInfoAud(coinDisplayInfo, isFavorite);
                break;
            case "CAD":
                mDataManager.updateFavoriteCoinInfoCad(coinDisplayInfo, isFavorite);
                break;
            case "EUR":
                mDataManager.updateFavoriteCoinInfoEur(coinDisplayInfo, isFavorite);
                break;
            case "GBP":
                mDataManager.updateFavoriteCoinInfoGpb(coinDisplayInfo, isFavorite);
                break;
            case "HKD":
                mDataManager.updateFavoriteCoinInfoHkd(coinDisplayInfo, isFavorite);
                break;
            case "JPY":
                mDataManager.updateFavoriteCoinInfoJpy(coinDisplayInfo, isFavorite);
                break;
            case "MXN":
                mDataManager.updateFavoriteCoinInfoMxn(coinDisplayInfo, isFavorite);
                break;
            case "BRL":
                mDataManager.updateFavoriteCoinInfoBrl(coinDisplayInfo, isFavorite);
                break;
            case "CNY":
                mDataManager.updateFavoriteCoinInfoCny(coinDisplayInfo, isFavorite);
                break;
            case "INR":
                mDataManager.updateFavoriteCoinInfoInr(coinDisplayInfo, isFavorite);
                break;
            case "KRW":
                mDataManager.updateFavoriteCoinInfoKrw(coinDisplayInfo, isFavorite);
                break;
            case "RUB":
                mDataManager.updateFavoriteCoinInfoRub(coinDisplayInfo, isFavorite);
                break;
            default:
                mDataManager.updateFavoriteCoinInfo(coinDisplayInfo, isFavorite);
                break;
        }
    }

    @Override
    public String getPriceValue() {
        return mDataManager.getPriceValue();
    }

    @Override
    public void setPriceValue(String priceValue) {
        mDataManager.setPriceValue(priceValue);
    }

    @Override
    public void resetUpdateTime() {
        mDataManager.setTimeUpdateCoinInfo(0L);
    }

    @Override
    public void getCoinInfo() {

        String priceSymbol = mDataManager.getPriceValue();
        final boolean isOnly = mDataManager.isDisplayOnlyFavoriteCoin();
        final boolean isFirst = mDataManager.isDisplayFavoriteCoinFirst();
        DLogUtils.d("PRICE SYMBOL " + priceSymbol + "IS ONLY: " + isOnly + " IS FIRST: " + isFirst);
        if (priceSymbol.equals("USD")) {
            final ArrayList<CoinInfo> localCoinInfos = mDataManager.getAllCoinInfos(isOnly, isFirst);
            if (localCoinInfos != null && localCoinInfos.size() > 0) {
                mView.onGetCoinInfoSuccess(Utils.convertCoin(localCoinInfos));
            }
        } else if (priceSymbol.equals("AUD")) {
            final ArrayList<CoinInfoAud> localCoinInfos = mDataManager.getCoinInfosAud(isOnly, isFirst);
            if (localCoinInfos != null && localCoinInfos.size() > 0) {
                mView.onGetCoinInfoSuccess(Utils.convertCoinAud(localCoinInfos));
            }
        } else if (priceSymbol.equals("CAD")) {
            final ArrayList<CoinInfoCad> localCoinInfos = mDataManager.getCoinInfosCad(isOnly, isFirst);
            if (localCoinInfos != null && localCoinInfos.size() > 0) {
                mView.onGetCoinInfoSuccess(Utils.convertCoinCad(localCoinInfos));
            }
        } else if (priceSymbol.equals("EUR")) {
            final ArrayList<CoinInfoEur> localCoinInfos = mDataManager.getCoinInfosEur(isOnly, isFirst);
            if (localCoinInfos != null && localCoinInfos.size() > 0) {
                mView.onGetCoinInfoSuccess(Utils.convertCoinEur(localCoinInfos));
            }
        } else if (priceSymbol.equals("GBP")) {
            final ArrayList<CoinInfoGbp> localCoinInfos = mDataManager.getCoinInfosGbp(isOnly, isFirst);
            if (localCoinInfos != null && localCoinInfos.size() > 0) {
                mView.onGetCoinInfoSuccess(Utils.convertCoinGbp(localCoinInfos));
            }
        } else if (priceSymbol.equals("HKD")) {
            final ArrayList<CoinInfoHkd> localCoinInfos = mDataManager.getCoinInfosHkd(isOnly, isFirst);
            if (localCoinInfos != null && localCoinInfos.size() > 0) {
                mView.onGetCoinInfoSuccess(Utils.convertCoinHkd(localCoinInfos));
            }
        } else if (priceSymbol.equals("JPY")) {
            final ArrayList<CoinInfoJpy> localCoinInfos = mDataManager.getCoinInfosJpy(isOnly, isFirst);
            if (localCoinInfos != null && localCoinInfos.size() > 0) {
                mView.onGetCoinInfoSuccess(Utils.convertCoinJpy(localCoinInfos));
            }
        } else if (priceSymbol.equals("MXN")) {
            final ArrayList<CoinInfoMxn> localCoinInfos = mDataManager.getCoinInfosMxn(isOnly, isFirst);
            if (localCoinInfos != null && localCoinInfos.size() > 0) {
                mView.onGetCoinInfoSuccess(Utils.convertCoinMxn(localCoinInfos));
            }
        } else if (priceSymbol.equals("BRL")) {
            final ArrayList<CoinInfoBrl> localCoinInfos = mDataManager.getCoinInfosBrl(isOnly, isFirst);
            if (localCoinInfos != null && localCoinInfos.size() > 0) {
                mView.onGetCoinInfoSuccess(Utils.convertCoinBrl(localCoinInfos));
            }
        } else if (priceSymbol.equals("CNY")) {
            final ArrayList<CoinInfoCny> localCoinInfos = mDataManager.getCoinInfosCny(isOnly, isFirst);
            if (localCoinInfos != null && localCoinInfos.size() > 0) {
                mView.onGetCoinInfoSuccess(Utils.convertCoinCny(localCoinInfos));
            }
        } else if (priceSymbol.equals("INR")) {
            final ArrayList<CoinInfoInr> localCoinInfos = mDataManager.getCoinInfosInr(isOnly, isFirst);
            if (localCoinInfos != null && localCoinInfos.size() > 0) {
                mView.onGetCoinInfoSuccess(Utils.convertCoinInr(localCoinInfos));
            }
        } else if (priceSymbol.equals("KRW")) {
            final ArrayList<CoinInfoKrw> localCoinInfos = mDataManager.getCoinInfosKrw(isOnly, isFirst);
            if (localCoinInfos != null && localCoinInfos.size() > 0) {
                mView.onGetCoinInfoSuccess(Utils.convertCoinKrw(localCoinInfos));
            }
        } else if (priceSymbol.equals("RUB")) {
            final ArrayList<CoinInfoRub> localCoinInfos = mDataManager.getCoinInfosRub(isOnly, isFirst);
            if (localCoinInfos != null && localCoinInfos.size() > 0) {
                mView.onGetCoinInfoSuccess(Utils.convertCoinRub(localCoinInfos));
            }
        } else {
            final ArrayList<CoinInfo> localCoinInfos = mDataManager.getAllCoinInfos(isOnly, isFirst);
            if (localCoinInfos != null && localCoinInfos.size() > 0) {
                mView.onGetCoinInfoSuccess(Utils.convertCoin(localCoinInfos));
            }
        }


        if (!verifyTimeUpdate()) {
            mView.onRequestUpdateToFast();
            return;
        }
        String url = "https://api.coinmarketcap.com/v1/ticker/?convert=" + priceSymbol;


        switch (priceSymbol) {
            case "USD":
                addSubscribe(mDataManager.getCoinInfos(url)
                        .compose(RxUtil.<List<CoinInfo>>rxSchedulerHelper())
                        .subscribeWith(new CommonSubscriber<List<CoinInfo>>(mView) {
                            @Override
                            public void onNext(List<CoinInfo> lists) {
                                mDataManager.saveCoinInfos((ArrayList<CoinInfo>) lists);
                                mView.onGetCoinInfoSuccess(Utils.convertCoin((ArrayList<CoinInfo>) mDataManager.getAllCoinInfos(isOnly, isFirst)));
                                mDataManager.setTimeUpdateCoinInfo(Utils.getCurrentTime());
                            }

                            @Override
                            public void onError(Throwable e) {
                                mView.onGetCoinInfoError();
                            }
                        })
                );
                break;
            case "AUD":
                addSubscribe(mDataManager.getCoinInfoAud(url)
                        .compose(RxUtil.<List<CoinInfoAud>>rxSchedulerHelper())
                        .subscribeWith(new CommonSubscriber<List<CoinInfoAud>>(mView) {
                            @Override
                            public void onNext(List<CoinInfoAud> lists) {
                                mDataManager.saveCoinInfoAud((ArrayList<CoinInfoAud>) lists);
                                mView.onGetCoinInfoSuccess(Utils.convertCoinAud((ArrayList<CoinInfoAud>) mDataManager.getCoinInfosAud(isOnly, isFirst)));
                                mDataManager.setTimeUpdateCoinInfo(Utils.getCurrentTime());
                            }

                            @Override
                            public void onError(Throwable e) {
                                mView.onGetCoinInfoError();
                            }
                        })
                );
                break;
            case "CAD":
                addSubscribe(mDataManager.getCoinInfoCad(url)
                        .compose(RxUtil.<List<CoinInfoCad>>rxSchedulerHelper())
                        .subscribeWith(new CommonSubscriber<List<CoinInfoCad>>(mView) {
                            @Override
                            public void onNext(List<CoinInfoCad> lists) {
                                mDataManager.saveCoinInfoCad((ArrayList<CoinInfoCad>) lists);
                                mView.onGetCoinInfoSuccess(Utils.convertCoinCad((ArrayList<CoinInfoCad>) mDataManager.getCoinInfosCad(isOnly, isFirst)));
                                mDataManager.setTimeUpdateCoinInfo(Utils.getCurrentTime());
                            }

                            @Override
                            public void onError(Throwable e) {
                                mView.onGetCoinInfoError();
                            }
                        })
                );
                break;
            case "EUR":
                addSubscribe(mDataManager.getCoinInfoEur(url)
                        .compose(RxUtil.<List<CoinInfoEur>>rxSchedulerHelper())
                        .subscribeWith(new CommonSubscriber<List<CoinInfoEur>>(mView) {
                            @Override
                            public void onNext(List<CoinInfoEur> lists) {
                                mDataManager.saveCoinInfoEur((ArrayList<CoinInfoEur>) lists);
                                mView.onGetCoinInfoSuccess(Utils.convertCoinEur(mDataManager.getCoinInfosEur(isOnly, isFirst)));
                                mDataManager.setTimeUpdateCoinInfo(Utils.getCurrentTime());
                            }

                            @Override
                            public void onError(Throwable e) {
                                mView.onGetCoinInfoError();
                            }
                        })
                );
                break;
            case "GBP":
                addSubscribe(mDataManager.getCoinInfoGbp(url)
                        .compose(RxUtil.<List<CoinInfoGbp>>rxSchedulerHelper())
                        .subscribeWith(new CommonSubscriber<List<CoinInfoGbp>>(mView) {
                            @Override
                            public void onNext(List<CoinInfoGbp> lists) {
                                mDataManager.saveCoinInfoGpb((ArrayList<CoinInfoGbp>) lists);
                                mView.onGetCoinInfoSuccess(Utils.convertCoinGbp(mDataManager.getCoinInfosGbp(isOnly, isFirst)));
                                mDataManager.setTimeUpdateCoinInfo(Utils.getCurrentTime());
                            }

                            @Override
                            public void onError(Throwable e) {
                                mView.onGetCoinInfoError();
                            }
                        })
                );

                break;
            case "HKD":
                addSubscribe(mDataManager.getCoinInfoHkd(url)
                        .compose(RxUtil.<List<CoinInfoHkd>>rxSchedulerHelper())
                        .subscribeWith(new CommonSubscriber<List<CoinInfoHkd>>(mView) {
                            @Override
                            public void onNext(List<CoinInfoHkd> lists) {
                                mDataManager.saveCoinInfoHkd((ArrayList<CoinInfoHkd>) lists);
                                mView.onGetCoinInfoSuccess(Utils.convertCoinHkd(mDataManager.getCoinInfosHkd(isOnly, isFirst)));
                                mDataManager.setTimeUpdateCoinInfo(Utils.getCurrentTime());
                            }

                            @Override
                            public void onError(Throwable e) {
                                mView.onGetCoinInfoError();
                            }
                        })
                );

                break;
            case "JPY":
                addSubscribe(mDataManager.getCoinInfoJpy(url)
                        .compose(RxUtil.<List<CoinInfoJpy>>rxSchedulerHelper())
                        .subscribeWith(new CommonSubscriber<List<CoinInfoJpy>>(mView) {
                            @Override
                            public void onNext(List<CoinInfoJpy> lists) {
                                mDataManager.saveCoinInfoJpy((ArrayList<CoinInfoJpy>) lists);
                                mView.onGetCoinInfoSuccess(Utils.convertCoinJpy(mDataManager.getCoinInfosJpy(isOnly, isFirst)));
                                mDataManager.setTimeUpdateCoinInfo(Utils.getCurrentTime());
                            }

                            @Override
                            public void onError(Throwable e) {
                                mView.onGetCoinInfoError();
                            }
                        })
                );
                break;
            case "MXN":
                addSubscribe(mDataManager.getCoinInfoMxn(url)
                        .compose(RxUtil.<List<CoinInfoMxn>>rxSchedulerHelper())
                        .subscribeWith(new CommonSubscriber<List<CoinInfoMxn>>(mView) {
                            @Override
                            public void onNext(List<CoinInfoMxn> lists) {
                                mDataManager.saveCoinInfoMxn((ArrayList<CoinInfoMxn>) lists);
                                mView.onGetCoinInfoSuccess(Utils.convertCoinMxn(mDataManager.getCoinInfosMxn(isOnly, isFirst)));
                                mDataManager.setTimeUpdateCoinInfo(Utils.getCurrentTime());
                            }

                            @Override
                            public void onError(Throwable e) {
                                mView.onGetCoinInfoError();
                            }
                        })
                );
                break;
            case "BRL":
                addSubscribe(mDataManager.getCoinInfoBrl(url)
                        .compose(RxUtil.<List<CoinInfoBrl>>rxSchedulerHelper())
                        .subscribeWith(new CommonSubscriber<List<CoinInfoBrl>>(mView) {
                            @Override
                            public void onNext(List<CoinInfoBrl> lists) {
                                mDataManager.saveCoinInfoBrl((ArrayList<CoinInfoBrl>) lists);
                                mView.onGetCoinInfoSuccess(Utils.convertCoinBrl(mDataManager.getCoinInfosBrl(isOnly, isFirst)));
                                mDataManager.setTimeUpdateCoinInfo(Utils.getCurrentTime());
                            }

                            @Override
                            public void onError(Throwable e) {
                                mView.onGetCoinInfoError();
                            }
                        })
                );
                break;
            case "CNY":
                addSubscribe(mDataManager.getCoinInfoCny(url)
                        .compose(RxUtil.<List<CoinInfoCny>>rxSchedulerHelper())
                        .subscribeWith(new CommonSubscriber<List<CoinInfoCny>>(mView) {
                            @Override
                            public void onNext(List<CoinInfoCny> lists) {
                                mDataManager.saveCoinInfoCny((ArrayList<CoinInfoCny>) lists);
                                mView.onGetCoinInfoSuccess(Utils.convertCoinCny(mDataManager.getCoinInfosCny(isOnly, isFirst)));
                                mDataManager.setTimeUpdateCoinInfo(Utils.getCurrentTime());
                            }

                            @Override
                            public void onError(Throwable e) {
                                mView.onGetCoinInfoError();
                            }
                        })
                );
                break;
            case "INR":
                addSubscribe(mDataManager.getCoinInfoInr(url)
                        .compose(RxUtil.<List<CoinInfoInr>>rxSchedulerHelper())
                        .subscribeWith(new CommonSubscriber<List<CoinInfoInr>>(mView) {
                            @Override
                            public void onNext(List<CoinInfoInr> lists) {
                                mDataManager.saveCoinInfoInr((ArrayList<CoinInfoInr>) lists);
                                mView.onGetCoinInfoSuccess(Utils.convertCoinInr(mDataManager.getCoinInfosInr(isOnly, isFirst)));
                                mDataManager.setTimeUpdateCoinInfo(Utils.getCurrentTime());
                            }

                            @Override
                            public void onError(Throwable e) {
                                mView.onGetCoinInfoError();
                            }
                        })
                );
                break;
            case "KRW":
                addSubscribe(mDataManager.getCoinInfoKwr(url)
                        .compose(RxUtil.<List<CoinInfoKrw>>rxSchedulerHelper())
                        .subscribeWith(new CommonSubscriber<List<CoinInfoKrw>>(mView) {
                            @Override
                            public void onNext(List<CoinInfoKrw> lists) {
                                mDataManager.saveCoinInfoKrw((ArrayList<CoinInfoKrw>) lists);
                                mView.onGetCoinInfoSuccess(Utils.convertCoinKrw(mDataManager.getCoinInfosKrw(isOnly, isFirst)));
                                mDataManager.setTimeUpdateCoinInfo(Utils.getCurrentTime());
                            }

                            @Override
                            public void onError(Throwable e) {
                                mView.onGetCoinInfoError();
                            }
                        })
                );
                break;
            case "RUB":
                addSubscribe(mDataManager.getCoinInfoRub(url)
                        .compose(RxUtil.<List<CoinInfoRub>>rxSchedulerHelper())
                        .subscribeWith(new CommonSubscriber<List<CoinInfoRub>>(mView) {
                            @Override
                            public void onNext(List<CoinInfoRub> lists) {
                                mDataManager.saveCoinInfoRub((ArrayList<CoinInfoRub>) lists);
                                mView.onGetCoinInfoSuccess(Utils.convertCoinRub(mDataManager.getCoinInfosRub(isOnly, isFirst)));
                                mDataManager.setTimeUpdateCoinInfo(Utils.getCurrentTime());
                            }

                            @Override
                            public void onError(Throwable e) {
                                mView.onGetCoinInfoError();
                            }
                        })
                );
                break;
            default:
                addSubscribe(mDataManager.getCoinInfos(url)
                        .compose(RxUtil.<List<CoinInfo>>rxSchedulerHelper())
                        .subscribeWith(new CommonSubscriber<List<CoinInfo>>(mView) {
                            @Override
                            public void onNext(List<CoinInfo> lists) {
                                mDataManager.saveCoinInfos((ArrayList<CoinInfo>) lists);
                                mView.onGetCoinInfoSuccess(Utils.convertCoin(mDataManager.getAllCoinInfos(isOnly, isFirst)));
                                mDataManager.setTimeUpdateCoinInfo(Utils.getCurrentTime());
                            }

                            @Override
                            public void onError(Throwable e) {
                                mView.onGetCoinInfoError();
                            }
                        })
                );
                break;


        }
    }

    @Inject
    public HomePresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

}
