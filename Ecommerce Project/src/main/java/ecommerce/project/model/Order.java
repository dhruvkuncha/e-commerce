package ecommerce.project.model;

public class Order extends Product{
	private int orderId;
	private int uid;
	private int quantity;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String date;
	
	
	
	
	public Order() {
		
	}

	public Order(int orderId, int uid, int quantity,
			String data) {
		this.orderId = orderId;
		this.uid = uid;
		this.quantity = quantity;
		this.date = data;
	}
	
	public Order(int uid, int quantity,
			String data) {
		this.uid = uid;
		this.quantity = quantity;
		this.date = data;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	


	
	
	
	

}
