package dinostudio.coinmarketmonitor.ui.receivers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import dinostudio.coinmarketmonitor.base.utils.DLogUtils;
import dinostudio.coinmarketmonitor.ui.service.UpdateCoinInfoService;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/12/17.
 */

public class UpdateCoinInfoReceiver extends BroadcastReceiver {

    final public static String ONE_TIME = "onetime";

    @Override
    public void onReceive(Context context, Intent intent) {
        DLogUtils.d("onReceiver");
        context.startService(new Intent(context, UpdateCoinInfoService.class));


//        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
//        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "YOUR TAG");
//        //Acquire the lock
//        wl.acquire();
//
//        //You can do the processing here.
//        Bundle extras = intent.getExtras();
//        StringBuilder msgStr = new StringBuilder();
//
//        if (extras != null && extras.getBoolean(ONE_TIME, Boolean.FALSE)) {
//            //Make sure this intent has been sent by the one-time timer button.
//            msgStr.append("One time Timer : ");
//        }
//        Format formatter = new SimpleDateFormat("hh:mm:ss a");
//        msgStr.append(formatter.format(new Date()));
//
//        Toast.makeText(context, msgStr, Toast.LENGTH_LONG).show();
//
//        //Release the lock
//        wl.release();
    }

    public void setAlarm(Context context, int timeInterval) {
        DLogUtils.d("INTERVAL time : " + timeInterval);
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, UpdateCoinInfoReceiver.class);
        intent.putExtra(ONE_TIME, Boolean.FALSE);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, 0);
        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1000 * timeInterval * 60, pi);
    }

    public void cancelAlarm(Context context) {
        Intent intent = new Intent(context, UpdateCoinInfoReceiver.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(sender);
    }

    public void setOnetimeTimer(Context context) {
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, UpdateCoinInfoReceiver.class);
        intent.putExtra(ONE_TIME, Boolean.TRUE);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, 0);
        am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), pi);
    }

}
