package com.wbw.java8.pojo;

import java.util.Optional;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-2-22 21:35
 */
public class Address {
    private Country country;

    public Optional<Country> getCountry() {
        return Optional.ofNullable(country);
    }
}
