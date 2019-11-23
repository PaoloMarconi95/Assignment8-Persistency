package design.pattern;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	public String url;

	public void createNewDatabase(String fileName) {

		String url = "jdbc:sqlite:" + fileName;
		this.url = url;

		try (Connection conn = DriverManager.getConnection(url)) {
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("The driver name is " + meta.getDriverName());
				System.out.println("A new database has been created.");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

    public static void createUserTable(Database db) {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Users (\n"
                + "    id integer,\n"
                + "    name text ,\n"
                + "    address text ,\n"
                + "    password text ,\n"
                + "    bestfriend integer ,\n"
                + "    PRIMARY KEY(id),\n"
                + "    FOREIGN KEY(bestfriend) REFERENCES Users(id)\n"
                + ");";
        try (Connection conn = DriverManager.getConnection(db.url)){
            Statement stmt = conn.createStatement();
            // create a new table
            stmt.execute(sql);
            System.out.println("Tabella creata");
        } catch (SQLException e) {
        	System.out.println("Tabella non creata");
            System.out.println(e.getMessage());
        }
    }
}
