package cn.zgy.utils.utils;

import java.util.List;

/**
 * 类描述：队列工具类
 *
 * @author jinzifu
 * @Email jinzifu123@163.com
 * @date 2018/3/16 0945
 */

public class ListUtils {

    /**
     * list是否为空
     */
    public static boolean isListEmpty(List<?> list) {
        if (list == null || list.size() == 0) {
            return true;
        }
        return false;
    }
}
