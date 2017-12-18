package dinostudio.coinmarketmonitor.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/9/17.
 */

public class CharData {

    @SerializedName("market_cap_by_available_supply")
    private ArrayList<ArrayList<Number>> marketCaptures;
    @SerializedName("price_btc")
    private ArrayList<ArrayList<Number>> priceBtcs;
    @SerializedName("price_usd")
    private ArrayList<ArrayList<Number>> priceUsds;
    @SerializedName("volume_usd")
    private ArrayList<ArrayList<Number>> volumeUsds;

    public ArrayList<ArrayList<Number>> getMarketCaptures() {
        return marketCaptures;
    }

    public void setMarketCaptures(ArrayList<ArrayList<Number>> marketCaptures) {
        this.marketCaptures = marketCaptures;
    }

    public ArrayList<ArrayList<Number>> getPriceBtcs() {
        return priceBtcs;
    }

    public void setPriceBtcs(ArrayList<ArrayList<Number>> priceBtcs) {
        this.priceBtcs = priceBtcs;
    }

    public ArrayList<ArrayList<Number>> getPriceUsds() {
        return priceUsds;
    }

    public void setPriceUsds(ArrayList<ArrayList<Number>> priceUsds) {
        this.priceUsds = priceUsds;
    }

    public ArrayList<ArrayList<Number>> getVolumeUsds() {
        return volumeUsds;
    }

    public void setVolumeUsds(ArrayList<ArrayList<Number>> volumeUsds) {
        this.volumeUsds = volumeUsds;
    }
}
