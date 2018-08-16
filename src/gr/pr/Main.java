package gr.pr;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

	public static Consumer<Customer> printCustomerNameCosts =
			customer -> System.out.println(customer.getFirstName() + " " + customer.getLastName() + " " +
				customer.getProducts().stream()
						.mapToDouble(product -> product.getCost())
						.sum());
	public static Predicate<Customer> nonBlackListedCustomers = customer -> !customer.isBlackListed();
	public static Consumer<Customer> printCustomerNames = customer -> System.out.println(customer.getFirstName() + " " + customer.getLastName());

	public static void main(String[] args) {

		List<Customer> customers = new ArrayList<>();

		List<Product> products1 = new ArrayList<>();
		products1.add(new Product("ps4", 499.99));
		products1.add(new Product("makaronia", 3.99));
		products1.add(new Product("patates", 5.23));
		products1.add(new Product("pop corn", 1.2));
		products1.add(new Product("beers", 15));
		customers.add(new Customer("Panagiotis", "Ressos", 27, false, products1));


		List<Product> products2 = new ArrayList<>();
		products2.add(new Product("pc", 1699.99));
		products2.add(new Product("soul", 0));
		products2.add(new Product("beers", 300));
		customers.add(new Customer("Makis", "Kotsovos", 27, true, products2));

		List<Product> products3 = new ArrayList<>();
		products3.add(new Product("pc", 700));
		products3.add(new Product("Constantinople", 1453));
		products3.add(new Product("swords", 5000));
		products3.add(new Product("beers", 20));
		customers.add(new Customer("Angel Gabriel", "Pearl", 26, false, products3));

		List<Product> products4 = new ArrayList<>();
		products4.add(new Product("rainbow dust", 100));
		products4.add(new Product("loan", 500000));
		products4.add(new Product("patates", 100));
		customers.add(new Customer("Filippos", "Geeorgantas", 28, false, products4));

		List<Product> products5 = new ArrayList<>();
		products5.add(new Product("swords", 200));
		products5.add(new Product("laptop", 500));
		products5.add(new Product("makaronia", 100));
		customers.add(new Customer("Panagiota", "LykoFotia", 28, false, products5));

		printAllCustomersName(customers);
		System.out.println();
		printAllNonBlackListedCustomersName(customers);
		System.out.println();
		printAllCustomersNameAndCosts(customers);
		System.out.println();
		printAllCustomersNameAndCostsOver26AndNonBlackListed(customers);
		System.out.println();
		printAllCustomersNameAndCostsWithProduct(customers,"beers");
//		System.out.println();
//		printAllCustomersNameAndCostsSortedNoStreams(customers);
	}

	public static void printAllCustomersName(List<Customer> customers) {
		customers.stream()
				.forEach(printCustomerNames);
	}

	public static void printAllNonBlackListedCustomersName(List<Customer> customers) {
		customers.stream()
				.filter(nonBlackListedCustomers)
				.forEach(printCustomerNames);
	}

	public static void printAllCustomersNameAndCosts(List<Customer> customers) {
		customers.stream()
				.forEach(printCustomerNameCosts);
	}

	public static void printAllCustomersNameAndCostsOver26AndNonBlackListed(List<Customer> customers) {
		customers.stream()
				.filter(customer -> customer.getAge() > 26)
				.filter(nonBlackListedCustomers)
				.forEach(printCustomerNameCosts);
	}

	public static void printAllCustomersNameAndCostsWithProduct(List<Customer> customers, String productName) {
		customers.stream()
				.filter(customer -> customer.getProducts().stream()
						.filter(product -> productName.equals(product.getName()))
									.count() > 0)
				.forEach(printCustomerNameCosts);
	}
	/*

	public static void printAllCustomersNameAndCostsSorted(List<Customer> customers) {
		customers.stream()
				.forEach(printCustomerNameCosts
								.sorted((o1, o2) -> Double.compare(o1,o2))


				));
	}

	public static void printAllCustomersNameAndCostsSortedNoStreams(List<Customer> customers) {
		List<Double> tempList = new ArrayList<>();

		for (Customer customer : customers) {
			double customerSumCost = 0.0;
			for (Product product : customer.getProducts()) {
				customerSumCost += product.getCost();
			}
			tempList.add(customerSumCost);
		}
		Collections.sort(tempList);
		System.out.println(tempList);
	}
*/

}