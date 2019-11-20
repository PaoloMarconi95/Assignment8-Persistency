package design.pattern;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {

	public Connection conn;

	public void createNewDatabase(String fileName) {

		String url = "jdbc:sqlite:" + fileName;

		try (Connection conn = DriverManager.getConnection(url)) {
			if (conn != null) {
				this.conn = conn;
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("The driver name is " + meta.getDriverName());
				System.out.println("A new database has been created.");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void createNewTable(Database db) {

	}

	public ArrayList<String> doQuery(String query) {
		ArrayList<String> result = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			//ResultSet rs = stmt.executeQuery("SELECT * FROM ACTORS LIMIT 1;");
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				result.add(rs.getString("name"));

			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

}
