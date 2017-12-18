package dinostudio.coinmarketmonitor.base.utils;

import android.text.TextUtils;
import com.elvishew.xlog.LogConfiguration;
import com.elvishew.xlog.XLog;
import com.elvishew.xlog.interceptor.BlacklistTagsFilterInterceptor;
import com.elvishew.xlog.printer.AndroidPrinter;
import com.elvishew.xlog.printer.ConsolePrinter;
import com.elvishew.xlog.printer.Printer;
import com.elvishew.xlog.printer.file.FilePrinter;
import com.elvishew.xlog.printer.file.backup.NeverBackupStrategy;
import com.elvishew.xlog.printer.file.naming.DateFileNameGenerator;

import dinostudio.coinmarketmonitor.BuildConfig;
import io.realm.log.LogLevel;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/7/17.
 */

public class DLogUtils {

    public static boolean isDebug = BuildConfig.DEBUG;
    private static final String TAG = "emdeplam";


    public static void e(String tag, Object o) {
        if (isDebug) {
            initXLOG();
            XLog.e(tag, o);
        }
    }

    public static void e(Object o) {
        DLogUtils.e(TAG, o);
    }

    public static void w(String tag, Object o) {
        if (isDebug) {
            initXLOG();
            XLog.w(tag, o);
        }
    }

    public static void w(Object o) {
        DLogUtils.w(TAG, o);
    }

    public static void d(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            if (isDebug) {
                initXLOGOnlyDispay();
                XLog.d(msg);
            }
        }
    }

    public static void dIn(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            if (isDebug) {
                initXLOG();
                XLog.d(msg);
            }
        }
    }

    public static void dJson(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            if (isDebug) {
                initXLOG();
                XLog.json(msg);
            }
        }
    }

    public static void i(String msg) {
        if (isDebug) {
            initXLOG();
            XLog.i(msg);
        }
    }

    private static void initXLOGOnlyDispay() {
        LogConfiguration config = new LogConfiguration.Builder()
                .logLevel(BuildConfig.DEBUG ? LogLevel.ALL             // Specify log level, logs below this level won't be printed, default: LogLevel.ALL
                        : LogLevel.ALL)
                .tag(TAG)                                         // Specify TAG, default: "X-LOG"
                .t()                                                   // Enable thread info, disabled by default
                .st(3)                                                 // Enable stack trace info with depth 2, disabled by default
                .b()                                                   // Enable border, disabled by default
                .addInterceptor(new BlacklistTagsFilterInterceptor(    // Add blacklist tags filter
                        "blacklist1", "blacklist2", "blacklist3"))
                .build();
        Printer androidPrinter = new AndroidPrinter();
        XLog.init(config, androidPrinter);

    }

    private static void initXLOG() {
        LogConfiguration config = new LogConfiguration.Builder()
                .logLevel(BuildConfig.DEBUG ? LogLevel.ALL             // Specify log level, logs below this level won't be printed, default: LogLevel.ALL
                        : LogLevel.ALL)
                .tag(TAG)                                         // Specify TAG, default: "X-LOG"
                .t()                                                   // Enable thread info, disabled by default
                .st(3)                                                 // Enable stack trace info with depth 2, disabled by default
                .b()                                                   // Enable border, disabled by default
//                .jsonFormatter(new MyJsonFormatter())                  // Default: DefaultJsonFormatter
//                .xmlFormatter(new MyXmlFormatter())                    // Default: DefaultXmlFormatter
//                .throwableFormatter(new MyThrowableFormatter())        // Default: DefaultThrowableFormatter
//                .threadFormatter(new MyThreadFormatter())              // Default: DefaultThreadFormatter
//                .stackTraceFormatter(new MyStackTraceFormatter())      // Default: DefaultStackTraceFormatter
//                .borderFormatter(new MyBoardFormatter())               // Default: DefaultBorderFormatter
//                .addObjectFormatter(AnyClass.class,                    // Add formatter for specific class of object
//                        new AnyClassObjectFormatter())                     // Use Object.toString() by default
                .addInterceptor(new BlacklistTagsFilterInterceptor(    // Add blacklist tags filter
                        "blacklist1", "blacklist2", "blacklist3"))
//                .addInterceptor(new MyInterceptor())                   // Add a log interceptor
                .build();

        Printer androidPrinter = new AndroidPrinter();             // Printer that print the log using android.util.Log
        Printer consolePrinter = new ConsolePrinter();             // Printer that print the log to console using System.out
        Printer filePrinter = new FilePrinter                      // Printer that print the log to the file system
                .Builder("/sdcard/PosTabletLog/")                              // Specify the path to save log file
                .fileNameGenerator(new DateFileNameGenerator())        // Default: ChangelessFileNameGenerator("log")
                .backupStrategy(new NeverBackupStrategy())             // Default: FileSizeBackupStrategy(1024 * 1024)
//                .logFlattener(new MyFlattener())                       // Default: DefaultFlattener
                .build();

        XLog.init(                                                 // Initialize XLog
                config,                                                // Specify the log configuration, if not specified, will use new LogConfiguration.Builder().build()
                androidPrinter,                                        // Specify printers, if no printer is specified, AndroidPrinter(for Android)/ConsolePrinter(for java) will be used.
//                consolePrinter,
                filePrinter);
    }
}
