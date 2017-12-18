package dinostudio.coinmarketmonitor.base.dj.component;

import android.app.Activity;

import dagger.Component;
import dinostudio.coinmarketmonitor.base.dj.module.ActivityModule;
import dinostudio.coinmarketmonitor.base.dj.scope.ActivityScope;
import dinostudio.coinmarketmonitor.ui.activity.CoinDetailActivity;
import dinostudio.coinmarketmonitor.ui.activity.HomeActivity;
import dinostudio.coinmarketmonitor.ui.activity.SettingActivity;

/**
 * Created by nguyenthanhdong0109@gmail.com on 5/20/17.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    void inject(HomeActivity homeActivity);

    void inject(CoinDetailActivity coinDetailActivity);

    void inject(SettingActivity settingActivity);


}
