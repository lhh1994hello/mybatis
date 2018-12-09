package com.atguigu.mybatis.test;

import com.atguigu.mybatis.bean.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * 作者:good、创建时间:2018/12/9、21:46
 */
public class MybatisTest1 {
    @Test
    public void fun1() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Employee employee= sqlSession.selectOne("com.atguigu.mybatis.bean.EmployeeMapper.findById","1");
        System.out.println(employee);
        sqlSession.close();
    }
}
