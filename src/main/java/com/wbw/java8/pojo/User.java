package com.wbw.java8.pojo;

import java.util.Optional;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-2-22 16:28
 */
public class User {
    private String email;
    private String password;
    private Address address;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User() {
        this.email = "123@123.com";
        this.password = "000";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Optional<Address> getAddress() {
        return Optional.ofNullable(address);
    }
}
