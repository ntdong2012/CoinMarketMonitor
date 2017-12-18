package dinostudio.coinmarketmonitor.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/8/17.
 */

public class CoinInfo extends RealmObject{

    @PrimaryKey
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("symbol")
    private String symbol;
    @SerializedName("rank")
    private String rank;
    @SerializedName("price_usd")
    private String priceUsd;
    @SerializedName("price_btc")
    private String priceBtc;
    @SerializedName("24h_volume_usd")
    private String timeVolumeUsd;
    @SerializedName("market_cap_usd")
    private String marketCapUsd;
    @SerializedName("available_supply")
    private String availableSupply;
    @SerializedName("total_supply")
    private String totalSupply;
    @SerializedName("percent_change_1h")
    private String percentChangeOneHour;
    @SerializedName("percent_change_24h")
    private String percentChangeOneDay;
    @SerializedName("percent_change_7d")
    private String percentChangeOneWeek;
    @SerializedName("last_updated")
    private String lastUpdate;

    private boolean isFavorite;

    private boolean hasAlarm;

    public boolean isHasAlarm() {
        return hasAlarm;
    }

    public void setHasAlarm(boolean hasAlarm) {
        this.hasAlarm = hasAlarm;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(String priceUsd) {
        this.priceUsd = priceUsd;
    }

    public String getPriceBtc() {
        return priceBtc;
    }

    public void setPriceBtc(String priceBtc) {
        this.priceBtc = priceBtc;
    }

    public String getTimeVolumeUsd() {
        return timeVolumeUsd;
    }

    public void setTimeVolumeUsd(String timeVolumeUsd) {
        this.timeVolumeUsd = timeVolumeUsd;
    }

    public String getMarketCapUsd() {
        return marketCapUsd;
    }

    public void setMarketCapUsd(String marketCapUsd) {
        this.marketCapUsd = marketCapUsd;
    }

    public String getAvailableSupply() {
        return availableSupply;
    }

    public void setAvailableSupply(String availableSupply) {
        this.availableSupply = availableSupply;
    }

    public String getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(String totalSupply) {
        this.totalSupply = totalSupply;
    }

    public String getPercentChangeOneHour() {
        return percentChangeOneHour;
    }

    public void setPercentChangeOneHour(String percentChangeOneHour) {
        this.percentChangeOneHour = percentChangeOneHour;
    }

    public String getPercentChangeOneDay() {
        return percentChangeOneDay;
    }

    public void setPercentChangeOneDay(String percentChangeOneDay) {
        this.percentChangeOneDay = percentChangeOneDay;
    }

    public String getPercentChangeOneWeek() {
        return percentChangeOneWeek;
    }

    public void setPercentChangeOneWeek(String percentChangeOneWeek) {
        this.percentChangeOneWeek = percentChangeOneWeek;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }


    //     "id": "bitcoin",
//             "name": "Bitcoin",
//             "symbol": "BTC",
//             "rank": "1",
//             "price_usd": "573.137",
//             "price_btc": "1.0",
//             "24h_volume_usd": "72855700.0",
//             "market_cap_usd": "9080883500.0",
//             "available_supply": "15844176.0",
//             "total_supply": "15844176.0",
//             "percent_change_1h": "0.04",
//             "percent_change_24h": "-0.3",
//             "percent_change_7d": "-0.57",
//             "last_updated": "1472762067"
}
