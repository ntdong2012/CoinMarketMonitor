package dinostudio.coinmarketmonitor.ui.fragment;

import android.support.v4.content.ContextCompat;
import android.support.v4.internal.view.SupportMenu;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.HashMap;

import belka.us.androidtoggleswitch.widgets.BaseToggleSwitch;
import belka.us.androidtoggleswitch.widgets.ToggleSwitch;
import butterknife.BindView;
import butterknife.OnClick;
import dinostudio.coinmarketmonitor.R;
import dinostudio.coinmarketmonitor.base.admob.Admob;
import dinostudio.coinmarketmonitor.base.contract.CoinCharContract;
import dinostudio.coinmarketmonitor.base.core.BaseFragment;
import dinostudio.coinmarketmonitor.base.utils.Common;
import dinostudio.coinmarketmonitor.base.utils.DLogUtils;
import dinostudio.coinmarketmonitor.base.utils.Utils;
import dinostudio.coinmarketmonitor.base.utils.formater.DayFormatter;
import dinostudio.coinmarketmonitor.base.utils.formater.DefaultFormatter;
import dinostudio.coinmarketmonitor.base.utils.formater.MonthFormatter;
import dinostudio.coinmarketmonitor.model.AlarmInfo;
import dinostudio.coinmarketmonitor.model.CharData;
import dinostudio.coinmarketmonitor.model.CoinInfo;
import dinostudio.coinmarketmonitor.presenter.CoinCharPresenter;
import dinostudio.coinmarketmonitor.ui.dialog.IDialogClick;
import dinostudio.coinmarketmonitor.ui.dialog.SetupAlarmDialog;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/8/17.
 */

