package dinostudio.coinmarketmonitor.ui.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import dinostudio.coinmarketmonitor.R;
import dinostudio.coinmarketmonitor.base.admob.Admob;
import dinostudio.coinmarketmonitor.base.contract.HomeContract;
import dinostudio.coinmarketmonitor.base.core.BaseActivity;
import dinostudio.coinmarketmonitor.base.utils.Common;
import dinostudio.coinmarketmonitor.base.utils.DLogUtils;
import dinostudio.coinmarketmonitor.base.utils.Utils;
import dinostudio.coinmarketmonitor.model.CoinDisplayInfo;
import dinostudio.coinmarketmonitor.presenter.HomePresenter;
import dinostudio.coinmarketmonitor.ui.adapters.CoinAdapter;
import dinostudio.coinmarketmonitor.ui.dialog.IDialogClick;
import dinostudio.coinmarketmonitor.ui.dialog.MyListDialog;
import dinostudio.coinmarketmonitor.ui.receivers.UpdateCoinInfoReceiver;

public class HomeActivity extends BaseActivity<HomePresenter> implements HomeContract.View {

    @BindView(R.id.coin_rv)
    RecyclerView coinRv;
    RecyclerView.LayoutManager mLayoutManager;
    CoinAdapter coinAdapter;
    ArrayList<CoinDisplayInfo> coinInfos;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.menu_iv)
    ImageView menuIv;
    private MyListDialog myListDialog;
    private UpdateCoinInfoReceiver alarm;
    private Admob ad;
    private AdView adView;

    @OnClick(R.id.menu_iv)
    void handleMenuClick() {
        PopupMenu popup = new PopupMenu(HomeActivity.this, menuIv);
        popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
        popup.getMenu().getItem(1).setTitle(getResources().getString(R.string.menu_two) + " " + mPresenter.getPriceValue());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.one) {
                    showShortOrder();
                } else if (item.getItemId() == R.id.two) {
                    showPriceAsDialog();
                } else {
                    SettingActivity.callIntent(HomeActivity.this, new Bundle());
                }

                return true;
            }
        });
        popup.show();
    }

    private void showShortOrder() {
        ArrayList<String> sortItems = new ArrayList<>();
        String[] sortArrs = getResources().getStringArray(R.array.sort_item_label);
        for (int i = 0; i < sortArrs.length; i++) {
            sortItems.add(sortArrs[i]);
        }
        myListDialog = new MyListDialog(this, getString(R.string.dialog_sort_title), sortItems, new IDialogClick() {
            @Override
            public void okClick(String result) {
                myListDialog.dismiss();
            }

            @Override
            public void cancelClick() {

            }
        });
        myListDialog.show();
    }


    private void showPriceAsDialog() {
        ArrayList<String> sortItems = new ArrayList<>();
        final String[] sortArrs = getResources().getStringArray(R.array.price_item_label);
        for (int i = 0; i < sortArrs.length; i++) {
            sortItems.add(sortArrs[i]);
        }
        myListDialog = new MyListDialog(this, getString(R.string.dialog_price_title), sortItems, new IDialogClick() {
            @Override
            public void okClick(String result) {
                myListDialog.dismiss();
                String priceSymbol = Utils.getPriceSymbol(sortArrs, Integer.parseInt(result));
                mPresenter.resetUpdateTime();
                mPresenter.setPriceValue(priceSymbol);
                mPresenter.getCoinInfo();
            }

            @Override
            public void cancelClick() {

            }
        });
        myListDialog.show();
    }


    void initCoinAdapter() {
        coinInfos = new ArrayList<>();
        mLayoutManager = new LinearLayoutManager(this);
        coinAdapter = new CoinAdapter(coinInfos, this, new CoinAdapter.ICoinClicked() {
            @Override
            public void onCoinSelected(CoinDisplayInfo coinInfo) {
                Bundle b = new Bundle();
                b.putString(Common.INTENT_DATA.COIN_ID, coinInfo.getId());
                b.putString(Common.INTENT_DATA.COIN_NAME, coinInfo.getName());
                CoinDetailActivity.callIntent(HomeActivity.this, b);
            }

            @Override
            public void onCoinFavorite(CoinDisplayInfo coinDisplayInfo) {
                if (coinDisplayInfo.isFavorites()) {
                    coinDisplayInfo.setFavorites(false);
                    mPresenter.updateFavoriteCoin(coinDisplayInfo, false);
                } else {
                    coinDisplayInfo.setFavorites(true);
                    mPresenter.updateFavoriteCoin(coinDisplayInfo, true);
                }
                coinAdapter.notifyDataSetChanged();
            }
        });
        coinRv.setLayoutManager(mLayoutManager);
        coinRv.setAdapter(coinAdapter);
    }

    @OnTextChanged(R.id.search_edt)
    void handleSearchTextChange(CharSequence text) {
        String featureName = text.toString();
        coinAdapter.search(featureName);
        coinAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRequestUpdateToFast() {
        refreshLayout.setRefreshing(false);
        showErrorMsg(getString(R.string.request_to_fast));
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void onGetCoinInfoSuccess(List<CoinDisplayInfo> list) {
        DLogUtils.d("LIST SIZE: " + list.size());
        refreshLayout.setRefreshing(false);
        coinInfos.clear();
        coinInfos.addAll(list);
        coinAdapter.notifyDataSetChanged();
    }


    @Override
    public void onGetCoinInfoError() {
        refreshLayout.setRefreshing(false);
        showErrorMsg(getString(R.string.network_not_connect));
    }

    void initUI() {
        menuIv.setColorFilter(Color.argb(255, 255, 255, 255));
    }

    @Override
    protected void initEventAndData() {
        initUI();
        initCoinAdapter();
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getCoinInfo();
            }
        });
        alarm = new UpdateCoinInfoReceiver();
        ad = new Admob(this);
        adView = (AdView) findViewById(R.id.ad_view_fragment_setting);
        ad.adsBanner_Setting(adView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getCoinInfo();
        startRepeatingTimer();

    }

    public void startRepeatingTimer() {
        Context context = this.getApplicationContext();
        if (alarm != null && mPresenter.getAutoRefresh()) {
            alarm.setAlarm(context, mPresenter.getAutoRefreshTime());
        } else if (alarm != null && !mPresenter.getAutoRefresh()) {
            alarm.cancelAlarm(context);
        }
    }

    @Override
    public void onBackPressedSupport() {
        if (myListDialog != null && myListDialog.isShowing()) {
            myListDialog.dismiss();
        } else {
            super.onBackPressedSupport();
            mPresenter.resetUpdateTime();
        }
    }

    @Override
    protected void initInject() {
        getActivityComponent(false).inject(this);
    }
}
