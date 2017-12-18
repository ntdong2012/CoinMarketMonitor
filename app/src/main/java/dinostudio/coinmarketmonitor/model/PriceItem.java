package dinostudio.coinmarketmonitor.model;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/9/17.
 */

public class PriceItem {

    private long time;
    private double price;


    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
