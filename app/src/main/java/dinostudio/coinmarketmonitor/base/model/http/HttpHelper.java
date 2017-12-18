package dinostudio.coinmarketmonitor.base.model.http;

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

/**
 * Created by nguyenthanhdong0109@gmail.com on 5/20/17.
 */

public interface HttpHelper {

    Flowable<List<CoinInfo>> getCoinInfos(String url);

    Flowable<List<CoinInfoAud>> getCoinInfoAud(String url);

    Flowable<List<CoinInfoCad>> getCoinInfoCad(String url);

    Flowable<List<CoinInfoEur>> getCoinInfoEur(String url);

    Flowable<List<CoinInfoGbp>> getCoinInfoGbp(String url);

    Flowable<List<CoinInfoHkd>> getCoinInfoHkd(String url);

    Flowable<List<CoinInfoJpy>> getCoinInfoJpy(String url);

    Flowable<List<CoinInfoMxn>> getCoinInfoMxn(String url);

    Flowable<List<CoinInfoBrl>> getCoinInfoBrl(String url);

    Flowable<List<CoinInfoCny>> getCoinInfoCny(String url);

    Flowable<List<CoinInfoInr>> getCoinInfoInr(String url);

    Flowable<List<CoinInfoKrw>> getCoinInfoKwr(String url);

    Flowable<List<CoinInfoRub>> getCoinInfoRub(String url);

    Flowable<CharData> getCharDataByType(String url);
}
