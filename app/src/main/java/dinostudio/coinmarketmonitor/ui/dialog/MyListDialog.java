package dinostudio.coinmarketmonitor.ui.dialog;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import dinostudio.coinmarketmonitor.R;
import dinostudio.coinmarketmonitor.ui.adapters.MenuAdapter;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/11/17.
 */

public class MyListDialog extends BaseDialog {

    private ArrayList<String> items;
    private Context mContext;
    private MenuAdapter menuAdapter;
    private String titleDialog;

    @BindView(R.id.title_dialog)
    TextView textView;

    @BindView(R.id.list_view_item)
    ListView menuListView;

    public MyListDialog(@NonNull Context context, String titleDialog, ArrayList<String> items, IDialogClick mIDialogClick) {
        super(context, mIDialogClick);
        this.mContext = context;
        this.items = items;
        this.titleDialog = titleDialog;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.my_list_dialog_layout);
        ButterKnife.bind(this);
        this.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        this.getWindow().setBackgroundDrawable(new ColorDrawable(0x11000000));

        textView.setText(titleDialog);

        menuAdapter = new MenuAdapter(mContext, items);
        menuListView.setAdapter(menuAdapter);

        menuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mIDialogClick.okClick("" + i);
            }
        });
    }
}
