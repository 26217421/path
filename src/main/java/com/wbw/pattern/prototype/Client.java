package com.wbw.pattern.prototype;

import java.text.MessageFormat;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-10 0:59
 */
public class Client {
    public static void main(String[] args) {
        long a = System.nanoTime();
        int maxCount = 10;
        Mail mail = new Mail();
        mail.setContent("初始化模板");
        System.out.println("初始化mail:"+mail);
        for(int i = 0;i < maxCount;i++){
            System.out.println();
            //Mail mailTemp = mail.clone();
            Mail mailTemp = new Mail();
            mailTemp.setName("姓名"+i);
            mailTemp.setEmailAddress("姓名"+i+"@test.com");
            mailTemp.setContent("恭喜您，此次抽奖活动中奖了");
            sendMail(mailTemp);
            System.out.println("克隆的mailTemp:"+mailTemp);
        }
        long b = System.nanoTime();
        System.out.println("用时： " + (b - a));
        saveOriginMailRecord(mail);
    }

    public static void sendMail(Mail mail) {
        String outputContent = "向{0}同学,邮件地址:{1},邮件内容:{2}发送邮件成功";
        System.out.println(MessageFormat.format(outputContent, mail.getName(), mail.getEmailAddress(), mail.getContent()));
    }

    public static void saveOriginMailRecord(Mail mail) {
        System.out.println("存储originMail记录,originMail:" + mail.getContent());
    }

}
