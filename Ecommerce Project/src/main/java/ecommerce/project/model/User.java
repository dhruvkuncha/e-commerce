package ecommerce.project.model;

public class User {
	private int id;
	private String firstname;
	private String lastname;
	private String username;
	private String email;
	private String password;
	private int aId;
	private String address;
	private String city;
	private String state;
	private String zip;
	private int cId;
	private String cNo;
	private String cName;
	private String validThrough;
	private String cvv;
	private double creditBalance;

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return username;
	}


	public void setName(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public User() {
	}


	public User(String firstname, String lastname, String email, String password) {
		this.firstname = firstname;
		this.lastname = lastname;
		
		this.email = email;
		this.password = password;
		
	}
	public User(int id,/* int cId,*/ String cNo, String cName, String validThrough, String cvv, double creditBalance) {
		this.id = id;
		//this.cId = cId;
		this.cNo = cNo;
		this.cName = cName;
		this.validThrough = validThrough;
		this.cvv = cvv;
		this.creditBalance = creditBalance;
		
	}
	
	 public User(int id, String address, String city, String state, String zip) {
	        this.id = id;
	        this.address = address;
			this.city = city;
			this.state = state;
			this.zip = zip;
	    }


	public double getCreditBalance() {
		return creditBalance;
	}


	public void setCreditBalance(double creditBalance) {
		this.creditBalance = creditBalance;
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


	public int getcId() {
		return cId;
	}


	public void setcId(int cId) {
		this.cId = cId;
	}


	public String getcNo() {
		return cNo;
	}


	public void setcNo(String cNo) {
		this.cNo = cNo;
	}


	public String getValidThrough() {
		return validThrough;
	}


	public void setValidThrough(String validThrough) {
		this.validThrough = validThrough;
	}


	public String getCvv() {
		return cvv;
	}


	public void setCvv(String cvv) {
		this.cvv = cvv;
	}


	public String getcName() {
		return cName;
	}


	public void setcName(String cName) {
		this.cName = cName;
	}


	public int getaId() {
		return aId;
	}


	public void setaId(int aId) {
		this.aId = aId;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
