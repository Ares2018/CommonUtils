package cn.zgy.utils.utils;

/**
 * 获取单元数据指定字段接口
 * <p>
 * 抽象策略类
 *
 * @author a_liYa
 * @date 16/9/6 20:56.
 */
public interface IUnitData<T> {

    /**
     * 获取t中需要拼接字符
     * <p>
     * 策略方法
     *
     * @param t 泛型类实例
     * @return String
     */
    String getUnitData(T t);

}
