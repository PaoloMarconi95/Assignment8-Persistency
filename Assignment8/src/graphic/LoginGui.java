package graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import design.pattern.Database;
import design.pattern.User;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class LoginGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameRead;
	private JPasswordField passwordRead;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGui frame = new LoginGui();
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
	public LoginGui() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(39, 91, 61, 16);
		contentPane.add(lblName);
		
		nameRead = new JTextField();
		nameRead.setBounds(84, 86, 130, 26);
		contentPane.add(nameRead);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(226, 91, 61, 16);
		contentPane.add(lblPassword);
		
		passwordRead = new JPasswordField();
		passwordRead.setBounds(299, 86, 130, 26);
		contentPane.add(passwordRead);
		
		JLabel errorMessage = new JLabel("");
		errorMessage.setForeground(Color.RED);
		errorMessage.setBounds(39, 236, 390, 16);
		contentPane.add(errorMessage);
		errorMessage.setVisible(false);
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				errorMessage.setVisible(false);
				Database db = Database.getInstance();
				User result = User.lookForPassword(nameRead.getText(), new String(passwordRead.getPassword()), db);
				if(result != null) {
					UserGui usergui = new UserGui(result);
					usergui.setVisible(true);										
				}
				else {
					errorMessage.setText("User not found or password incorrect for user " + nameRead.getText());
					errorMessage.setVisible(true);
				}
			}
		});
		btnLogin.setBounds(170, 149, 117, 29);
		contentPane.add(btnLogin);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnGoBack.setBounds(167, 229, 117, 29);
		contentPane.add(btnGoBack);
				

	}
}
