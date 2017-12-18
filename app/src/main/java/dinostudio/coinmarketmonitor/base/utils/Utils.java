package dinostudio.coinmarketmonitor.base.utils;

import android.text.TextUtils;

import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import dinostudio.coinmarketmonitor.model.CoinDisplayInfo;
import dinostudio.coinmarketmonitor.model.CoinInfo;
import dinostudio.coinmarketmonitor.model.CoinInfoAud;
import dinostudio.coinmarketmonitor.model.CoinInfoBrl;
import dinostudio.coinmarketmonitor.model.CoinInfoCad;
import dinostudio.coinmarketmonitor.model.CoinInfoCny;
import dinostudio.coinmarketmonitor.model.CoinInfoEur;
import dinostudio.coinmarketmonitor.model.CoinInfoGbp;
import dinostudio.coinmarketmonitor.model.CoinInfoHkd;
import dinostudio.coinmarketmonitor.model.CoinInfoInr;
import dinostudio.coinmarketmonitor.model.CoinInfoJpy;
import dinostudio.coinmarketmonitor.model.CoinInfoKrw;
import dinostudio.coinmarketmonitor.model.CoinInfoMxn;
import dinostudio.coinmarketmonitor.model.CoinInfoRub;

/**
 * Created by nguyenthanhdong0109@gmail.com on 12/8/17.
 */

public class Utils {

