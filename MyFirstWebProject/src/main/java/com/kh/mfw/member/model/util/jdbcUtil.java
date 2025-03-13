package com.kh.mfw.member.model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcUtil {
	static {
		try {
			// FullClassName = 패키지 경로부터 클래스 Name 까지 
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			final String URL = "jdbc:oracle:thin:@112.221.156.34:12345:XE";
			final String USERNAME = "KH04_KDW";
			final String PASSWORD = "KH1234";
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}

	public static void updateClose(PreparedStatement stmt, Connection conn) {
		try {
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void queryClose(PreparedStatement stmt, Connection conn, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
