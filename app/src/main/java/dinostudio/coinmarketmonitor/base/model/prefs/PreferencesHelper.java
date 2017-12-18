package dinostudio.coinmarketmonitor.base.model.prefs;

/**
 * Created by nguyenthanhdong0109@gmail.com on 5/21/17.
 */

public interface PreferencesHelper {


    void setTimeUpdateCoinInfo(long time);

    long getTimeUpdateCoinInfo();

    void setPriceValue(String priceValue);

    String getPriceValue();

    boolean getAlarmSound();

    boolean getAlarmVibration();

    boolean getAutoRefresh();

    void setAlarmSound(boolean isEnable);

    void setAlarmVibration(boolean isEnable);

    void setAutoRefresh(boolean isEnable);

    int getAutoRefreshTime();

    void setAutoRefreshTime(int time);

    void displayOnlyFavoriteCoin(boolean isDisplayOnly);

    void displayFavoriteCoinFirst(boolean isDisplayFirst);

    boolean isDisplayOnlyFavoriteCoin();

    boolean isDisplayFavoriteCoinFirst();
}
