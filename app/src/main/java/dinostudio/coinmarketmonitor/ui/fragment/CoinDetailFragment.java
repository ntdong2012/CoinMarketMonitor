package dinostudio.coinmarketmonitor.ui.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdView;

import butterknife.BindView;
import dinostudio.coinmarketmonitor.R;
import dinostudio.coinmarketmonitor.base.admob.Admob;
import dinostudio.coinmarketmonitor.base.contract.CoinDetailContact;
import dinostudio.coinmarketmonitor.base.core.BaseFragment;
import dinostudio.coinmarketmonitor.base.utils.DLogUtils;
import dinostudio.coinmarketmonitor.base.utils.Utils;
import dinostudio.coinmarketmonitor.model.CoinInfo;
import dinostudio.coinmarketmonitor.model.CoinInfoAud;
import dinostudio.coinmarketmonitor.model.CoinInfoBrl;
import dinostudio.coinmarketmonitor.model.CoinInfoCad;
import dinostudio.coinmarketmonitor.model.CoinInfoCny;
import dinostudio.coinmarketmonitor.model.CoinInfoEur;
import dinostudio.coinmarketmonitor.model.CoinInfoGbp;
import dinostudio.coinmarketmonitor.model.CoinInfoHkd;
import dinostudio.coinmarketmonitor.model.CoinInfoInr;
import dinostudio.coinmarketmonitor.model.CoinInfoJpy;
import dinostudio.coinmarketmonitor.model.CoinInfoKrw;
import dinostudio.coinmarketmonitor.model.CoinInfoMxn;
import dinostudio.coinmarketmonitor.model.CoinInfoRub;
import dinostudio.coinmarketmonitor.presenter.CoinDetailPresenter;
import dinostudio.coinmarketmonitor.ui.adapters.PriceTypeAdapter;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/8/17.
 */

public class CoinDetailFragment extends BaseFragment<CoinDetailPresenter> implements CoinDetailContact.View {

    private String coinId;

    @BindView(R.id.price_tv)
    TextView priceTv;
    @BindView(R.id.last_update_tv)
    TextView lastUpdateTv;
    @BindView(R.id.spinner_money)
    Spinner spinnerMoney;
    @BindView(R.id.symbol_value)
    TextView symbolTv;
    @BindView(R.id.price_usd_value)
    TextView priceUsdTv;
    @BindView(R.id.price_btc_value)
    TextView priceBtcTv;
    @BindView(R.id.volume_day_value)
    TextView volumeDayTv;
    @BindView(R.id.market_cab_value)
    TextView marketCabTv;
    @BindView(R.id.available_supply_value)
    TextView availableSupplyTv;
    @BindView(R.id.total_supply_value)
    TextView totalSupplyTv;
    @BindView(R.id.max_supply_value)
    TextView maxSupplyTv;
    @BindView(R.id.change_one_hour_value)
    TextView changeOneHourTv;
    @BindView(R.id.change_one_day_value)
    TextView changeOneDayTv;
    @BindView(R.id.change_one_week_value)
    TextView changeOneWeekTv;
    @BindView(R.id.ad_view_fragment_setting)
    AdView adView;
    @BindView(R.id.image_icon)
    ImageView coinIcon;
    @BindView(R.id.coin_name_tv)
    TextView coinNameTv;

    PriceTypeAdapter mPriceAdapter;
    private Admob ad;

