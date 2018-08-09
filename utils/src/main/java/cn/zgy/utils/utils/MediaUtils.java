package cn.zgy.utils.utils;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.support.annotation.WorkerThread;

import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

/**
 * 多媒体资源工具类
 *
 * @author a_liYa
 * @date 16/10/23 16:43.
 */
public class MediaUtils {

    public static int getMediaDuration(Uri uri) {
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        mmr.setDataSource(UIUtils.getContext(), uri);
        String durationStr = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
        int millSecond = Integer.parseInt(durationStr);
        return millSecond;
    }

    public static int getMediaDuration(String url) {
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        mmr.setDataSource(url, new HashMap<String, String>());
        String durationStr = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
        int millSecond = Integer.parseInt(durationStr);
        mmr.release();
        return millSecond;
    }

    public static Bitmap getMediaFrame(String url) {
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        mmr.setDataSource(url, new HashMap<String, String>());
        Bitmap bitmap = mmr.getFrameAtTime();
        mmr.release();
        return bitmap;
    }


    public static boolean isImageFile(String path) {
        String mimeType = URLConnection.guessContentTypeFromName(path);
        return mimeType != null && mimeType.indexOf("image") == 0;
    }

    public static boolean isVideoFile(String path) {
        String mimeType = URLConnection.guessContentTypeFromName(path);
        return mimeType != null && mimeType.indexOf("video") == 0;
    }

    @WorkerThread
    public static final int getFileSizeByUrl(String strUrl) {
        try {
            URL url = new URL(strUrl);
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();
            int file_size = urlConnection.getContentLength();
            return file_size;
        } catch (Exception e) {

        }
        return -1;
    }
}
