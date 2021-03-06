package dinostudio.coinmarketmonitor.base.utils.formater;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/14/17.
 */

public class MonthFormatter implements IAxisValueFormatter {
    private SimpleDateFormat mFormat = new SimpleDateFormat("dd/MM");

    public MonthFormatter() {
    }

    public String getFormattedValue(float f, AxisBase axisBase) {
        return this.mFormat.format(new Date((long) f));
    }
}
