package ecommerce.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ecommerce.project.model.Order;
import ecommerce.project.model.Product;
import ecommerce.project.model.User;

public class OrderDao {
	
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	
	public OrderDao(Connection con) {
		this.con = con;
	}
	
	public boolean insertOrder(Order model) {
		
		boolean result = false;
		
		try {
			query = "insert into orders(p_id, u_id, quantity, aId, cId, date) values(?,?,?,?,?,?)";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, model.getId());
			pst.setInt(2, model.getUid());
			pst.setInt(3, model.getQuantity());
			pst.setInt(4, model.getaId());
			pst.setInt(5, model.getcId());
			pst.setString(6, model.getDate());
			pst.executeUpdate();
			result = true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public User getAddress(String address) {
		User row = null;
		
		try {
			query = "select aId from address where address=?";
			pst = this.con.prepareStatement(query);
			pst.setString(1,address);
			rs = pst.executeQuery();
			while(rs.next()) {
				row = new User();
				row.setaId(rs.getInt("aId"));;
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return row;
	}
	public User getCard(int cNo) {
		User row = null;
		
		try {
			query = "select cId from card where cNo=?";
			pst = this.con.prepareStatement(query);
			pst.setInt(1,cNo);
			rs = pst.executeQuery();
			while(rs.next()) {
				row = new User();
				row.setcId(rs.getInt("cId"));
				
				
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return row;
	}
	
	
	public List<Order> userOrders(int id){
		List<Order> list = new ArrayList<>();
		
		try {
			query = "select * from orders where u_id=? order by orders.o_id desc";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Order order = new Order();
				ProductDao productDao = new ProductDao(this.con);
				int pId = rs.getInt("p_id");
				
				Product product = productDao.getSingleProduct(pId);
				order.setOrderId(rs.getInt("o_id"));
				order.setId(pId);
				order.setName(product.getName());
				order.setRating(product.getRating());
				order.setPrice(product.getPrice()*rs.getInt("quantity"));
				order.setQuantity(rs.getInt("quantity"));
				order.setDate(rs.getString("date"));
				list.add(order);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return list;
	}
	public void cancelOrder(int id) {
       
        try {
            query = "delete from orders where o_id=?";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            pst.execute();
          
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
       
    }
	

}
