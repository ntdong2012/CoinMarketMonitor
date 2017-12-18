package dinostudio.coinmarketmonitor.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/14/17.
 */

public class AlarmInfo extends RealmObject {

    @PrimaryKey
    private String coinId;
    private float priceAbove;
    private float priceBelow;
    private boolean isAbove;
    private int isEnable;// 0 - dis - 1. end
    private boolean isBelow;

    public String getCoinId() {
        return coinId;
    }

    public void setCoinId(String coinId) {
        this.coinId = coinId;
    }

    public float getPriceAbove() {
        return priceAbove;
    }

    public void setPriceAbove(float priceAbove) {
        this.priceAbove = priceAbove;
    }

    public float getPriceBelow() {
        return priceBelow;
    }

    public void setPriceBelow(float priceBelow) {
        this.priceBelow = priceBelow;
    }

    public boolean isAbove() {
        return isAbove;
    }

    public void setAbove(boolean above) {
        isAbove = above;
    }

    public boolean isBelow() {
        return isBelow;
    }

    public void setBelow(boolean below) {
        isBelow = below;
    }

    public int getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(int isEnable) {
        this.isEnable = isEnable;
    }
}
