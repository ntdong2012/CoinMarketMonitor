package dinostudio.coinmarketmonitor.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/11/17.
 */

public class BaseDialog extends Dialog {

    IDialogClick mIDialogClick;

    public BaseDialog(@NonNull Context context, IDialogClick mIDialogClick) {
        super(context);
        this.mIDialogClick = mIDialogClick;
    }

    public BaseDialog(@NonNull Context context, @StyleRes int themeResId, IDialogClick mIDialogClick) {
        super(context, themeResId);
        this.mIDialogClick = mIDialogClick;
    }

    public BaseDialog(@NonNull Context context, boolean cancelable, @Nullable DialogInterface.OnCancelListener cancelListener, IDialogClick mIDialogClick) {
        super(context, cancelable, cancelListener);
        this.mIDialogClick = mIDialogClick;
    }
}
