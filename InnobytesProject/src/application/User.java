package application;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
	private String username;
	private String password;

	public User(String username, String password) {
		this.username = username;
		this.password = hashPassword(password);
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public boolean login() {
		return Database.validateUser(username, password);
	}

	public void register() {
		Database.saveUser(username, password);
	}

	private static String hashPassword(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hash = md.digest(password.getBytes());
			StringBuilder hexString = new StringBuilder();
			for (byte b : hash) {
				hexString.append(String.format("%02x", b));
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Error hashing password", e);
		}
	}
}
