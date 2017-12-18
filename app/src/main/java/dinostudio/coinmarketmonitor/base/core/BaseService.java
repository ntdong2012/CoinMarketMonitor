package dinostudio.coinmarketmonitor.base.core;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import javax.annotation.Nullable;
import javax.inject.Inject;

import dinostudio.coinmarketmonitor.base.apps.CoinApps;
import dinostudio.coinmarketmonitor.base.dj.component.DaggerServiceComponent;
import dinostudio.coinmarketmonitor.base.dj.component.ServiceComponent;
import dinostudio.coinmarketmonitor.base.dj.module.ServiceModule;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/13/17.
 */

public abstract class BaseService<T extends BasePresenter> extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        initInject();
    }

    @Inject
    protected T mPresenter;

    protected ServiceModule getServiceModule() {
        return new ServiceModule(this);
    }

    protected ServiceComponent getServiceComponent() {
        return DaggerServiceComponent.builder().appComponent
                (CoinApps.getAppComponent(false)).serviceModule(getServiceModule()).build();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    protected abstract void initInject();
}
