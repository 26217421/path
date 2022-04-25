package com.wbw.pattern.relational.chain;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-25 23:06
 */
public class LoginHandler extends Handler {
    /**
     * 处理方法
     *
     * @param member 实体
     */
    @Override
    public void doHandle(Member member) {
        System.out.println("登录成功！");
        member.setRoleName("管理员");
        chain.doHandle(member);
    }
}
