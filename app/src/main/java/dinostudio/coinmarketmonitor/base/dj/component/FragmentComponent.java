package dinostudio.coinmarketmonitor.base.dj.component;

import android.app.Activity;

import dagger.Component;
import dinostudio.coinmarketmonitor.base.dj.module.FragmentModule;
import dinostudio.coinmarketmonitor.base.dj.scope.FragmentScope;
import dinostudio.coinmarketmonitor.ui.fragment.CoinCharFragment;
import dinostudio.coinmarketmonitor.ui.fragment.CoinDetailFragment;

/**
 * Created by nguyenthanhdong0109@gmail.com on 5/21/17.
 */


@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

    void inject(CoinCharFragment coinCharFragment);

    void inject(CoinDetailFragment coinDetailFragment);
}
