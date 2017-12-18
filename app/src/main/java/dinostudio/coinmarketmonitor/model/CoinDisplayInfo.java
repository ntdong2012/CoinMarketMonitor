package dinostudio.coinmarketmonitor.model;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/11/17.
 */

public class CoinDisplayInfo {


    private String id;
    private String price;
    private String priceType;
    private String oneHourVl;
    private String ondDayVl;
    private String lastUpdate;
    private String name;
    private String symbol;
    private boolean isFavorites;
    private boolean hasAlarm;

    public boolean isHasAlarm() {
        return hasAlarm;
    }

    public void setHasAlarm(boolean hasAlarm) {
        this.hasAlarm = hasAlarm;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }


    public String getOneHourVl() {
        return oneHourVl;
    }

    public void setOneHourVl(String oneHourVl) {
        this.oneHourVl = oneHourVl;
    }

    public String getOndDayVl() {
        return ondDayVl;
    }

    public void setOndDayVl(String ondDayVl) {
        this.ondDayVl = ondDayVl;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
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

    public boolean isFavorites() {
        return isFavorites;
    }

    public void setFavorites(boolean favorites) {
        isFavorites = favorites;
    }
}
