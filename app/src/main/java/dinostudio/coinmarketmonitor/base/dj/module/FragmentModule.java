package dinostudio.coinmarketmonitor.base.dj.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import dagger.Module;
import dagger.Provides;
import dinostudio.coinmarketmonitor.base.dj.scope.FragmentScope;

/**
 * Created by nguyenthanhdong0109@gmail.com on 5/21/17.
 */
@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    public Activity provideActivity() {
        return fragment.getActivity();
    }

}
