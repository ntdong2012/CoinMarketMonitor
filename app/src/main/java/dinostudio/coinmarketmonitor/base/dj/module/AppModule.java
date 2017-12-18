package dinostudio.coinmarketmonitor.base.dj.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dinostudio.coinmarketmonitor.base.apps.CoinApps;
import dinostudio.coinmarketmonitor.base.model.DataManager;
import dinostudio.coinmarketmonitor.base.model.db.DBHelper;
import dinostudio.coinmarketmonitor.base.model.db.RealmHelper;
import dinostudio.coinmarketmonitor.base.model.http.HttpHelper;
import dinostudio.coinmarketmonitor.base.model.http.RetrofitHelper;
import dinostudio.coinmarketmonitor.base.model.prefs.PreferencesHelper;
import dinostudio.coinmarketmonitor.base.model.prefs.PreferencesHelperImpl;

/**
 * Created by nguyenthanhdong0109@gmail.com on 5/20/17.
 */

@Module
public class AppModule {

    private final CoinApps application;

    public AppModule(CoinApps application) {
        this.application = application;
    }

    @Provides
    @Singleton
    CoinApps provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper) {
        return retrofitHelper;
    }

    @Provides
    @Singleton
    DBHelper provideDBHelper(RealmHelper realmHelper) {
        return realmHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(PreferencesHelperImpl implPreferencesHelper) {
        return implPreferencesHelper;
    }

    //
    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper, PreferencesHelper preferencesHelper, DBHelper dBHelper) {
        return new DataManager(httpHelper, preferencesHelper, dBHelper);
    }
}

