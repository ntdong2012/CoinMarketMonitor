package dinostudio.coinmarketmonitor.base.model.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.inject.Inject;

import dinostudio.coinmarketmonitor.model.AlarmInfo;
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
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by ntdong2012 on 16/8/16.
 */

public class RealmHelper implements DBHelper {

    private static final String DB_NAME = "myRealm.realm";

    private Realm mRealm;

    @Override
    public ArrayList<AlarmInfo> getAllAlarms() {
        ArrayList<AlarmInfo> results = new ArrayList<>();
        RealmResults<AlarmInfo> infos = mRealm.where(AlarmInfo.class).equalTo("isEnable", 1).findAll();
        if (infos != null && infos.size() > 0) {
            for (AlarmInfo info : infos) {
                results.add(info);
            }
        }
        return results;
    }

    private void updateCoinAlarm(String coinId, boolean hasAlarm) {
        CoinInfo info = getCoinInfoById(coinId);
        if (info != null) {
            mRealm.beginTransaction();
            info.setHasAlarm(hasAlarm);
            mRealm.copyToRealmOrUpdate(info);
            mRealm.commitTransaction();
        }
        CoinInfoAud info2 = getCoinInfoAudById(coinId);
        if (info2 != null) {
            mRealm.beginTransaction();
            info2.setHasAlarm(hasAlarm);
            mRealm.copyToRealmOrUpdate(info2);
            mRealm.commitTransaction();
        }

        CoinInfoBrl info3 = getCoinInfoBrlById(coinId);
        if (info3 != null) {
            mRealm.beginTransaction();
            info3.setHasAlarm(hasAlarm);
            mRealm.copyToRealmOrUpdate(info3);
            mRealm.commitTransaction();
        }

        CoinInfoCad info4 = getCoinInfoCadById(coinId);
        if (info4 != null) {
            mRealm.beginTransaction();
            info4.setHasAlarm(hasAlarm);
            mRealm.copyToRealmOrUpdate(info4);
            mRealm.commitTransaction();
        }

        CoinInfoCny infoCny = getCoinInfoCnyById(coinId);
        if (infoCny != null) {
            mRealm.beginTransaction();
            infoCny.setHasAlarm(hasAlarm);
            mRealm.copyToRealmOrUpdate(infoCny);
            mRealm.commitTransaction();
        }

        CoinInfoEur infoEur = getCoinInfoEurById(coinId);
        if (infoEur != null) {
            mRealm.beginTransaction();
            infoEur.setHasAlarm(hasAlarm);
            mRealm.copyToRealmOrUpdate(infoEur);
            mRealm.commitTransaction();
        }
        CoinInfoGbp infoGbp = getCoinInfoGpbById(coinId);
        if (infoGbp != null) {
            mRealm.beginTransaction();
            infoGbp.setHasAlarm(hasAlarm);
            mRealm.copyToRealmOrUpdate(infoGbp);
            mRealm.commitTransaction();
        }

        CoinInfoHkd infoHkd = getCoinInfoHkdById(coinId);
        if (infoHkd != null) {
            mRealm.beginTransaction();
            infoHkd.setHasAlarm(hasAlarm);
            mRealm.copyToRealmOrUpdate(infoHkd);
            mRealm.commitTransaction();
        }

        CoinInfoInr infoInr = getCoinInfoInrById(coinId);
        if (infoInr != null) {
            mRealm.beginTransaction();
            infoInr.setHasAlarm(hasAlarm);
            mRealm.copyToRealmOrUpdate(infoInr);
            mRealm.commitTransaction();
        }

        CoinInfoJpy infoJpy = getCoinInfoJpyById(coinId);
        if (infoJpy != null) {
            mRealm.beginTransaction();
            infoJpy.setHasAlarm(hasAlarm);
            mRealm.copyToRealmOrUpdate(infoJpy);
            mRealm.commitTransaction();
        }

        CoinInfoKrw infoKrw = getCoinInfoKwrById(coinId);
        if (infoKrw != null) {
            mRealm.beginTransaction();
            infoKrw.setHasAlarm(hasAlarm);
            mRealm.copyToRealmOrUpdate(infoKrw);
            mRealm.commitTransaction();
        }

        CoinInfoMxn infoMxn = getCoinInfoMxnById(coinId);
        if (infoMxn != null) {
            mRealm.beginTransaction();
            infoMxn.setHasAlarm(hasAlarm);
            mRealm.copyToRealmOrUpdate(infoMxn);
            mRealm.commitTransaction();
        }

        CoinInfoRub infoRub = getCoinInfoRubById(coinId);
        if (infoRub != null) {
            mRealm.beginTransaction();
            infoRub.setHasAlarm(hasAlarm);
            mRealm.copyToRealmOrUpdate(infoRub);
            mRealm.commitTransaction();
        }
    }