    public static String convertTimeToDisplay(long time) {
        Date date = new Date(time * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd HH:mm");
        return sdf.format(date);
    }

    public static String convertTimeToDisplayForChar(long time) {
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
        return sdf.format(date);
    }

    public static String convertTimeToDisplayForDetail(long time) {
        Date date = new Date(time * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
        return sdf.format(date);
    }


    public static boolean isNumber(String ch) {
        if (!TextUtils.isEmpty(ch)) {
            try {
                Integer i = Integer.parseInt(ch);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static float getMoneyFromEdt(String money) {
        String lasChar = money.substring(money.length() - 1, money.length());
        if (!Utils.isNumber(lasChar)) {
            money = money.substring(0, money.length() - 1);
        }
        String firstChar = money.substring(0, 1);
        if (!Utils.isNumber(firstChar)) {
            money.substring(0, 1);
        }
        money = money.replaceAll("\\.", "");
        try {
            float moneyL = Float.parseFloat(money);
            return moneyL;
        } catch (Exception e) {
            e.printStackTrace();
            return -1F;
        }

    }

    public static String getPriceSymbol(String[] strArr, int position) {
        switch (position) {
            case 0:
                return "USD";
            case 1:
                return "AUD";
            case 2:
                return "CAD";
            case 3:
                return "EUR";
            case 4:
                return "GBP";
            case 5:
                return "HKD";
            case 6:
                return "JPY";
            case 7:
                return "MXN";
            case 8:
                return "BRL";
            case 9:
                return "CNY";
            case 10:
                return "INR";
            case 11:
                return "KRW";
            case 12:
                return "RUB";
            case 13:
                return "USD";

        }
        return "USD";
    }


    public static ArrayList<CoinDisplayInfo> convertCoinMxn(ArrayList<CoinInfoMxn> list) {
        ArrayList<CoinDisplayInfo> result = new ArrayList<>();
        for (CoinInfoMxn info : list) {
            CoinDisplayInfo displayInfo = new CoinDisplayInfo();
            displayInfo.setId(info.getId());
            displayInfo.setLastUpdate(info.getLastUpdate());
            displayInfo.setFavorites(info.isFavorite());
            displayInfo.setName(info.getName());
            displayInfo.setOndDayVl(info.getPercentChangeOneDay());
            displayInfo.setSymbol(info.getSymbol());
            displayInfo.setOneHourVl(info.getPercentChangeOneHour());
            displayInfo.setPrice(info.getPriceMxn());
            displayInfo.setPriceType("MXN");
            displayInfo.setHasAlarm(info.isHasAlarm());
            result.add(displayInfo);
        }
        return result;
    }

    public static ArrayList<CoinDisplayInfo> convertCoinInr(ArrayList<CoinInfoInr> list) {
        ArrayList<CoinDisplayInfo> result = new ArrayList<>();
        for (CoinInfoInr info : list) {
            CoinDisplayInfo displayInfo = new CoinDisplayInfo();
            displayInfo.setId(info.getId());
            displayInfo.setLastUpdate(info.getLastUpdate());
            displayInfo.setFavorites(info.isFavorite());
            displayInfo.setName(info.getName());
            displayInfo.setOndDayVl(info.getPercentChangeOneDay());
            displayInfo.setSymbol(info.getSymbol());
            displayInfo.setOneHourVl(info.getPercentChangeOneHour());
            displayInfo.setPrice(info.getPriceInr());
            displayInfo.setPriceType("INR");
            displayInfo.setHasAlarm(info.isHasAlarm());
            result.add(displayInfo);
        }
        return result;
    }


    public static ArrayList<CoinDisplayInfo> convertCoinJpy(ArrayList<CoinInfoJpy> list) {
        ArrayList<CoinDisplayInfo> result = new ArrayList<>();
        for (CoinInfoJpy info : list) {
            CoinDisplayInfo displayInfo = new CoinDisplayInfo();
            displayInfo.setId(info.getId());
            displayInfo.setLastUpdate(info.getLastUpdate());
            displayInfo.setFavorites(info.isFavorite());
            displayInfo.setName(info.getName());
            displayInfo.setOndDayVl(info.getPercentChangeOneDay());
            displayInfo.setSymbol(info.getSymbol());
            displayInfo.setOneHourVl(info.getPercentChangeOneHour());
            displayInfo.setPrice(info.getPriceJpy());
            displayInfo.setPriceType("JPY");
            displayInfo.setHasAlarm(info.isHasAlarm());
            result.add(displayInfo);
        }
        return result;
    }


    public static ArrayList<CoinDisplayInfo> convertCoinKrw(ArrayList<CoinInfoKrw> list) {
        ArrayList<CoinDisplayInfo> result = new ArrayList<>();
        for (CoinInfoKrw info : list) {
            CoinDisplayInfo displayInfo = new CoinDisplayInfo();
            displayInfo.setId(info.getId());
            displayInfo.setLastUpdate(info.getLastUpdate());
            displayInfo.setFavorites(info.isFavorite());
            displayInfo.setName(info.getName());
            displayInfo.setOndDayVl(info.getPercentChangeOneDay());
            displayInfo.setSymbol(info.getSymbol());
            displayInfo.setOneHourVl(info.getPercentChangeOneHour());
            displayInfo.setPrice(info.getPriceKrw());
            displayInfo.setPriceType("KRW");
            displayInfo.setHasAlarm(info.isHasAlarm());
            result.add(displayInfo);
        }
        return result;
    }


    public static ArrayList<CoinDisplayInfo> convertCoinRub(ArrayList<CoinInfoRub> list) {
        ArrayList<CoinDisplayInfo> result = new ArrayList<>();
        for (CoinInfoRub info : list) {
            CoinDisplayInfo displayInfo = new CoinDisplayInfo();
            displayInfo.setId(info.getId());
            displayInfo.setLastUpdate(info.getLastUpdate());
            displayInfo.setFavorites(info.isFavorite());
            displayInfo.setName(info.getName());
            displayInfo.setOndDayVl(info.getPercentChangeOneDay());
            displayInfo.setSymbol(info.getSymbol());
            displayInfo.setOneHourVl(info.getPercentChangeOneHour());
            displayInfo.setPrice(info.getPriceRub());
            displayInfo.setPriceType("RUB");
            displayInfo.setHasAlarm(info.isHasAlarm());
            result.add(displayInfo);
        }
        return result;
    }


    public static ArrayList<CoinDisplayInfo> convertCoinBrl(ArrayList<CoinInfoBrl> list) {
        ArrayList<CoinDisplayInfo> result = new ArrayList<>();
        for (CoinInfoBrl info : list) {
            CoinDisplayInfo displayInfo = new CoinDisplayInfo();
            displayInfo.setId(info.getId());
            displayInfo.setLastUpdate(info.getLastUpdate());
            displayInfo.setFavorites(info.isFavorite());
            displayInfo.setName(info.getName());
            displayInfo.setOndDayVl(info.getPercentChangeOneDay());
            displayInfo.setSymbol(info.getSymbol());
            displayInfo.setOneHourVl(info.getPercentChangeOneHour());
            displayInfo.setPrice(info.getPriceBrl());
            displayInfo.setPriceType("BRL");
            displayInfo.setHasAlarm(info.isHasAlarm());
            result.add(displayInfo);
        }
        return result;
    }

    public static ArrayList<CoinDisplayInfo> convertCoinGbp(ArrayList<CoinInfoGbp> list) {
        ArrayList<CoinDisplayInfo> result = new ArrayList<>();
        for (CoinInfoGbp info : list) {
            CoinDisplayInfo displayInfo = new CoinDisplayInfo();
            displayInfo.setId(info.getId());
            displayInfo.setLastUpdate(info.getLastUpdate());
            displayInfo.setFavorites(info.isFavorite());
            displayInfo.setName(info.getName());
            displayInfo.setOndDayVl(info.getPercentChangeOneDay());
            displayInfo.setSymbol(info.getSymbol());
            displayInfo.setOneHourVl(info.getPercentChangeOneHour());
            displayInfo.setPrice(info.getPriceGbp());
            displayInfo.setPriceType("GBP");
            displayInfo.setHasAlarm(info.isHasAlarm());
            result.add(displayInfo);
        }
        return result;
    }


    public static ArrayList<CoinDisplayInfo> convertCoinEur(ArrayList<CoinInfoEur> list) {
        ArrayList<CoinDisplayInfo> result = new ArrayList<>();
        for (CoinInfoEur info : list) {
            CoinDisplayInfo displayInfo = new CoinDisplayInfo();
            displayInfo.setId(info.getId());
            displayInfo.setLastUpdate(info.getLastUpdate());
            displayInfo.setFavorites(info.isFavorite());
            displayInfo.setName(info.getName());
            displayInfo.setOndDayVl(info.getPercentChangeOneDay());
            displayInfo.setSymbol(info.getSymbol());
            displayInfo.setOneHourVl(info.getPercentChangeOneHour());
            displayInfo.setPrice(info.getPriceEur());
            displayInfo.setPriceType("EUR");
            displayInfo.setHasAlarm(info.isHasAlarm());
            result.add(displayInfo);
        }
        return result;
    }


    public static ArrayList<CoinDisplayInfo> convertCoinCny(ArrayList<CoinInfoCny> list) {
        ArrayList<CoinDisplayInfo> result = new ArrayList<>();
        for (CoinInfoCny info : list) {
            CoinDisplayInfo displayInfo = new CoinDisplayInfo();
            displayInfo.setId(info.getId());
            displayInfo.setLastUpdate(info.getLastUpdate());
            displayInfo.setFavorites(info.isFavorite());
            displayInfo.setName(info.getName());
            displayInfo.setOndDayVl(info.getPercentChangeOneDay());
            displayInfo.setSymbol(info.getSymbol());
            displayInfo.setOneHourVl(info.getPercentChangeOneHour());
            displayInfo.setPrice(info.getPriceCny());
            displayInfo.setPriceType("CNY");
            displayInfo.setHasAlarm(info.isHasAlarm());
            result.add(displayInfo);
        }
        return result;
    }


    public static ArrayList<CoinDisplayInfo> convertCoinCad(ArrayList<CoinInfoCad> list) {
        ArrayList<CoinDisplayInfo> result = new ArrayList<>();
        for (CoinInfoCad info : list) {
            CoinDisplayInfo displayInfo = new CoinDisplayInfo();
            displayInfo.setId(info.getId());
            displayInfo.setLastUpdate(info.getLastUpdate());
            displayInfo.setFavorites(info.isFavorite());
            displayInfo.setName(info.getName());
            displayInfo.setOndDayVl(info.getPercentChangeOneDay());
            displayInfo.setSymbol(info.getSymbol());
            displayInfo.setOneHourVl(info.getPercentChangeOneHour());
            displayInfo.setPrice(info.getPriceCad());
            displayInfo.setPriceType("CAD");
            displayInfo.setHasAlarm(info.isHasAlarm());
            result.add(displayInfo);
        }
        return result;
    }


    public static ArrayList<CoinDisplayInfo> convertCoinAud(ArrayList<CoinInfoAud> list) {
        ArrayList<CoinDisplayInfo> result = new ArrayList<>();
        for (CoinInfoAud info : list) {
            CoinDisplayInfo displayInfo = new CoinDisplayInfo();
            displayInfo.setId(info.getId());
            displayInfo.setLastUpdate(info.getLastUpdate());
            displayInfo.setFavorites(info.isFavorite());
            displayInfo.setName(info.getName());
            displayInfo.setOndDayVl(info.getPercentChangeOneDay());
            displayInfo.setSymbol(info.getSymbol());
            displayInfo.setOneHourVl(info.getPercentChangeOneHour());
            displayInfo.setPrice(info.getPriceAud());
            displayInfo.setPriceType("AUD");
            displayInfo.setHasAlarm(info.isHasAlarm());
            result.add(displayInfo);
        }
        return result;
    }

    public static ArrayList<CoinDisplayInfo> convertCoinHkd(ArrayList<CoinInfoHkd> list) {
        ArrayList<CoinDisplayInfo> result = new ArrayList<>();
        for (CoinInfoHkd info : list) {
            CoinDisplayInfo displayInfo = new CoinDisplayInfo();
            displayInfo.setId(info.getId());
            displayInfo.setLastUpdate(info.getLastUpdate());
            displayInfo.setFavorites(info.isFavorite());
            displayInfo.setName(info.getName());
            displayInfo.setOndDayVl(info.getPercentChangeOneDay());
            displayInfo.setSymbol(info.getSymbol());
            displayInfo.setOneHourVl(info.getPercentChangeOneHour());
            displayInfo.setPrice(info.getPriceHkd());
            displayInfo.setPriceType("HKD");
            displayInfo.setHasAlarm(info.isHasAlarm());
            result.add(displayInfo);
        }
        return result;
    }

    public static CoinDisplayInfo convertCoinInfo(CoinInfo info) {
        CoinDisplayInfo displayInfo = new CoinDisplayInfo();
        displayInfo.setId(info.getId());
        displayInfo.setLastUpdate(info.getLastUpdate());
        displayInfo.setFavorites(info.isFavorite());
        displayInfo.setName(info.getName());
        displayInfo.setOndDayVl(info.getPercentChangeOneDay());
        displayInfo.setSymbol(info.getSymbol());
        displayInfo.setOneHourVl(info.getPercentChangeOneHour());
        displayInfo.setPrice(info.getPriceUsd());
        displayInfo.setPriceType("USD");
        displayInfo.setHasAlarm(info.isHasAlarm());
        return displayInfo;
    }

    public static ArrayList<CoinDisplayInfo> convertCoin(ArrayList<CoinInfo> list) {
        ArrayList<CoinDisplayInfo> result = new ArrayList<>();
        for (CoinInfo info : list) {
            CoinDisplayInfo displayInfo = new CoinDisplayInfo();
            displayInfo.setId(info.getId());
            displayInfo.setLastUpdate(info.getLastUpdate());
            displayInfo.setFavorites(info.isFavorite());
            displayInfo.setName(info.getName());
            displayInfo.setOndDayVl(info.getPercentChangeOneDay());
            displayInfo.setSymbol(info.getSymbol());
            displayInfo.setOneHourVl(info.getPercentChangeOneHour());
            displayInfo.setPrice(info.getPriceUsd());
            displayInfo.setPriceType("USD");
            displayInfo.setHasAlarm(info.isHasAlarm());

            result.add(displayInfo);
        }
        return result;
    }

    public static long getCurrentTimeForChar() {
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        return instance.getTimeInMillis();
    }

    public static long getTimeForCharDay() {
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        instance.add(Calendar.DATE, -1);
        return instance.getTimeInMillis();
    }

    public static long getTimeForCharWeek() {
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        instance.add(Calendar.DATE, -7);
        return instance.getTimeInMillis();
    }

    public static long getTimeForChar(int value) {
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        instance.add(Calendar.DATE, value);
        return instance.getTimeInMillis();
    }


    public static long getCurrentTime() {
        Date date = new Date();
        return date.getTime();
    }

    public static String convertFloatToMoney(float balance, String type) {
        Locale locale = new Locale("us", "");
        Currency currency = Currency.getInstance(type);
        DecimalFormatSymbols df = DecimalFormatSymbols.getInstance(locale);
        df.setCurrency(currency);
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        numberFormat.setCurrency(currency);
        return numberFormat.format(balance);
    }

    public static boolean isPositiveNumber(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                float i = Float.parseFloat(str);
                return i >= 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
