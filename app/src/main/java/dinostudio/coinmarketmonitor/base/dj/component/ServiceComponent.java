package dinostudio.coinmarketmonitor.base.dj.component;

import android.app.Service;

import dagger.Component;
import dinostudio.coinmarketmonitor.base.dj.module.ServiceModule;
import dinostudio.coinmarketmonitor.base.dj.scope.ServiceScope;
import dinostudio.coinmarketmonitor.ui.service.UpdateCoinInfoService;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/13/17.
 */

@ServiceScope
@Component(dependencies = AppComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {

    Service getService();

    void inject(UpdateCoinInfoService updateCoinInfoService);
}
