package dinostudio.coinmarketmonitor.base.core;

/**
 * Created by nguyenthanhdong0109@gmail.com on 5/20/17.
 */

public interface BasePresenter<T extends BaseView> {

    void attachView(T view);

    void detachView();
}
