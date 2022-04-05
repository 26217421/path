package com.wbw.java8;


import com.wbw.java8.pojo.Address;
import com.wbw.java8.pojo.Country;
import com.wbw.java8.pojo.User;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-2-22 16:14
 */
public class OptionalTest {
    @Test(expected = NoSuchElementException.class)
    public void whenCreateEmptyOptionalThenNull() {
        User user = new User("john@gmail.com", "1234");
        Optional<User> emptyOpt = Optional.empty();
        emptyOpt.get();
    }
    @Test(expected = NullPointerException.class)
    public void whenCreateOfEmptyOptionalThenNullPointerException() {
        Optional<User> opt0 = Optional.ofNullable(new User());
        Optional<User> opt = Optional.of(null);
    }

    @Test
    public void func1(){
        String name = "John";
        Optional<String> opt = Optional.of(name);
        assertEquals("John", opt.get());

        User user = new User("john@gmail.com", "1234");
        Optional<User> opt1 = Optional.of(user);
        assertTrue(opt1.isPresent());

        assertEquals(user.getEmail(), opt1.get().getEmail());

        opt1.ifPresent( u -> assertEquals(user.getEmail(), u.getEmail()));
    }

    @Test
    public void func2(){
        User user = null;
        User user2 = new User("anna@gmail.com", "1234");
        User result = Optional.ofNullable(user).orElse(user2);

        assertEquals(user2.getEmail(), result.getEmail());
    }
    @Test
    public void func3(){
        User user = new User("john@gmail.com","1234");
        User user2 = new User("anna@gmail.com", "1234");
        User result = Optional.ofNullable(user).orElse(user2);

        assertEquals("john@gmail.com", result.getEmail());
        User user3 = null;
        User result1 = (User) Optional.ofNullable(user3).orElseGet( () -> user2);
        assertEquals("anna@gmail.com", result1.getEmail());
    }
    @Test
    public void givenPresentValueWhenCompareThenOk() {
        User user = new User("john@gmail.com", "1234");
        System.err.println("Using orElse");
        User result = Optional.ofNullable(user).orElse(createNewUser());
        System.err.println("Using orElseGet");
        //非空值时orElseGet() 方法不创建 User 对象。
        User result2 = Optional.ofNullable(user).orElseGet(this::createNewUser);
    }
    @Test(expected = IllegalArgumentException.class)
    public void whenThrowExceptionThenOk() {
        User user = null;
        User result = Optional.ofNullable(user)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Test
    public void whenFilter_thenOk() {
        User user = new User("anna@gmail.com", "1234");
        Optional<User> result = Optional.ofNullable(user)
                .filter(u -> u.getEmail() != null && u.getEmail().contains("@"));

        assertTrue(result.isPresent());
    }

    @Test
    public void whenChaining_thenOk() {
        User user = new User("anna@gmail.com", "1234");

        String result = Optional.ofNullable(user)
                .flatMap(User::getAddress)
                .flatMap(Address::getCountry)
                .map(Country::getIsocode)
                .orElse("default");

        assertEquals(result, "default");
    }

    private User createNewUser() {
        System.err.println("Creating New User");
        return new User("extra@gmail.com", "1234");
    }

}
