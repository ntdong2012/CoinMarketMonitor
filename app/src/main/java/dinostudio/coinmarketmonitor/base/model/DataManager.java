package dinostudio.coinmarketmonitor.base.model;

import java.util.ArrayList;
import java.util.List;

import dinostudio.coinmarketmonitor.base.model.db.DBHelper;
import dinostudio.coinmarketmonitor.base.model.http.HttpHelper;
import dinostudio.coinmarketmonitor.base.model.prefs.PreferencesHelper;
import dinostudio.coinmarketmonitor.model.AlarmInfo;
import dinostudio.coinmarketmonitor.model.CharData;
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
import io.reactivex.Flowable;

/**
 * Created by nguyenthanhdong0109@gmail.com on 5/20/17.
 */

public class DataManager implements HttpHelper, PreferencesHelper, DBHelper {

    private HttpHelper httpHelper;
    private PreferencesHelper preferencesHelper;
    private DBHelper realmHelper;


    @Override
    public ArrayList<AlarmInfo> getAllAlarms() {
        return realmHelper.getAllAlarms();
    }

    @Override
    public AlarmInfo getAlarmInfo(String id) {
        return realmHelper.getAlarmInfo(id);
    }

    @Override
    public void onUpdateAlarmInfo(String coinId, boolean above, boolean bellow, float aboveVl, float belowValue) {
        realmHelper.onUpdateAlarmInfo(coinId, above, bellow, aboveVl, belowValue);
    }

    @Override
    public CoinInfoInr getCoinInfoInrById(String coinId) {
        return realmHelper.getCoinInfoInrById(coinId);
    }

    @Override
    public CoinInfo getCoinInfoById(String id) {
        return realmHelper.getCoinInfoById(id);
    }

    @Override
    public CoinInfoAud getCoinInfoAudById(String id) {
        return realmHelper.getCoinInfoAudById(id);
    }

    @Override
    public CoinInfoCad getCoinInfoCadById(String id) {
        return realmHelper.getCoinInfoCadById(id);
    }

    @Override
    public CoinInfoEur getCoinInfoEurById(String id) {
        return realmHelper.getCoinInfoEurById(id);
    }

    @Override
    public CoinInfoGbp getCoinInfoGpbById(String id) {
        return realmHelper.getCoinInfoGpbById(id);
    }

    @Override
    public CoinInfoHkd getCoinInfoHkdById(String id) {
        return realmHelper.getCoinInfoHkdById(id);
    }

    @Override
    public CoinInfoJpy getCoinInfoJpyById(String id) {
        return realmHelper.getCoinInfoJpyById(id);
    }

    @Override
    public CoinInfoMxn getCoinInfoMxnById(String id) {
        return realmHelper.getCoinInfoMxnById(id);
    }

    @Override
    public CoinInfoBrl getCoinInfoBrlById(String id) {
        return realmHelper.getCoinInfoBrlById(id);
    }

    @Override
    public CoinInfoCny getCoinInfoCnyById(String id) {
        return realmHelper.getCoinInfoCnyById(id);
    }

    @Override
    public CoinInfoKrw getCoinInfoKwrById(String id) {
        return realmHelper.getCoinInfoKwrById(id);
    }

    @Override
    public CoinInfoRub getCoinInfoRubById(String id) {
        return realmHelper.getCoinInfoRubById(id);
    }

    @Override
    public boolean isDisplayOnlyFavoriteCoin() {
        return preferencesHelper.isDisplayOnlyFavoriteCoin();
    }

    @Override
    public boolean isDisplayFavoriteCoinFirst() {
        return preferencesHelper.isDisplayFavoriteCoinFirst();
    }

    @Override
    public void displayOnlyFavoriteCoin(boolean isDisplayOnly) {
        preferencesHelper.displayOnlyFavoriteCoin(isDisplayOnly);
    }

    @Override
    public void displayFavoriteCoinFirst(boolean isDisplayFirst) {
        preferencesHelper.displayFavoriteCoinFirst(isDisplayFirst);
    }

