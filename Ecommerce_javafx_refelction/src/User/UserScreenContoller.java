package User;

import AddUser.AdduserScreen;
import Home_Screen.HomeScreen;
import Product.ProductScreen;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class UserScreenContoller {
	@FXML
	Button adduser;

	@FXML
	Button deleteuser;

	@FXML
	Button updateuser;
	
	@FXML
	Button searchuser;
	
	@FXML
	Button viewuser;
	
	@FXML
	Button back;


	public void adduserclick() throws Exception {
		new AdduserScreen().show();

	}

	public void deleteuserclick() {
		System.out.println("Welcome to User Management");

	}

	public void searchuserclick() {
		System.out.println("  logout");

	}
	public void viewuserclick() {
		System.out.println("  logout");

	}

	public void updateuserclick() {
		System.out.println("  logout");

	}
	
	public void backclick() throws Exception {
		new HomeScreen().show();

	}


}
