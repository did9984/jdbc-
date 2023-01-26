package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.TableStringConverter;

public class JdbcExe {
	public static void main(String[] args) {
		// jdbc 오라클 데이터 CRUD 작업.
		// 1. JDBC.JAR라이브러리. // 라이브러리 마우스오른쪽 - PROPERTI - LIBRARIES -ADD LIBRARY -
		// ojdbc6_g파일 찾아서 라이브러리 추가
		// 2. Connection 객체. db연결 쿼리실행 or 실행결과 통로.
		//
		Connection conn;
		Statement stmt = null;
		ResultSet rs = null;
		String sql ="insert into employees(job_id,employee_id,last_name,email,hire_date)"+"values('IT_PROG',300,'홍','H2',sysdate)";// sysdate= 현재날짜를 넣어준다
 
//		sql = "delete from employees where employee_id =305";
		
		sql = "update employees set FIRST_NAME ='길동' where employee_id =300";
		
		
		// jdbc driver정상.
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("오라클 드라이버 에러.");
			e.printStackTrace();

		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 연결 url
		String user = "hr"; // 계정
		String pass = "hr"; // password

		try {
			conn = DriverManager.getConnection(url, user, pass);// 연결할 변수
			System.out.println("connect complete");

			stmt = conn.createStatement(); // 쿼리실행,처리결과 객체.
			
			int r  =stmt.executeUpdate(sql); //insert,update,delete dml 
			
			rs = stmt.executeQuery("select * from employees"); // () 사이에 실행할 쿼리 입력 //executeQuery = 데이터 조회
			
			
          while (rs.next()) { // oracle 테이블에 담겨있는값을 가져오는 반복
			System.out.println("사원번호:"+ rs.getInt("employee_id")+"이름:"+rs.getString("FIRST_NAME")
			+",이메일: "+rs.getString("email")+", 급여:"+rs.getInt("SALARY")); // getInt(): 속성이 숫자인 값을 가져온다 () 안의 값을 대문자 소문자 상관없이 가능 ,getstring() 문자열 
		}
          System.out.println("end of records");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("fuck fail");
			e.printStackTrace();
		}
	}
}
