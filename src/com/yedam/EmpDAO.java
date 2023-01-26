package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

public class EmpDAO {
// C(reate)R(ead)U(pdate)D(elete) 처리 . 
	Connection conn;
	Statement stmt = null;
	ResultSet rs = null;
	String SQL;

	String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 연결 url
	String user = "hr"; // 계정
	String pass = "hr"; // password
	

	public void connect() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("FUCKING ERROR");
			e.printStackTrace();

		}
	}

	// 목록조회.
	public List<Map<String, Object>> emplist() {

	}
	// 단건조회.

	// 수정.

	// 삭제.
}
