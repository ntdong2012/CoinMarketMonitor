package dinostudio.coinmarketmonitor.base.model.http;

import java.util.List;

import javax.inject.Inject;

import dinostudio.coinmarketmonitor.base.model.http.api.CoinApis;
import dinostudio.coinmarketmonitor.base.model.http.api.MuseumApi;
import dinostudio.coinmarketmonitor.model.CharData;
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
import io.reactivex.Flowable;

/**
 * Created by nguyenthanhdong0109@gmail.com on 5/20/17.
 */

public class RetrofitHelper implements HttpHelper {

    private CoinApis coinApis;
    private MuseumApi museumApi;

    @Override
    public Flowable<List<CoinInfo>> getCoinInfos(String url) {
        return coinApis.getCoinInfos(url);
    }

    @Override
    public Flowable<List<CoinInfoAud>> getCoinInfoAud(String url) {
        return coinApis.getCoinInfoAudsFromApi(url);
    }

    @Override
    public Flowable<List<CoinInfoCad>> getCoinInfoCad(String url) {
        return coinApis.getCoinInfoCadsFromApi(url);
    }

    @Override
    public Flowable<List<CoinInfoEur>> getCoinInfoEur(String url) {
        return coinApis.getCoinInfoEursFromApi(url);
    }

    @Override
    public Flowable<List<CoinInfoGbp>> getCoinInfoGbp(String url) {
        return coinApis.getCoinInfoGbpsFromApi(url);
    }

    @Override
    public Flowable<List<CoinInfoHkd>> getCoinInfoHkd(String url) {
        return coinApis.getCoinInfoHkdsFromApi(url);
    }

    @Override
    public Flowable<List<CoinInfoJpy>> getCoinInfoJpy(String url) {
        return coinApis.getCoinInfoJpysFromApi(url);
    }

    @Override
    public Flowable<List<CoinInfoMxn>> getCoinInfoMxn(String url) {
        return coinApis.getCoinInfoMxnsFromApi(url);
    }

    @Override
    public Flowable<List<CoinInfoBrl>> getCoinInfoBrl(String url) {
        return coinApis.getCoinInfoBrlsFromApi(url);
    }

    @Override
    public Flowable<List<CoinInfoCny>> getCoinInfoCny(String url) {
        return coinApis.getCoinInfoCnysFromApi(url);
    }

    @Override
    public Flowable<List<CoinInfoInr>> getCoinInfoInr(String url) {
        return coinApis.getCoinInfoInrsFromApi(url);
    }

    @Override
    public Flowable<List<CoinInfoKrw>> getCoinInfoKwr(String url) {
        return coinApis.getCoinInfoKrwsFromApi(url);
    }

    @Override
    public Flowable<List<CoinInfoRub>> getCoinInfoRub(String url) {
        return coinApis.getCoinInfoRubsFromApi(url);
    }

    @Inject
    public RetrofitHelper(CoinApis coinApis, MuseumApi museumApi) {
        this.coinApis = coinApis;
        this.museumApi = museumApi;
    }

    @Override
    public Flowable<CharData> getCharDataByType(String url) {
        return coinApis.getCharDataByType(url);
    }
}
