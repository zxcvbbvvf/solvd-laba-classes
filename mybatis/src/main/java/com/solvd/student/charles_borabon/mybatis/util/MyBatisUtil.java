package com.solvd.student.charles_borabon.mybatis.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            // Load the MyBatis configuration file from the resources folder
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Error initializing MyBatis. Cause: " + e);
        }
    }

    // Returns the SqlSessionFactory that will be used in DAOs
    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}