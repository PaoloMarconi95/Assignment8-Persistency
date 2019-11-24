package design.pattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {

	private String id;
	private String name;
	private String address;
	private String password;
	private String bestfriend;

	private final static String selectWhere = "SELECT * " + "FROM Users WHERE ";
	private final static String insert = "INSERT INTO Users(Id, name, address, password, bestfriend) " + "VALUES(";
	private final static String delete = "DELETE FROM Users WHERE id == ";
    private final static String update = "UPDATE Users SET ";

	public User(String id, String name, String address, String password, String bestfriend) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.password = password;
		this.bestfriend = bestfriend;
	}

	// Getters
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPassword() {
		return password;
	}

	public String getBestfriend() {
		return bestfriend;
	}

	// Setters
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setBestfriend(String bestfriend) {
		this.bestfriend = bestfriend;
	}

	public static User findById(String id, Database db) {
		String query = selectWhere + "id == \"" + id + "\" ;";
		return find(query, db);
	}

	public static User findByAddress(String address, Database db) {
		String query = selectWhere + "address == \"" + address + "\" ;";
		return find(query, db);
	}

	public static User findByName(String name, Database db) {
		String query = selectWhere + "name == \"" + name + "\" ;";
		return find(query, db);
	}

	public static User find(String query, Database db) {
		try (Connection conn = DriverManager.getConnection(db.url)){
			Statement stmt = conn.createStatement();
			System.out.println("sto per eseguire :\n" + query);
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				User user = new User(rs.getString("id"),
						rs.getString("name"),
						rs.getString("address"),
						rs.getString("password"),
						rs.getString("bestfriend"));
				rs.close();
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void insert(User user, Database db) {
		try (Connection conn = DriverManager.getConnection(db.url)) {
			String query = insert +
					"\"" + user.getId() + "\", " +
					"\"" + user.getName() + "\", " + 
					"\"" + user.getAddress()	+ "\", " +
					"\"" + user.getPassword() + "\", " +
					"\"" + user.getBestfriend() + "\"); ";
			
			
        	Statement stmt1 = conn.createStatement();
        	stmt1.execute("PRAGMA foreign_keys = ON");
			
			
			System.out.println("sto per eseguire :\n" + query);
			PreparedStatement stmt = conn.prepareStatement(query);			
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
    public static boolean remove(User user, Database db) { 
        try (Connection conn = DriverManager.getConnection(db.url)){
        	String query = delete + "\"" + user.getId() + "\" ;";
        	System.out.println("sto per eseguire :\n" + query);
        	
        	
        	Statement stmt = conn.createStatement();
        	stmt.execute("PRAGMA foreign_keys = ON");
        	
        	
        	PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public static void update(String id, String[] param, Database db) { 
        try (Connection conn = DriverManager.getConnection(db.url)){  
        	String query = update + 
        			" name = \"" + param[0] + "\"," + 
        			" address = \"" + param[1] + "\"," + 
        			" password = \"" + param[2] + "\"," + 
        			" bestfriend = \"" + param[3] + "\"" + 
        			" WHERE id == \"" + id + "\" ;";     
        	System.out.println("sto per eseguire :\n" + query);
        	
        	
        	Statement stmt = conn.createStatement();
        	stmt.execute("PRAGMA foreign_keys = ON");
        	
        	
        	PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public boolean equals(User user2) {
    	if(this.getId().equals(user2.getId()) &&
    			this.getAddress().equals(user2.getAddress()) &&
    			this.getName().equals(user2.getName()) &&
    			this.getPassword().equals(user2.getPassword()) &&
    			this.getBestfriend().equals(user2.getBestfriend())) {
    		return true;
    	}
    	else {
    		return false;
    	}
    	
    }

}
