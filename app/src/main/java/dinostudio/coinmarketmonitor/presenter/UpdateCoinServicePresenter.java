package dinostudio.coinmarketmonitor.presenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dinostudio.coinmarketmonitor.base.apps.CoinApps;
import dinostudio.coinmarketmonitor.base.contract.UpdateCoinServiceContract;
import dinostudio.coinmarketmonitor.base.core.RxPresenter;
import dinostudio.coinmarketmonitor.base.model.DataManager;
import dinostudio.coinmarketmonitor.base.utils.CommonSubscriber;
import dinostudio.coinmarketmonitor.base.utils.DLogUtils;
import dinostudio.coinmarketmonitor.base.utils.NotificationUtils;
import dinostudio.coinmarketmonitor.base.utils.RxUtil;
import dinostudio.coinmarketmonitor.model.AlarmInfo;
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
 * Created by nguyenthanhdong0109@gmail.com on 12/13/17.
 */

public class UpdateCoinServicePresenter extends RxPresenter<UpdateCoinServiceContract.View> implements UpdateCoinServiceContract.Presenter {

    private DataManager mDataManager;

    @Inject
    public UpdateCoinServicePresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void getCoinInfo() {
        String priceSymbol = mDataManager.getPriceValue();

        final boolean isOnly = mDataManager.isDisplayOnlyFavoriteCoin();
        final boolean isFirst = mDataManager.isDisplayFavoriteCoinFirst();
        DLogUtils.d("PRICE SYMBOL " + priceSymbol);

        String url = "https://api.coinmarketcap.com/v1/ticker/?convert=" + priceSymbol;
        if (!priceSymbol.equals("USD")) {
            updateUsdCoin();
        }

        switch (priceSymbol) {
            case "USD":
                addSubscribe(mDataManager.getCoinInfos(url)
                        .compose(RxUtil.<List<CoinInfo>>rxSchedulerHelper())
                        .subscribeWith(new CommonSubscriber<List<CoinInfo>>(mView) {
                            @Override
                            public void onNext(List<CoinInfo> lists) {
                                mDataManager.saveCoinInfos((ArrayList<CoinInfo>) lists);
                            }

                            @Override
                            public void onError(Throwable e) {
                                DLogUtils.d("Update Error: " + e.getMessage());
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
                            }

                            @Override
                            public void onError(Throwable e) {
                                DLogUtils.d("Update Error: " + e.getMessage());
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
                            }

                            @Override
                            public void onError(Throwable e) {
                                DLogUtils.d("Update Error: " + e.getMessage());
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
                            }

                            @Override
                            public void onError(Throwable e) {
                                DLogUtils.d("Update Error: " + e.getMessage());
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
                            }

                            @Override
                            public void onError(Throwable e) {
                                DLogUtils.d("Update Error: " + e.getMessage());
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

                            }

                            @Override
                            public void onError(Throwable e) {
                                DLogUtils.d("Update Error: " + e.getMessage());
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
                            }

                            @Override
                            public void onError(Throwable e) {
                                DLogUtils.d("Update Error: " + e.getMessage());
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
                            }

                            @Override
                            public void onError(Throwable e) {
                                DLogUtils.d("Update Error: " + e.getMessage());
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
                            }

                            @Override
                            public void onError(Throwable e) {
                                DLogUtils.d("Update Error: " + e.getMessage());
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
                            }

                            @Override
                            public void onError(Throwable e) {
                                DLogUtils.d("Update Error: " + e.getMessage());
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
                            }

                            @Override
                            public void onError(Throwable e) {
                                DLogUtils.d("Update Error: " + e.getMessage());
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
                            }

                            @Override
                            public void onError(Throwable e) {
                                DLogUtils.d("Update Error: " + e.getMessage());
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
                            }

                            @Override
                            public void onError(Throwable e) {
                                DLogUtils.d("Update Error: " + e.getMessage());
                            }
                        })
                );
                break;
            default:
                url = "https://api.coinmarketcap.com/v1/ticker/?convert=USD";
                addSubscribe(mDataManager.getCoinInfos(url)
                        .compose(RxUtil.<List<CoinInfo>>rxSchedulerHelper())
                        .subscribeWith(new CommonSubscriber<List<CoinInfo>>(mView) {
                            @Override
                            public void onNext(List<CoinInfo> lists) {
                                mDataManager.saveCoinInfos((ArrayList<CoinInfo>) lists);
                            }

                            @Override
                            public void onError(Throwable e) {
                                DLogUtils.d("Update Error: " + e.getMessage());
                            }
                        })
                );
                break;

        }
    }

    void updateUsdCoin() {
        String url = "https://api.coinmarketcap.com/v1/ticker/?convert=USD";
        addSubscribe(mDataManager.getCoinInfos(url)
                .compose(RxUtil.<List<CoinInfo>>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<List<CoinInfo>>(mView) {
                    @Override
                    public void onNext(List<CoinInfo> lists) {
                        mDataManager.saveCoinInfos((ArrayList<CoinInfo>) lists);
                        checkForShowNotification((ArrayList<CoinInfo>) lists);
                    }

                    @Override
                    public void onError(Throwable e) {
                        DLogUtils.d("Update Error: " + e.getMessage());
                    }
                })
        );
    }

    private void checkForShowNotification(ArrayList<CoinInfo> coinInfos) {
        ArrayList<AlarmInfo> alarmInfos = mDataManager.getAllAlarms();

        if (alarmInfos != null && alarmInfos.size() > 0) {
            for (int i = 0; i < alarmInfos.size(); i++) {
                AlarmInfo info = alarmInfos.get(i);
                for (int j = 0; j < coinInfos.size(); j++) {
                    CoinInfo coin = coinInfos.get(j);
                    if (info.getCoinId().equals(coin.getId())) {
                        if (Float.parseFloat(coin.getPriceUsd()) >= info.getPriceAbove()) {
                            NotificationUtils.showNotification(CoinApps.getInstance().getApplicationContext(), "Coin " + coin.getSymbol() + " has "
                                    + coin.getPriceUsd() + "USD", mDataManager.getAlarmSound(), mDataManager.getAlarmVibration());
                        } else if (Float.parseFloat(coin.getPriceUsd()) <= info.getPriceBelow()) {
                            NotificationUtils.showNotification(CoinApps.getInstance().getApplicationContext(), "Coin " + coin.getSymbol() + " has "
                                    + coin.getPriceUsd() + "USD", mDataManager.getAlarmSound(), mDataManager.getAlarmVibration());
                        }
                    }
                }
            }
        }
    }
}