    @Override
    public void updateFavoriteCoinInfo(CoinDisplayInfo coinDisplayInfo, boolean isFavorite) {
        realmHelper.updateFavoriteCoinInfo(coinDisplayInfo, isFavorite);
    }

    @Override
    public void updateFavoriteCoinInfoAud(CoinDisplayInfo coinDisplayInfo, boolean isFavorite) {
        realmHelper.updateFavoriteCoinInfoAud(coinDisplayInfo, isFavorite);
    }

    @Override
    public void updateFavoriteCoinInfoCad(CoinDisplayInfo coinDisplayInfo, boolean isFavorite) {
        realmHelper.updateFavoriteCoinInfoCad(coinDisplayInfo, isFavorite);
    }

    @Override
    public void updateFavoriteCoinInfoEur(CoinDisplayInfo coinDisplayInfo, boolean isFavorite) {
        realmHelper.updateFavoriteCoinInfoEur(coinDisplayInfo, isFavorite);
    }

    @Override
    public void updateFavoriteCoinInfoGpb(CoinDisplayInfo coinDisplayInfo, boolean isFavorite) {
        realmHelper.updateFavoriteCoinInfoGpb(coinDisplayInfo, isFavorite);
    }

    @Override
    public void updateFavoriteCoinInfoHkd(CoinDisplayInfo coinDisplayInfo, boolean isFavorite) {
        realmHelper.updateFavoriteCoinInfoHkd(coinDisplayInfo, isFavorite);
    }

    @Override
    public void updateFavoriteCoinInfoJpy(CoinDisplayInfo coinDisplayInfo, boolean isFavorite) {
        realmHelper.updateFavoriteCoinInfoJpy(coinDisplayInfo, isFavorite);
    }

    @Override
    public void updateFavoriteCoinInfoMxn(CoinDisplayInfo coinDisplayInfo, boolean isFavorite) {
        realmHelper.updateFavoriteCoinInfoMxn(coinDisplayInfo, isFavorite);
    }

    @Override
    public void updateFavoriteCoinInfoBrl(CoinDisplayInfo coinDisplayInfo, boolean isFavorite) {
        realmHelper.updateFavoriteCoinInfoBrl(coinDisplayInfo, isFavorite);
    }

    @Override
    public void updateFavoriteCoinInfoCny(CoinDisplayInfo coinDisplayInfo, boolean isFavorite) {
        realmHelper.updateFavoriteCoinInfoCny(coinDisplayInfo, isFavorite);
    }

    @Override
    public void updateFavoriteCoinInfoInr(CoinDisplayInfo coinDisplayInfo, boolean isFavorite) {
        realmHelper.updateFavoriteCoinInfoInr(coinDisplayInfo, isFavorite);
    }

    @Override
    public void updateFavoriteCoinInfoKrw(CoinDisplayInfo coinDisplayInfo, boolean isFavorite) {
        realmHelper.updateFavoriteCoinInfoKrw(coinDisplayInfo, isFavorite);
    }

    @Override
    public void updateFavoriteCoinInfoRub(CoinDisplayInfo coinDisplayInfo, boolean isFavorite) {
        realmHelper.updateFavoriteCoinInfoRub(coinDisplayInfo, isFavorite);
    }

    @Override
    public void setAlarmSound(boolean isEnable) {
        preferencesHelper.setAlarmSound(isEnable);
    }

    @Override
    public void setAlarmVibration(boolean isEnable) {
        preferencesHelper.setAlarmVibration(isEnable);
    }

    @Override
    public void setAutoRefresh(boolean isEnable) {
        preferencesHelper.setAutoRefresh(isEnable);
    }

    @Override
    public void setAutoRefreshTime(int time) {
        preferencesHelper.setAutoRefreshTime(time);
    }

    @Override
    public boolean getAlarmSound() {
        return preferencesHelper.getAlarmSound();
    }

    @Override
    public boolean getAlarmVibration() {
        return preferencesHelper.getAlarmVibration();
    }

    @Override
    public boolean getAutoRefresh() {
        return preferencesHelper.getAutoRefresh();
    }

    @Override
    public int getAutoRefreshTime() {
        return preferencesHelper.getAutoRefreshTime();
    }

