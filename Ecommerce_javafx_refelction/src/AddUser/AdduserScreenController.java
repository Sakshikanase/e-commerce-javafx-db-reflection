package AddUser;

import java.sql.SQLException;

import Product.ProductScreen;
import User.UserScreen;
import common.DBUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class AdduserScreenController {
	@FXML
	TextField firstname;

	@FXML
	TextField lastname;

	@FXML
	TextField age;

	@FXML
	TextField gender;

	@FXML
	TextField email;

	@FXML
	TextField password;

	@FXML
	TextField conpassword;

	@FXML
	Button back;

	@FXML
	Button submit;

	@FXML
	Label message;

	public void submitclick() {
		String firstnameField = firstname.getText();
		String lastnameField = lastname.getText();
		String ageField = age.getText();
		String genderField = gender.getText();
		String emailField = email.getText();
		String passwordField = password.getText();
		String conpasswordField = conpassword.getText();

		if (firstnameField.isEmpty() || lastnameField.isEmpty() || ageField.isEmpty() || genderField.isEmpty()
				|| emailField.isEmpty() || passwordField.isEmpty() || conpasswordField.isEmpty()) {
			message.setText("Please fill in all fields.");
			message.setTextFill(Color.RED);
			return;
		}
		if (adduserIntoDb(firstnameField, lastnameField, Integer.parseInt(ageField), genderField, emailField,
				passwordField)) {
//			ProductAddedMessage.setText("Product Added Sucessfully!!");
//			ProductAddedMessage.setTextFill(Color.GREEN);
			message.setText("Failed to add User!!");
			message.setTextFill(Color.RED);

		} else {
//			ProductAddedMessage.setText("Failed to add product!!");
//			ProductAddedMessage.setTextFill(Color.RED);
			message.setText("User Added Sucessfully!!");
			message.setTextFill(Color.GREEN);
			clearFields();
		}
	}

	public void backclick() throws Exception {
		 new ProductScreen().show();
	}

	private void clearFields() {
		firstname.clear();
		lastname.clear();
		age.clear();
		gender.clear();
		email.clear();
		password.clear();
		conpassword.clear();
	}

	public boolean adduserIntoDb(String firstname, String lastname, int age, String gender, String email,
			String password) {
		String query = "INSERT INTO user (First_name, last_name, age, gender, Email, Password) VALUES ( '" + firstname
				+ "','" + lastname + "'," + age + ",'" + gender + "', ' " + email + "','" + password + "')";

		boolean isInserted = false;
		try {
			isInserted = DBUtils.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isInserted;
	}

}
