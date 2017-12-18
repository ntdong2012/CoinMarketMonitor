package dinostudio.coinmarketmonitor.ui.service;

import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import dinostudio.coinmarketmonitor.base.core.BaseService;
import dinostudio.coinmarketmonitor.base.utils.DLogUtils;
import dinostudio.coinmarketmonitor.presenter.UpdateCoinServicePresenter;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/12/17.
 */

public class UpdateCoinInfoService extends BaseService<UpdateCoinServicePresenter> {


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        DLogUtils.d("onStartCommand");

        mPresenter.getCoinInfo();
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    protected void initInject() {
        getServiceComponent().inject(this);
    }
}
