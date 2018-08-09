package cn.zgy.utils.utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import cn.zgy.utils.R;

/**
 * Created by lixinke on 2017/8/2.
 */

public class SettingManager {
    public static final String SETTING_NAME = "daily_setting";
    private static Context sContext;
    private static final SettingManager ourInstance = new SettingManager();
    private SharedPreferences mSharedPreferences;

    public static SettingManager getInstance() {
        return ourInstance;
    }

    @Deprecated
    public static void init(Application application) {

    }

    private void checkValid() {
        if (mSharedPreferences == null) {
            if (sContext == null) {
                sContext = UIUtils.getApp();
            }
            mSharedPreferences = sContext.getSharedPreferences(SettingManager.SETTING_NAME, Context.MODE_PRIVATE);
        }
    }

    /**
     * 设置正文字体大小
     *
     * @param size 字体大小 {@link TextSize}
     */
    public void setArticleTextSize(int size) {
        checkValid();
        mSharedPreferences
                .edit()
                .putInt(Name.ArticleFontSize, size)
                .apply();
    }


    /**
     * 获取正文字体大小
     *
     * @return 默认返回 {@link TextSize#NORMAL}
     */
    public int getArticleTextSize() {
        checkValid();
        return mSharedPreferences.getInt(Name.ArticleFontSize, 100);
    }

    public void setUserIconUrl(String url) {
        checkValid();
        mSharedPreferences
                .edit()
                .putString(Name.UserIconUrl, url)
                .apply();
    }

    public void getUserIconUrl() {
        checkValid();
        mSharedPreferences.getString(Name.UserIconUrl, "");
    }

    public void setNightMode() {
        checkValid();
        mSharedPreferences
                .edit()
                .putBoolean(Name.NightMode, true)
                .apply();
    }

    public boolean isNightMode() {
        checkValid();
        return mSharedPreferences.getBoolean(Name.NightMode, false);
    }

    public void setAutoPlayVideoWithWifi(boolean isAuto) {
        checkValid();
        mSharedPreferences
                .edit()
                .putBoolean(Name.AutoPlayVideoWithWifi, isAuto)
                .apply();
    }

    public boolean isAutoPlayVideoWithWifi() {
        checkValid();
        return mSharedPreferences.getBoolean(Name.AutoPlayVideoWithWifi, true);
    }

    public void setExtraValue(String key, String value) {
        checkValid();
        mSharedPreferences.edit().putString(key, value).apply();
    }

    public void getExtraValue(String key, String value) {
        checkValid();
        mSharedPreferences.getString(key, value);
    }

    /**
     * 切换推送热点
     *
     * @param isChecked true 开启
     */
    public void switchDailyHotspot(boolean isChecked) {
        checkValid();
        mSharedPreferences
                .edit()
                .putBoolean(Name.PUSH_BREAKING_NEWS, isChecked)
                .apply();
    }

    /**
     * 推送消息活动
     *
     * @param isChecked true 开启
     */
    public void switchActivityMessages(boolean isChecked) {
        checkValid();
        mSharedPreferences.edit().putBoolean(Name.PUSH_ACTIVITY_NEWS, isChecked).apply();
    }

    /**
     * 推送当地新闻
     *
     * @param isChecked true 开启
     */
    public void switchPushLocalNews(boolean isChecked) {
        checkValid();
        mSharedPreferences.edit().putBoolean(Name.PUSH_LOCAL_NEWS, isChecked).apply();
    }

    public boolean isOpenDailyHotspot() {
        checkValid();
        return mSharedPreferences.getBoolean(Name.PUSH_BREAKING_NEWS, true);
    }

    public boolean isOpenPushLocalNews() {
        checkValid();
        return mSharedPreferences.getBoolean(Name.PUSH_LOCAL_NEWS, true);
    }

    public boolean isOpenActivityMessages() {
        checkValid();
        return mSharedPreferences.getBoolean(Name.PUSH_ACTIVITY_NEWS, false);
    }

    public String getAdCache() {
        checkValid();
        return mSharedPreferences.getString(Name.AD_CACHE, "");
    }

    public void setAdCache(String cache) {
        checkValid();
        mSharedPreferences.edit().putString(Name.AD_CACHE, cache).apply();
    }

    public boolean isFirstStart() {
        checkValid();
        return mSharedPreferences.getBoolean(Name.FIRST_START, true);
    }

    public void setFirstStartState() {
        checkValid();
        mSharedPreferences.edit().putBoolean(Name.FIRST_START, false).apply();
    }

    public void setGuideRecommendInfo(String string) {
        checkValid();
        mSharedPreferences.edit().putString(Name.GUIDE_RECOMMEND, string).apply();
    }

    public String getGuideRecommendInfo() {
        checkValid();
        return mSharedPreferences.getString(Name.GUIDE_RECOMMEND, null);
    }

    public void isNeedUpdate(boolean isNeedUpdate) {
        checkValid();
        mSharedPreferences.edit().putBoolean(Name.IS_NEED_UPDATE, isNeedUpdate).apply();
    }

    public void setApkPath(String pkg_url, String path) {
        checkValid();
        mSharedPreferences.edit().putString(pkg_url, path).commit();
    }

    public String getApkPath(String pkg_url) {
        checkValid();
        return mSharedPreferences.getString(pkg_url, "");
    }

