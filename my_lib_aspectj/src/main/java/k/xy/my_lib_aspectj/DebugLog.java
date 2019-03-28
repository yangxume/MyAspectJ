package k.xy.my_lib_aspectj;

import android.util.Log;

public class DebugLog {

    private static final String TAG = DebugLog.class.getSimpleName();

    private DebugLog() {
    }

    /**
     * Send a debug log message
     *
     * @param tag     Source of a log message.
     * @param message The message you would like logged.
     */
    public static void log(String tag, String message) {
        Log.d(tag, message);
    }

}
