package com.wbw.pattern.relational.chain;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-25 22:55
 */
public class ValidateHandler extends Handler{
    /**
     * 处理方法
     *
     * @param member 实体
     */
    @Override
    public void doHandle(Member member) {
        if(StringUtils.isEmpty(member.getLoginName()) ||
                StringUtils.isEmpty(member.getLoginPass())){
            System.out.println("用户名或者密码为空");
            return;
        }
        System.out.println("用户名和密码校验成功，可以往下执行");
        chain.doHandle(member);

    }
}
