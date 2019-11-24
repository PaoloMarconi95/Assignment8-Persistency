package design.pattern;


public class Main {
	
	public static void main(String[] args) {
		Database db = Database.getInstance();
		User user = new User("1", "Paolo", "Mazzini", "internet", "2");
		User.insert(user, db);
		User io = User.findById("1", db);
		if(user.equals(io)) {
			System.out.println("Corretto");
		}
		else {
			System.out.println("Non Corretto");			
		}
		User.remove(user, db);
		User io2 = User.findById("1", db);
		if(io2 == null) {
			System.out.println("Corretto");
		}
		else {
			System.out.println("Non Corretto");
		}
		
	}
	
	public static Database initializeDB() {
		Database db = new Database();
		db.createNewDatabase("Usersdb.db");
		Database.createUserTable(db);
		return db;
	}

}
