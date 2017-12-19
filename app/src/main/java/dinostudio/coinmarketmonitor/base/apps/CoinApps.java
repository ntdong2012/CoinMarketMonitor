package dinostudio.coinmarketmonitor.base.apps;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Typeface;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashSet;
import java.util.Set;

import dinostudio.coinmarketmonitor.base.dj.component.AppComponent;
import dinostudio.coinmarketmonitor.base.dj.component.DaggerAppComponent;
import dinostudio.coinmarketmonitor.base.dj.module.AppModule;
import dinostudio.coinmarketmonitor.base.dj.module.HttpModule;
import io.realm.Realm;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/7/17.
 */

public class CoinApps extends Application {

    private static CoinApps instance;
    public static AppComponent appComponent;
    private Set<Activity> allActivities;

    private boolean isUTMode = true;
    private boolean isSendLog = true;

    private static AppModule appModule;
    private static HttpModule httpModule;
    private static Typeface fontAwesomeTf;

    private Thread.UncaughtExceptionHandler uncaughtHandler;

    public static AppComponent getAppComponent(boolean isNeedRefresh) {
        if (appComponent == null || isNeedRefresh) {
            appModule = new AppModule(instance);
            httpModule = new HttpModule();

            appComponent = DaggerAppComponent.builder()
                    .appModule(appModule)
                    .httpModule(httpModule)
                    .build();
        }
        return appComponent;
    }


    void initFont() {
        if (fontAwesomeTf == null) {
            fontAwesomeTf = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
        }
    }

    public static Typeface getFontAwesomeTf() {
        return fontAwesomeTf;
    }


    @Override
    public void onCreate() {
        super.onCreate();
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            // This process is dedicated to LeakCanary for heap analysis.
//            // You should not init your app in this process.
//            return;
//        }
//        LeakCanary.install(this);
//        initAppModule();

//        initFont();
        Realm.init(getApplicationContext());
        if (isSendLog) {
            uncaughtHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandlerApplication());
        }

        instance = this;
    }

    public static CoinApps getInstance() {
        return instance;
    }

    public static void setInstance(CoinApps instance) {
        CoinApps.instance = instance;
    }

    public void addActivity(Activity act) {
        if (allActivities == null) {
            allActivities = new HashSet<>();
        }
        allActivities.add(act);
    }

    public void removeActivity(Activity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }
    }

    public static AppModule getAppModule() {
        return appModule;
    }

    public static void setAppModule(AppModule appModule) {
        CoinApps.appModule = appModule;
    }

    public static HttpModule getHttpModule() {
        return httpModule;
    }

    public static void setHttpModule(HttpModule httpModule) {
        CoinApps.httpModule = httpModule;
    }

    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity act : allActivities) {
                    act.finish();
                }
            }
        }


        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    private String getStackTrace(Throwable t) {
        final Writer result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);
        Throwable cause = t;

        while (cause != null) {
            cause.printStackTrace(printWriter);
            cause = cause.getCause();

        }

        final String stackTrace = result.toString();
        printWriter.close();
        return stackTrace;
    }

    private String getDeviceSuperInfo() {
        try {
            PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);

            String s = "Debug-infos:";
            s += "\n OS Version: " + System.getProperty("os.version") + "("
                    + android.os.Build.VERSION.INCREMENTAL + ")";
            s += "\n OS API Level: " + android.os.Build.VERSION.SDK_INT;
            s += "\n Device: " + android.os.Build.DEVICE;
            s += "\n Model (and Product): " + android.os.Build.MODEL + " ("
                    + android.os.Build.PRODUCT + ")";
            s += "\n DISPLAY: " + android.os.Build.DISPLAY;
            s += "\n UNKNOWN: " + android.os.Build.UNKNOWN;
            s += "\n MANUFACTURER: " + android.os.Build.MANUFACTURER;
            s += "\n SERIAL: " + android.os.Build.SERIAL;
            s += "\n USER: " + android.os.Build.USER;
            s += "\n HOST: " + android.os.Build.HOST;
            s += "\n APPVER: " + pInfo.versionCode;
            s += "\n++++++++++++++++++++++++++++++++++++++\n";
            return s;
        } catch (Exception e) {
            return "";
        }

    }

    class UncaughtExceptionHandlerApplication implements
            Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread thread, Throwable ex) {
            String stackString = getStackTrace(ex);
            stackString = getDeviceSuperInfo() + stackString;
            if (isUTMode) {
                String[] mails = {"nguyenthanhdong0109@gmail.com"};
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, mails);
                intent.putExtra(Intent.EXTRA_SUBJECT,
                        "[VOC for Coin Market Monitor] FC_Log");
                intent.putExtra(Intent.EXTRA_TEXT, stackString);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                int pid = android.os.Process.myPid();
                try {
                    android.os.Process.killProcess(pid);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                uncaughtHandler.uncaughtException(thread, ex);
            }
        }
    }

}
