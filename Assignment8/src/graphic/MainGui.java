package graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;

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
		btnCrudOperations.setBounds(22, 109, 133, 45);
		getContentPane().add(btnCrudOperations);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGui logingui = new LoginGui();
				logingui.setVisible(true);
			}
		});
		btnLogin.setBounds(167, 109, 117, 45);
		getContentPane().add(btnLogin);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchGui searchgui = new SearchGui();
				searchgui.setVisible(true);
			}
		});
		btnSearch.setBounds(296, 109, 117, 45);
		getContentPane().add(btnSearch);
		
		JButton btnGoBack = new JButton("Exit");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnGoBack.setBounds(167, 229, 117, 29);
		getContentPane().add(btnGoBack);
	}
	
}
