package fall24.hsf301.slot1.controller;

import java.io.IOException;

import fall24.hsf301.slot1.pojo.Account;
import fall24.hsf301.slot1.service.AccountService;
import fall24.hsf301.slot1.service.IAccountService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	private IAccountService accountService;
	private String hibernateConfig = "hibernate.cfg.xml";

	public LoginController() {
		accountService = new AccountService(hibernateConfig);
	}

	@FXML
	private TextField txtUserName;

	@FXML
	private PasswordField txtPassword;

	@FXML
	public void closeLoginForm() {
//		Platform.exit();
		System.exit(0);
	}

	@FXML
	public void btnloginOnAction(ActionEvent e) throws IOException {
		Account account = accountService.findByUserName(txtUserName.getText());
		
		if (account == null) {
			loginFailAlert();
		}
		
		if (account.getPassword().equals(txtPassword.getText())) {
//			((Stage) ((Node) e.getSource()).getScene().getWindow()).hide();
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxgui/StudentManagementGUI.fxml"));
//			Parent root = loader.load();
//			StudentManagementController controller = loader.getController();
//
//			controller.setRole(account.getRole());
//			controller.setAccount(account);
//			Stage primaryStage = new Stage();
//
//			primaryStage.setScene(new Scene(root));
//			primaryStage.setResizable(false);
//			primaryStage.show();
			
			((Stage) ((Node) e.getSource()).getScene().getWindow()).hide();

		    FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxgui/StudentManagementGUI.fxml"));
		    Parent root = loader.load();

		    StudentManagementController controller = loader.getController();
		    controller.setRole(account.getRole());
		    controller.setAccount(account);

		    Stage primaryStage = new Stage();
		    Scene scene = new Scene(root);

		    // Add the CSS file to the new scene
		    scene.getStylesheets().add(getClass().getResource("../fxgui/application.css").toExternalForm());

		    primaryStage.setScene(scene);
		    primaryStage.setResizable(false);
		    primaryStage.show();
		} else {
			loginFailAlert();
		}
	}
	
	private void loginFailAlert() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText(null);
		alert.setContentText("Incorrect username or password");
		alert.show();
	}

}