    @Override
    public void onUpdateAlarmInfo(String coinId, boolean above, boolean bellow, float aboveVl, float belowValue) {
        AlarmInfo info = getAlarmInfo(coinId);
        if (info != null) {
            mRealm.beginTransaction();
            info.setAbove(above);
            info.setBelow(bellow);
            info.setPriceAbove(aboveVl);
            info.setPriceBelow(belowValue);
            if (above || bellow) {
                info.setIsEnable(1);
            } else {
                info.setIsEnable(0);
            }
            mRealm.copyToRealmOrUpdate(info);
            mRealm.commitTransaction();
        } else {
            mRealm.beginTransaction();
            AlarmInfo i = new AlarmInfo();
            i.setPriceBelow(belowValue);
            i.setPriceAbove(aboveVl);
            i.setAbove(above);
            i.setBelow(bellow);
            i.setCoinId(coinId);
            if (above || bellow) {
                i.setIsEnable(1);
            } else {
                i.setIsEnable(0);
            }
            mRealm.copyToRealmOrUpdate(i);
            mRealm.commitTransaction();
        }
        if (above || bellow) {
            updateCoinAlarm(coinId, true);
        } else {
            updateCoinAlarm(coinId, false);
        }
    }

    @Override
    public AlarmInfo getAlarmInfo(String id) {
        return mRealm.where(AlarmInfo.class).equalTo("coinId", id).equalTo("isEnable", 1).findFirst();
    }

    @Override
    public CoinInfoInr getCoinInfoInrById(String coinId) {
        return mRealm.where(CoinInfoInr.class).equalTo("id", coinId).findFirst();
    }

    @Override
    public CoinInfo getCoinInfoById(String id) {
        return mRealm.where(CoinInfo.class).equalTo("id", id).findFirst();
    }

    @Override
    public CoinInfoAud getCoinInfoAudById(String id) {
        return mRealm.where(CoinInfoAud.class).equalTo("id", id).findFirst();
    }

    @Override
    public CoinInfoCad getCoinInfoCadById(String id) {
        return mRealm.where(CoinInfoCad.class).equalTo("id", id).findFirst();
    }

    @Override
    public CoinInfoEur getCoinInfoEurById(String id) {
        return mRealm.where(CoinInfoEur.class).equalTo("id", id).findFirst();
    }

    @Override
    public CoinInfoGbp getCoinInfoGpbById(String id) {
        return mRealm.where(CoinInfoGbp.class).equalTo("id", id).findFirst();
    }

    @Override
    public CoinInfoHkd getCoinInfoHkdById(String id) {
        return mRealm.where(CoinInfoHkd.class).equalTo("id", id).findFirst();
    }

    @Override
    public CoinInfoJpy getCoinInfoJpyById(String id) {
        return mRealm.where(CoinInfoJpy.class).equalTo("id", id).findFirst();
    }

    @Override
    public CoinInfoMxn getCoinInfoMxnById(String id) {
        return mRealm.where(CoinInfoMxn.class).equalTo("id", id).findFirst();
    }

    @Override
    public CoinInfoBrl getCoinInfoBrlById(String id) {
        return mRealm.where(CoinInfoBrl.class).equalTo("id", id).findFirst();
    }

    @Override
    public CoinInfoCny getCoinInfoCnyById(String id) {
        return mRealm.where(CoinInfoCny.class).equalTo("id", id).findFirst();
    }

    @Override
    public CoinInfoKrw getCoinInfoKwrById(String id) {
        return mRealm.where(CoinInfoKrw.class).equalTo("id", id).findFirst();
    }

    @Override
    public CoinInfoRub getCoinInfoRubById(String id) {
        return mRealm.where(CoinInfoRub.class).equalTo("id", id).findFirst();
    }

    @Override
    public void updateFavoriteCoinInfo(CoinDisplayInfo coinDisplayInfo, boolean isFavorite) {
        CoinInfo info = mRealm.where(CoinInfo.class).equalTo("id", coinDisplayInfo.getId()).findFirst();
        if (info != null) {
            mRealm.beginTransaction();
            info.setFavorite(isFavorite);
            mRealm.copyToRealmOrUpdate(info);
            mRealm.commitTransaction();
        }

    }

    @Override
    public void updateFavoriteCoinInfoAud(CoinDisplayInfo coinDisplayInfo, boolean isFavorite) {
        CoinInfoAud info = mRealm.where(CoinInfoAud.class).equalTo("id", coinDisplayInfo.getId()).findFirst();
        if (info != null) {
            mRealm.beginTransaction();
            info.setFavorite(isFavorite);
            mRealm.copyToRealmOrUpdate(info);
            mRealm.commitTransaction();
        }
    }

    @Override
    public void updateFavoriteCoinInfoCad(CoinDisplayInfo coinDisplayInfo, boolean isFavorite) {
        CoinInfoCad info = mRealm.where(CoinInfoCad.class).equalTo("id", coinDisplayInfo.getId()).findFirst();
        if (info != null) {
            mRealm.beginTransaction();
            info.setFavorite(isFavorite);
            mRealm.copyToRealmOrUpdate(info);
            mRealm.commitTransaction();
        }
    }

    @Override
    public void updateFavoriteCoinInfoEur(CoinDisplayInfo coinDisplayInfo, boolean isFavorite) {
        CoinInfoEur info = mRealm.where(CoinInfoEur.class).equalTo("id", coinDisplayInfo.getId()).findFirst();
        if (info != null) {
            mRealm.beginTransaction();
            info.setFavorite(isFavorite);
            mRealm.copyToRealmOrUpdate(info);
            mRealm.commitTransaction();
        }
    }

