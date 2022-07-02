package com.wbw.concurrent.util;

/**
 * @author wbw
 * @since 2022-5-21 3:03
 */
@FunctionalInterface
public interface ThriftAsyncCall {
    void invoke() throws TException ;
}