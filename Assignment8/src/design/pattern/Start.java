package design.pattern;

public class Start {
	
	public static void main(String[] args) {
		System.out.println("ciao zio");
		Database db = new Database();
		db.createNewDatabase("Usersdb.db");
		db.createNewTable(db);
	}

}
