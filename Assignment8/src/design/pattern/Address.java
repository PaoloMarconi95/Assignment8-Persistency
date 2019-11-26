package design.pattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Address {

	private String name;

	private final static String selectWhere = "SELECT * " + "FROM Address WHERE ";
	private final static String insert = "INSERT INTO Address(name) " + "VALUES(";
	private final static String delete = "DELETE FROM Address WHERE id == ";
    private final static String update = "UPDATE Address SET ";

	public Address(String name) {
		this.name = name;
	}

	// Getters
	public String getName() {
		return name;
	}

	// Setters
	public void setName(String name) {
		this.name = name;
	}


	public static Address findByName(String name, Database db) {
		String query = selectWhere + "name == \"" + name + "\" ;";
		return find(query, db);
	}


	private static Address find(String query, Database db) {
		try (Connection conn = DriverManager.getConnection(db.url)){
			Statement stmt = conn.createStatement();
			System.out.println("Sto per eseguire \n" + query);
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				Address user = new Address(rs.getString("name"));
				rs.close();
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean insert(Address address, Database db) {		
		try (Connection conn = DriverManager.getConnection(db.url)) {
			String query = insert + "\"" + address.getName() + "\"); ";
        	Statement stmt1 = conn.createStatement();
        	stmt1.execute("PRAGMA foreign_keys = ON");
			System.out.println("Sto per eseguire \n" + query);
			PreparedStatement stmt = conn.prepareStatement(query);			
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
    public static boolean remove(Address address, Database db) { 
        try (Connection conn = DriverManager.getConnection(db.url)){
        	String query = delete + "\"" + address.getName() + "\" ;";
        	Statement stmt = conn.createStatement();
        	stmt.execute("PRAGMA foreign_keys = ON");
			System.out.println("Sto per eseguire \n" + query);
        	PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public static void update(String name, Database db) {
    	if(Address.findByName(name, db) != null) {
    		try (Connection conn = DriverManager.getConnection(db.url)){
    			String query = update + " name = \"" + name + "\" ;";     
    			Statement stmt = conn.createStatement();
    			stmt.execute("PRAGMA foreign_keys = ON");
    			System.out.println("Sto per eseguire \n" + query);
    			PreparedStatement pstmt = conn.prepareStatement(query);
    			pstmt.executeUpdate();
    		} catch (SQLException e) {
    			System.out.println(e.getMessage());
    		}
    	}
    }

}