    @Override
    public ArrayList<CoinInfoEur> getCoinInfosEur(boolean isOnly, boolean isFirst) {
        return realmHelper.getCoinInfosEur(isOnly, isFirst);
    }

    @Override
    public ArrayList<CoinInfoGbp> getCoinInfosGbp(boolean isOnly, boolean isFirst) {
        return realmHelper.getCoinInfosGbp(isOnly, isFirst);
    }

    @Override
    public ArrayList<CoinInfoHkd> getCoinInfosHkd(boolean isOnly, boolean isFirst) {
        return realmHelper.getCoinInfosHkd(isOnly, isFirst);
    }

    @Override
    public ArrayList<CoinInfoInr> getCoinInfosInr(boolean isOnly, boolean isFirst) {
        return realmHelper.getCoinInfosInr(isOnly, isFirst);
    }

    @Override
    public ArrayList<CoinInfoJpy> getCoinInfosJpy(boolean isOnly, boolean isFirst) {
        return realmHelper.getCoinInfosJpy(isOnly, isFirst);
    }

    @Override
    public ArrayList<CoinInfoKrw> getCoinInfosKrw(boolean isOnly, boolean isFirst) {
        return realmHelper.getCoinInfosKrw(isOnly, isFirst);
    }

    @Override
    public ArrayList<CoinInfoMxn> getCoinInfosMxn(boolean isOnly, boolean isFirst) {
        return realmHelper.getCoinInfosMxn(isOnly, isFirst);
    }

    @Override
    public ArrayList<CoinInfoRub> getCoinInfosRub(boolean isOnly, boolean isFirst) {
        return realmHelper.getCoinInfosRub(isOnly, isFirst);
    }

    @Override
    public ArrayList<CoinInfoCny> getCoinInfosCny(boolean isOnly, boolean isFirst) {
        return realmHelper.getCoinInfosCny(isOnly, isFirst);
    }

    @Override
    public ArrayList<CoinInfoCad> getCoinInfosCad(boolean isOnly, boolean isFirst) {
        return realmHelper.getCoinInfosCad(isOnly, isFirst);
    }

    @Override
    public ArrayList<CoinInfoBrl> getCoinInfosBrl(boolean isOnly, boolean isFirst) {
        return realmHelper.getCoinInfosBrl(isOnly, isFirst);
    }

    @Override
    public ArrayList<CoinInfoAud> getCoinInfosAud(boolean isOnly, boolean isFirst) {
        return realmHelper.getCoinInfosAud(isOnly, isFirst);
    }

    @Override
    public void saveCoinInfoRub(ArrayList<CoinInfoRub> coinInfoRubs) {
        realmHelper.saveCoinInfoRub(coinInfoRubs);
    }

    @Override
    public void saveCoinInfoMxn(ArrayList<CoinInfoMxn> coinInfoMxns) {
        realmHelper.saveCoinInfoMxn(coinInfoMxns);
    }

    @Override
    public void saveCoinInfoKrw(ArrayList<CoinInfoKrw> coinInfoKrws) {
        realmHelper.saveCoinInfoKrw(coinInfoKrws);
    }

    @Override
    public void saveCoinInfoJpy(ArrayList<CoinInfoJpy> coinInfoJpys) {
        realmHelper.saveCoinInfoJpy(coinInfoJpys);
    }

    @Override
    public void saveCoinInfoInr(ArrayList<CoinInfoInr> coinInfoInrs) {
        realmHelper.saveCoinInfoInr(coinInfoInrs);
    }

    @Override
    public void saveCoinInfoHkd(ArrayList<CoinInfoHkd> coinInfoHkds) {
        realmHelper.saveCoinInfoHkd(coinInfoHkds);
    }

    @Override
    public void saveCoinInfoGpb(ArrayList<CoinInfoGbp> coinInfoGbps) {
        realmHelper.saveCoinInfoGpb(coinInfoGbps);
    }

    @Override
    public void saveCoinInfoEur(ArrayList<CoinInfoEur> coinInfoEurs) {
        realmHelper.saveCoinInfoEur(coinInfoEurs);
    }

