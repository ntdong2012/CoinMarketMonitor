package dinostudio.coinmarketmonitor.base.utils;

import java.io.File;

import dinostudio.coinmarketmonitor.base.apps.CoinApps;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/7/17.
 */

public class Common {

    public interface INTENT_DATA {
        public static final String BUNDLE_DATA = "BUNDLE_DATA";
        public static final String COIN_ID = "COIN_ID";
        public static final String COIN_NAME = "COIN_NAME";
    }

    public interface CHAR_TIME_VALUE {
        public static final int DAY = 0;
        public static final int WEEK = 1;
        public static final int MONTH = 2;
        public static final int YEAR = 3;
        public static final int ALL = 4;
    }

    public static final String PATH_DATA = CoinApps.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";
    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

}
