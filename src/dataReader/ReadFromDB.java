package dataReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadFromDB extends DataReader {

	private Connection conn;
	private String server = "127.0.0.1:5432";
	private String dbName = "postgres";
	private String userName = "postgres";
	private String password = "1234";
	private String url = "jdbc:postgresql://" + server + "/" + dbName + "";

	public Connection getConnection() {
		return conn;
	}

	@Override
	public void connect() {
		try {
			conn = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public ResultSet executeQuery(String query) {
		try {
			return conn.createStatement().executeQuery(query);
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
	}

}
