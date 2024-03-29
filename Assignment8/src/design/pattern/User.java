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
	private Address address;
	private String password;
	private String bestfriend;

	private final static String selectWhere = "SELECT * " + "FROM Users WHERE ";
	private final static String insert = "INSERT INTO Users(Id, name, address, password, bestfriend) " + "VALUES(";
	private final static String delete = "DELETE FROM Users WHERE id == ";
    private final static String update = "UPDATE Users SET ";

	public User(String id, String name, Address address, String password, String bestfriend) {
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

	public Address getAddress() {
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

	public void setAddress(Address address) {
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
	
	public static User findByBestFriend(String bestfriend, Database db) {
		String query = selectWhere + "bestfriend == \"" + bestfriend + "\" ;";
		return find(query, db);
	}

	private static User find(String query, Database db) {
		try (Connection conn = DriverManager.getConnection(db.url)){
			Statement stmt = conn.createStatement();
			System.out.println("Sto per eseguire \n" + query);
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				Address address = Address.findByName(rs.getString("address"), db);
				User user = new User(rs.getString("id"),
						rs.getString("name"),
						address,
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

	public static boolean insert(User user, Database db) {
		// SQLite, "null" != null
		String bestfriend ;
		if(user.getBestfriend().equals("")) {
			bestfriend = null;
		}
		else {
			bestfriend = "\"" + user.getBestfriend() + "\"";
		}
		try (Connection conn = DriverManager.getConnection(db.url)) {
			Address address = Address.findByName(user.getAddress().getName(), db);
			if(address == null) {
			address = new Address(user.getAddress().getName());
			Address.insert(address, db);
			}
			else {
				// use the already found value for address 
			}
			String query = insert +
					"\"" + user.getId() + "\", " +
					"\"" + user.getName() + "\", " + 
					"\"" + address.getName() + "\", " +
					"\"" + user.getPassword() + "\", " +
					bestfriend + "); ";
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
	
    public static boolean remove(User user, Database db) { 
        try (Connection conn = DriverManager.getConnection(db.url)){
        	String query = delete + "\"" + user.getId() + "\" ;";
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
    
    public static void update(String id, String[] param, Database db) {
    	Address address = Address.findByName(param[1], db);
    	if(address == null) {
    		address = new Address(param[1]);
    		Address.insert(address, db);
    	}
    	if(param[3] != null) {
    		param[3] = "\"" + param[3] + "\"";
    	}
    	try (Connection conn = DriverManager.getConnection(db.url)){  
    			String query = update + 
    					" id = \"" + param[4] + "\"," + 
    					" name = \"" + param[0] + "\"," + 
    					" address = \"" + address.getName() + "\"," + 
    					" password = \"" + param[2] + "\"," + 
    					" bestfriend = " + param[3] + "" + 
    					" WHERE id == \"" + id + "\" ;";     
    			Statement stmt = conn.createStatement();
    			stmt.execute("PRAGMA foreign_keys = ON");
    			System.out.println("Sto per eseguire \n" + query);
    			PreparedStatement pstmt = conn.prepareStatement(query);
    			pstmt.executeUpdate();
    		} catch (SQLException e) {
    			System.out.println(e.getMessage());
    		}
    }
    
    
	public static User lookForPassword(String name, String password, Database db) {
		String query = selectWhere + "name == \"" + name + "\" ;";
		try (Connection conn = DriverManager.getConnection(db.url)){
			Statement stmt = conn.createStatement();
			System.out.println("Sto per eseguire \n" + query);
			ResultSet rs = stmt.executeQuery(query);
			boolean found = false;
			while(rs.next() && !found) {
				if(rs.getString("password").equals(password)) {
					Address address = Address.findByName(rs.getString("address"), db);
					found = true;
					User user = new User(rs.getString("id"),
							rs.getString("name"),
							address,
							rs.getString("password"),
							rs.getString("bestfriend"));
					rs.close();
					return user;
					}
				// else : next input
				}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}