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
			db.createNewDatabase("Database.db");
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

		try{
	        try {
				Class.forName("org.sqlite.JDBC");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			Connection conn = DriverManager.getConnection(url);
			if (conn != null) {
				conn.getMetaData();
				System.out.println("Connsessione stabilita");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

    public static void createUserTable(Database db) {
        // SQL statement for creating a new table
        String users = "CREATE TABLE IF NOT EXISTS Users(\n"
                + "    id text,\n"
                + "    name text ,\n"
                + "    address text ,\n"
                + "    password text ,\n"
                + "    bestfriend text ,\n"
                + "    PRIMARY KEY(id),\n"
                + "    FOREIGN KEY(bestfriend) REFERENCES Users(id) ON DELETE SET NULL,\n"
                + "    FOREIGN KEY(address) REFERENCES Address(name) ON DELETE SET NULL);";
        
        String address = "CREATE TABLE IF NOT EXISTS Address(\n"
                + "    name text,\n"
                + "    PRIMARY KEY(name) );";
        		
        try (Connection conn = DriverManager.getConnection(db.url)){
            Statement stmt = conn.createStatement();
            // create a new table
            stmt.execute("PRAGMA foreign_keys = ON");
            stmt.execute(users);
            System.out.println("Ho creato " + "\n" + users);
            System.out.println("\nSto per creare " + "\n" + address);
            stmt.execute(address);
            System.out.println("Tabella Creata");
        } catch (SQLException e) {
            System.out.println("Errore nella creazione");
            System.out.println(e.getMessage());
        }
    }
}
