package dinostudio.coinmarketmonitor.ui.dialog;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dinostudio.coinmarketmonitor.R;
import dinostudio.coinmarketmonitor.base.utils.AnimationUtils;
import dinostudio.coinmarketmonitor.base.utils.NumberTextWatcher;
import dinostudio.coinmarketmonitor.base.utils.Utils;
import dinostudio.coinmarketmonitor.model.AlarmInfo;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/14/17.
 */

public class SetupAlarmDialog extends BaseDialog {

    private Context mContext;
    private String coinId;
    private String coinName;
    private float currentPrice;

    @BindView(R.id.image_icon)
    ImageView coinIcon;
    @BindView(R.id.coin_name_tv)
    TextView coinNameTv;
    @BindView(R.id.current_price_tv)
    TextView currentPriceTv;
    @BindView(R.id.above_switch)
    Switch aboveSwitch;
    @BindView(R.id.below_switch)
    Switch bellowSwitch;
    @BindView(R.id.price_above_edt)
    EditText priceAboveEdt;
    @BindView(R.id.price_below_edt)
    EditText priceBelowEdt;


    public interface IAlarmInterface {
        void onSetupAlarm(String coinId, boolean above, boolean bellow, float aboveVl,
                          float belowValue);
    }

    public void setCoinId(String coinId) {
        this.coinId = coinId;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public void setCurrentPrice(float currentPrice) {
        this.currentPrice = currentPrice;
    }

    public SetupAlarmDialog(@NonNull Context context, IDialogClick mIDialogClick, IAlarmInterface iAlarmInterface) {
        super(context, mIDialogClick);
        this.iAlarmCallback = iAlarmInterface;
        mContext = context;
    }

    private AlarmInfo alarmInfo;
    private IAlarmInterface iAlarmCallback;

    public void setAlarmInfo(AlarmInfo alarmInfo) {
        this.alarmInfo = alarmInfo;
    }

    @OnClick(R.id.ok_btn)
    void handleOK() {
        float abow = 0;
        float below = 0;
        try {
            abow = Utils.getMoneyFromEdt(priceAboveEdt.getText().toString());
            if (abow == -1) {
                AnimationUtils.shake(mContext, priceAboveEdt);
                return;
            }
        } catch (Exception e) {

            return;
        }

        try {
            below = Utils.getMoneyFromEdt(priceBelowEdt.getText().toString());
            if (below == -1) {
                AnimationUtils.shake(mContext, priceBelowEdt);
                return;
            }
        } catch (Exception e) {
            AnimationUtils.shake(mContext, priceBelowEdt);
            return;
        }
        iAlarmCallback.onSetupAlarm(coinId, aboveSwitch.isChecked(), bellowSwitch.isChecked(),
                abow, below);

    }

    @OnClick(R.id.cancel_btn)
    void handleCancel() {
        mIDialogClick.cancelClick();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_alarm);
        ButterKnife.bind(this);
        this.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        this.getWindow().setBackgroundDrawable(new ColorDrawable(0x11000000));

        Glide.with(mContext).load("https://files.coinmarketcap.com/static/img/coins/64x64/" + coinId + ".png").into(coinIcon);
        currentPriceTv.setText(Utils.convertFloatToMoney(currentPrice, "USD"));
        coinNameTv.setText(coinName);
        aboveSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                priceAboveEdt.setEnabled(b);
            }
        });
        bellowSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                priceBelowEdt.setEnabled(b);
            }
        });
        priceAboveEdt.addTextChangedListener(new NumberTextWatcher(priceAboveEdt));
        priceBelowEdt.addTextChangedListener(new NumberTextWatcher(priceBelowEdt));

        if (alarmInfo != null) {
            bellowSwitch.setChecked(alarmInfo.isBelow());
            aboveSwitch.setChecked(alarmInfo.isAbove());
            priceAboveEdt.setText("" + alarmInfo.getPriceAbove());
            priceBelowEdt.setText("" + alarmInfo.getPriceBelow());
        }

    }
}
