package com.wbw.pattern.creative.factory.abstractpat;

import com.wbw.pattern.creative.factory.pojo.Login;
import com.wbw.pattern.creative.factory.pojo.User;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-11 2:29
 */
public class Client {
    public static void main(String[] args) throws Exception {
        SqlFactory sqlFactory = (SqlFactory) Class.forName("com.wbw.pattern.creative.factory.abstractpat.MysqlFactory").newInstance();
        IUser user = sqlFactory.createUser();
        ILogin login = sqlFactory.createLogin();
        user.getUser(1);
        user.insert(new User());
        login.insert(new Login());
        login.getLogin(1);
    }
}