    @Override
    public void onGetCoinInfoSuccess(CoinInfo coinInfo) {
        if (coinInfo != null) {
            coinNameTv.setText(coinInfo.getName() + "(" + coinInfo.getSymbol() + ")");
            Glide.with(mContext).load("https://files.coinmarketcap.com/static/img/coins/64x64/" + coinInfo.getId() + ".png").into(coinIcon);
            priceTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getPriceUsd()), "USD"));
            lastUpdateTv.setText(getString(R.string.last_update_label) + "  " +
                    Utils.convertTimeToDisplayForDetail(Long.parseLong(coinInfo.getLastUpdate())));
            symbolTv.setText(coinInfo.getSymbol());
            priceUsdTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getPriceUsd()), "USD"));
            priceBtcTv.setText(coinInfo.getPriceBtc() + "Ƀ");
            volumeDayTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getTimeVolumeUsd()), "USD"));
            marketCabTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getMarketCapUsd()), "USD"));
            availableSupplyTv.setText(coinInfo.getAvailableSupply());
            totalSupplyTv.setText(coinInfo.getTotalSupply());
            changeOneHourTv.setText(coinInfo.getPercentChangeOneHour() + "%");
            changeOneDayTv.setText(coinInfo.getPercentChangeOneDay() + "%");
            changeOneWeekTv.setText(coinInfo.getPercentChangeOneWeek() + "%");

            if (Float.parseFloat(coinInfo.getPercentChangeOneDay()) >= 0) {
                changeOneDayTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneDayTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
            if (Float.parseFloat(coinInfo.getPercentChangeOneHour()) >= 0) {
                changeOneHourTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneHourTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
            if (Float.parseFloat(coinInfo.getPercentChangeOneWeek()) >= 0) {
                changeOneWeekTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneWeekTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
        }
    }

    @Override
    public void onGetCoinInfoSuccess(CoinInfoAud coinInfo) {
        if (coinInfo != null) {
            coinNameTv.setText(coinInfo.getName() + "(" + coinInfo.getSymbol() + ")");
            Glide.with(mContext).load("https://files.coinmarketcap.com/static/img/coins/64x64/" + coinInfo.getId() + ".png").into(coinIcon);
            priceTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getPriceUsd()), "AUD"));
            lastUpdateTv.setText(getString(R.string.last_update_label) + "  " +
                    Utils.convertTimeToDisplayForDetail(Long.parseLong(coinInfo.getLastUpdate())));
            symbolTv.setText(coinInfo.getSymbol());
            priceUsdTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getPriceUsd()), "USD"));
            priceBtcTv.setText(coinInfo.getPriceBtc() + "Ƀ");
            volumeDayTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getTimeVolumeUsd()), "USD"));
            marketCabTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getMarketCapUsd()), "USD"));
            availableSupplyTv.setText(coinInfo.getAvailableSupply());
            totalSupplyTv.setText(coinInfo.getTotalSupply());
            changeOneHourTv.setText(coinInfo.getPercentChangeOneHour() + "%");
            changeOneDayTv.setText(coinInfo.getPercentChangeOneDay() + "%");
            changeOneWeekTv.setText(coinInfo.getPercentChangeOneWeek() + "%");

            if (Float.parseFloat(coinInfo.getPercentChangeOneDay()) >= 0) {
                changeOneDayTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneDayTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
            if (Float.parseFloat(coinInfo.getPercentChangeOneHour()) >= 0) {
                changeOneHourTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneHourTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
            if (Float.parseFloat(coinInfo.getPercentChangeOneWeek()) >= 0) {
                changeOneWeekTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneWeekTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
        }
    }

    @Override
    public void onGetCoinInfoSuccess(CoinInfoBrl coinInfo) {
        if (coinInfo != null) {
            coinNameTv.setText(coinInfo.getName() + "(" + coinInfo.getSymbol() + ")");
            Glide.with(mContext).load("https://files.coinmarketcap.com/static/img/coins/64x64/" + coinInfo.getId() + ".png").into(coinIcon);
            priceTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getPriceUsd()), "BRL"));
            lastUpdateTv.setText(getString(R.string.last_update_label) + "  " +
                    Utils.convertTimeToDisplayForDetail(Long.parseLong(coinInfo.getLastUpdate())));
            symbolTv.setText(coinInfo.getSymbol());
            priceUsdTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getPriceUsd()), "USD"));
            priceBtcTv.setText(coinInfo.getPriceBtc() + "Ƀ");
            volumeDayTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getTimeVolumeUsd()), "USD"));
            marketCabTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getMarketCapUsd()), "USD"));
            availableSupplyTv.setText(coinInfo.getAvailableSupply());
            totalSupplyTv.setText(coinInfo.getTotalSupply());
            changeOneHourTv.setText(coinInfo.getPercentChangeOneHour() + "%");
            changeOneDayTv.setText(coinInfo.getPercentChangeOneDay() + "%");
            changeOneWeekTv.setText(coinInfo.getPercentChangeOneWeek() + "%");

            if (Float.parseFloat(coinInfo.getPercentChangeOneDay()) >= 0) {
                changeOneDayTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneDayTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
            if (Float.parseFloat(coinInfo.getPercentChangeOneHour()) >= 0) {
                changeOneHourTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneHourTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
            if (Float.parseFloat(coinInfo.getPercentChangeOneWeek()) >= 0) {
                changeOneWeekTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneWeekTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
        }
    }

    @Override
    public void onGetCoinInfoSuccess(CoinInfoCad coinInfo) {
        if (coinInfo != null) {
            coinNameTv.setText(coinInfo.getName() + "(" + coinInfo.getSymbol() + ")");
            Glide.with(mContext).load("https://files.coinmarketcap.com/static/img/coins/64x64/" + coinInfo.getId() + ".png").into(coinIcon);
            priceTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getPriceUsd()), "CAD"));
            lastUpdateTv.setText(getString(R.string.last_update_label) + "  " +
                    Utils.convertTimeToDisplayForDetail(Long.parseLong(coinInfo.getLastUpdate())));
            symbolTv.setText(coinInfo.getSymbol());
            priceUsdTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getPriceUsd()), "USD"));
            priceBtcTv.setText(coinInfo.getPriceBtc() + "Ƀ");
            volumeDayTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getTimeVolumeUsd()), "USD"));
            marketCabTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getMarketCapUsd()), "USD"));
            availableSupplyTv.setText(coinInfo.getAvailableSupply());
            totalSupplyTv.setText(coinInfo.getTotalSupply());
            changeOneHourTv.setText(coinInfo.getPercentChangeOneHour() + "%");
            changeOneDayTv.setText(coinInfo.getPercentChangeOneDay() + "%");
            changeOneWeekTv.setText(coinInfo.getPercentChangeOneWeek() + "%");

            if (Float.parseFloat(coinInfo.getPercentChangeOneDay()) >= 0) {
                changeOneDayTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneDayTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
            if (Float.parseFloat(coinInfo.getPercentChangeOneHour()) >= 0) {
                changeOneHourTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneHourTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
            if (Float.parseFloat(coinInfo.getPercentChangeOneWeek()) >= 0) {
                changeOneWeekTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneWeekTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
        }
    }

    @Override
    public void onGetCoinInfoSuccess(CoinInfoCny coinInfo) {
        if (coinInfo != null) {
            coinNameTv.setText(coinInfo.getName() + "(" + coinInfo.getSymbol() + ")");
            Glide.with(mContext).load("https://files.coinmarketcap.com/static/img/coins/64x64/" + coinInfo.getId() + ".png").into(coinIcon);
            priceTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getPriceUsd()), "CNY"));
            lastUpdateTv.setText(getString(R.string.last_update_label) + "  " +
                    Utils.convertTimeToDisplayForDetail(Long.parseLong(coinInfo.getLastUpdate())));
            symbolTv.setText(coinInfo.getSymbol());
            priceUsdTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getPriceUsd()), "USD"));
            priceBtcTv.setText(coinInfo.getPriceBtc() + "Ƀ");
            volumeDayTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getTimeVolumeUsd()), "USD"));
            marketCabTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getMarketCapUsd()), "USD"));
            availableSupplyTv.setText(coinInfo.getAvailableSupply());
            totalSupplyTv.setText(coinInfo.getTotalSupply());
            changeOneHourTv.setText(coinInfo.getPercentChangeOneHour() + "%");
            changeOneDayTv.setText(coinInfo.getPercentChangeOneDay() + "%");
            changeOneWeekTv.setText(coinInfo.getPercentChangeOneWeek() + "%");

            if (Float.parseFloat(coinInfo.getPercentChangeOneDay()) >= 0) {
                changeOneDayTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneDayTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
            if (Float.parseFloat(coinInfo.getPercentChangeOneHour()) >= 0) {
                changeOneHourTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneHourTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
            if (Float.parseFloat(coinInfo.getPercentChangeOneWeek()) >= 0) {
                changeOneWeekTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneWeekTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
        }
    }

    @Override
    public void onGetCoinInfoSuccess(CoinInfoEur coinInfo) {
        if (coinInfo != null) {
            coinNameTv.setText(coinInfo.getName() + "(" + coinInfo.getSymbol() + ")");
            Glide.with(mContext).load("https://files.coinmarketcap.com/static/img/coins/64x64/" + coinInfo.getId() + ".png").into(coinIcon);
            priceTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getPriceUsd()), "EUR"));
            lastUpdateTv.setText(getString(R.string.last_update_label) + "  " +
                    Utils.convertTimeToDisplayForDetail(Long.parseLong(coinInfo.getLastUpdate())));
            symbolTv.setText(coinInfo.getSymbol());
            priceUsdTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getPriceUsd()), "USD"));
            priceBtcTv.setText(coinInfo.getPriceBtc() + "Ƀ");
            volumeDayTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getTimeVolumeUsd()), "USD"));
            marketCabTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getMarketCapUsd()), "USD"));
            availableSupplyTv.setText(coinInfo.getAvailableSupply());
            totalSupplyTv.setText(coinInfo.getTotalSupply());
            changeOneHourTv.setText(coinInfo.getPercentChangeOneHour() + "%");
            changeOneDayTv.setText(coinInfo.getPercentChangeOneDay() + "%");
            changeOneWeekTv.setText(coinInfo.getPercentChangeOneWeek() + "%");

            if (Float.parseFloat(coinInfo.getPercentChangeOneDay()) >= 0) {
                changeOneDayTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneDayTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
            if (Float.parseFloat(coinInfo.getPercentChangeOneHour()) >= 0) {
                changeOneHourTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneHourTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
            if (Float.parseFloat(coinInfo.getPercentChangeOneWeek()) >= 0) {
                changeOneWeekTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneWeekTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
        }
    }

    @Override
    public void onGetCoinInfoSuccess(CoinInfoGbp coinInfo) {
        if (coinInfo != null) {
            coinNameTv.setText(coinInfo.getName() + "(" + coinInfo.getSymbol() + ")");
            Glide.with(mContext).load("https://files.coinmarketcap.com/static/img/coins/64x64/" + coinInfo.getId() + ".png").into(coinIcon);
            priceTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getPriceUsd()), "GBP"));
            lastUpdateTv.setText(getString(R.string.last_update_label) + "  " +
                    Utils.convertTimeToDisplayForDetail(Long.parseLong(coinInfo.getLastUpdate())));
            symbolTv.setText(coinInfo.getSymbol());
            priceUsdTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getPriceUsd()), "USD"));
            priceBtcTv.setText(coinInfo.getPriceBtc() + "Ƀ");
            volumeDayTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getTimeVolumeUsd()), "USD"));
            marketCabTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getMarketCapUsd()), "USD"));
            availableSupplyTv.setText(coinInfo.getAvailableSupply());
            totalSupplyTv.setText(coinInfo.getTotalSupply());
            changeOneHourTv.setText(coinInfo.getPercentChangeOneHour() + "%");
            changeOneDayTv.setText(coinInfo.getPercentChangeOneDay() + "%");
            changeOneWeekTv.setText(coinInfo.getPercentChangeOneWeek() + "%");

            if (Float.parseFloat(coinInfo.getPercentChangeOneDay()) >= 0) {
                changeOneDayTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneDayTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
            if (Float.parseFloat(coinInfo.getPercentChangeOneHour()) >= 0) {
                changeOneHourTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneHourTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
            if (Float.parseFloat(coinInfo.getPercentChangeOneWeek()) >= 0) {
                changeOneWeekTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneWeekTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
        }
    }

    @Override
    public void onGetCoinInfoSuccess(CoinInfoHkd coinInfo) {
        if (coinInfo != null) {
            coinNameTv.setText(coinInfo.getName() + "(" + coinInfo.getSymbol() + ")");
            Glide.with(mContext).load("https://files.coinmarketcap.com/static/img/coins/64x64/" + coinInfo.getId() + ".png").into(coinIcon);
            priceTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getPriceUsd()), "HKD"));
            lastUpdateTv.setText(getString(R.string.last_update_label) + "  " +
                    Utils.convertTimeToDisplayForDetail(Long.parseLong(coinInfo.getLastUpdate())));
            symbolTv.setText(coinInfo.getSymbol());
            priceUsdTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getPriceUsd()), "USD"));
            priceBtcTv.setText(coinInfo.getPriceBtc() + "Ƀ");
            volumeDayTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getTimeVolumeUsd()), "USD"));
            marketCabTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getMarketCapUsd()), "USD"));
            availableSupplyTv.setText(coinInfo.getAvailableSupply());
            totalSupplyTv.setText(coinInfo.getTotalSupply());
            changeOneHourTv.setText(coinInfo.getPercentChangeOneHour() + "%");
            changeOneDayTv.setText(coinInfo.getPercentChangeOneDay() + "%");
            changeOneWeekTv.setText(coinInfo.getPercentChangeOneWeek() + "%");

            if (Float.parseFloat(coinInfo.getPercentChangeOneDay()) >= 0) {
                changeOneDayTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneDayTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
            if (Float.parseFloat(coinInfo.getPercentChangeOneHour()) >= 0) {
                changeOneHourTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneHourTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
            if (Float.parseFloat(coinInfo.getPercentChangeOneWeek()) >= 0) {
                changeOneWeekTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneWeekTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
        }
    }

    @Override
    public void onGetCoinInfoSuccess(CoinInfoInr coinInfo) {
        if (coinInfo != null) {
            coinNameTv.setText(coinInfo.getName() + "(" + coinInfo.getSymbol() + ")");
            Glide.with(mContext).load("https://files.coinmarketcap.com/static/img/coins/64x64/" + coinInfo.getId() + ".png").into(coinIcon);
            priceTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getPriceUsd()), "INR"));
            lastUpdateTv.setText(getString(R.string.last_update_label) + "  " +
                    Utils.convertTimeToDisplayForDetail(Long.parseLong(coinInfo.getLastUpdate())));
            symbolTv.setText(coinInfo.getSymbol());
            priceUsdTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getPriceUsd()), "USD"));
            priceBtcTv.setText(coinInfo.getPriceBtc() + "Ƀ");
            volumeDayTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getTimeVolumeUsd()), "USD"));
            marketCabTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getMarketCapUsd()), "USD"));
            availableSupplyTv.setText(coinInfo.getAvailableSupply());
            totalSupplyTv.setText(coinInfo.getTotalSupply());
            changeOneHourTv.setText(coinInfo.getPercentChangeOneHour() + "%");
            changeOneDayTv.setText(coinInfo.getPercentChangeOneDay() + "%");
            changeOneWeekTv.setText(coinInfo.getPercentChangeOneWeek() + "%");

            if (Float.parseFloat(coinInfo.getPercentChangeOneDay()) >= 0) {
                changeOneDayTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneDayTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
            if (Float.parseFloat(coinInfo.getPercentChangeOneHour()) >= 0) {
                changeOneHourTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneHourTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
            if (Float.parseFloat(coinInfo.getPercentChangeOneWeek()) >= 0) {
                changeOneWeekTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneWeekTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
        }
    }

    @Override
    public void onGetCoinInfoSuccess(CoinInfoJpy coinInfo) {
        if (coinInfo != null) {
            coinNameTv.setText(coinInfo.getName() + "(" + coinInfo.getSymbol() + ")");
            Glide.with(mContext).load("https://files.coinmarketcap.com/static/img/coins/64x64/" + coinInfo.getId() + ".png").into(coinIcon);
            priceTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getPriceUsd()), "JPY"));
            lastUpdateTv.setText(getString(R.string.last_update_label) + "  " +
                    Utils.convertTimeToDisplayForDetail(Long.parseLong(coinInfo.getLastUpdate())));
            symbolTv.setText(coinInfo.getSymbol());
            priceUsdTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getPriceUsd()), "USD"));
            priceBtcTv.setText(coinInfo.getPriceBtc() + "Ƀ");
            volumeDayTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getTimeVolumeUsd()), "USD"));
            marketCabTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getMarketCapUsd()), "USD"));
            availableSupplyTv.setText(coinInfo.getAvailableSupply());
            totalSupplyTv.setText(coinInfo.getTotalSupply());
            changeOneHourTv.setText(coinInfo.getPercentChangeOneHour() + "%");
            changeOneDayTv.setText(coinInfo.getPercentChangeOneDay() + "%");
            changeOneWeekTv.setText(coinInfo.getPercentChangeOneWeek() + "%");

            if (Float.parseFloat(coinInfo.getPercentChangeOneDay()) >= 0) {
                changeOneDayTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneDayTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
            if (Float.parseFloat(coinInfo.getPercentChangeOneHour()) >= 0) {
                changeOneHourTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneHourTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
            if (Float.parseFloat(coinInfo.getPercentChangeOneWeek()) >= 0) {
                changeOneWeekTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneWeekTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
        }
    }

    @Override
    public void onGetCoinInfoSuccess(CoinInfoKrw coinInfo) {
        if (coinInfo != null) {
            coinNameTv.setText(coinInfo.getName() + "(" + coinInfo.getSymbol() + ")");
            Glide.with(mContext).load("https://files.coinmarketcap.com/static/img/coins/64x64/" + coinInfo.getId() + ".png").into(coinIcon);
            priceTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getPriceUsd()), "KRW"));
            lastUpdateTv.setText(getString(R.string.last_update_label) + "  " +
                    Utils.convertTimeToDisplayForDetail(Long.parseLong(coinInfo.getLastUpdate())));
            symbolTv.setText(coinInfo.getSymbol());
            priceUsdTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getPriceUsd()), "USD"));
            priceBtcTv.setText(coinInfo.getPriceBtc() + "Ƀ");
            volumeDayTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getTimeVolumeUsd()), "USD"));
            marketCabTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getMarketCapUsd()), "USD"));
            availableSupplyTv.setText(coinInfo.getAvailableSupply());
            totalSupplyTv.setText(coinInfo.getTotalSupply());
            changeOneHourTv.setText(coinInfo.getPercentChangeOneHour() + "%");
            changeOneDayTv.setText(coinInfo.getPercentChangeOneDay() + "%");
            changeOneWeekTv.setText(coinInfo.getPercentChangeOneWeek() + "%");

            if (Float.parseFloat(coinInfo.getPercentChangeOneDay()) >= 0) {
                changeOneDayTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneDayTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
            if (Float.parseFloat(coinInfo.getPercentChangeOneHour()) >= 0) {
                changeOneHourTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneHourTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
            if (Float.parseFloat(coinInfo.getPercentChangeOneWeek()) >= 0) {
                changeOneWeekTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneWeekTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
        }
    }

    @Override
    public void onGetCoinInfoSuccess(CoinInfoMxn coinInfo) {
        if (coinInfo != null) {
            coinNameTv.setText(coinInfo.getName() + "(" + coinInfo.getSymbol() + ")");
            Glide.with(mContext).load("https://files.coinmarketcap.com/static/img/coins/64x64/" + coinInfo.getId() + ".png").into(coinIcon);
            priceTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getPriceUsd()), "MXN"));
            lastUpdateTv.setText(getString(R.string.last_update_label) + "  " +
                    Utils.convertTimeToDisplayForDetail(Long.parseLong(coinInfo.getLastUpdate())));
            symbolTv.setText(coinInfo.getSymbol());
            priceUsdTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getPriceUsd()), "USD"));
            priceBtcTv.setText(coinInfo.getPriceBtc() + "Ƀ");
            volumeDayTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getTimeVolumeUsd()), "USD"));
            marketCabTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getMarketCapUsd()), "USD"));
            availableSupplyTv.setText(coinInfo.getAvailableSupply());
            totalSupplyTv.setText(coinInfo.getTotalSupply());
            changeOneHourTv.setText(coinInfo.getPercentChangeOneHour() + "%");
            changeOneDayTv.setText(coinInfo.getPercentChangeOneDay() + "%");
            changeOneWeekTv.setText(coinInfo.getPercentChangeOneWeek() + "%");

            if (Float.parseFloat(coinInfo.getPercentChangeOneDay()) >= 0) {
                changeOneDayTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneDayTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
            if (Float.parseFloat(coinInfo.getPercentChangeOneHour()) >= 0) {
                changeOneHourTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneHourTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
            if (Float.parseFloat(coinInfo.getPercentChangeOneWeek()) >= 0) {
                changeOneWeekTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneWeekTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
        }
    }

    @Override
    public void onGetCoinInfoSuccess(CoinInfoRub coinInfo) {
        if (coinInfo != null) {
            coinNameTv.setText(coinInfo.getName() + "(" + coinInfo.getSymbol() + ")");
            Glide.with(mContext).load("https://files.coinmarketcap.com/static/img/coins/64x64/" + coinInfo.getId() + ".png").into(coinIcon);
            priceTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getPriceUsd()), "RUB"));
            lastUpdateTv.setText(getString(R.string.last_update_label) + "  " +
                    Utils.convertTimeToDisplayForDetail(Long.parseLong(coinInfo.getLastUpdate())));
            symbolTv.setText(coinInfo.getSymbol());
            priceUsdTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getPriceUsd()), "USD"));
            priceBtcTv.setText(coinInfo.getPriceBtc() + "Ƀ");
            volumeDayTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getTimeVolumeUsd()), "USD"));
            marketCabTv.setText(Utils.convertFloatToMoney(Float.parseFloat(coinInfo.getMarketCapUsd()), "USD"));
            availableSupplyTv.setText(coinInfo.getAvailableSupply());
            totalSupplyTv.setText(coinInfo.getTotalSupply());
            changeOneHourTv.setText(coinInfo.getPercentChangeOneHour() + "%");
            changeOneDayTv.setText(coinInfo.getPercentChangeOneDay() + "%");
            changeOneWeekTv.setText(coinInfo.getPercentChangeOneWeek() + "%");

            if (Float.parseFloat(coinInfo.getPercentChangeOneDay()) >= 0) {
                changeOneDayTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneDayTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
            if (Float.parseFloat(coinInfo.getPercentChangeOneHour()) >= 0) {
                changeOneHourTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneHourTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
            if (Float.parseFloat(coinInfo.getPercentChangeOneWeek()) >= 0) {
                changeOneWeekTv.setTextColor(getResources().getColor(R.color.colorPrimary));
            } else {
                changeOneWeekTv.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
        }
    }

    public void setCoinId(String coinId) {
        this.coinId = coinId;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_coin_detail;
    }

    @Override
    protected void initEventAndData() {
        mPresenter.getCoinInfo(coinId);

        mPriceAdapter = new PriceTypeAdapter(getActivity());
        spinnerMoney.setAdapter(mPriceAdapter);

        spinnerMoney.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] prices = mContext.getResources().getStringArray(R.array.price_type);
                DLogUtils.d("PRICE: " + prices[i]);
                mPresenter.setPriceValue(prices[i]);
                mPresenter.getCoinInfo(coinId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ad = new Admob(getActivity());
        ad.adsBanner_Setting(adView);

    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }
}
