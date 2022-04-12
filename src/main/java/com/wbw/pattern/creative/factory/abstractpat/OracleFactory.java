package com.wbw.pattern.creative.factory.abstractpat;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-11 2:26
 */
public class OracleFactory implements SqlFactory {
    /**
     * 生产访问user表的对象
     *
     * @return 数据库操作对象
     */
    @Override
    public IUser createUser() {

        return new OracleUser();
    }

    /**
     * 生产访问login表的对象
     *
     * @return 数据库操作对象
     */
    @Override
    public ILogin createLogin() {
        return new OracleLogin();
    }
}
