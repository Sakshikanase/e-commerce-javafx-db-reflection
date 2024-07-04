package Home_Screen;

import java.sql.ResultSet;
import java.sql.SQLException;

import Product.ProductScreen;
import User.UserScreen;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import login_screen.LoginScreen;

public class HomeScreenController {
	@FXML
	Button productmanagement;

	@FXML
	Button usermanagement;

	@FXML
	Button logoutclick;

	

	public void productmanagementclick() throws Exception {
		 new ProductScreen().show();

	}

	public void usermanagementclick() throws Exception {
		 new UserScreen().show();
	}

	public void logoutclick()  {
		new LoginScreen().show();
		
	}

}
