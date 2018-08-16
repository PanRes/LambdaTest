package gr.pr;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private String firstName;
	private String lastName;
	private int age;
	private boolean blackListed;
	private List<Product> products;

	public Customer() {
		products = new ArrayList<>();
	}

	public Customer(String firstName, String lastName, int age, boolean blackListed, List<Product> products) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.blackListed = blackListed;
		this.products = products;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBlackListed() {
		return blackListed;
	}

	public void setBlackListed(boolean blackListed) {
		this.blackListed = blackListed;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void addProduct(Product product){
		this.products.add(product);
	}
}
