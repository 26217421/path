package com.wbw.pattern.factory.abstractpat;

import com.wbw.pattern.factory.pojo.User;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-11 2:23
 */
public class OracleUser implements IUser {
    /**
     * @param user 添加信息
     */
    @Override
    public void insert(User user) {
        System.out.println("在oracle中的user表中插入一条元素");
    }

    /**
     * @param uid 用户id
     * @return
     */
    @Override
    public User getUser(int uid) {
        System.out.println("在oracle中的user表得到id为"+uid+"的一条数据");
        return null;
    }
}
