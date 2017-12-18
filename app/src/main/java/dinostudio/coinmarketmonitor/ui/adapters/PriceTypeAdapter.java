package dinostudio.coinmarketmonitor.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import dinostudio.coinmarketmonitor.R;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/15/17.
 */

public class PriceTypeAdapter extends BaseAdapter {

    private Context mContext;
    private String[] mPriceArr;
    private LayoutInflater inflater;

    public PriceTypeAdapter(Context mContext) {
        this.mContext = mContext;
        mPriceArr = mContext.getResources().getStringArray(R.array.price_type);
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mPriceArr.length;
    }

    @Override
    public Object getItem(int i) {
        return mPriceArr[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView tv = (TextView) inflater.inflate(R.layout.price_type_item, viewGroup, false);
        tv.setText(mPriceArr[i]);
        return tv;
    }
}
