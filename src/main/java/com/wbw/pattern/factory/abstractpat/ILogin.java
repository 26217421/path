package com.wbw.pattern.factory.abstractpat;

import com.wbw.pattern.factory.pojo.Login;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-11 2:48
 */
public interface ILogin {

    /**
     * 添加登录信息
     * @param login 实体
     */
    public void insert(Login login);

    /**
     * 查询登录信息
     * @param id 用户id
     * @return login实体
     */
    public Login getLogin(int id);

}
