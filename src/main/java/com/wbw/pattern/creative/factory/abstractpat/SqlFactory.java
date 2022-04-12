package com.wbw.pattern.creative.factory.abstractpat;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-11 2:23
 */
public interface SqlFactory {
    /**
     * 生产访问user表的对象
     * @return 数据库操作对象
     */
    public IUser createUser();

    /**
     * 生产访问login表的对象
     * @return 数据库操作对象
     */
    public ILogin createLogin();

}
