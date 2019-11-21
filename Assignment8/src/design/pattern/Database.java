package design.pattern;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
        String sql = "CREATE TABLE IF NOT EXISTS users (\n"
                + "    id text,\n"
                + "    name text ,\n"
                + "    bestfriend_id text ,\n"
                + "    PRIMARY KEY(id),\n"
                + "    FOREIGN KEY(bestfriend_id) REFERENCES users(id)\n"
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

	public ArrayList<String> doQuery(String query) {
		ArrayList<String> result = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(this.url)){
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