    @Override
    public void saveCoinInfoCny(ArrayList<CoinInfoCny> coinInfoCnys) {
        realmHelper.saveCoinInfoCny(coinInfoCnys);
    }

    @Override
    public void saveCoinInfoCad(ArrayList<CoinInfoCad> coinInfoCads) {
        realmHelper.saveCoinInfoCad(coinInfoCads);
    }

    @Override
    public void saveCoinInfoAud(ArrayList<CoinInfoAud> coinInfoAuds) {
        realmHelper.saveCoinInfoAud(coinInfoAuds);
    }

    @Override
    public void saveCoinInfoBrl(ArrayList<CoinInfoBrl> coinInfoBrls) {
        realmHelper.saveCoinInfoBrl(coinInfoBrls);
    }

    @Override
    public String getPriceValue() {
        return preferencesHelper.getPriceValue();
    }

    @Override
    public void setPriceValue(String priceValue) {
        preferencesHelper.setPriceValue(priceValue);
    }

    @Override
    public Flowable<CharData> getCharDataByType(String url) {
        return httpHelper.getCharDataByType(url);
    }

    @Override
    public long getTimeUpdateCoinInfo() {
        return preferencesHelper.getTimeUpdateCoinInfo();
    }

    @Override
    public void setTimeUpdateCoinInfo(long time) {
        preferencesHelper.setTimeUpdateCoinInfo(time);
    }

    @Override
    public ArrayList<CoinInfo> getAllCoinInfos(boolean isOnlyDisplay, boolean isDisplayFirst) {
        return realmHelper.getAllCoinInfos(isOnlyDisplay, isDisplayFirst);
    }

    @Override
    public void saveCoinInfos(ArrayList<CoinInfo> coinInfos) {
        realmHelper.saveCoinInfos(coinInfos);
    }

    @Override
    public Flowable<List<CoinInfo>> getCoinInfos(String url) {
        return httpHelper.getCoinInfos(url);
    }

    @Override
    public Flowable<List<CoinInfoAud>> getCoinInfoAud(String url) {
        return httpHelper.getCoinInfoAud(url);
    }

    @Override
    public Flowable<List<CoinInfoCad>> getCoinInfoCad(String url) {
        return httpHelper.getCoinInfoCad(url);
    }

    @Override
    public Flowable<List<CoinInfoBrl>> getCoinInfoBrl(String url) {
        return httpHelper.getCoinInfoBrl(url);
    }

    @Override
    public Flowable<List<CoinInfoCny>> getCoinInfoCny(String url) {
        return httpHelper.getCoinInfoCny(url);
    }

    @Override
    public Flowable<List<CoinInfoEur>> getCoinInfoEur(String url) {
        return httpHelper.getCoinInfoEur(url);
    }

    @Override
    public Flowable<List<CoinInfoGbp>> getCoinInfoGbp(String url) {
        return httpHelper.getCoinInfoGbp(url);
    }

    @Override
    public Flowable<List<CoinInfoHkd>> getCoinInfoHkd(String url) {
        return httpHelper.getCoinInfoHkd(url);
    }

    @Override
    public Flowable<List<CoinInfoRub>> getCoinInfoRub(String url) {
        return httpHelper.getCoinInfoRub(url);
    }

    @Override
    public Flowable<List<CoinInfoInr>> getCoinInfoInr(String url) {
        return httpHelper.getCoinInfoInr(url);
    }

    @Override
    public Flowable<List<CoinInfoJpy>> getCoinInfoJpy(String url) {
        return httpHelper.getCoinInfoJpy(url);
    }

    @Override
    public Flowable<List<CoinInfoKrw>> getCoinInfoKwr(String url) {
        return httpHelper.getCoinInfoKwr(url);
    }

    @Override
    public Flowable<List<CoinInfoMxn>> getCoinInfoMxn(String url) {
        return httpHelper.getCoinInfoMxn(url);
    }

    public DataManager(HttpHelper httpHelper, PreferencesHelper preferencesHelper, DBHelper realmHelper) {
        this.httpHelper = httpHelper;
        this.preferencesHelper = preferencesHelper;
        this.realmHelper = realmHelper;
    }

}