    public void setLastApkVersionCode(int lastVersionCode) {
        checkValid();
        mSharedPreferences.edit().putInt(Name.LAST_VERSION_CODE, lastVersionCode).apply();
    }

    public int getLastApkVersionCode() {
        checkValid();
        return mSharedPreferences.getInt(Name.LAST_VERSION_CODE, 0);
    }

    public long getLatestReadingMessageTime() {
        return mSharedPreferences.getLong(Name.LAST_READING_MESSAGE_TIME, 0);
    }

    public void setLatestReadingMessageTime(long time) {
        checkValid();
        mSharedPreferences.edit().putLong(Name.LAST_READING_MESSAGE_TIME, time).apply();
    }

    public long getServiceVersion() {
        checkValid();
        return mSharedPreferences.getLong(Name.SERVICE_VERSION, 0);
    }

    public void setServiceVersion(long version) {
        checkValid();
        mSharedPreferences.edit().putLong(Name.SERVICE_VERSION, version).apply();
    }

    public void setClearCacheTime(String clearCacheTime) {
        checkValid();
        mSharedPreferences.edit().putString(Name.CLEAR_CACHE_TIME, clearCacheTime).apply();
    }

    public String getClearTime() {
        checkValid();
        return mSharedPreferences.getString(Name.CLEAR_CACHE_TIME, "");
    }

    public boolean isProvincialTraffic() {
        checkValid();
        return mSharedPreferences.getBoolean(Name.PROVINCIAL_TRAFFIC, false);
    }

    public void setSubscriptionRefreshTime(long timeMillis) {
        checkValid();
        mSharedPreferences.edit().putLong(Name.SUBSCRIPTION_REFRESH_TIME, timeMillis).apply();
    }

    public long getLastSubscriptionRefreshTime() {
        checkValid();
        return mSharedPreferences.getLong(Name.SUBSCRIPTION_REFRESH_TIME, 0);
    }

    public boolean isShowGuide(String tag) {
        checkValid();
        return mSharedPreferences.getBoolean(tag, true);
    }

    public void hideGuide(String tag) {
        checkValid();
        mSharedPreferences.edit().putBoolean(tag, false).apply();
    }

    public boolean isOpenHttps() {
        checkValid();
        return mSharedPreferences.getBoolean(Name.HTTPS, true);
    }

    public void setOpenHttps(boolean https) {
        checkValid();
        mSharedPreferences.edit().putBoolean(Name.HTTPS, https).commit();
    }

    public void setHost(String host) {
        // Application重启时apply方法无法及时同步到硬盘
        checkValid();
        mSharedPreferences.edit().putString(Name.HOST, host).commit();
    }

    //    home红包弹窗需要检查打开app是否在同一天
    public void setHomeYearAndDay(String yearAndDay) {
        checkValid();
        mSharedPreferences.edit().putString(Name.HOMEYEARDAY, yearAndDay).commit();
    }

    public String getHomeYearAndDay() {
        checkValid();
        return mSharedPreferences.getString(Name.HOMEYEARDAY, "");
    }

    //    find红包弹窗需要检查打开app是否在同一天
    public void setFindYearAndDay(String yearAndDay) {
        checkValid();
        mSharedPreferences.edit().putString(Name.FINDYEARDAY, yearAndDay).commit();
    }

    public String getFindYearAndDay() {
        checkValid();
        return mSharedPreferences.getString(Name.FINDYEARDAY, "");
    }

    //存储IMEI,连续登陆时获取
    public void setImei(String imei) {
        checkValid();
        mSharedPreferences.edit().putString(Name.IMEI, imei).commit();
    }

    public String getImei() {
        checkValid();
        return mSharedPreferences.getString(Name.IMEI, "");
    }


    interface Name {
        String ArticleFontSize = "ArticleFontSize";
        String UserIconUrl = "UserIconUrl";
        String NightMode = "NightMode";
        String AutoPlayVideoWithWifi = "AutoPlayVideoWithWifi";
        //push
        String PUSH_BREAKING_NEWS = "pushBreakingNews";
        String PUSH_LOCAL_NEWS = "pushLocalNews";
        String PUSH_ACTIVITY_NEWS = "pushActivityNews";

        //ad
        String AD_CACHE = "ad_cache";
        String FIRST_START = "first_start";
        String GUIDE_RECOMMEND = "guide_recommend";

        //login
        String NICK_NAME = "nickName";
        String INVITE_CODE = "inviteCode";
        String IS_LOGIN = "isLogin";
        String ACCOUNT_INFO = "AccountInfo";
        //Update APK
        String IS_NEED_UPDATE = "isNeedUpdate";
        String APK_PATH = "apkPath";
        String LAST_VERSION_CODE = "lastVersionCode";
        String LAST_READING_MESSAGE_TIME = "last_reading_message_time";
        String SERVICE_VERSION = "service_version";
        String CLEAR_CACHE_TIME = "clear_cache_time";
        String PROVINCIAL_TRAFFIC = "provincial_traffic";
        String SUBSCRIPTION_REFRESH_TIME = "subscription_refresh_time";
        String HTTPS = "https";
        String HOST = "host";
        String HOMEYEARDAY = "homeyearday";
        String FINDYEARDAY = "findyearday";
        String IMEI = "imei";
    }

    /**
     * 正文字体大小类
     */
    public interface TextSize {
        int LARGER = 150;
        int NORMAL = 100;
        int SMALLER = 75;
    }

}
