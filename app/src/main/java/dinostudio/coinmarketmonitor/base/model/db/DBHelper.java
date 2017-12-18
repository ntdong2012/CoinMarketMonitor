package dinostudio.coinmarketmonitor.base.model.db;

import java.util.ArrayList;

import dinostudio.coinmarketmonitor.model.AlarmInfo;
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
 * @author: Est <nguyenthanhdong0109@gmail.com>
 * @date: 2017/4/21
 * @description:
 */

public interface DBHelper {

    AlarmInfo getAlarmInfo(String id);

    ArrayList<AlarmInfo> getAllAlarms();

    CoinInfo getCoinInfoById(String id);
    CoinInfoAud getCoinInfoAudById(String id);
    CoinInfoCad getCoinInfoCadById(String id);
    CoinInfoEur getCoinInfoEurById(String id);
    CoinInfoGbp getCoinInfoGpbById(String id);
    CoinInfoHkd getCoinInfoHkdById(String id);
    CoinInfoJpy getCoinInfoJpyById(String id);
    CoinInfoMxn getCoinInfoMxnById(String id);
    CoinInfoBrl getCoinInfoBrlById(String id);
    CoinInfoCny getCoinInfoCnyById(String id);
    CoinInfoKrw getCoinInfoKwrById(String id);
    CoinInfoRub getCoinInfoRubById(String id);
    CoinInfoInr getCoinInfoInrById(String coinId);

    void onUpdateAlarmInfo(String coinId, boolean above, boolean bellow, float aboveVl,
                           float belowValue);

    void updateFavoriteCoinInfo(CoinDisplayInfo coinDisplayInfo, boolean isFavorite);

    void saveCoinInfos(ArrayList<CoinInfo> coinInfos);

    void saveCoinInfoAud(ArrayList<CoinInfoAud> coinInfoAuds);

    void updateFavoriteCoinInfoAud(CoinDisplayInfo coinDisplayInfo, boolean isFavorite);

    void saveCoinInfoCad(ArrayList<CoinInfoCad> coinInfoCads);

    void updateFavoriteCoinInfoCad(CoinDisplayInfo coinDisplayInfo, boolean isFavorite);

    void saveCoinInfoEur(ArrayList<CoinInfoEur> coinInfoEurs);

    void updateFavoriteCoinInfoEur(CoinDisplayInfo coinDisplayInfo, boolean isFavorite);

    void saveCoinInfoGpb(ArrayList<CoinInfoGbp> coinInfoGbps);

    void updateFavoriteCoinInfoGpb(CoinDisplayInfo coinDisplayInfo, boolean isFavorite);

    void saveCoinInfoHkd(ArrayList<CoinInfoHkd> coinInfoHkds);

    void updateFavoriteCoinInfoHkd(CoinDisplayInfo coinDisplayInfo, boolean isFavorite);

    void saveCoinInfoJpy(ArrayList<CoinInfoJpy> coinInfoJpys);

    void updateFavoriteCoinInfoJpy(CoinDisplayInfo coinDisplayInfo, boolean isFavorite);

    void saveCoinInfoMxn(ArrayList<CoinInfoMxn> coinInfoMxns);

    void updateFavoriteCoinInfoMxn(CoinDisplayInfo coinDisplayInfo, boolean isFavorite);

    void saveCoinInfoBrl(ArrayList<CoinInfoBrl> coinInfoBrls);

    void updateFavoriteCoinInfoBrl(CoinDisplayInfo coinDisplayInfo, boolean isFavorite);

    void saveCoinInfoCny(ArrayList<CoinInfoCny> coinInfoCnys);

    void updateFavoriteCoinInfoCny(CoinDisplayInfo coinDisplayInfo, boolean isFavorite);

    void saveCoinInfoInr(ArrayList<CoinInfoInr> coinInfoInrs);

    void updateFavoriteCoinInfoInr(CoinDisplayInfo coinDisplayInfo, boolean isFavorite);

    void saveCoinInfoKrw(ArrayList<CoinInfoKrw> coinInfoKrws);

    void updateFavoriteCoinInfoKrw(CoinDisplayInfo coinDisplayInfo, boolean isFavorite);

    void saveCoinInfoRub(ArrayList<CoinInfoRub> coinInfoRubs);

    void updateFavoriteCoinInfoRub(CoinDisplayInfo coinDisplayInfo, boolean isFavorite);


    ArrayList<CoinInfoAud> getCoinInfosAud(boolean isOnly, boolean isFirst);

    ArrayList<CoinInfoCad> getCoinInfosCad(boolean isOnly, boolean isFirst);

    ArrayList<CoinInfoEur> getCoinInfosEur(boolean isOnly, boolean isFirst);

    ArrayList<CoinInfoGbp> getCoinInfosGbp(boolean isOnly, boolean isFirst);

    ArrayList<CoinInfoHkd> getCoinInfosHkd(boolean isOnly, boolean isFirst);

    ArrayList<CoinInfoJpy> getCoinInfosJpy(boolean isOnly, boolean isFirst);

    ArrayList<CoinInfoMxn> getCoinInfosMxn(boolean isOnly, boolean isFirst);

    ArrayList<CoinInfoBrl> getCoinInfosBrl(boolean isOnly, boolean isFirst);

    ArrayList<CoinInfoCny> getCoinInfosCny(boolean isOnly, boolean isFirst);

    ArrayList<CoinInfoInr> getCoinInfosInr(boolean isOnly, boolean isFirst);

    ArrayList<CoinInfoKrw> getCoinInfosKrw(boolean isOnly, boolean isFirst);

    ArrayList<CoinInfoRub> getCoinInfosRub(boolean isOnly, boolean isFirst);

    ArrayList<CoinInfo> getAllCoinInfos(boolean isOnlyDisplay, boolean isDisplayFirst);
}
