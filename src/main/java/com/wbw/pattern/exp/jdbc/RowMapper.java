package com.wbw.pattern.exp.jdbc;

import java.sql.ResultSet;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-19 23:53
 */
public interface RowMapper<T> {

    T mapRow(ResultSet rs, int rowNum) throws Exception;
}