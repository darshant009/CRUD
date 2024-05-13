package com.darsh;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class empDAO {

	private List<employee> emp;
	private Connection con;
	
	public empDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/master",
	                "root",
	                "thillai96");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public employee getEmployee(int id){
		employee e = new employee();
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM master.employee where id=?");
			stmt.setInt(1, id);
			ResultSet rs= stmt.executeQuery();
			if(rs.next())
			{
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
			}
			con.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return e;	
	}
	
	public List<employee> getAllEmployees(){
		emp = new ArrayList<employee>();
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM master.employee");
			ResultSet rs= stmt.executeQuery();
			while(rs.next()) {
				employee e = new employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
				emp.add(e);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;	
	}
	
	public int writeData(employee e){
		int status = 0;
		try {
			PreparedStatement stmt = con.prepareStatement(
					"INSERT INTO master.employee (name, password, email, country) " + "VALUES (?,?,?,?)");
			stmt.setString(1, e.getName());
			stmt.setString(2, e.getPassword());
			stmt.setString(3, e.getEmail());
			stmt.setString(4, e.getCountry());
			status=stmt.executeUpdate();
			con.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return status;	
		
	}
	
	public int updateData(employee e){
		int status = 0;
		try {
			PreparedStatement stmt = con.prepareStatement(
					"UPDATE master.employee set name=?, password=?, email=?, country=? where id=?");
			stmt.setString(1, e.getName());
			stmt.setString(2, e.getPassword());
			stmt.setString(3, e.getEmail());
			stmt.setString(4, e.getCountry());
			stmt.setInt(5, e.getId());
			
			status=stmt.executeUpdate();
			con.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return status;	
		
	}
	
	public int deleteData(int id){
		int status = 0;
		try {
			PreparedStatement stmt = con.prepareStatement(
					"DELETE from master.employee where id=?");
			stmt.setInt(1, id);
			status=stmt.executeUpdate();
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return status;			
	}
	
	
}
