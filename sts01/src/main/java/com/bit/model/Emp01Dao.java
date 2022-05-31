package com.bit.model;

import java.sql.*;
import java.util.*;

public class Emp01Dao {
	
	public List<EmpVo> selectAll() throws ClassNotFoundException, SQLException{
		List<EmpVo> list=new ArrayList<>();
		String sql="select * from emp";
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/scott";
		String user = "user01";
		String password="1234";
		
		Class.forName(driver);
		try (
				Connection conn = DriverManager.getConnection(url,user,password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				){
			while(rs.next()) {
				list.add(new EmpVo(
						rs.getInt("empno"),rs.getString("ename"),
						rs.getInt("sal"),rs.getString("job")
						));
			}
		}
		return list;
	}
	
}
