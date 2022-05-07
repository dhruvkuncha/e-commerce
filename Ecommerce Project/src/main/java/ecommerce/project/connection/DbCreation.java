package ecommerce.project.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ecommerce.project.model.User;

public class DbCreation {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;

	public DbCreation(Connection con) {
		this.con = con;
	}

	public void main(String[] args) {

		try {
			query = "create database e_commerce";
			pst = this.con.prepareStatement(query);
			rs = pst.executeQuery();

			query = "CREATE TABLE `users` (\n" + "  `id` int NOT NULL AUTO_INCREMENT,\n"
					+ "  `email` varchar(250) NOT NULL,\n" + "  `password` varchar(250) NOT NULL,\n"
					+ "  `firstname` varchar(250) NOT NULL,\n" + "  `lastname` varchar(250) NOT NULL,\n"
					+ "  PRIMARY KEY (`id`),\n" + "  UNIQUE KEY `email_UNIQUE` (`email`)\n" + ")";
			pst = this.con.prepareStatement(query);
			rs = pst.executeQuery();

			query = "CREATE TABLE `products` (\n" + "  `id` int NOT NULL AUTO_INCREMENT,\n"
					+ "  `name` varchar(450) NOT NULL,\n" + "  `rating` varchar(450) NOT NULL,\n"
					+ "  `price` double NOT NULL,\n" + "  `image` varchar(450) NOT NULL,\n" + "  PRIMARY KEY (`id`)\n"
					+ ")";
			pst = this.con.prepareStatement(query);
			rs = pst.executeQuery();

			query = "CREATE TABLE orders (\n" + "  o_id int NOT NULL AUTO_INCREMENT,\n" + "  p_id int NOT NULL,\n"
					+ "  u_id int NOT NULL,\n" + "  quantity int NOT NULL,\n" + "  aId int not null,\n"
					+ "  cId int not null,\n" + "  date varchar(450) NOT NULL,\n" + "  PRIMARY KEY (o_id),\n"
					+ "  foreign key (aId) references address(aId),\n" + "  foreign key (cId) references card(cId)\n"
					+ ");";
			pst = this.con.prepareStatement(query);
			rs = pst.executeQuery();

			query = "create table card (\n" + "cId int not null auto_increment primary key,\n" + "uId int not null,\n"
					+ "cNo varchar(458) not null,\n" + "cName varchar(458) not null,\n"
					+ "validThrough varchar(458) not null,\n" + "cvv varchar(458) not null,\n"
					+ "cBal double not null,\n" + "foreign key (uId) references users(id)\n" + ");";
			pst = this.con.prepareStatement(query);
			rs = pst.executeQuery();

			query = "create table address (\n" + "aId int not null auto_increment primary key,\n"
					+ "uId int not null,\n" + "address varchar(458) not null,\n" + "city varchar(458) not null,\n"
					+ "state varchar(458) not null,\n" + "zip varchar(458) not null,\n"
					+ "foreign key (uId) references users(id)\n" + ");";
			pst = this.con.prepareStatement(query);
			rs = pst.executeQuery();

			query = "INSERT INTO users(email, password, firstname, lastname) VALUES(test@mail.com,0000,Test,Project)";
			pst = this.con.prepareStatement(query);
			rs = pst.executeQuery();

			query = "INSERT INTO products(name,rating,price,image)\n"
					+ "VALUES ('The 4-Hour Workweek','&#11088&#11088&#11088&#11088',13.39,'https://images-na.ssl-images-amazon.com/images/I/51I2EIRF44L._SX329_BO1,204,203,200_.jpg'),(2,'Mueller Ultra Bullet Personal Blender','&#11088&#11088&#11088',21.99,'https://m.media-amazon.com/images/I/81NOEKcr4aL._AC_SX679_.jpg'),(3,'Apple MacBook Pro','&#11088&#11088&#11088&#11088',1949.0,'https://m.media-amazon.com/images/I/61vFO3R5UNL._AC_SX679_.jpg'),(4,'Leather Desk Pad Protector','&#11088&#11088',10.99,'https://m.media-amazon.com/images/I/71GW5oNYpqS._AC_SX679_.jpg'),(5,'DualShock 4 Wireless Controller for PlayStation 4','&#11088&#11088&#11088&#11088&#11088',59.99,'https://m.media-amazon.com/images/I/61IG46p-yHL._SX522_.jpg'),(6,'Kindle Paperwhite (8 GB)','&#11088&#11088&#11088',139.99,'https://m.media-amazon.com/images/I/51QCk82iGcL._AC_SX679_.jpg');\n"
					+ "";
			pst = this.con.prepareStatement(query);
			rs = pst.executeQuery();

			query = "\n"
					+ "INSERT INTO products(name,rating,price,image) VALUES ('Kasa Indoor Pan/Tilt Smart Security Camera','&#11088&#11088&#11088&',200.49,'https://images-na.ssl-images-amazon.com/images/I/51lGcD26GoL._AC_UL675_SR675,480_.jpg'),(\"Under Armour Men's Blitzing 3.0 Cap\",'&#11088&#11088&#11088&#11088',49.99,'https://images-na.ssl-images-amazon.com/images/I/91owaR5pNKS._AC_UL675_SR675,480_.jpg'),('Echo Dot (4th Gen, 2020 release)','&#11088&#11088&',39.99,'https://images-na.ssl-images-amazon.com/images/I/51cGlUCK5WL._AC_UL675_SR675,480_.jpg'),('Fire TV Stick 4K','&#11088&#11088&#11088',15.99,'https://images-na.ssl-images-amazon.com/images/I/41XTOfFgUqL._AC_UL675_SR675,480_.jpg'),('2021 Apple 10.2-inch iPad','&#11088&#11088&#11088&#11088&#11088',379.99,'https://images-na.ssl-images-amazon.com/images/I/61NGnpjoRDL._AC_UL675_SR675,480_.jpg'),('Fitbit Versa 2 Health and Fitness Smartwatch','&#11088&#11088&#11088',259.99,'https://images-na.ssl-images-amazon.com/images/I/51rGnBQ3dsL._AC_UL675_SR675,480_.jpg');";
			pst = this.con.prepareStatement(query);
			rs = pst.executeQuery();
		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}

	}

}
