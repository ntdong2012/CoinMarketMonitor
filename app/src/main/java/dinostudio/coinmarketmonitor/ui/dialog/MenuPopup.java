package dinostudio.coinmarketmonitor.ui.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.PopupWindow;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/10/17.
 */

public class MenuPopup extends PopupWindow {


    private Context mContext;

    public MenuPopup(@NonNull Context context) {
        super(context);
        this.mContext = context;
    }


}
