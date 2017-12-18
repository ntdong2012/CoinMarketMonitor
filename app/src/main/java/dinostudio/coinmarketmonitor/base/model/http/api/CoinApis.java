package dinostudio.coinmarketmonitor.base.model.http.api;

import java.util.List;

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
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by nguyenthanhdong0109@gmail.com on 5/20/17.
 */

public interface CoinApis {

    @GET
    Flowable<List<CoinInfo>> getCoinInfos(@Url String url);

    @GET
    Flowable<List<CoinInfoRub>> getCoinInfoRubsFromApi(@Url String url);

    @GET
    Flowable<List<CoinInfoAud>> getCoinInfoAudsFromApi(@Url String url);

    @GET
    Flowable<List<CoinInfoCad>> getCoinInfoCadsFromApi(@Url String url);

    @GET
    Flowable<List<CoinInfoEur>> getCoinInfoEursFromApi(@Url String url);

    @GET
    Flowable<List<CoinInfoGbp>> getCoinInfoGbpsFromApi(@Url String url);

    @GET
    Flowable<List<CoinInfoHkd>> getCoinInfoHkdsFromApi(@Url String url);

    @GET
    Flowable<List<CoinInfoJpy>> getCoinInfoJpysFromApi(@Url String url);

    @GET
    Flowable<List<CoinInfoMxn>> getCoinInfoMxnsFromApi(@Url String url);

    @GET
    Flowable<List<CoinInfoBrl>> getCoinInfoBrlsFromApi(@Url String url);

    @GET
    Flowable<List<CoinInfoCny>> getCoinInfoCnysFromApi(@Url String url);

    @GET
    Flowable<List<CoinInfoInr>> getCoinInfoInrsFromApi(@Url String url);

    @GET
    Flowable<List<CoinInfoKrw>> getCoinInfoKrwsFromApi(@Url String url);


    @GET
    Flowable<CharData> getCharDataByType(@Url String url);

}
