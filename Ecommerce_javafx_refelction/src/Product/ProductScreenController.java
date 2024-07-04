package Product;


import AddProduct.AddproductScreen;
import Home_Screen.HomeScreen;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ProductScreenController {
	@FXML
	Button addproduct;

	@FXML
	Button deleteproduct;

	@FXML
	Button updateproduct;

	@FXML
	Button searchproduct;

	@FXML
	Button viewproduct;

	@FXML
	Button back;

	public void addproductclick() throws Exception {
		
		new AddproductScreen().show();

	}

	public void deleteproductclick() {
		System.out.println("Welcome to User Management");

	}

	public void searchproductclick() {
		System.out.println("  logout");

	}

	public void viewproductclick() {
		System.out.println("  logout");

	}

	public void updateproductclick() {
		System.out.println("  logout");
		
		
	}

	public void backclick() throws Exception {
		new HomeScreen().show();
	}

}
