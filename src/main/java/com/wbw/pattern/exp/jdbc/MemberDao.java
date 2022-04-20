package com.wbw.pattern.exp.jdbc;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-19 23:59
 */
public class MemberDao extends JdbcTemplate<Member> {
    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<Member> selectAll() {
        String sql = "select * from t_member";
        return super.executeQuery(sql, (rs, rowNum) -> {
            Member member = new Member();
            member.setUsername(rs.getString("username"));
            member.setPassword(rs.getString("password"));
            member.setAge(rs.getInt("age"));
            member.setNickname(rs.getString("nickname"));
            member.setAddr(rs.getString("addr"));
            return member;
        }, null);
    }

}
