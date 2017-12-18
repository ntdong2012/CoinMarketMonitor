package dinostudio.coinmarketmonitor.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import dinostudio.coinmarketmonitor.R;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/11/17.
 */

public class MenuAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<String> items;
    private LayoutInflater inflater;

    public MenuAdapter(Context mContext, ArrayList<String> items) {
        this.mContext = mContext;
        this.items = items;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items != null ? items.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return items != null ? items.get(i) : null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View tv = inflater.inflate(R.layout.menu_item_text_view, viewGroup, false);
        TextView tvIt = (TextView) tv.findViewById(R.id.textview);
        tvIt.setText(items.get(i));
        return tv;
    }
}
