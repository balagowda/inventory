package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Helper {
	static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbUrl = "jdbc:mysql://localhost:3306/temp?useSSL=false";
			conn = DriverManager.getConnection(dbUrl,"root","Root123$");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	static void close(Connection conn, PreparedStatement ps) {
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
