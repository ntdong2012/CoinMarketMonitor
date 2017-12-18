package dinostudio.coinmarketmonitor.ui.dialog;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dinostudio.coinmarketmonitor.R;
import dinostudio.coinmarketmonitor.base.utils.AnimationUtils;
import dinostudio.coinmarketmonitor.base.utils.ToastUtils;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/12/17.
 */

public class CustomTimeRefreshDialog extends BaseDialog {

    private Context mContext;
    private int refreshTime;

    @BindView(R.id.time_custom_edt)
    EditText customEdt;


    @OnClick(R.id.cancel_btn)
    void handleCancelDialog() {
        mIDialogClick.cancelClick();
    }


    @OnClick(R.id.cancel_btn)
    void handleCancelAction() {
        mIDialogClick.cancelClick();
    }

    @OnClick(R.id.ok_btn)
    void handleOkAction() {
        String num = customEdt.getText().toString();
        if (TextUtils.isEmpty(num)) {
            num = customEdt.getHint().toString();
        }
        if (!TextUtils.isEmpty(num)) {
            try {
                Integer i = Integer.parseInt(num);
                if (i < 5) {
                    AnimationUtils.shake(mContext, customEdt);
                    ToastUtils.shortShow("Interval more than 5 minutes");
                } else {
                    mIDialogClick.okClick(num);
                }
            } catch (Exception e) {
                e.printStackTrace();
                AnimationUtils.shake(mContext, customEdt);
            }
        }
    }

    public CustomTimeRefreshDialog(@NonNull Context context, int refreshTime, IDialogClick mIDialogClick) {
        super(context, mIDialogClick);
        this.mContext = context;
        this.refreshTime = refreshTime;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_custom_auto_resfresh_time);
        ButterKnife.bind(this);
        this.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        this.getWindow().setBackgroundDrawable(new ColorDrawable(0x11000000));
        customEdt.setHint("" + refreshTime);
    }


}
