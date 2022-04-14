package ecommerce.project.model;

public class Product {
	private int id;
	private String name;
	private String rating;
	private Double price;
	private String image;
	
	
	public Product(int id, String name, String rating, Double price, String image) {
		this.id = id;
		this.name = name;
		this.rating = rating;
		this.price = price;
		this.image = image;
		
		
	}
	
	
	public Product() {

	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

}
