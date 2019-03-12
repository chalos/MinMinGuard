package tw.fatminmin.xposed.minminguard.blocker.adnetwork;

import de.robv.android.xposed.callbacks.XC_LoadPackage;
import tw.fatminmin.xposed.minminguard.blocker.ApiBlocking;
import tw.fatminmin.xposed.minminguard.blocker.Blocker;

public class Ironsource extends Blocker
{
    public static final String SuperSonicAdsAdapter = "com.ironsource.adapters.supersonicads.SupersonicAdsAdapter";
    @Override
    public boolean handleLoadPackage(String packageName, XC_LoadPackage.LoadPackageParam lpparam, boolean removeAd)
    {
        boolean result = false;

        result |= ApiBlocking.blockAdFunction(packageName, SuperSonicAdsAdapter, "showRewardedVideo", "org.json.JSONObject", "com.ironsource.mediationsdk.f.t", lpparam, removeAd);
        result |= ApiBlocking.blockAdFunction(packageName, SuperSonicAdsAdapter, "showInterstitial", "org.json.JSONObject", "com.ironsource.mediationsdk.f.k", lpparam, removeAd);
        result |= ApiBlocking.blockAdFunction(packageName, SuperSonicAdsAdapter, "showOfferwall", String.class, "org.json.JSONObject", lpparam, removeAd);

        result |= ApiBlocking.blockAdFunctionWithResult(packageName, SuperSonicAdsAdapter, "isRewardedVideoAvailable", "org.json.JSONObject", false, lpparam, removeAd);
        result |= ApiBlocking.blockAdFunctionWithResult(packageName, SuperSonicAdsAdapter, "isInterstitialReady", "org.json.JSONObject", false, lpparam, removeAd);

        return result;
    }

    @Override
    public String getBanner()
    {
        return null;
    }

    @Override
    public String getBannerPrefix()
    {
        return null;
    }
}