package graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;

public class CRUDGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Id;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField pwdPassword;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRUDGui frame = new CRUDGui();
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
	public CRUDGui() {
		setBounds(100, 100, 547, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnCreateUser = new JButton("Create User");
		btnCreateUser.setBounds(27, 79, 117, 29);
		contentPane.add(btnCreateUser);
		
		Id = new JTextField();
		Id.setBounds(33, 28, 95, 26);
		contentPane.add(Id);
		
		textField_1 = new JTextField();
		textField_1.setBounds(180, 28, 117, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(361, 28, 164, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(18, 33, 19, 16);
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(142, 33, 43, 16);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(309, 33, 51, 16);
		contentPane.add(lblAddress);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setText("Password");
		pwdPassword.setBounds(263, 79, 145, 26);
		contentPane.add(pwdPassword);
		
		JLabel lblId_1 = new JLabel("Id");
		lblId_1.setBounds(201, 145, 19, 16);
		contentPane.add(lblId_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(220, 140, 95, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnFindUser = new JButton("Read User");
		btnFindUser.setBounds(33, 187, 117, 29);
		contentPane.add(btnFindUser);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(201, 84, 61, 16);
		contentPane.add(lblPassword);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 0, 535, 128);
		contentPane.add(tabbedPane);
		
		JButton btnDeleteUser = new JButton("Update User");
		btnDeleteUser.setBounds(210, 187, 117, 29);
		contentPane.add(btnDeleteUser);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(68, 256, 117, 26);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(361, 256, 164, 26);
		contentPane.add(textField_6);
		
		JLabel label_1 = new JLabel("Name");
		label_1.setBounds(27, 261, 43, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Address");
		label_2.setBounds(309, 261, 51, 16);
		contentPane.add(label_2);
		
		passwordField = new JPasswordField();
		passwordField.setText("Password");
		passwordField.setBounds(220, 294, 145, 26);
		contentPane.add(passwordField);
		
		JButton btnRemoveUser = new JButton("Remove User");
		btnRemoveUser.setBounds(408, 187, 117, 29);
		contentPane.add(btnRemoveUser);
		
		JLabel label_3 = new JLabel("Password");
		label_3.setBounds(154, 299, 61, 16);
		contentPane.add(label_3);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(6, 118, 535, 221);
		contentPane.add(tabbedPane_1);
		
		
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnCreateUser}));
	}
}
