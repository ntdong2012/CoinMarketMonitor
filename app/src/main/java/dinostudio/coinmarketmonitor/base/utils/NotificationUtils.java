package dinostudio.coinmarketmonitor.base.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.provider.Settings;

import dinostudio.coinmarketmonitor.R;
import dinostudio.coinmarketmonitor.ui.activity.HomeActivity;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/18/17.
 */

public class NotificationUtils {

    public static void showNotification(Context context, String message, boolean isSound, boolean isVibrate) {

        Intent intent = new Intent(context, HomeActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), intent, 0);
        Notification.Builder builder = new Notification.Builder(context)
                .setContentTitle(message)
                .setContentText(context.getString(R.string.notification_title))
                .setSmallIcon(R.drawable.if_advantage_wallet_1034368_mini)
                .setContentIntent(pIntent)
                .setAutoCancel(true);

        if (isVibrate) {
            builder.setLights(Color.RED, 500, 500);
            long[] pattern = {500, 500, 500, 500, 500, 500, 500, 500, 500};
            builder.setVibrate(pattern);
        }
        if (isSound) {
            builder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
        }
        Notification n = builder.build();


        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(0, n);
    }
}
