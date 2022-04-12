package com.wbw.pattern.creative.factory.abstractpat;

import com.wbw.pattern.creative.factory.pojo.User;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-11 2:22
 */
public class MysqlUser implements IUser {
    /**
     * @param user 添加信息
     */
    @Override
    public void insert(User user) {
        System.out.println("在mysql中的user表中插入一条元素");
    }

    /**
     * @param uid 用户id
     * @return
     */
    @Override
    public User getUser(int uid) {
        System.out.println("在mysql中的user表得到id为"+uid+"的一条数据");
        return null;
    }
}
