package dinostudio.coinmarketmonitor.base.dj.module;

import android.app.Service;

import dagger.Module;
import dagger.Provides;
import dinostudio.coinmarketmonitor.base.dj.scope.ServiceScope;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/13/17.
 */

@Module
public class ServiceModule {

    private Service mService;

    public ServiceModule(Service mService) {
        this.mService = mService;
    }


    @Provides
    @ServiceScope
    public Service providerService() {
        return mService;
    }

}
