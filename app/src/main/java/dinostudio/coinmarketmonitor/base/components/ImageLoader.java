package dinostudio.coinmarketmonitor.base.components;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by nguyenthanhdong0109@gmail.com on 5/20/17.
 */

public class ImageLoader {

    public static void load(Context context, String url, ImageView iv) {
//        if (!BtsApplication.getAppComponent().preferencesHelper().getNoImageState()) {
//            Glide.with(context).load(url).crossFade().diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).into(iv);
//        }
    }

    public static void load(Activity activity, String url, ImageView iv) {
        if (!activity.isDestroyed()) {
//            Glide.with(activity).load(url)..diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).into(iv);
        }
    }

    public static void loadAll(Context context, String url, ImageView iv) {
//        Glide.with(context).load(url).crossFade().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(iv);
    }

    public static void loadAll(Activity activity, String url, ImageView iv) {
        if (!activity.isDestroyed()) {
//            Glide.with(activity).load(url).crossFade().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(iv);
        }
    }
}