    @Override
    public void updateFavoriteCoinInfoGpb(CoinDisplayInfo coinDisplayInfo, boolean isFavorite) {
        CoinInfoGbp info = mRealm.where(CoinInfoGbp.class).equalTo("id", coinDisplayInfo.getId()).findFirst();
        if (info != null) {
            mRealm.beginTransaction();
            info.setFavorite(isFavorite);
            mRealm.copyToRealmOrUpdate(info);
            mRealm.commitTransaction();
        }
    }

    @Override
    public void updateFavoriteCoinInfoHkd(CoinDisplayInfo coinDisplayInfo, boolean isFavorite) {
        CoinInfoHkd info = mRealm.where(CoinInfoHkd.class).equalTo("id", coinDisplayInfo.getId()).findFirst();
        if (info != null) {
            mRealm.beginTransaction();
            info.setFavorite(isFavorite);
            mRealm.copyToRealmOrUpdate(info);
            mRealm.commitTransaction();
        }
    }

    @Override
    public void updateFavoriteCoinInfoJpy(CoinDisplayInfo coinDisplayInfo, boolean isFavorite) {
        CoinInfoJpy info = mRealm.where(CoinInfoJpy.class).equalTo("id", coinDisplayInfo.getId()).findFirst();
        if (info != null) {
            mRealm.beginTransaction();
            info.setFavorite(isFavorite);
            mRealm.copyToRealmOrUpdate(info);
            mRealm.commitTransaction();
        }
    }

    @Override
    public void updateFavoriteCoinInfoMxn(CoinDisplayInfo coinDisplayInfo, boolean isFavorite) {
        CoinInfoMxn info = mRealm.where(CoinInfoMxn.class).equalTo("id", coinDisplayInfo.getId()).findFirst();
        if (info != null) {
            mRealm.beginTransaction();
            info.setFavorite(isFavorite);
            mRealm.copyToRealmOrUpdate(info);
            mRealm.commitTransaction();
        }
    }

    @Override
    public void updateFavoriteCoinInfoBrl(CoinDisplayInfo coinDisplayInfo, boolean isFavorite) {
        CoinInfoBrl info = mRealm.where(CoinInfoBrl.class).equalTo("id", coinDisplayInfo.getId()).findFirst();
        if (info != null) {
            mRealm.beginTransaction();
            info.setFavorite(isFavorite);
            mRealm.copyToRealmOrUpdate(info);
            mRealm.commitTransaction();
        }
    }

    @Override
    public void updateFavoriteCoinInfoCny(CoinDisplayInfo coinDisplayInfo, boolean isFavorite) {
        CoinInfoCny info = mRealm.where(CoinInfoCny.class).equalTo("id", coinDisplayInfo.getId()).findFirst();
        if (info != null) {
            mRealm.beginTransaction();
            info.setFavorite(isFavorite);
            mRealm.copyToRealmOrUpdate(info);
            mRealm.commitTransaction();
        }
    }

    @Override
    public void updateFavoriteCoinInfoInr(CoinDisplayInfo coinDisplayInfo, boolean isFavorite) {
        CoinInfoCny info = mRealm.where(CoinInfoCny.class).equalTo("id", coinDisplayInfo.getId()).findFirst();
        if (info != null) {
            mRealm.beginTransaction();
            info.setFavorite(isFavorite);
            mRealm.copyToRealmOrUpdate(info);
            mRealm.commitTransaction();
        }
    }

    @Override
    public void updateFavoriteCoinInfoKrw(CoinDisplayInfo coinDisplayInfo, boolean isFavorite) {
        CoinInfoKrw info = mRealm.where(CoinInfoKrw.class).equalTo("id", coinDisplayInfo.getId()).findFirst();
        if (info != null) {
            mRealm.beginTransaction();
            info.setFavorite(isFavorite);
            mRealm.copyToRealmOrUpdate(info);
            mRealm.commitTransaction();
        }
    }

    @Override
    public void updateFavoriteCoinInfoRub(CoinDisplayInfo coinDisplayInfo, boolean isFavorite) {
        CoinInfoRub info = mRealm.where(CoinInfoRub.class).equalTo("id", coinDisplayInfo.getId()).findFirst();
        if (info != null) {
            mRealm.beginTransaction();
            info.setFavorite(isFavorite);
            mRealm.copyToRealmOrUpdate(info);
            mRealm.commitTransaction();
        }
    }

    @Inject
    public RealmHelper() {
        mRealm = Realm.getInstance(new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .name(DB_NAME)
                .build());
    }

    @Override
    public ArrayList<CoinInfoAud> getCoinInfosAud(boolean isOnlyDisplay, boolean isDisplayFirst) {
        ArrayList<CoinInfoAud> coinInfos = new ArrayList<>();
        RealmResults<CoinInfoAud> results = null;
        if (!isOnlyDisplay && !isDisplayFirst) {
            results = mRealm.where(CoinInfoAud.class).findAll();
        } else if (isOnlyDisplay) {
            results = mRealm.where(CoinInfoAud.class).equalTo("isFavorite", true).findAll();
        } else if (isDisplayFirst) {
            results = mRealm.where(CoinInfoAud.class).equalTo("isFavorite", true).findAll();
            if (results != null && results.size() > 0) {
                for (CoinInfoAud info : results) {
                    CoinInfoAud useCoin = mRealm.copyFromRealm(info);
                    coinInfos.add(useCoin);
                }
            }
            results = mRealm.where(CoinInfoAud.class).equalTo("isFavorite", false).findAll();
            if (results != null && results.size() > 0) {
                for (CoinInfoAud info : results) {
                    CoinInfoAud useCoin = mRealm.copyFromRealm(info);
                    coinInfos.add(useCoin);
                }
            }
            return coinInfos;
        }
        if (results != null && results.size() > 0) {
            for (CoinInfoAud info : results) {
                CoinInfoAud useCoin = mRealm.copyFromRealm(info);
                coinInfos.add(useCoin);
            }
        }
        return coinInfos;
    }

