package ecommerce.project.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {
	private static Connection connection = null;
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		String url = "jdbc:mysql://localhost:3306/e_commerce?";
		String user = "root";
		String password = "redhat@1234";
        if(connection == null){
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection(url + "user="+user+"&password="+password);
            System.out.print("connected");
        }
        return connection;
    }
}