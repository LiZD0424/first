package com.example.demo.dto;

import org.hibernate.dialect.MySQL5Dialect;

/**
 * 描述:
 * <p>
 * Created by mengxiansen on 2018-11-27 16:41
 *
 * @author mengxs@lenovocloud.com
 */
public class MySQLConfig extends MySQL5Dialect {
    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }

}
