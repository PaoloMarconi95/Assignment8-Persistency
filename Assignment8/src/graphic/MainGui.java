package graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;

import design.pattern.Database;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGui extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGui frame = new MainGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		initializeDB();
	}

	/**
	 * Create the frame.
	 */
	public MainGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JButton btnCrudOperations = new JButton("CRUD Operations");
		btnCrudOperations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CRUDGui crudgui = new CRUDGui();
				crudgui.setVisible(true);
			}
		});
		btnCrudOperations.setBounds(6, 125, 133, 29);
		getContentPane().add(btnCrudOperations);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGui logingui = new LoginGui();
				logingui.setVisible(true);
			}
		});
		btnLogin.setBounds(176, 125, 117, 29);
		getContentPane().add(btnLogin);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchGui searchgui = new SearchGui();
				searchgui.setVisible(true);
			}
		});
		btnSearch.setBounds(327, 125, 117, 29);
		getContentPane().add(btnSearch);
	}
	
	
	public static void initializeDB() {
		Database db = new Database();
		db.createNewDatabase("Usersdb.db");
		Database.createUserTable(db);
	}
}
