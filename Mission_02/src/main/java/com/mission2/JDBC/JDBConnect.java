package com.mission2.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;

public class JDBConnect {
    public Connection con;
    public Statement stmt;  
    public PreparedStatement psmt;  
    public ResultSet rs;

    // 기본 생성자
    public JDBConnect() {}

    // 두 번째 생성자
    public JDBConnect(String driver, String url, String id, String pwd) {
    	if (getConnection(driver, url, id, pwd)) {
            System.out.println("[JDBConnect]DB 연결 성공(인수 생성자 1)");
        } else {
        	System.out.println("[JDBConnect]DB 연결 실패(인수 생성자 1)");
        }
    }

    
    public JDBConnect(ServletContext application, String param) {
        String driver = application.getInitParameter(param + "Driver"); 
        String url = application.getInitParameter(param + "URL");
        String id = application.getInitParameter(param + "Id");
        String pwd = application.getInitParameter(param + "Pwd");

    	if (getConnection(driver, url, id, pwd)) {
            System.out.println("[JDBConnect]DB 연결 성공(인수 생성자 2)");
        } else {
        	System.out.println("[JDBConnect]DB 연결 실패(인수 생성자 2)");
        }
   	}

    // 연결 해제(자원 반납)
    public void close() { 
        try {            
            if (rs != null) rs.close(); 
            if (stmt != null) stmt.close();
            if (psmt != null) psmt.close();
            if (con != null) con.close(); 

            System.out.println("[JDBConnect]JDBC 자원 해제");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    boolean getConnection(String driver, String url, String id, String pwd) {

        System.out.println("[driver]" + driver);
        System.out.println("[url   ]" + url);
        System.out.println("[id    ]" + id);
        System.out.println("[pwd   ]" + pwd);
    	
        try {
            // JDBC 드라이버 로드
            Class.forName(driver);  

            // DB에 연결
            con = DriverManager.getConnection(url, id, pwd);

            return true;
        }
        catch (Exception e) {            
            e.printStackTrace();
        }
        return false;
    }    
}