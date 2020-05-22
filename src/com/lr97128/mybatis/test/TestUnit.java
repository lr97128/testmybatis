package com.lr97128.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.lr97128.mybatis.bean.Employee;

public class TestUnit {

	public SqlSessionFactory getFactory() {
		SqlSessionFactory sqlSessionFactory = null;
		String resource = "mybatis-config.xml"; 
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		return sqlSessionFactory;

	}
	
	@Test
	public void test() {
		SqlSessionFactory sqlSessionFactory = getFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			Employee employee = sqlSession
					.selectOne("com.lr97128.mybatis.dao.EmployeeMapper.getEmpById", 1);
			System.out.println(employee);
		}finally {
			sqlSession.close();
		}
	}
	
}
