package com.drondon.androiddebugme.logger;

import android.util.Log;

/**
 * Created by andriimiroshnychenko on 3/17/18.
 * <p>
 * For more customisable logger you can use <a href="https://github.com/JakeWharton/timber">Timber</a>
 * by <a href="https://github.com/JakeWharton">Jake Wharton</a>
 */

public class Logger {

    /**
     * Simple example how to use {@link System#getProperty(String)} for setup logs
     *
     * adb shell setprop log.tag.MainActivity_ INFO
     * adb shell getprop | grep -E '\[log'
     *
     * @see <a href="https://stackoverflow.com/a/2019563/3124400">Example</a>
     */
    public static void d(String tag, String message) {
        if (Log.isLoggable(tag, Log.DEBUG)) {
            Log.d(tag, message);
        }
    }

}
