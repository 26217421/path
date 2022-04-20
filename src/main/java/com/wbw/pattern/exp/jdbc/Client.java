package com.wbw.pattern.exp.jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-20 0:01
 */
public class Client {
    public static void main(String[] args) throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("262174rty");
        dataSource.setURL("jdbc:mysql://localhost:3306/test");
        dataSource.setServerTimezone("UTC");
        dataSource.setUseSSL(false);
        MemberDao memberDao = new MemberDao(dataSource);
        List<Member> result = memberDao.selectAll();
        result.forEach(System.out::println);
    }
}