    @Override
    public ArrayList<CoinInfoBrl> getCoinInfosBrl(boolean isOnlyDisplay, boolean isDisplayFirst) {
        ArrayList<CoinInfoBrl> coinInfos = new ArrayList<>();
        RealmResults<CoinInfoBrl> results = null;
        if (!isOnlyDisplay && !isDisplayFirst) {
            results = mRealm.where(CoinInfoBrl.class).findAll();
        } else if (isOnlyDisplay) {
            results = mRealm.where(CoinInfoBrl.class).equalTo("isFavorite", true).findAll();
        } else if (isDisplayFirst) {
            results = mRealm.where(CoinInfoBrl.class).equalTo("isFavorite", true).findAll();
            if (results != null && results.size() > 0) {
                for (CoinInfoBrl info : results) {
                    CoinInfoBrl useCoin = mRealm.copyFromRealm(info);
                    coinInfos.add(useCoin);
                }
            }
            results = mRealm.where(CoinInfoBrl.class).equalTo("isFavorite", false).findAll();
            if (results != null && results.size() > 0) {
                for (CoinInfoBrl info : results) {
                    CoinInfoBrl useCoin = mRealm.copyFromRealm(info);
                    coinInfos.add(useCoin);
                }
            }
            return coinInfos;
        }
        if (results != null && results.size() > 0) {
            for (CoinInfoBrl info : results) {
                CoinInfoBrl useCoin = mRealm.copyFromRealm(info);
                coinInfos.add(useCoin);
            }
        }
        return coinInfos;
    }

    @Override
    public ArrayList<CoinInfoCad> getCoinInfosCad(boolean isOnlyDisplay, boolean isDisplayFirst) {
        ArrayList<CoinInfoCad> coinInfos = new ArrayList<>();
        RealmResults<CoinInfoCad> results = null;
        if (!isOnlyDisplay && !isDisplayFirst) {
            results = mRealm.where(CoinInfoCad.class).findAll();
        } else if (isOnlyDisplay) {
            results = mRealm.where(CoinInfoCad.class).equalTo("isFavorite", true).findAll();
        } else if (isDisplayFirst) {
            results = mRealm.where(CoinInfoCad.class).equalTo("isFavorite", true).findAll();
            if (results != null && results.size() > 0) {
                for (CoinInfoCad info : results) {
                    CoinInfoCad useCoin = mRealm.copyFromRealm(info);
                    coinInfos.add(useCoin);
                }
            }
            results = mRealm.where(CoinInfoCad.class).equalTo("isFavorite", false).findAll();
            if (results != null && results.size() > 0) {
                for (CoinInfoCad info : results) {
                    CoinInfoCad useCoin = mRealm.copyFromRealm(info);
                    coinInfos.add(useCoin);
                }
            }
            return coinInfos;
        }
        if (results != null && results.size() > 0) {
            for (CoinInfoCad info : results) {
                CoinInfoCad useCoin = mRealm.copyFromRealm(info);
                coinInfos.add(useCoin);
            }
        }
        return coinInfos;
    }

    @Override
    public ArrayList<CoinInfoCny> getCoinInfosCny(boolean isOnly, boolean isFirst) {
        ArrayList<CoinInfoCny> coinInfos = new ArrayList<>();
        RealmResults<CoinInfoCny> results = null;
        if (!isOnly && !isFirst) {
            results = mRealm.where(CoinInfoCny.class).findAll();
        } else if (isOnly) {
            results = mRealm.where(CoinInfoCny.class).equalTo("isFavorite", true).findAll();
        } else if (isFirst) {
            results = mRealm.where(CoinInfoCny.class).equalTo("isFavorite", true).findAll();
            if (results != null && results.size() > 0) {
                for (CoinInfoCny info : results) {
                    CoinInfoCny useCoin = mRealm.copyFromRealm(info);
                    coinInfos.add(useCoin);
                }
            }
            results = mRealm.where(CoinInfoCny.class).equalTo("isFavorite", false).findAll();
            if (results != null && results.size() > 0) {
                for (CoinInfoCny info : results) {
                    CoinInfoCny useCoin = mRealm.copyFromRealm(info);
                    coinInfos.add(useCoin);
                }
            }
            return coinInfos;
        }
        if (results != null && results.size() > 0) {
            for (CoinInfoCny info : results) {
                CoinInfoCny useCoin = mRealm.copyFromRealm(info);
                coinInfos.add(useCoin);
            }
        }
        return coinInfos;
    }

