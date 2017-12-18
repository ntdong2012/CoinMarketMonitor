package dinostudio.coinmarketmonitor.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import dinostudio.coinmarketmonitor.R;
import dinostudio.coinmarketmonitor.base.contract.SettingContract;
import dinostudio.coinmarketmonitor.base.core.BaseActivity;
import dinostudio.coinmarketmonitor.base.utils.Common;
import dinostudio.coinmarketmonitor.presenter.SettingPresenter;
import dinostudio.coinmarketmonitor.ui.dialog.CustomTimeRefreshDialog;
import dinostudio.coinmarketmonitor.ui.dialog.DefaultTimeRefreshDialog;
import dinostudio.coinmarketmonitor.ui.dialog.IDialogClick;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/12/17.
 */

public class SettingActivity extends BaseActivity<SettingPresenter> implements SettingContract.View {

    @BindView(R.id.switch_sound)
    Switch soundSwitch;
    @BindView(R.id.switch_vibration)
    Switch vibrationSwitch;
    @BindView(R.id.switch_refresh)
    Switch refreshSwitch;
    @BindView(R.id.auto_refresh_time_value)
    TextView autoRefreshTv;
    DefaultTimeRefreshDialog timeRefreshDialog;
    CustomTimeRefreshDialog customTimeRefreshDialog;
    @BindView(R.id.switch_display_favorite_first)
    Switch displayFavoriteFirstSwitch;
    @BindView(R.id.switch_display_favorite_only)
    Switch displayOnlyFavoriteSwitch;

    void updateAutoRefreshTime() {
        autoRefreshTv.setText(getString(R.string.every_label) + " " +
                mPresenter.getAutoRefreshTime() + " " + getString(R.string.min_label));
    }


    @OnClick(R.id.refresh_time_wrapper)
    void handleTimeRefresh() {
        timeRefreshDialog = new DefaultTimeRefreshDialog(this, mPresenter.getAutoRefreshTime(), new IDialogClick() {
            @Override
            public void okClick(String result) {
                try {
                    Integer i = Integer.parseInt(result);
                    mPresenter.setAutoRefreshTime(i);
                    updateAutoRefreshTime();
                } catch (Exception e) {
                    customTimeRefreshDialog = new CustomTimeRefreshDialog(SettingActivity.this, mPresenter.getAutoRefreshTime(), new IDialogClick() {
                        @Override
                        public void okClick(String result) {
                            Integer i = Integer.parseInt(result);
                            mPresenter.setAutoRefreshTime(i);
                            updateAutoRefreshTime();
                            customTimeRefreshDialog.dismiss();
                        }

                        @Override
                        public void cancelClick() {
                            customTimeRefreshDialog.dismiss();
                        }
                    });
                    customTimeRefreshDialog.show();


                }
                timeRefreshDialog.dismiss();
            }

            @Override
            public void cancelClick() {
                timeRefreshDialog.dismiss();
            }
        });
        timeRefreshDialog.show();
    }

    @Override
    protected void initEventAndData() {
        soundSwitch.setChecked(mPresenter.getAlarmSound());
        vibrationSwitch.setChecked(mPresenter.getAlarmVibration());
        refreshSwitch.setChecked(mPresenter.getAutoRefresh());
        displayFavoriteFirstSwitch.setChecked(mPresenter.isDisplayFavoriteCoinFirst());
        displayOnlyFavoriteSwitch.setChecked(mPresenter.isDisplayOnlyFavoriteCoin());
        updateAutoRefreshTime();
    }


    public static void callIntent(Context context, Bundle bundle) {
        Intent i = new Intent(context, SettingActivity.class);
        i.putExtra(Common.INTENT_DATA.BUNDLE_DATA, bundle);
        context.startActivity(i);
        ((Activity) context).overridePendingTransition(R.anim.right_in, R.anim.left_out);
    }


    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.setAlarmSound(soundSwitch.isChecked());
        mPresenter.setAlarmVibration(vibrationSwitch.isChecked());
        mPresenter.setAutoRefresh(refreshSwitch.isChecked());
        mPresenter.displayFavoriteCoinFirst(displayFavoriteFirstSwitch.isChecked());
        mPresenter.displayOnlyFavoriteCoin(displayOnlyFavoriteSwitch.isChecked());
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onBackPressedSupport() {
        super.onBackPressedSupport();
        overridePendingTransition(R.anim.left_in, R.anim.right_out);

    }

    @Override
    protected void initInject() {
        getActivityComponent(false).inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_setting;
    }


}
