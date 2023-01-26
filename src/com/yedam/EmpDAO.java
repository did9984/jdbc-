package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.ldap.HasControls;

public class EmpDAO {
// C(reate)R(ead)U(pdate)D(elete) 처리 . 
	Connection conn;
	Statement stmt = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	String SQL;

	String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 연결 url

	public Connection getConn() {
		return conn;
	}

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
//	public List<Map<String, Object>> emplist() {
//		SQL = "select * from emp_temp";
//		connect();
//		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//		// 인터페이스 // 실질적 실행 메소드
//		try {
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(SQL);
//			while (rs.next()) {
//
//				Map<String, Object> map = new HashMap<>();
//				map.put("emp_id", rs.getInt("employee_id"));
//				map.put("first_name", rs.getString("first_name"));
//				map.put("last_name", rs.getString("last_name"));
//				map.put("salary", rs.getInt("salary"));
//
//				list.add(map);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return list;
//	}

	// List<Map<String,Object>>비교.
	public List<EmpVO> empVoList() {
		connect();
		SQL = "select * from emp_temp";
		List<EmpVO> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			while (rs.next()) {
				EmpVO emp = new EmpVO();
				emp.setEmployeedId(rs.getInt("employee_id"));
				emp.setFirstname(rs.getString("first_name"));
				emp.setLastname(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setSalary(rs.getInt("salary"));

				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 단건조회.
	public EmpVO getEmp(int id) {
		SQL = "select * from emp_temp where employee_id= " + id;
		connect();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			if (rs.next()) {
				EmpVO emp = new EmpVO();
				emp.setEmployeedId(rs.getInt("employee_id"));
				emp.setFirstname(rs.getString("first_name"));
				emp.setLastname(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setSalary(rs.getInt("salary"));
				emp.setHireDate(rs.getString("hire_date"));
				return emp;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;// 조회된 데이터 없음
	}

	// 입력
	public int addEmp(EmpVO emp) {
		connect();
		
		SQL = "insert into emp_temp(employee_id,last_name,email,hire_date,job_id)" + "values(?,?,?,?,?)";
		int r = 0; // 처리된 건수.
		try {
			psmt = conn.prepareStatement(SQL);
			psmt.setInt(1, emp.getEmployeedId());// values(?????)첫번째 물음표값
			psmt.setString(2, emp.getLastname());
			psmt.setString(3, emp.getEmail());
			psmt.setString(4, emp.getHireDate());
			psmt.setString(5, emp.getJobId());
			
			r = psmt.executeUpdate(); // 처리된 건수.
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          return r;
	}

	// 수정.
	public int updateEmp(int id, int sal) {
		connect();
		SQL = "update emp_temp set salary = ? where employee_id = ?";
		int r = 0;
		try {
			psmt = conn.prepareStatement(SQL);
			psmt.setInt(1, sal);
			psmt.setInt(2, id);
			r = psmt.executeUpdate(); // 처리된 건수.
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;

	}
	// 삭제.
	public int deleteEmp(int id) {
		connect();
	SQL = "delete from emp_temp where employee_id = ?";
	int r = 0;
	try {
		psmt = conn.prepareStatement(SQL);
		psmt.setInt(1, id);
		r = psmt.executeUpdate(); // 처리된 건수.
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return r;
}
}
