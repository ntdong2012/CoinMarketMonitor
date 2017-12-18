package dinostudio.coinmarketmonitor.base.core;

/**
 * Created by nguyenthanhdong0109@gmail.com on 5/20/17.
 */

public interface BaseView {

    void showErrorMsg(String msg);

    void useNightMode(boolean isNight);

    //=======  State  =======
    void stateError();

    void stateLoading();

    void stateMain();
}
