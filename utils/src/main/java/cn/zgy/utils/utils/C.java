package cn.zgy.utils.utils;

import android.os.Build;

import java.net.URLEncoder;
import java.util.Locale;

/**
 * 全局常量
 *
 * @author a_liYa
 * @date 2016/5/19 20:39.
 */
public final class C {

    /**
     * 每页请求条数
     */
    public static final int PAGE_SIZE = 20;

    /**
     * 稿件列表每页请求条数
     */
    public static final int ARTICLE_PAGE_SIZE = 20;

    /**
     * 下拉刷新最短延迟时间
     */
    public static final long REFRESH_SHORTEST_TIME = 1000;

    /**
     * 保存到本地根文件夹名
     */
    public static final String SAVE_ROOT_FOLDER = "24小时";

    /**
     * 多图分隔字符串
     */
    public static final String PICS_SPLIT = ",";

    /**
     * 时间格式化：新闻详情页、
     */
    public static final String DATE_FORMAT_1 = "yyyy-M-d HH:mm";

    // 字体放缩比例
    public static final float FONT_SCALE_SMALL = 0.8f;
    public static final float FONT_SCALE_STANDARD = 1f;
    public static final float FONT_SCALE_LARGE = 1.2f;

    /**
     * 文章详情内容距离左右两边的边距 单位:dp
     */
//    public static final int HTML_SIDE_MARGIN = 15;


    /**
     * Http相关常量
     */
    public static final class http {

        /**
         * 缓存文件名
         */
        public static final String CACHE_FILENAME = "HttpCache";
        /**
         * 缓存大小
         */
        public static final int CACHE_MAX_SIZE = 10 * 1024 * 1024; // 10M

        /**
         * 缓存时间 单位：秒
         */
        public static final int CACHE_TIME = 3600 * 24 * 30; // 30天

        /**
         * key User-Agent
         */
        public static final String KEY_USER_AGENT = "User-Agent";
        /**
         * key X-SESSION-ID
         */
        public static final String KEY_SESSION_ID = "X-SESSION-ID";
        /**
         * key X-REQUEST-ID
         */
        public static final String KEY_REQUEST_ID = "X-REQUEST-ID";
        /**
         * key X-TIMESTAMP
         */
        public static final String KEY_TIMESTAMP = "X-TIMESTAMP";
        /**
         * key X-SIGNATURE
         */
        public static final String KEY_SIGNATURE = "X-SIGNATURE";

        public static final String userAgent() {

            StringBuffer sb = new StringBuffer();

            // 1. 应用名称
            sb.append("zjxw; ");

            // 2. 应用版本
            sb.append(AppUtils.getVersion()).append("; ");

            // 3. 设备uuid号
            sb.append(uniqueUUID()).append("; ");

            // 4. 设备信息
            try {
                sb.append(URLEncoder.encode(Build.MODEL, "utf-8"))
                        .append(" ")
                        .append(UIUtils.getAspectRatio())
                        .append("; ");
            } catch (Exception e) {
                sb.append("; ");
            }

            // 5. 操作系统
            sb.append("Android; ");

            // 6. 系统版本
            try {
                sb.append(URLEncoder.encode(Build.VERSION.RELEASE, "utf-8")).append("; ");
            } catch (Exception e) {
                sb.append("; ");
            }

            // 7. 语言和地区
            sb.append(Locale.getDefault().getLanguage()).append("; ");

            // 8. 渠道信息
            try {
                sb.append(URLEncoder.encode(AppUtils.getChannelName(), "utf-8"));
            } catch (Exception e) {
            }

            return sb.toString();
        }

        /**
         * 获取设备的唯一 uuid
         *
         * @return uuid
         */
        private static String uniqueUUID() {
            return AppUtils.getUniquePsuedoID();
        }

    }

    /*---------------------------------------------------------------------------*/

    /**
     * start Activity - request code
     *
     * @author a_liYa
     * @date 16/8/14 上午10:08.
     */
    public static final class request {
        /**
         * request code for tack pic(拍照)
         */
        public static final int TAKE_PICTURE = 0x1;
    }

}
