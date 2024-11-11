package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	private static final String URL = "jdbc:postgresql://localhost:5432/"; // Use "jdbc:mysql://localhost:3306/quiz_app" for MySQL
	private static final String USER = "postgres";
	private static final String PASSWORD = "postgres";

	public static Connection connect() {
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			System.out.println("Database connection failed: " + e.getMessage());
			return null;
		}
	}

	public static boolean validateUser(String username, String hashedPassword) {
		try (Connection conn = connect()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Users WHERE username = ? AND password = ?");
			stmt.setString(1, username);
			stmt.setString(2, hashedPassword);
			ResultSet rs = stmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			System.out.println("Error validating user: " + e.getMessage());
			return false;
		}
	}

	public static void saveUser(String username, String hashedPassword) {
		try (Connection conn = connect()) {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO Users (username, password) VALUES (?, ?)");
			stmt.setString(1, username);
			stmt.setString(2, hashedPassword);
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error saving user: " + e.getMessage());
		}
	}
}
