package design.pattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	public String url;
	
	private static Database instance = null;
	
	
	// Singleton
	public static Database getInstance() {
		if(instance == null) {
			Database db = new Database();
			db.createNewDatabase("Usersdb.db");
			Database.createUserTable(db);
			instance = db;
			return db;
		}
		else {
			return instance;
		}
	}

	public void createNewDatabase(String fileName) {

		String url = "jdbc:sqlite:" + fileName;
		this.url = url;

		try (Connection conn = DriverManager.getConnection(url)) {
			if (conn != null) {
				conn.getMetaData();
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

    public static void createUserTable(Database db) {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Users(\n"
                + "    id text,\n"
                + "    name text ,\n"
                + "    address text ,\n"
                + "    password text ,\n"
                + "    bestfriend text ,\n"
                + "    PRIMARY KEY(id),\n"
                + "    FOREIGN KEY(bestfriend) REFERENCES Users(id) ON DELETE SET NULL\n"
                + ");";
        try (Connection conn = DriverManager.getConnection(db.url)){
            Statement stmt = conn.createStatement();
            // create a new table
            stmt.execute("PRAGMA foreign_keys = ON");
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
