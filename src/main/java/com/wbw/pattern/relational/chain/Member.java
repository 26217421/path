package com.wbw.pattern.relational.chain;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-25 22:55
 */
public class Member {
    private final String loginName;
    private final String loginPass;
    private String roleName;

    public Member(String loginName, String loginPass) {
        this.loginName = loginName;
        this.loginPass = loginPass;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getLoginPass() {
        return loginPass;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Member{" +
                "loginName='" + loginName + '\'' +
                ", loginPass='" + loginPass + '\'' +
                '}';
    }
}
