package com.wbw.pattern.relational.chain;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-25 23:06
 */
public class AuthHandler extends Handler {
    /**
     * 处理方法
     *
     * @param member 实体
     */
    @Override
    public void doHandle(Member member) {
        if (!"管理员".equals(member.getRoleName())) {
            System.out.println("您不是管理员，没有操作权限");
            return;
        }
        System.out.println("您是管理员，允许操作");
    }
}
