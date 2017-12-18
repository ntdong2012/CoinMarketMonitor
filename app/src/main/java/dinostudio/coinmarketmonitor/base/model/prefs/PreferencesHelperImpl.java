package dinostudio.coinmarketmonitor.base.model.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

import dinostudio.coinmarketmonitor.base.apps.CoinApps;


/**
 * Created by nguyenthanhdong0109@gmail.com on 5/21/17.
 */

public class PreferencesHelperImpl implements PreferencesHelper {

    private static final String SHAREDPREFERENCES_NAME = "coin_sp";

    private final SharedPreferences mSPrefs;

    public interface Constants {
        public static final String UPDATE_TIME = "UPDATE_TIME";
        public static final String PRICE_VALUE = "PRICE_VALUE";
        public static final String ALARM_SOUND = "ALARM_SOUND";
        public static final String ALARM_VIBRATION = "ALARM_VIBRATION";
        public static final String AUTO_REFRESH = "AUTO_REFRESH";
        public static final String AUTO_REFRESH_TIME = "AUTO_REFRESH_TIME";
        public static final String DISPLAY_FAVORITE_COIN_FIRST = "DISPLAY_FAVORITE_COIN_FIRST";
        public static final String DISPLAY_ONLY_FAVORITE = "DISPLAY_ONLY_FAVORITE";

    }

    @Override
    public boolean isDisplayOnlyFavoriteCoin() {
        return mSPrefs.getBoolean(Constants.DISPLAY_ONLY_FAVORITE, false);
    }

    @Override
    public boolean isDisplayFavoriteCoinFirst() {
        return mSPrefs.getBoolean(Constants.DISPLAY_FAVORITE_COIN_FIRST, false);
    }

    @Override
    public void displayFavoriteCoinFirst(boolean isDisplayFirst) {
        mSPrefs.edit().putBoolean(Constants.DISPLAY_FAVORITE_COIN_FIRST, isDisplayFirst).commit();
    }

    @Override
    public void displayOnlyFavoriteCoin(boolean isDisplayOnly) {
        mSPrefs.edit().putBoolean(Constants.DISPLAY_ONLY_FAVORITE, isDisplayOnly).commit();
    }

    @Override
    public void setAutoRefreshTime(int time) {
        mSPrefs.edit().putInt(Constants.AUTO_REFRESH_TIME, time).commit();
    }

    @Override
    public void setAutoRefresh(boolean isEnable) {
        mSPrefs.edit().putBoolean(Constants.AUTO_REFRESH, isEnable).commit();
    }

    @Override
    public void setAlarmVibration(boolean isEnable) {
        mSPrefs.edit().putBoolean(Constants.ALARM_VIBRATION, isEnable).commit();
    }

    @Override
    public void setAlarmSound(boolean isEnable) {
        mSPrefs.edit().putBoolean(Constants.ALARM_SOUND, isEnable).commit();
    }

    @Override
    public boolean getAlarmSound() {
        return mSPrefs.getBoolean(Constants.ALARM_SOUND, true);
    }

    @Override
    public boolean getAlarmVibration() {
        return mSPrefs.getBoolean(Constants.ALARM_VIBRATION, true);
    }

    @Override
    public boolean getAutoRefresh() {
        return mSPrefs.getBoolean(Constants.AUTO_REFRESH, false);
    }

    @Override
    public int getAutoRefreshTime() {
        return mSPrefs.getInt(Constants.AUTO_REFRESH_TIME, 10);
    }

    @Override
    public String getPriceValue() {
        return mSPrefs.getString(Constants.PRICE_VALUE, "USD");
    }

    @Override
    public void setPriceValue(String priceValue) {
        mSPrefs.edit().putString(Constants.PRICE_VALUE, priceValue).commit();
    }

    @Override
    public long getTimeUpdateCoinInfo() {
        return mSPrefs.getLong(Constants.UPDATE_TIME, 0);
    }

    @Override
    public void setTimeUpdateCoinInfo(long time) {
        mSPrefs.edit().putLong(Constants.UPDATE_TIME, time).commit();
    }

    @Inject
    public PreferencesHelperImpl() {
        mSPrefs = CoinApps.getInstance().getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
    }
}
