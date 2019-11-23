package design.pattern;


public class Main {
	
	public static void main(String[] args) {
		Database db = initializeDB();
		User user = new User("1", "Paolo", "Mazzini", "internet", "2");
		User.insert(user, db);
		User.findById("1", db);
		User.delete(user, db);
		User io2 = User.findById("1", db);
		if(io2 == null) {
			System.out.println("Beeeeeeene");
		}
		else {
			System.out.println("Diocane");
		}
		
	}
	
	public static Database initializeDB() {
		Database db = new Database();
		db.createNewDatabase("Usersdb.db");
		Database.createUserTable(db);
		return db;
	}

}
