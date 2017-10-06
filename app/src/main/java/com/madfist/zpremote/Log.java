package com.madfist.zpremote;

/**
 * Created by akoleszar on 2017.10.06..
 */

public class Log {
    private static int logLevel = android.util.Log.WARN;

    public static void setLogLevel(int level) {
        logLevel = level;
    }

    public static void d(String tag, String msg) {
        if (android.util.Log.DEBUG >= logLevel) {
            android.util.Log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (android.util.Log.INFO >= logLevel) {
            android.util.Log.i(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (android.util.Log.WARN >= logLevel) {
            android.util.Log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (android.util.Log.ERROR >= logLevel) {
            android.util.Log.e(tag, msg);
        }
    }
}
