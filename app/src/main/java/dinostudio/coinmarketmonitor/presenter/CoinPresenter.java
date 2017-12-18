package dinostudio.coinmarketmonitor.presenter;

import javax.inject.Inject;

import dinostudio.coinmarketmonitor.base.contract.CoinContract;
import dinostudio.coinmarketmonitor.base.core.RxPresenter;
import dinostudio.coinmarketmonitor.base.model.DataManager;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/8/17.
 */

public class CoinPresenter extends RxPresenter<CoinContract.View> implements CoinContract.Presenter {

    private DataManager mDataManager;

    @Inject
    public CoinPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }
}
