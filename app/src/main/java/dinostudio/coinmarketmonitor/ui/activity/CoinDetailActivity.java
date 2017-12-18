package dinostudio.coinmarketmonitor.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import dinostudio.coinmarketmonitor.R;
import dinostudio.coinmarketmonitor.base.contract.CoinContract;
import dinostudio.coinmarketmonitor.base.core.BaseActivity;
import dinostudio.coinmarketmonitor.base.utils.Common;
import dinostudio.coinmarketmonitor.base.utils.DLogUtils;
import dinostudio.coinmarketmonitor.presenter.CoinPresenter;
import dinostudio.coinmarketmonitor.ui.adapters.CoinDetailAdapter;
import dinostudio.coinmarketmonitor.ui.fragment.CoinCharFragment;
import dinostudio.coinmarketmonitor.ui.fragment.CoinDetailFragment;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/8/17.
 */

public class CoinDetailActivity extends BaseActivity<CoinPresenter> implements CoinContract.View {

    @BindView(R.id.tabs)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;


    public static String[] tabTitle = new String[2];
    List<Fragment> fragments = new ArrayList<>();

    CoinDetailFragment coinDetailFragment;
    CoinCharFragment coinCharFragment;
    CoinDetailAdapter coinDetailAdapter;
    private String coinId;
    private String coinName;


    void initViewPaper() {
        coinDetailFragment = new CoinDetailFragment();

        coinCharFragment = new CoinCharFragment();

        coinCharFragment.setCoinId(coinId);
        coinDetailFragment.setCoinId(coinId);
        coinCharFragment.setCoinName(coinName);
        fragments.add(coinCharFragment);
        fragments.add(coinDetailFragment);

        coinDetailAdapter = new CoinDetailAdapter(getSupportFragmentManager(), fragments);

        viewPager.setAdapter(coinDetailAdapter);

        mTabLayout.addTab(mTabLayout.newTab().setText("Chard"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Details"));

        mTabLayout.setupWithViewPager(viewPager);
        mTabLayout.getTabAt(0).setText(mContext.getString(R.string.char_label));
        mTabLayout.getTabAt(1).setText(mContext.getString(R.string.detail_label));
    }


    @Override
    protected void initInject() {
        getActivityComponent(false).inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_coin_detail;
    }

    @Override
    protected void initEventAndData() {
        Intent i = getIntent();
        if (i != null) {
            Bundle b = i.getBundleExtra(Common.INTENT_DATA.BUNDLE_DATA);
            if (b != null) {
                coinId = b.getString(Common.INTENT_DATA.COIN_ID);
                coinName = b.getString(Common.INTENT_DATA.COIN_NAME);
                DLogUtils.d("COIN ID: " + coinId);
            }
        }
        initViewPaper();
    }

    @Override
    public void onBackPressedSupport() {
        super.onBackPressedSupport();
        overridePendingTransition(R.anim.left_in, R.anim.right_out);

    }

    public static void callIntent(Context context, Bundle bundle) {
        Intent i = new Intent(context, CoinDetailActivity.class);
        i.putExtra(Common.INTENT_DATA.BUNDLE_DATA, bundle);
        context.startActivity(i);
        ((Activity) context).overridePendingTransition(R.anim.right_in, R.anim.left_out);
    }
}