    @Override
    public ArrayList<CoinInfoRub> getCoinInfosRub(boolean isOnly, boolean isFirst) {
        ArrayList<CoinInfoRub> coinInfos = new ArrayList<>();
        RealmResults<CoinInfoRub> results = null;
        if (!isOnly && !isFirst) {
            results = mRealm.where(CoinInfoRub.class).findAll();
        } else if (isOnly) {
            results = mRealm.where(CoinInfoRub.class).equalTo("isFavorite", true).findAll();
        } else if (isFirst) {
            results = mRealm.where(CoinInfoRub.class).equalTo("isFavorite", true).findAll();
            if (results != null && results.size() > 0) {
                for (CoinInfoRub info : results) {
                    CoinInfoRub useCoin = mRealm.copyFromRealm(info);
                    coinInfos.add(useCoin);
                }
            }
            results = mRealm.where(CoinInfoRub.class).equalTo("isFavorite", false).findAll();
            if (results != null && results.size() > 0) {
                for (CoinInfoRub info : results) {
                    CoinInfoRub useCoin = mRealm.copyFromRealm(info);
                    coinInfos.add(useCoin);
                }
            }
            return coinInfos;
        }
        if (results != null && results.size() > 0) {
            for (CoinInfoRub info : results) {
                CoinInfoRub useCoin = mRealm.copyFromRealm(info);
                coinInfos.add(useCoin);
            }
        }
        return coinInfos;
    }

    @Override
    public ArrayList<CoinInfoMxn> getCoinInfosMxn(boolean isOnly, boolean isFirst) {
        ArrayList<CoinInfoMxn> coinInfos = new ArrayList<>();
        RealmResults<CoinInfoMxn> results = null;
        if (!isOnly && !isFirst) {
            results = mRealm.where(CoinInfoMxn.class).findAll();
        } else if (isOnly) {
            results = mRealm.where(CoinInfoMxn.class).equalTo("isFavorite", true).findAll();
        } else if (isFirst) {
            results = mRealm.where(CoinInfoMxn.class).equalTo("isFavorite", true).findAll();
            if (results != null && results.size() > 0) {
                for (CoinInfoMxn info : results) {
                    CoinInfoMxn useCoin = mRealm.copyFromRealm(info);
                    coinInfos.add(useCoin);
                }
            }
            results = mRealm.where(CoinInfoMxn.class).equalTo("isFavorite", false).findAll();
            if (results != null && results.size() > 0) {
                for (CoinInfoMxn info : results) {
                    CoinInfoMxn useCoin = mRealm.copyFromRealm(info);
                    coinInfos.add(useCoin);
                }
            }
            return coinInfos;
        }
        if (results != null && results.size() > 0) {
            for (CoinInfoMxn info : results) {
                CoinInfoMxn useCoin = mRealm.copyFromRealm(info);
                coinInfos.add(useCoin);
            }
        }
        return coinInfos;
    }

    @Override
    public ArrayList<CoinInfoKrw> getCoinInfosKrw(boolean isOnly, boolean isFirst) {
        ArrayList<CoinInfoKrw> coinInfos = new ArrayList<>();
        RealmResults<CoinInfoKrw> results = null;
        if (!isOnly && !isFirst) {
            results = mRealm.where(CoinInfoKrw.class).findAll();
        } else if (isOnly) {
            results = mRealm.where(CoinInfoKrw.class).equalTo("isFavorite", true).findAll();
        } else if (isFirst) {
            results = mRealm.where(CoinInfoKrw.class).equalTo("isFavorite", true).findAll();
            if (results != null && results.size() > 0) {
                for (CoinInfoKrw info : results) {
                    CoinInfoKrw useCoin = mRealm.copyFromRealm(info);
                    coinInfos.add(useCoin);
                }
            }
            results = mRealm.where(CoinInfoKrw.class).equalTo("isFavorite", false).findAll();
            if (results != null && results.size() > 0) {
                for (CoinInfoKrw info : results) {
                    CoinInfoKrw useCoin = mRealm.copyFromRealm(info);
                    coinInfos.add(useCoin);
                }
            }
            return coinInfos;
        }
        if (results != null && results.size() > 0) {
            for (CoinInfoKrw info : results) {
                CoinInfoKrw useCoin = mRealm.copyFromRealm(info);
                coinInfos.add(useCoin);
            }
        }
        return coinInfos;
    }

    @Override
    public ArrayList<CoinInfoJpy> getCoinInfosJpy(boolean isOnly, boolean isFirst) {
        ArrayList<CoinInfoJpy> coinInfos = new ArrayList<>();
        RealmResults<CoinInfoJpy> results = null;
        if (!isOnly && !isFirst) {
            results = mRealm.where(CoinInfoJpy.class).findAll();
        } else if (isOnly) {
            results = mRealm.where(CoinInfoJpy.class).equalTo("isFavorite", true).findAll();
        } else if (isFirst) {
            results = mRealm.where(CoinInfoJpy.class).equalTo("isFavorite", true).findAll();
            if (results != null && results.size() > 0) {
                for (CoinInfoJpy info : results) {
                    CoinInfoJpy useCoin = mRealm.copyFromRealm(info);
                    coinInfos.add(useCoin);
                }
            }
            results = mRealm.where(CoinInfoJpy.class).equalTo("isFavorite", false).findAll();
            if (results != null && results.size() > 0) {
                for (CoinInfoJpy info : results) {
                    CoinInfoJpy useCoin = mRealm.copyFromRealm(info);
                    coinInfos.add(useCoin);
                }
            }
            return coinInfos;
        }
        if (results != null && results.size() > 0) {
            for (CoinInfoJpy info : results) {
                CoinInfoJpy useCoin = mRealm.copyFromRealm(info);
                coinInfos.add(useCoin);
            }
        }
        return coinInfos;
    }

