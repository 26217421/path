package com.wbw.pattern.creative.factory.abstractpat;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-11 17:43
 */
public class EasyFactory {
    private static String db="MySQL";
    // private static String db="Oracle";

    public static IUser createUser(){

        IUser user=null;
        switch (db){
            case "MySQL":
                user=new MysqlUser();
                break;

            case "Oracle":
                user=new OracleUser();
                break;
            default:
                break;
        }
        return user;
    }

    public static ILogin createLogin(){

        ILogin login=null;
        switch (db){
            case "MySQL":
                login=new MysqlLogin();
                break;

            case "Oracle":
                login=new OracleLogin();
                break;
            default:
                break;
        }
        return login;
    }
}
