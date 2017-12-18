package dinostudio.coinmarketmonitor.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dinostudio.coinmarketmonitor.R;
import dinostudio.coinmarketmonitor.base.utils.Utils;
import dinostudio.coinmarketmonitor.model.CoinDisplayInfo;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/8/17.
 */

public class CoinAdapter extends RecyclerView.Adapter<CoinAdapter.ViewHolder> {

    private ArrayList<CoinDisplayInfo> coinInfos;
    private ArrayList<CoinDisplayInfo> displayCoinList = null;
    private Context mContext;

    public interface ICoinClicked {
        void onCoinSelected(CoinDisplayInfo coinInfo);

        void onCoinFavorite(CoinDisplayInfo coinDisplayInfo);
    }

    private ICoinClicked iCoinClicked;

    public CoinAdapter(ArrayList<CoinDisplayInfo> coinInfos, Context mContext, ICoinClicked iCoinClicked) {
        this.coinInfos = coinInfos;
        this.displayCoinList = coinInfos;
        this.mContext = mContext;
        this.iCoinClicked = iCoinClicked;
    }

    public List<CoinDisplayInfo> search(String key) {
        ArrayList<CoinDisplayInfo> result = new ArrayList<CoinDisplayInfo>();
        if (!TextUtils.isEmpty(key)) {
            key = key.toLowerCase();
            for (int i = 0; i < coinInfos.size(); i++) {
                String coinName = coinInfos.get(i).getName().toLowerCase();
                if (coinName.contains(key.toLowerCase())) {
                    result.add(coinInfos.get(i));
                }
            }
        } else {
            result = coinInfos;
        }
        displayCoinList = result;
        return displayCoinList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.coin_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final CoinDisplayInfo info = displayCoinList.get(position);
        if (info != null) {
            holder.coinNameTv.setText(info.getName() + "(" + info.getSymbol() + ")");
            if (Utils.isPositiveNumber(info.getOndDayVl())) {
                holder.coinOneDayTv.setTextColor(mContext.getResources().getColor(R.color.colorPrimary));
            } else {
                holder.coinOneDayTv.setTextColor(mContext.getResources().getColor(android.R.color.holo_red_dark));
            }
            if (Utils.isPositiveNumber(info.getOneHourVl())) {
                holder.coinOneHourTv.setTextColor(mContext.getResources().getColor(R.color.colorPrimary));
            } else {
                holder.coinOneHourTv.setTextColor(mContext.getResources().getColor(android.R.color.holo_red_dark));
            }
            holder.coinOneDayTv.setText(info.getOndDayVl() + "%(24hr)");
            holder.coinOneHourTv.setText(info.getOneHourVl() + "%(1hr)");
            holder.lastUpdateTv.setText(mContext.getResources().getString(R.string.last_update_label) + " " + Utils.convertTimeToDisplay(Long.parseLong(info.getLastUpdate())));
            holder.coinPriceUsdTv.setText(Utils.convertFloatToMoney(Float.parseFloat(info.getPrice()), info.getPriceType()));
            Glide.with(mContext).load("https://files.coinmarketcap.com/static/img/coins/64x64/" + info.getId() + ".png").into(holder.coinIcon);
            holder.infoOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    iCoinClicked.onCoinSelected(info);
                }
            });

            holder.coinOneHourTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    iCoinClicked.onCoinSelected(info);
                }
            });
            holder.coinOneDayTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    iCoinClicked.onCoinSelected(info);
                }
            });
            holder.lastUpdateTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    iCoinClicked.onCoinSelected(info);
                }
            });
            holder.favoriteIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    iCoinClicked.onCoinFavorite(info);
                }
            });

            if (info.isFavorites()) {
                holder.favoriteIcon.setColorFilter(mContext.getResources().getColor(R.color.yellow_color));
            } else {
                holder.favoriteIcon.setColorFilter(mContext.getResources().getColor(R.color.gray_color));
            }
            if (info.isHasAlarm()) {
                holder.alarmIcon.setVisibility(View.VISIBLE);
                holder.alarmIcon.setColorFilter(mContext.getResources().getColor(R.color.yellow_color));
            } else {
                holder.alarmIcon.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return displayCoinList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image_icon)
        ImageView coinIcon;
        @BindView(R.id.coin_name_tv)
        TextView coinNameTv;
        @BindView(R.id.one_day_tv)
        TextView coinOneDayTv;
        @BindView(R.id.one_hour_tv)
        TextView coinOneHourTv;
        @BindView(R.id.last_update_tv)
        TextView lastUpdateTv;
        @BindView(R.id.coin_price_tv)
        TextView coinPriceUsdTv;
        @BindView(R.id.coin_info_wrapper)
        LinearLayout coinInfoWrapper;
        @BindView(R.id.favorite_icon)
        ImageView favoriteIcon;
        @BindView(R.id.info_one)
        RelativeLayout infoOne;
        @BindView(R.id.alarm_icon)
        ImageView alarmIcon;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