public class CoinCharFragment extends BaseFragment<CoinCharPresenter> implements CoinCharContract.View,
        OnChartGestureListener, OnChartValueSelectedListener {


    @BindView(R.id.customized_items_toggle_switch)
    ToggleSwitch toggleSwitch;
    @BindView(R.id.linechart)
    LineChart mChart;
    @BindView(R.id.ad_view_fragment_setting)
    AdView adView;
    @BindView(R.id.tv_value)
    TextView coinPriceValue;
    @BindView(R.id.tv_time)
    TextView coinPriceTime;
    @BindView(R.id.image_icon)
    ImageView coinIcon;
    @BindView(R.id.coin_name_tv)
    TextView coinNameTv;
    @BindView(R.id.last_value_tv)
    TextView lastValueTv;
    @BindView(R.id.alarm_icon)
    ImageView alarmIcon;


    private String coinId;
    private String coinName;
    private int selectedCharTime;
    private HashMap<String, String> mapaChart = new HashMap();
    private Admob ad;
    private CoinInfo currentCoin;
    private float lastestPrice;
    private SetupAlarmDialog alarmDialog;


    ArrayList<Entry> entries;
    private AlarmInfo currentAlarmInfo;

    public void setCoinId(String coinId) {
        this.coinId = coinId;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    @Override
    public void onGetCoinInfoSuccess(CoinInfo info) {

    }

    @Override
    public void onGetAlarmInfoSuccess(AlarmInfo alarmInfo) {
        currentAlarmInfo = alarmInfo;
    }

    @OnClick(R.id.alarm_icon)
    void handleAlarmClick() {

        alarmDialog = new SetupAlarmDialog(getActivity(), new IDialogClick() {
            @Override
            public void okClick(String result) {

            }

            @Override
            public void cancelClick() {
                alarmDialog.dismiss();
            }
        }, new SetupAlarmDialog.IAlarmInterface() {
            @Override
            public void onSetupAlarm(String coinId, boolean above, boolean bellow, float aboveVl, float belowValue) {
                alarmDialog.dismiss();
                mPresenter.onUpdateAlarmInfo(coinId, above, bellow, aboveVl, belowValue);
                updateNotificationIcon();

            }
        });
        alarmDialog.setCoinId(coinId);
        alarmDialog.setCoinName(coinName);
        alarmDialog.setCurrentPrice(lastestPrice);
        alarmDialog.setAlarmInfo(mPresenter.getAlarmInfo(coinId));
        alarmDialog.show();
    }

    @Override
    public void onGetCharDataSuccess(CharData charData) {

        mapaChart.clear();
        mChart.clear();
        entries = new ArrayList<>();
        int i2 = 0;
        while (i2 < charData.getPriceUsds().size()) {
            try {
                long f = (long) charData.getPriceUsds().get(i2).get(0).longValue();
                double f2 = (double) charData.getPriceUsds().get(i2).get(1).doubleValue();
                entries.add(new Entry((float) f, (float) f2));
                mapaChart.put(String.valueOf(f), String.valueOf(f2));
                i2++;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (entries.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Price (USD) ");
            LineDataSet lineDataSet = new LineDataSet(entries, stringBuilder.toString());

            lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
            lineDataSet.setColor(getResources().getColor(R.color.colorPrimary));
            lineDataSet.setValueTextColor(ColorTemplate.getHoloBlue());
            lineDataSet.setLineWidth((float) 1.3);
            lineDataSet.setDrawCircles(false);
            lineDataSet.setDrawFilled(true);
            lineDataSet.setDrawValues(true);
            lineDataSet.setFillAlpha(10);
            lineDataSet.setFillColor(ColorTemplate.getHoloBlue());
            lineDataSet.setHighLightColor(getResources().getColor(R.color.colorPrimary));
            lineDataSet.setDrawCircleHole(false);
            lineDataSet.setDrawValues(false);
            lineDataSet.setHighlightEnabled(true);
            lineDataSet.setDrawHighlightIndicators(true);
            lineDataSet.setHighLightColor(getResources().getColor(R.color.yellow_color));
            lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);


            LineData lineData = new LineData(lineDataSet);
            lineData.setValueTextColor(-1);
            lineData.setValueTextSize(9.0f);

            Legend legend = mChart.getLegend();
            legend.setEnabled(true);

            legend.setForm(Legend.LegendForm.CIRCLE);
            legend.setTextColor(getResources().getColor(R.color.colorPrimary));


            XAxis eAxis = mChart.getXAxis();
            mChart.getXAxis();
            eAxis.setLabelCount(7, false);
            eAxis.setTextColor(getResources().getColor(R.color.colorPrimary));
            eAxis.setEnabled(true);
            eAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
            eAxis.setDrawGridLines(false);
            eAxis.setAxisLineColor(getResources().getColor(android.R.color.black));
            eAxis.setLabelRotationAngle(0.0f);
            if (this.selectedCharTime == Common.CHAR_TIME_VALUE.DAY) {
                eAxis.setValueFormatter(new DayFormatter());
            } else if (this.selectedCharTime == Common.CHAR_TIME_VALUE.WEEK) {
                eAxis.setValueFormatter(new MonthFormatter());
            } else if (this.selectedCharTime == Common.CHAR_TIME_VALUE.MONTH) {
                eAxis.setValueFormatter(new MonthFormatter());
            } else if (this.selectedCharTime == Common.CHAR_TIME_VALUE.YEAR) {
                eAxis.setValueFormatter(new DefaultFormatter());
            } else if (this.selectedCharTime == Common.CHAR_TIME_VALUE.ALL) {
                eAxis.setValueFormatter(new DefaultFormatter());
            }
            YAxis yAxis = mChart.getAxisLeft();
            yAxis.setTextColor(getResources().getColor(R.color.colorPrimary));
            yAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
            yAxis.setDrawGridLines(false);
            yAxis.setAxisLineColor(getResources().getColor(android.R.color.black));

            mChart.setData((LineData) lineData);
            mChart.setData(lineData);
            mChart.animateX(1000);
            mChart.invalidate();


            Entry e = entries.get(entries.size() - 1);
            lastestPrice = e.getY();
            coinPriceValue.setText("" + Utils.convertFloatToMoney(e.getY(), "USD"));

            coinPriceTime.setText("" + Utils.convertTimeToDisplayForChar((long) e.getX()));
            lastValueTv.setText(getString(R.string.last_price) + " " + Utils.convertFloatToMoney(e.getY(), "USD") + "\n" +
                    getString(R.string.on_label) + " " + Utils.convertTimeToDisplayForChar((long) e.getX()));

            alarmIcon.setClickable(true);
        }
        this.mChart.setNoDataText("No data");
    }

    @Override
    public void onGetCharDataError(String str) {
        DLogUtils.d("Error: " + str);
    }

    void initChar() {
        mChart.setOnChartGestureListener(this);
        mChart.setOnChartValueSelectedListener(this);
        mChart.setDrawGridBackground(false);
        this.mChart.setNoDataText(getString(R.string.loading_chart_data));
        this.mChart.invalidate();
        this.mChart.clear();
        this.mChart.setViewPortOffsets(150.0f, 50.0f, 30.0f, 200.0f);
        this.mChart.setBackgroundColor(ContextCompat.getColor(getActivity(), android.R.color.transparent));
        this.mChart.getDescription().setEnabled(false);
        this.mChart.setTouchEnabled(true);
        this.mChart.setDragEnabled(true);
        this.mChart.setScaleEnabled(true);
        this.mChart.setPinchZoom(true);
        this.mChart.setMaxHighlightDistance(100.0f);
        XAxis view = this.mChart.getXAxis();
        view.setPosition(XAxis.XAxisPosition.BOTTOM);
        view.setTextSize(10.0f);
        view.setTextColor(SupportMenu.CATEGORY_MASK);
        view.setDrawAxisLine(true);
        view.setDrawGridLines(true);
        view.setLabelRotationAngle(90.0f);

        view.setTextColor(getResources().getColor(R.color.colorPrimary));

        YAxis tview2 = this.mChart.getAxisLeft();

        tview2.setLabelCount(6, false);
        tview2.setTextColor(getResources().getColor(R.color.colorPrimary));
        tview2.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART);
        tview2.setDrawGridLines(false);

        tview2.setAxisLineColor(getResources().getColor(android.R.color.black));
        this.mChart.getAxisRight().setEnabled(false);
        this.mChart.getLegend().setEnabled(true);
        this.mChart.animateX(1000);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_coin_char;
    }

    @Override
    protected void initEventAndData() {
        initToggleSwitch();
        initChar();
        mPresenter.getCharDataByType(coinId, 0);
        ad = new Admob(getActivity());
        ad.adsBanner_Setting(adView);

        coinNameTv.setText(coinName);
        Glide.with(mContext).load("https://files.coinmarketcap.com/static/img/coins/64x64/" + coinId + ".png").into(coinIcon);
        updateNotificationIcon();
    }

    private void updateNotificationIcon() {
        if (mPresenter.getAlarmInfo(coinId) != null) {
            alarmIcon.setColorFilter(mContext.getResources().getColor(R.color.yellow_color));
        } else {
            alarmIcon.setColorFilter(mContext.getResources().getColor(R.color.gray_color));
        }
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void onChartGestureStart(MotionEvent me,
                                    ChartTouchListener.ChartGesture
                                            lastPerformedGesture) {
        Log.i("Gesture", "START, x: " + me.getX() + ", y: " + me.getY());
    }

    @Override
    public void onChartGestureEnd(MotionEvent me,
                                  ChartTouchListener.ChartGesture
                                          lastPerformedGesture) {

        Log.i("Gesture", "END, lastGesture: " + lastPerformedGesture);

        // un-highlight values after the gesture is finished and no single-tap
        if (lastPerformedGesture != ChartTouchListener.ChartGesture.SINGLE_TAP)
            // or highlightTouch(null) for callback to onNothingSelected(...)
            mChart.highlightValues(null);
    }

    @Override
    public void onChartLongPressed(MotionEvent me) {
        Log.i("LongPress", "Chart longpressed.");
    }

    @Override
    public void onChartDoubleTapped(MotionEvent me) {
        Log.i("DoubleTap", "Chart double-tapped.");
    }

    @Override
    public void onChartSingleTapped(MotionEvent me) {
        Log.i("SingleTap", "Chart single-tapped.");
    }

    @Override
    public void onChartFling(MotionEvent me1, MotionEvent me2,
                             float velocityX, float velocityY) {
        Log.i("Fling", "Chart flinged. VeloX: "
                + velocityX + ", VeloY: " + velocityY);
    }

    @Override
    public void onChartScale(MotionEvent me, float scaleX, float scaleY) {
        Log.i("Scale / Zoom", "ScaleX: " + scaleX + ", ScaleY: " + scaleY);
    }

    @Override
    public void onChartTranslate(MotionEvent me, float dX, float dY) {
        Log.i("Translate / Move", "dX: " + dX + ", dY: " + dY);
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {
        coinPriceValue.setText("" + Utils.convertFloatToMoney(e.getY(), "USD"));
        coinPriceTime.setText("" + Utils.convertTimeToDisplayForChar((long) e.getX()));

    }

    @Override
    public void onNothingSelected() {
        Log.i("Nothing selected", "Nothing selected.");
    }


    void initToggleSwitch() {
        ArrayList<String> labels = new ArrayList<>();
        String[] labelsArr = getResources().getStringArray(R.array.char_time_label);
        for (int i = 0; i < labelsArr.length; i++) {
            labels.add(labelsArr[i]);
        }
        toggleSwitch.setLabels(labels);
        toggleSwitch.setCheckedTogglePosition(selectedCharTime);
        toggleSwitch.setOnToggleSwitchChangeListener(new BaseToggleSwitch.OnToggleSwitchChangeListener() {
            @Override
            public void onToggleSwitchChangeListener(int position, boolean isChecked) {
                if (isChecked) {
                    switch (position) {
                        case Common.CHAR_TIME_VALUE.DAY:
                            selectedCharTime = Common.CHAR_TIME_VALUE.DAY;
                            mPresenter.getCharDataByType(coinId, Common.CHAR_TIME_VALUE.DAY);
                            break;
                        case Common.CHAR_TIME_VALUE.WEEK:
                            selectedCharTime = Common.CHAR_TIME_VALUE.WEEK;
                            mPresenter.getCharDataByType(coinId, Common.CHAR_TIME_VALUE.WEEK);
                            break;
                        case Common.CHAR_TIME_VALUE.MONTH:
                            selectedCharTime = Common.CHAR_TIME_VALUE.MONTH;
                            mPresenter.getCharDataByType(coinId, Common.CHAR_TIME_VALUE.MONTH);
                            break;
                        case Common.CHAR_TIME_VALUE.YEAR:
                            selectedCharTime = Common.CHAR_TIME_VALUE.YEAR;
                            mPresenter.getCharDataByType(coinId, Common.CHAR_TIME_VALUE.YEAR);
                            break;
                        default:
                            selectedCharTime = Common.CHAR_TIME_VALUE.ALL;
                            mPresenter.getCharDataByType(coinId, Common.CHAR_TIME_VALUE.ALL);
                            break;
                    }

                }

            }
        });
    }

}
