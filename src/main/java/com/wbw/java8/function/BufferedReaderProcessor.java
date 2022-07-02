package com.wbw.java8.function;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author wbw
 * @date 2022-7-2 14:13
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException;
}
