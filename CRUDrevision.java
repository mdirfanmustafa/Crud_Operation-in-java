import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Products {
	private int prodId;
	private String prodName;
	private double prodPrice;

	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public double getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}

	public int getProdId() {
		return prodId;
	}

	public Products(int prodId, String prodName, double prodPrice) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
	}

	@Override
	public String toString() {
		return "[prodId=" + prodId + ", prodName=" + prodName + ", prodPrice=" + prodPrice + "]";
	}

	@Override
	public boolean equals(Object o) {
		Products p = (Products) o; // Downcasting
		if (this.prodId == p.prodId && this.prodName.equals(p.prodName) && this.prodPrice == p.prodPrice) {
			return true;
		} else {
			return false;
		}
	}

}

class ProductOperations1 {
	ArrayList<Products> productList = new ArrayList<>();
	Scanner scan = new Scanner(System.in);

	public boolean isCartEmpty() {
		if (productList.isEmpty()) {
			System.out.println("Your cart is empty....Please enter 1 to add items");
			return true;
		}
		return false;

	}

	public void addProduct() {
		System.out.println("Enter the product ID");
		int pid = scan.nextInt();
		System.out.println("Enter the product name");
		String name = scan.next();
		System.out.println("Enter the product price");
		double price = scan.nextDouble();
		Products product = new Products(pid, name, price);
		productList.add(product);
		System.out.println("product successfully  saved....");
	}

	public void printProducts() {
		if (!isCartEmpty()) {
			productList.forEach(System.out::println);
		}
	}

	public void searchProducts() {
		if (!isCartEmpty()) {
			System.out.println("Enter the product ID");
			int pid1 = scan.nextInt();
			System.out.println("Enter the product name");
			String name1 = scan.next();
			System.out.println("Enter the product price");
			double price1 = scan.nextDouble();
			Products product5 = new Products(pid1, name1, price1);
			int index = productList.indexOf(product5);

			if (index >= 0) {
				System.out.println("Found..");
			} else {
				System.out.println("not found..");
			}
		}
	}

	public void deleteproduct() {
		if (!isCartEmpty()) {
			System.out.println("Enter the product ID");
			int pid1 = scan.nextInt();
			System.out.println("Enter the product name");
			String name1 = scan.next();
			System.out.println("Enter the product price");
			double price1 = scan.nextDouble();
			Products product6 = new Products(pid1, name1, price1);
			int index = productList.indexOf(product6);
			productList.remove(index);
		}
	}

	public void updateProduct() {
		if (!isCartEmpty()) {
			System.out.println("Enter the product ID");
			int pid1 = scan.nextInt();
			System.out.println("Enter the product name");
			String name1 = scan.next();
			System.out.println("Enter the product price");
			double price1 = scan.nextDouble();
			Products product7 = new Products(pid1, name1, price1);
			int index = productList.indexOf(product7);
			System.out.println("set the new product ID");
			int pid2 = scan.nextInt();
			System.out.println("set the new  product name");
			String name2 = scan.next();
			System.out.println("set the new product price");
			double price2 = scan.nextDouble();
			Products product8 = new Products(pid2, name2, price2);
			productList.set(index, product8);
		}
	}

	public void sortByNameProduct() {
		Collections.sort(productList, (one, two) -> one.getProdName().compareTo(two.getProdName()));

	}

	public void sortByPriceProduct() {
		Collections.sort(productList,
				(one, two) -> ((Double) one.getProdPrice()).compareTo((Double) two.getProdPrice()));

	}

	public void sortByIdProduct() {
		Collections.sort(productList, (one, two) -> ((Integer) one.getProdId()).compareTo((Integer) two.getProdId()));

	}
}

public class CRUDrevision {

	public static void main(String[] args) {
		ProductOperations1 prodsOpr = new ProductOperations1();
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("1. Add A New Product");
			System.out.println("2. Search A Product");
			System.out.println("3. Print All Products");
			System.out.println("4. Delete a Product");
			System.out.println("5. Update a Product");
			System.out.println("6. Sort a Product By Price");
			System.out.println("7. Sort a Product by Name");
			System.out.println("8. Sort a Product by id");
			System.out.println("Press 0 to Quit");
			System.out.println("Enter Your Choice");
			int choice = scan.nextInt();
			switch (choice) {
			case 0:
				System.out.println("System is Closing...");
				System.exit(1);
				break;
			case 1:
				prodsOpr.addProduct();
				break;
			case 2:
				prodsOpr.searchProducts();
				break;
			case 3:
				prodsOpr.printProducts();
				break;
			case 4:
				prodsOpr.deleteproduct();
				break;
			case 5:
				prodsOpr.updateProduct();
				break;
			case 6:
				prodsOpr.sortByPriceProduct();
				break;
			case 7:
				prodsOpr.sortByNameProduct();
				break;
			case 8:
				prodsOpr.sortByIdProduct();
				break;
			default:
				System.out.println("Wrong Choice...Try again");
			}
		}
	}
}