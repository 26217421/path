package com.wbw.pattern.creative.prototype;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-10 0:52
 */
public class Mail implements Cloneable {
    private String name;
    private String emailAddress;
    private String content;
    public Mail(){
        System.out.println("Mail Class Constructor");
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public Mail clone() {
        try {
            Mail clone = (Mail) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            System.out.println("clone mail object");
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
