package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
	@SuppressWarnings("unused")
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Online Quiz Application");

		// Login Form
		GridPane loginGrid = new GridPane();
		Label usernameLabel = new Label("Username:");
		TextField usernameField = new TextField();
		Label passwordLabel = new Label("Password:");
		PasswordField passwordField = new PasswordField();
		Button loginButton = new Button("Login");

		loginGrid.add(usernameLabel, 0, 0);
		loginGrid.add(usernameField, 1, 0);
		loginGrid.add(passwordLabel, 0, 1);
		loginGrid.add(passwordField, 1, 1);
		loginGrid.add(loginButton, 1, 2);

		loginButton.setOnAction(e -> {
			String username = usernameField.getText();
			String password = passwordField.getText();
			User user = new User(username, password);

			if (user.login()) {
				System.out.println("Login Successful");
				// Proceed to quiz selection screen
			} else {
				System.out.println("Invalid credentials");
			}
		});

		Scene loginScene = new Scene(loginGrid, 300, 200);
		primaryStage.setScene(loginScene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
