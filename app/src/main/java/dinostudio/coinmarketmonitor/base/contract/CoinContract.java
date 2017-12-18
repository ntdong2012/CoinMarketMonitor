package dinostudio.coinmarketmonitor.base.contract;

import dinostudio.coinmarketmonitor.base.core.BasePresenter;
import dinostudio.coinmarketmonitor.base.core.BaseView;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/8/17.
 */

public interface CoinContract {

    interface View extends BaseView {

    }


    interface Presenter extends BasePresenter<View> {


    }
}
