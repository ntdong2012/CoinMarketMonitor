package dinostudio.coinmarketmonitor.ui.dialog;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RadioButton;

import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dinostudio.coinmarketmonitor.R;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/12/17.
 */

public class DefaultTimeRefreshDialog extends BaseDialog {

    private Context mContext;
    private int refreshTime;

    @BindViews({R.id.radio_btn_5, R.id.radio_btn_15, R.id.radio_btn_30, R.id.radio_btn_1h, R.id.radio_btn_3h, R.id.radio_btn_custom})
    RadioButton[] radioButtons;


    @OnClick(R.id.cancel_btn)
    void handleCancelDialog() {
        mIDialogClick.cancelClick();
    }


    public DefaultTimeRefreshDialog(@NonNull Context context, int refreshTime, IDialogClick mIDialogClick) {
        super(context, mIDialogClick);
        this.mContext = context;
        this.refreshTime = refreshTime;
    }

    @OnClick({R.id.radio_btn_5, R.id.radio_btn_15, R.id.radio_btn_30, R.id.radio_btn_1h, R.id.radio_btn_3h, R.id.radio_btn_custom})
    void handleTimeRadioBtnClick(RadioButton radioButton) {
        boolean checked = radioButton.isChecked();

        // Check which radio button was clicked
        switch (radioButton.getId()) {
            case R.id.radio_btn_5:
                if (checked) {
                    mIDialogClick.okClick("5");
                }
                break;
            case R.id.radio_btn_15:
                if (checked) {
                    mIDialogClick.okClick("15");
                }
                break;
            case R.id.radio_btn_30:
                if (checked) {
                    mIDialogClick.okClick("30");
                }
                break;
            case R.id.radio_btn_1h:
                if (checked) {
                    mIDialogClick.okClick("60");
                }
                break;
            case R.id.radio_btn_3h:
                if (checked) {
                    mIDialogClick.okClick("180");
                }
                break;
            case R.id.radio_btn_custom:
                if (checked) {
                    mIDialogClick.okClick("custom");
                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_default_time_refresh);
        ButterKnife.bind(this);
        this.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        this.getWindow().setBackgroundDrawable(new ColorDrawable(0x11000000));

        switch (refreshTime) {
            case 5:
                radioButtons[0].setChecked(true);
                break;
            case 15:
                radioButtons[1].setChecked(true);
                break;
            case 30:
                radioButtons[2].setChecked(true);
                break;
            case 60:
                radioButtons[3].setChecked(true);
                break;
            case 180:
                radioButtons[4].setChecked(true);
                break;
            default:
                radioButtons[5].setChecked(true);
                break;
        }
    }

}
