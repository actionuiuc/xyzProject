/*
 * Brian Jackson
 * bj1412@att.com
 * 11/13/2017
 * Android Developer Nanodegree
 * Project 5: Make Your App Material
 *
 * Filename: Config.java
 * -Replaced url "https://go.udacity.com/xyz-reader-json" with "https://raw.githubusercontent.com/TNTest/xyzreader/master/data.json"
 *   based on forum suggestion after receiving "Error reading item detail cursor" message.  Article details would not load
 *   most of the time with the old url.
 *
 *
 */

package com.example.xyzreader.remote;

import android.util.Log;

import java.net.MalformedURLException;
import java.net.URL;

public class Config {
    public static final URL BASE_URL;
    private static String TAG = Config.class.toString();

    static {
        URL url = null;
        try {
            //url = new URL("https://go.udacity.com/xyz-reader-json" );
            url = new URL("https://raw.githubusercontent.com/TNTest/xyzreader/master/data.json" );
        } catch (MalformedURLException ignored) {
            // TODO: throw a real error
            Log.e(TAG, "Please check your internet connection.");
        }

        BASE_URL = url;
    }
}
