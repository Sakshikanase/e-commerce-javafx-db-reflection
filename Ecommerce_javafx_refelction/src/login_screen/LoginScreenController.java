package login_screen;

import java.sql.ResultSet;
import java.sql.SQLException;

import Home_Screen.HomeScreen;
import Product.ProductScreen;
import common.DBUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginScreenController {
	@FXML
	TextField loginname;

	@FXML
	PasswordField password;

	public void loginbuttonclick() throws SQLException, Exception  {
		String name = loginname.getText();
		String pass = password.getText();

		if (validateLogin(name, pass)) {
			showAlert(Alert.AlertType.INFORMATION, "Login Successful", "Welcome!!! ");
			
			 new HomeScreen().show();
			
		} else {
			showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid username or password.");
		}
	}
	public boolean validateLogin(String loginname, String password) throws SQLException {

		String query = "SELECT First_name, Password FROM user WHERE First_name='" + loginname + "'AND Password= '"
				+ password + "'";

		ResultSet result = DBUtils.executeSelectQuery(query);
		return result.next();

	}

	private void showAlert(Alert.AlertType alertType, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setContentText(message);
		alert.showAndWait();

	}

}
