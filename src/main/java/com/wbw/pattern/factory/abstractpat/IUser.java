package com.wbw.pattern.factory.abstractpat;

import com.wbw.pattern.factory.pojo.User;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-11 2:20
 */
public interface IUser {
    /**
     * 添加用户
     * @param user 添加实体
     */
    public void insert(User user);

    /**
     * 根据id查询用户
     * @param uid 用户id
     * @return
     */
    public User getUser(int uid);
}
