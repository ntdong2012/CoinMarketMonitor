package dinostudio.coinmarketmonitor.base.utils.formater;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/14/17.
 */

public class DayFormatter implements IAxisValueFormatter {
    private SimpleDateFormat mFormat = new SimpleDateFormat("hh:mm");

    public DayFormatter() {
    }

    public String getFormattedValue(float f, AxisBase axisBase) {
        return this.mFormat.format(new Date((long) f));
    }
}
