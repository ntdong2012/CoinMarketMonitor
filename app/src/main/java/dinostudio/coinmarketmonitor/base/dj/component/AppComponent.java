package dinostudio.coinmarketmonitor.base.dj.component;

import javax.inject.Singleton;

import dagger.Component;
import dinostudio.coinmarketmonitor.base.apps.CoinApps;
import dinostudio.coinmarketmonitor.base.dj.module.AppModule;
import dinostudio.coinmarketmonitor.base.dj.module.HttpModule;
import dinostudio.coinmarketmonitor.base.model.DataManager;
import dinostudio.coinmarketmonitor.base.model.db.RealmHelper;
import dinostudio.coinmarketmonitor.base.model.http.RetrofitHelper;

/**
 * Created by nguyenthanhdong0109@gmail.com on 5/20/17.
 */


@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    CoinApps getContext();

    RetrofitHelper retrofitHelper();

    DataManager getDataManager();

    RealmHelper realmHelper();

}


