package co.micol.prj.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//싱글톤 클래스 가장 기본꼴
public class DataSource { 
	private static SqlSessionFactory SqlSessionFactory; //Mybatis 사용
	
	private DataSource() {} //생성자를 다른곳에서 생성할 수 없도록 하기 위해 private으로
	
	public static SqlSessionFactory getInstance() {
		// 데이터 소스 객체 생성, mybatis 파일 위치 생성
		String resource = "config/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); //물리적인 DB위치를 찾고 
			System.out.println("DB 연결 성공!!!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("DB 연결 실패!!!");
		}
		return SqlSessionFactory;
	}
}