    @Override
    public ArrayList<CoinInfoInr> getCoinInfosInr(boolean isOnly, boolean isFirst) {
        ArrayList<CoinInfoInr> coinInfos = new ArrayList<>();
        RealmResults<CoinInfoInr> results = null;
        if (!isOnly && !isFirst) {
            results = mRealm.where(CoinInfoInr.class).findAll();
        } else if (isOnly) {
            results = mRealm.where(CoinInfoInr.class).equalTo("isFavorite", true).findAll();
        } else if (isFirst) {
            results = mRealm.where(CoinInfoInr.class).equalTo("isFavorite", true).findAll();
            if (results != null && results.size() > 0) {
                for (CoinInfoInr info : results) {
                    CoinInfoInr useCoin = mRealm.copyFromRealm(info);
                    coinInfos.add(useCoin);
                }
            }
            results = mRealm.where(CoinInfoInr.class).equalTo("isFavorite", false).findAll();
            if (results != null && results.size() > 0) {
                for (CoinInfoInr info : results) {
                    CoinInfoInr useCoin = mRealm.copyFromRealm(info);
                    coinInfos.add(useCoin);
                }
            }
            return coinInfos;
        }
        if (results != null && results.size() > 0) {
            for (CoinInfoInr info : results) {
                CoinInfoInr useCoin = mRealm.copyFromRealm(info);
                coinInfos.add(useCoin);
            }
        }
        return coinInfos;

    }

    @Override
    public ArrayList<CoinInfoHkd> getCoinInfosHkd(boolean isOnly, boolean isFirst) {
        ArrayList<CoinInfoHkd> coinInfos = new ArrayList<>();
        RealmResults<CoinInfoHkd> results = null;
        if (!isOnly && !isFirst) {
            results = mRealm.where(CoinInfoHkd.class).findAll();
        } else if (isOnly) {
            results = mRealm.where(CoinInfoHkd.class).equalTo("isFavorite", true).findAll();
        } else if (isFirst) {
            results = mRealm.where(CoinInfoHkd.class).equalTo("isFavorite", true).findAll();
            if (results != null && results.size() > 0) {
                for (CoinInfoHkd info : results) {
                    CoinInfoHkd useCoin = mRealm.copyFromRealm(info);
                    coinInfos.add(useCoin);
                }
            }
            results = mRealm.where(CoinInfoHkd.class).equalTo("isFavorite", false).findAll();
            if (results != null && results.size() > 0) {
                for (CoinInfoHkd info : results) {
                    CoinInfoHkd useCoin = mRealm.copyFromRealm(info);
                    coinInfos.add(useCoin);
                }
            }
            return coinInfos;
        }
        if (results != null && results.size() > 0) {
            for (CoinInfoHkd info : results) {
                CoinInfoHkd useCoin = mRealm.copyFromRealm(info);
                coinInfos.add(useCoin);
            }
        }
        return coinInfos;

    }

    @Override
    public ArrayList<CoinInfoGbp> getCoinInfosGbp(boolean isOnly, boolean isFirst) {
        ArrayList<CoinInfoGbp> coinInfos = new ArrayList<>();
        RealmResults<CoinInfoGbp> results = null;
        if (!isOnly && !isFirst) {
            results = mRealm.where(CoinInfoGbp.class).findAll();
        } else if (isOnly) {
            results = mRealm.where(CoinInfoGbp.class).equalTo("isFavorite", true).findAll();
        } else if (isFirst) {
            results = mRealm.where(CoinInfoGbp.class).equalTo("isFavorite", true).findAll();
            if (results != null && results.size() > 0) {
                for (CoinInfoGbp info : results) {
                    CoinInfoGbp useCoin = mRealm.copyFromRealm(info);
                    coinInfos.add(useCoin);
                }
            }
            results = mRealm.where(CoinInfoGbp.class).equalTo("isFavorite", false).findAll();
            if (results != null && results.size() > 0) {
                for (CoinInfoGbp info : results) {
                    CoinInfoGbp useCoin = mRealm.copyFromRealm(info);
                    coinInfos.add(useCoin);
                }
            }
            return coinInfos;
        }
        if (results != null && results.size() > 0) {
            for (CoinInfoGbp info : results) {
                CoinInfoGbp useCoin = mRealm.copyFromRealm(info);
                coinInfos.add(useCoin);
            }
        }
        return coinInfos;
    }

