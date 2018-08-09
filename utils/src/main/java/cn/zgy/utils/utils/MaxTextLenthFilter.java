package cn.zgy.utils.utils;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.Toast;

/**
 * Toast超过显示数量弹框
 * Created by wanglinjie.
 * create time:2017/10/30  下午4:35
 */

public class MaxTextLenthFilter implements InputFilter {

    private int mMaxLength;
    private Toast toast;

    public MaxTextLenthFilter(int max) {
        mMaxLength = max - 1;
        toast = Toast.makeText(UIUtils.getApp(), "字数过多", Toast.LENGTH_SHORT);
    }

    public CharSequence filter(CharSequence source, int start, int end,
                               Spanned dest, int dstart, int dend) {
        int keep = mMaxLength - (dest.length() - (dend - dstart));
        if (keep < (end - start)) {
            toast.show();
        }
        if (keep <= 0) {
            return "";
        } else if (keep >= end - start) {
            return null;
        } else {
            return source.subSequence(start, start + keep);
        }
    }
}
