package dinostudio.coinmarketmonitor.base.admob;

import android.app.Activity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import dinostudio.coinmarketmonitor.base.utils.DLogUtils;

public class Admob {
    private static final String AD_UNIT_ID_INTERSTITIAL = "ca-app-pub-5874042652708882/6634034264";
    private static final String TEST_DEVICE = "650947C4578F924F1FA9BD61D505FA2E";
    Activity context;
    InterstitialAd interstitial_Exit;
    AdView adView;

    public Admob(Activity context) {
        super();
        this.context = context;
    }

    public void displayInterstitial() {
        final InterstitialAd interstitial = new InterstitialAd(context);
        interstitial.setAdUnitId(AD_UNIT_ID_INTERSTITIAL);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(TEST_DEVICE).build();
        interstitial.loadAd(adRequest);
        interstitial.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                if (interstitial.isLoaded()) {
                    interstitial.show();
                }
            }
        });
    }

    public void initAds() {
        interstitial_Exit = new InterstitialAd(context);
        interstitial_Exit.setAdUnitId(AD_UNIT_ID_INTERSTITIAL);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(TEST_DEVICE).build();
        interstitial_Exit.loadAd(adRequest);
        interstitial_Exit.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // TODO Auto-generated method stub
                super.onAdLoaded();
            }
        });
    }

    public void ShowAds() {
        if (interstitial_Exit != null)
            if (interstitial_Exit.isLoaded()) {
                interstitial_Exit.show();
            }
    }

    public void adsBanner(final AdView adView) {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(TEST_DEVICE).build();

        adView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                LinearLayout adViewContainer = (LinearLayout) adView
                        .getParent();
                adViewContainer.setVisibility(View.VISIBLE);
                adView.setVisibility(View.VISIBLE);
                // adViewContainer.startAnimation(AnimationUtils.makeInChildBottomAnimation(adView.getContext()));
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);
                adView.setVisibility(View.GONE);
            }
        });
        adView.loadAd(adRequest);
    }

    public void adsBanner_Setting(final AdView adView) {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(TEST_DEVICE).build();

        adView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                LinearLayout adViewContainer = (LinearLayout) adView
                        .getParent();
                adViewContainer.setVisibility(View.VISIBLE);
                adView.setVisibility(View.VISIBLE);
                adViewContainer.startAnimation(AnimationUtils
                        .makeInChildBottomAnimation(adView.getContext()));
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                DLogUtils.d("onAddFailt to code" + errorCode);
                super.onAdFailedToLoad(errorCode);
                adView.setVisibility(View.GONE);
            }
        });
        adView.loadAd(adRequest);
    }
}