    @Override
    public ArrayList<CoinInfoEur> getCoinInfosEur(boolean isOnly, boolean isFirst) {
        ArrayList<CoinInfoEur> coinInfos = new ArrayList<>();
        RealmResults<CoinInfoEur> results = null;
        if (!isOnly && !isFirst) {
            results = mRealm.where(CoinInfoEur.class).findAll();
        } else if (isOnly) {
            results = mRealm.where(CoinInfoEur.class).equalTo("isFavorite", true).findAll();
        } else if (isFirst) {
            results = mRealm.where(CoinInfoEur.class).equalTo("isFavorite", true).findAll();
            if (results != null && results.size() > 0) {
                for (CoinInfoEur info : results) {
                    CoinInfoEur useCoin = mRealm.copyFromRealm(info);
                    coinInfos.add(useCoin);
                }
            }
            results = mRealm.where(CoinInfoEur.class).equalTo("isFavorite", false).findAll();
            if (results != null && results.size() > 0) {
                for (CoinInfoEur info : results) {
                    CoinInfoEur useCoin = mRealm.copyFromRealm(info);
                    coinInfos.add(useCoin);
                }
            }
            return coinInfos;
        }
        if (results != null && results.size() > 0) {
            for (CoinInfoEur info : results) {
                CoinInfoEur useCoin = mRealm.copyFromRealm(info);
                coinInfos.add(useCoin);
            }
        }
        return coinInfos;
    }

    @Override
    public void saveCoinInfoAud(ArrayList<CoinInfoAud> coinInfoAuds) {
        for (CoinInfoAud infor : coinInfoAuds) {
            CoinInfoAud iDb = mRealm.where(CoinInfoAud.class).equalTo("id", infor.getId()).findFirst();
            mRealm.beginTransaction();
            if (iDb != null) {
                infor.setFavorite(iDb.isFavorite());
                infor.setHasAlarm(iDb.isHasAlarm());

            }
            mRealm.copyToRealmOrUpdate(infor);
            mRealm.commitTransaction();
        }
    }

    @Override
    public void saveCoinInfoBrl(ArrayList<CoinInfoBrl> coinInfoBrls) {
        for (CoinInfoBrl infor : coinInfoBrls) {
            CoinInfoBrl iDb = mRealm.where(CoinInfoBrl.class).equalTo("id", infor.getId()).findFirst();
            mRealm.beginTransaction();
            if (iDb != null) {
                infor.setFavorite(iDb.isFavorite());
                infor.setHasAlarm(iDb.isHasAlarm());

            }
            mRealm.copyToRealmOrUpdate(infor);
            mRealm.commitTransaction();
        }
    }

    @Override
    public void saveCoinInfoCad(ArrayList<CoinInfoCad> coinInfoCads) {
        for (CoinInfoCad infor : coinInfoCads) {
            CoinInfoCad iDb = mRealm.where(CoinInfoCad.class).equalTo("id", infor.getId()).findFirst();
            mRealm.beginTransaction();
            if (iDb != null) {
                infor.setFavorite(iDb.isFavorite());
                infor.setHasAlarm(iDb.isHasAlarm());

            }
            mRealm.copyToRealmOrUpdate(infor);
            mRealm.commitTransaction();
        }
    }

    @Override
    public void saveCoinInfoCny(ArrayList<CoinInfoCny> coinInfoCnys) {
        for (CoinInfoCny infor : coinInfoCnys) {
            CoinInfoCny iDb = mRealm.where(CoinInfoCny.class).equalTo("id", infor.getId()).findFirst();
            mRealm.beginTransaction();
            if (iDb != null) {
                infor.setFavorite(iDb.isFavorite());
                infor.setHasAlarm(iDb.isHasAlarm());

            }
            mRealm.copyToRealmOrUpdate(infor);
            mRealm.commitTransaction();
        }
    }

    @Override
    public void saveCoinInfoEur(ArrayList<CoinInfoEur> coinInfoEurs) {
        for (CoinInfoEur infor : coinInfoEurs) {
            CoinInfoEur iDb = mRealm.where(CoinInfoEur.class).equalTo("id", infor.getId()).findFirst();
            mRealm.beginTransaction();
            if (iDb != null) {
                infor.setFavorite(iDb.isFavorite());
                infor.setHasAlarm(iDb.isHasAlarm());

            }
            mRealm.copyToRealmOrUpdate(infor);
            mRealm.commitTransaction();
        }
    }

    @Override
    public void saveCoinInfoGpb(ArrayList<CoinInfoGbp> coinInfoGbps) {
        for (CoinInfoGbp infor : coinInfoGbps) {
            CoinInfoGbp iDb = mRealm.where(CoinInfoGbp.class).equalTo("id", infor.getId()).findFirst();
            mRealm.beginTransaction();
            if (iDb != null) {
                infor.setFavorite(iDb.isFavorite());
                infor.setHasAlarm(iDb.isHasAlarm());

            }
            mRealm.copyToRealmOrUpdate(infor);
            mRealm.commitTransaction();
        }
    }

    @Override
    public void saveCoinInfoHkd(ArrayList<CoinInfoHkd> coinInfoHkds) {
        for (CoinInfoHkd infor : coinInfoHkds) {
            CoinInfoHkd iDb = mRealm.where(CoinInfoHkd.class).equalTo("id", infor.getId()).findFirst();
            mRealm.beginTransaction();
            if (iDb != null) {
                infor.setFavorite(iDb.isFavorite());
                infor.setHasAlarm(iDb.isHasAlarm());

            }
            mRealm.copyToRealmOrUpdate(infor);
            mRealm.commitTransaction();
        }
    }

