package com.Dao;

import java.util.Properties;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

public class MySqlDatasourceUtil {

    public static DataSource getMySQLDataSource() {
        Properties prop = PropertiesFileUtil.getPropertiesFromFile();

        MysqlDataSource mysqlDS = new MysqlDataSource();

        mysqlDS.setURL("jdbc:mysql://localhost:3306/labs");
        mysqlDS.setUser("root");
        mysqlDS.setPassword("1234");

        return mysqlDS;
    }

}
