package AddProduct;

import java.sql.SQLException;

import Product.ProductScreen;
import common.DBUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class AddproductScreenController {
	@FXML
	TextField id;

	@FXML
	TextField name;

	@FXML
	TextField quantity;

	@FXML
	TextField price;

	@FXML
	Button back;

	@FXML
	Button submit;

	@FXML
	Label message;

	public void submitclick()  {
		String ProductIdField = id.getText();
		String productNameField = name.getText();
		String productQuantityField = quantity.getText();
		String productPriceField = price.getText();

		if (productNameField.isEmpty() || productPriceField.isEmpty() || ProductIdField.isEmpty()
				|| productQuantityField.isEmpty()) {
			message.setText("Please fill in all fields.");
			message.setTextFill(Color.RED);
			return;
		}
		if (addProductIntoDb(Integer.parseInt(ProductIdField), productNameField, Integer.parseInt(productQuantityField),
				Integer.parseInt(productPriceField))) {
//			ProductAddedMessage.setText("Product Added Sucessfully!!");
//			ProductAddedMessage.setTextFill(Color.GREEN);
			message.setText("Failed to add product!!");
			message.setTextFill(Color.RED);
			
			
		} else {
//			ProductAddedMessage.setText("Failed to add product!!");
//			ProductAddedMessage.setTextFill(Color.RED);
			message.setText("Product Added Sucessfully!!");
			message.setTextFill(Color.GREEN);
			clearFields();
		}
	}
	public void backclick() throws Exception {
		
		 new ProductScreen().show();
	}


	private void clearFields() {
		id.clear();
		name.clear();
		quantity.clear();
		price.clear();
	}

	public boolean addProductIntoDb(int id, String name, int quantity, int price) {
		String query = "INSERT INTO product (product_id, product_name, quantity, price) VALUES ("
				+ id + ", '" + name + "', " + quantity + ", "
				+ price + ")";
        
        boolean isInserted = false;
        try {
            isInserted = DBUtils.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isInserted;
    }

}