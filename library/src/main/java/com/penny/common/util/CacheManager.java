package com.penny.common.util;

import android.app.Activity;
import android.content.Context;

import com.penny.common.service.HttpCache;
import com.penny.common.service.impl.ImageCache;
import com.penny.common.service.impl.ImageSDCardCache;

/**
 * CacheManager
 * 
 */
public class CacheManager {

    private static HttpCache httpCache = null;

    private CacheManager() {
        throw new AssertionError();
    }

    /**
     * get the singleton instance of HttpCache
     * 
     * @param context {@link Activity#getApplicationContext()}
     * @return
     */
    public static HttpCache getHttpCache(Context context) {
        if (httpCache == null) {
            synchronized (CacheManager.class) {
                if (httpCache == null) {
                    httpCache = new HttpCache(context);
                }
            }
        }
        return httpCache;
    }

    /**
     * get the singleton instance of ImageCache
     * 
     * @return
     * @see ImageCacheManager#getImageCache()
     */
    public static ImageCache getImageCache() {
        return ImageCacheManager.getImageCache();
    }

    /**
     * get the singleton instance of ImageSDCardCache
     * 
     * @return
     * @see ImageCacheManager#getImageSDCardCache()
     */
    public static ImageSDCardCache getImageSDCardCache() {
        return ImageCacheManager.getImageSDCardCache();
    }
}
