package com.wbw.pattern.relational.chain;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-25 23:07
 */
public class Client {
    public static void main(String[] args) {
        MemberService service = new MemberService();
        service.login("tom","666");
        
    }
}
