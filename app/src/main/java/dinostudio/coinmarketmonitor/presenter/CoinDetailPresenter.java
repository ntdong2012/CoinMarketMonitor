package dinostudio.coinmarketmonitor.presenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dinostudio.coinmarketmonitor.base.contract.CoinDetailContact;
import dinostudio.coinmarketmonitor.base.core.RxPresenter;
import dinostudio.coinmarketmonitor.base.model.DataManager;
import dinostudio.coinmarketmonitor.base.utils.CommonSubscriber;
import dinostudio.coinmarketmonitor.base.utils.RxUtil;
import dinostudio.coinmarketmonitor.base.utils.Utils;
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

public class CoinDetailPresenter extends RxPresenter<CoinDetailContact.View> implements CoinDetailContact.Presenter {

    private DataManager mDataManager;

    @Override
    public void setPriceValue(String str) {
        mDataManager.setPriceValue(str);
    }

    @Override
    public void getCoinInfoFromServer(final String coinId) {
        String priceSymbol = mDataManager.getPriceValue();
        String url = "https://api.coinmarketcap.com/v1/ticker/" + coinId + "/?convert=" + priceSymbol;
        switch (priceSymbol) {
            case "USD":
                addSubscribe(mDataManager.getCoinInfos(url)
                        .compose(RxUtil.<List<CoinInfo>>rxSchedulerHelper())
                        .subscribeWith(new CommonSubscriber<List<CoinInfo>>(mView) {
                            @Override
                            public void onNext(List<CoinInfo> lists) {
                                mDataManager.saveCoinInfos((ArrayList<CoinInfo>) lists);
                                mView.onGetCoinInfoSuccess(mDataManager.getCoinInfoById(coinId));
                                mDataManager.setTimeUpdateCoinInfo(Utils.getCurrentTime());
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
                                mView.onGetCoinInfoSuccess(mDataManager.getCoinInfoAudById(coinId));
                                mDataManager.setTimeUpdateCoinInfo(Utils.getCurrentTime());
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
                                mView.onGetCoinInfoSuccess(mDataManager.getCoinInfoCadById(coinId));
                                mDataManager.setTimeUpdateCoinInfo(Utils.getCurrentTime());
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
                                mView.onGetCoinInfoSuccess(mDataManager.getCoinInfoEurById(coinId));
                                mDataManager.setTimeUpdateCoinInfo(Utils.getCurrentTime());
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
                                mView.onGetCoinInfoSuccess(mDataManager.getCoinInfoGpbById(coinId));
                                mDataManager.setTimeUpdateCoinInfo(Utils.getCurrentTime());
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
                                mView.onGetCoinInfoSuccess(mDataManager.getCoinInfoHkdById(coinId));
                                mDataManager.setTimeUpdateCoinInfo(Utils.getCurrentTime());
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
                                mView.onGetCoinInfoSuccess(mDataManager.getCoinInfoJpyById(coinId));
                                mDataManager.setTimeUpdateCoinInfo(Utils.getCurrentTime());
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
                                mView.onGetCoinInfoSuccess(mDataManager.getCoinInfoMxnById(coinId));
                                mDataManager.setTimeUpdateCoinInfo(Utils.getCurrentTime());
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
                                mView.onGetCoinInfoSuccess(mDataManager.getCoinInfoBrlById(coinId));
                                mDataManager.setTimeUpdateCoinInfo(Utils.getCurrentTime());
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
                                mView.onGetCoinInfoSuccess(mDataManager.getCoinInfoCnyById(coinId));
                                mDataManager.setTimeUpdateCoinInfo(Utils.getCurrentTime());
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
                                mView.onGetCoinInfoSuccess(mDataManager.getCoinInfoInrById(coinId));
                                mDataManager.setTimeUpdateCoinInfo(Utils.getCurrentTime());
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
                                mView.onGetCoinInfoSuccess(mDataManager.getCoinInfoKwrById(coinId));
                                mDataManager.setTimeUpdateCoinInfo(Utils.getCurrentTime());
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
                                mView.onGetCoinInfoSuccess(mDataManager.getCoinInfoRubById(coinId));
                                mDataManager.setTimeUpdateCoinInfo(Utils.getCurrentTime());
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
                                mView.onGetCoinInfoSuccess(mDataManager.getCoinInfoById(coinId));
                                mDataManager.setTimeUpdateCoinInfo(Utils.getCurrentTime());
                            }
                        })
                );
                break;
        }
    }

    @Override
    public void getCoinInfo(String coinId) {
        String priceSymbol = mDataManager.getPriceValue();
        switch (priceSymbol) {
            case "USD":
                CoinInfo info = mDataManager.getCoinInfoById(coinId);
                mView.onGetCoinInfoSuccess(info);
                break;
            case "AUD":
                CoinInfoAud infoAud = mDataManager.getCoinInfoAudById(coinId);
                mView.onGetCoinInfoSuccess(infoAud);
                break;
            case "CAD":
                CoinInfoCad infoCad = mDataManager.getCoinInfoCadById(coinId);
                mView.onGetCoinInfoSuccess(infoCad);
                break;
            case "EUR":
                CoinInfoEur infoEur = mDataManager.getCoinInfoEurById(coinId);
                mView.onGetCoinInfoSuccess(infoEur);
                break;
            case "GBP":
                CoinInfoGbp infoGbp = mDataManager.getCoinInfoGpbById(coinId);
                mView.onGetCoinInfoSuccess(infoGbp);
                break;
            case "HKD":
                CoinInfoHkd infoHkd = mDataManager.getCoinInfoHkdById(coinId);
                mView.onGetCoinInfoSuccess(infoHkd);
                break;
            case "JPY":
                CoinInfoJpy infoJpy = mDataManager.getCoinInfoJpyById(coinId);
                mView.onGetCoinInfoSuccess(infoJpy);
                break;
            case "MXN":
                CoinInfoMxn infoMxn = mDataManager.getCoinInfoMxnById(coinId);
                mView.onGetCoinInfoSuccess(infoMxn);
                break;
            case "BRL":
                CoinInfoBrl infoBrl = mDataManager.getCoinInfoBrlById(coinId);
                mView.onGetCoinInfoSuccess(infoBrl);
                break;
            case "CNY":
                CoinInfoCny infoCny = mDataManager.getCoinInfoCnyById(coinId);
                mView.onGetCoinInfoSuccess(infoCny);
                break;
            case "INR":
                CoinInfoInr infoInr = mDataManager.getCoinInfoInrById(coinId);
                mView.onGetCoinInfoSuccess(infoInr);
                break;
            case "KRW":
                CoinInfoKrw infoKrw = mDataManager.getCoinInfoKwrById(coinId);
                mView.onGetCoinInfoSuccess(infoKrw);
                break;
            case "RUB":
                CoinInfoRub infoRub = mDataManager.getCoinInfoRubById(coinId);
                mView.onGetCoinInfoSuccess(infoRub);
                break;
            default:
                CoinInfo infoDf = mDataManager.getCoinInfoById(coinId);
                mView.onGetCoinInfoSuccess(infoDf);
                break;
        }

        getCoinInfoFromServer(coinId);
    }

    @Inject
    public CoinDetailPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }
}
