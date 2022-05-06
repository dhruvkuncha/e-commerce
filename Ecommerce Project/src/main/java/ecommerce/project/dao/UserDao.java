package ecommerce.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ecommerce.project.model.*;


public class UserDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public UserDao(Connection con) {
		this.con = con;
	}
	
	public User userLogin(String email, String password) {
		User user = null;
		
		try {
			query = "select * from users where email=? and password=?";
			pst = this.con.prepareStatement(query);
			pst.setString(1,  email);
			pst.setString(2, password);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setEmail(rs.getString("email"));
				
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		return user;
	}
	public boolean userRegister(User user) {
		Boolean set = false;
		
		try {
			query = "INSERT INTO users(email, password, firstname, lastname) VALUES(?,?,?,?)";
			pst = this.con.prepareStatement(query);
			pst.setString(3, user.getFirstname());
			pst.setString(4, user.getLastname());
			pst.setString(1,  user.getEmail());
			pst.setString(2, user.getPassword());
			pst.execute();
			
			set = true;
			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		return set;
		
	}
	public boolean userUpdate(User user, String email) {
		Boolean set = false;
		
		try {
			query = "UPDATE users SET email=?, password=?, firstname=?, lastname=? WHERE email=?";
			pst = this.con.prepareStatement(query);
			pst.setString(1, user.getEmail());
			pst.setString(2,  user.getPassword());
			pst.setString(3, user.getFirstname());
			pst.setString(4, user.getLastname());		
			pst.setString(5, email);
			pst.execute();
			
			set = true;
			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		return set;
		
	}
	
	public boolean userDelete(String email) {
		Boolean set = false;
		
		try {
			query = "DELETE FROM users WHERE email=?";
			pst = this.con.prepareStatement(query);
			pst.setString(1, email);
			
			pst.execute();
			
			set = true;
			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		return set;
		
	}
	
	
	
	public boolean cardInsert(User user) {
		Boolean set = false;
		
		try {
			query = "INSERT INTO card(uId, cNo, cName, validThrough, cvv, cBal) VALUES(?,?,?,?,?,?)";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, user.getId());
			pst.setString(2,  user.getcNo());
			pst.setString(3, user.getcName());
			pst.setString(4,  user.getValidThrough());
			pst.setString(5, user.getCvv());
			pst.setDouble(6, user.getCreditBalance());
			pst.execute();
			
			set = true;
			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		return set;
		
	}
	
	public boolean cardUpdate(User user, String cNo) {
		Boolean set = false;
		
		try {
			query = "UPDATE card SET cNo=?, cName=?, validThrough=?, cvv=?, cBal=? WHERE cNo=?";
			pst = this.con.prepareStatement(query);
			pst.setString(1,  user.getcNo());
			pst.setString(2, user.getcName());
			pst.setString(3,  user.getValidThrough());
			pst.setString(4, user.getCvv());
			pst.setDouble(5, user.getCreditBalance());		
			pst.setInt(6, Integer.parseInt(cNo));
			pst.execute();
			
			set = true;
			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		return set;
		
	}
	
	public List<User> getAllCards(int id) {
        List<User> user = new ArrayList<>();
        try {

            query = "select * from card where uId = ?";
            pst = this.con.prepareStatement(query);
            pst.setInt(1,  id);
            rs = pst.executeQuery();

            while (rs.next()) {
            	User row = new User();
                row.setId(rs.getInt("cId"));
                row.setcNo(rs.getString("cNo"));
                row.setcName(rs.getString("cName"));
                row.setValidThrough(rs.getString("validThrough"));
                row.setCvv(rs.getString("cvv"));
                row.setCreditBalance(rs.getDouble("cBal"));

                user.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return user;
    }
	
	public List<User> getAllAddress(int id) {
        List<User> user = new ArrayList<>();
        try {

            query = "select * from address where uId = ?";
            pst = this.con.prepareStatement(query);
            pst.setInt(1,  id);
            rs = pst.executeQuery();

            while (rs.next()) {
            	User row = new User();
                row.setId(rs.getInt("aId"));
                row.setAddress(rs.getString("address"));
                row.setCity(rs.getString("city"));
                row.setState(rs.getString("state"));
                row.setZip(rs.getString("zip"));
                

                user.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return user;
    }
	
	public boolean addressUpdate(User user, String address) {
		Boolean set = false;
		
		try {
			query = "UPDATE address SET address=?, city=?, state=?, zip=? WHERE address=?";
			pst = this.con.prepareStatement(query);
			//pst.setInt(5, Integer.parseInt(aId));
			pst.setString(1,  user.getAddress());
			pst.setString(2, user.getCity());
			pst.setString(3,  user.getState());
			pst.setString(4, user.getZip());
			pst.setString(5,  address);
			pst.execute();
			set = true;
			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		return set;
		
	}
	public boolean addressInsert(User user) {
		Boolean set = false;
		
		try {
			query = "INSERT INTO address(uId, address, city, state, zip) VALUES(?,?,?,?,?)";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, user.getId());
			pst.setString(2,  user.getAddress());
			pst.setString(3, user.getCity());
			pst.setString(4,  user.getState());
			pst.setString(5, user.getZip());
			pst.execute();
			
			set = true;
			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		return set;
		
	}
	
	
	
	
	
	

}