    @Override
    public void saveCoinInfoInr(ArrayList<CoinInfoInr> coinInfoInrs) {
        for (CoinInfoInr infor : coinInfoInrs) {
            CoinInfoInr iDb = mRealm.where(CoinInfoInr.class).equalTo("id", infor.getId()).findFirst();
            mRealm.beginTransaction();
            if (iDb != null) {
                infor.setHasAlarm(iDb.isHasAlarm());
                infor.setFavorite(iDb.isFavorite());
            }
            mRealm.copyToRealmOrUpdate(infor);
            mRealm.commitTransaction();
        }
    }

    @Override
    public void saveCoinInfoJpy(ArrayList<CoinInfoJpy> coinInfoJpys) {
        for (CoinInfoJpy infor : coinInfoJpys) {
            CoinInfoJpy iDb = mRealm.where(CoinInfoJpy.class).equalTo("id", infor.getId()).findFirst();
            mRealm.beginTransaction();
            if (iDb != null) {
                infor.setFavorite(iDb.isFavorite());
                infor.setHasAlarm(iDb.isHasAlarm());

            }
            mRealm.copyToRealmOrUpdate(infor);
            mRealm.commitTransaction();
        }
    }

    @Override
    public void saveCoinInfoKrw(ArrayList<CoinInfoKrw> coinInfoKrws) {
        for (CoinInfoKrw infor : coinInfoKrws) {
            CoinInfoKrw iDb = mRealm.where(CoinInfoKrw.class).equalTo("id", infor.getId()).findFirst();
            mRealm.beginTransaction();
            if (iDb != null) {
                infor.setFavorite(iDb.isFavorite());
                infor.setHasAlarm(iDb.isHasAlarm());

            }
            mRealm.copyToRealmOrUpdate(infor);
            mRealm.commitTransaction();
        }
    }

    @Override
    public void saveCoinInfoMxn(ArrayList<CoinInfoMxn> coinInfoMxns) {
        for (CoinInfoMxn infor : coinInfoMxns) {
            CoinInfoMxn iDb = mRealm.where(CoinInfoMxn.class).equalTo("id", infor.getId()).findFirst();
            mRealm.beginTransaction();
            if (iDb != null) {
                infor.setFavorite(iDb.isFavorite());
                infor.setHasAlarm(iDb.isHasAlarm());
            }
            mRealm.beginTransaction();
            mRealm.copyToRealmOrUpdate(infor);
            mRealm.commitTransaction();
        }
    }

    @Override
    public void saveCoinInfoRub(ArrayList<CoinInfoRub> coinInfoRubs) {
        for (CoinInfoRub infor : coinInfoRubs) {
            CoinInfoRub iDb = mRealm.where(CoinInfoRub.class).equalTo("id", infor.getId()).findFirst();
            mRealm.beginTransaction();
            if (iDb != null) {
                infor.setFavorite(iDb.isFavorite());
                infor.setHasAlarm(iDb.isHasAlarm());
            }
            mRealm.copyToRealmOrUpdate(infor);
            mRealm.commitTransaction();
        }
    }

    @Override
    public ArrayList<CoinInfo> getAllCoinInfos(boolean isOnlyDisplay, boolean isDisplayFirst) {
        ArrayList<CoinInfo> coinInfos = new ArrayList<>();
        RealmResults<CoinInfo> results = null;
        if (!isOnlyDisplay && !isDisplayFirst) {
            results = mRealm.where(CoinInfo.class).findAll();
        } else if (isOnlyDisplay) {
            results = mRealm.where(CoinInfo.class).equalTo("isFavorite", true).findAll();
        } else if (isDisplayFirst) {
            results = mRealm.where(CoinInfo.class).equalTo("isFavorite", true).findAll();
            if (results != null && results.size() > 0) {
                for (CoinInfo info : results) {
                    CoinInfo useCoin = mRealm.copyFromRealm(info);
                    coinInfos.add(useCoin);
                }
            }
            results = mRealm.where(CoinInfo.class).equalTo("isFavorite", false).findAll();
            if (results != null && results.size() > 0) {
                for (CoinInfo info : results) {
                    CoinInfo useCoin = mRealm.copyFromRealm(info);
                    coinInfos.add(useCoin);
                }
            }
            return coinInfos;
        }
        if (results != null && results.size() > 0) {
            for (CoinInfo info : results) {
                CoinInfo useCoin = mRealm.copyFromRealm(info);
                coinInfos.add(useCoin);
            }
        }

        Collections.sort(coinInfos, new Comparator<CoinInfo>() {
            @Override
            public int compare(CoinInfo coinInfo, CoinInfo t1) {
                int rank1 = Integer.parseInt(coinInfo.getRank());
                int rank2 = Integer.parseInt(t1.getRank());
                int result = rank1 - rank2;
                if (result > 0) {
                    return 1;
                } else if (result < 0) {
                    return -1;
                } else return 0;
            }
        });


        return coinInfos;
    }

    @Override
    public void saveCoinInfos(ArrayList<CoinInfo> coinInfos) {
        for (CoinInfo infor : coinInfos) {
            CoinInfo iDb = mRealm.where(CoinInfo.class).equalTo("id", infor.getId()).findFirst();
            mRealm.beginTransaction();
            if (iDb != null) {
                infor.setFavorite(iDb.isFavorite());
                infor.setHasAlarm(iDb.isHasAlarm());
            }
            mRealm.copyToRealmOrUpdate(infor);
            mRealm.commitTransaction();
        }
    }
}
