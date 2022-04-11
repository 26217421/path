package com.wbw.pattern.factory.abstractpat;

import com.wbw.pattern.factory.pojo.Login;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-11 2:52
 */
public class OracleLogin implements ILogin {
    /**
     * 添加登录信息
     *
     * @param login 实体
     */
    @Override
    public void insert(Login login) {
        System.out.println("对 Oracle 里的 Login 表插入了一条数据");
    }

    /**
     * 查询登录信息
     *
     * @param id 用户id
     * @return login实体
     */
    @Override
    public Login getLogin(int id) {
        System.out.println("通过 uid 在 Oracle 里的 Login 表得到了一条数据");
        return null;
    }
}
