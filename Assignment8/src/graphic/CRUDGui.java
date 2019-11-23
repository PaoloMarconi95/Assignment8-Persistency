package graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CRUDGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idCreate;
	private JTextField nameCreate;
	private JTextField addressCreate;
	private JPasswordField passwordCreate;
	private JTextField idRead;
	private JTextField nameRead;
	private JTextField addressRead;
	private JPasswordField passwordRead;

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
		
		// Labels and text input for create new User
		idCreate = new JTextField();
		idCreate.setBounds(33, 28, 95, 26);
		contentPane.add(idCreate);
		
		nameCreate = new JTextField();
		nameCreate.setBounds(180, 28, 117, 26);
		contentPane.add(nameCreate);
		nameCreate.setColumns(10);
		
		addressCreate = new JTextField();
		addressCreate.setBounds(361, 28, 164, 26);
		contentPane.add(addressCreate);
		addressCreate.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(18, 33, 19, 16);
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(142, 33, 43, 16);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(309, 33, 51, 16);
		contentPane.add(lblAddress);
		
		passwordCreate = new JPasswordField();
		passwordCreate.setBounds(263, 79, 145, 26);
		contentPane.add(passwordCreate);
		
		JButton btnCreateUser = new JButton("Create User");
		btnCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCreateUser.setBounds(27, 79, 117, 29);
		contentPane.add(btnCreateUser);
		
		
		// Labels and text input for other CRUD operations		
		JLabel lblId_1 = new JLabel("Id");
		lblId_1.setBounds(201, 145, 19, 16);
		contentPane.add(lblId_1);
		
		idRead = new JTextField();
		idRead.setBounds(220, 140, 95, 26);
		contentPane.add(idRead);
		idRead.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(201, 84, 61, 16);
		contentPane.add(lblPassword);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 0, 535, 128);
		contentPane.add(tabbedPane);
		
		nameRead = new JTextField();
		nameRead.setColumns(10);
		nameRead.setBounds(68, 256, 117, 26);
		contentPane.add(nameRead);
		
		addressRead = new JTextField();
		addressRead.setColumns(10);
		addressRead.setBounds(361, 256, 164, 26);
		contentPane.add(addressRead);
		
		JLabel label_1 = new JLabel("Name");
		label_1.setBounds(27, 261, 43, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Address");
		label_2.setBounds(309, 261, 51, 16);
		contentPane.add(label_2);
		
		passwordRead = new JPasswordField();
		passwordRead.setBounds(220, 294, 145, 26);
		contentPane.add(passwordRead);
				
		JLabel label_3 = new JLabel("Password");
		label_3.setBounds(154, 299, 61, 16);
		contentPane.add(label_3);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(6, 112, 535, 227);
		contentPane.add(tabbedPane_1);
		
		JButton btnFindUser = new JButton("Read User");
		btnFindUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFindUser.setBounds(33, 187, 117, 29);
		contentPane.add(btnFindUser);
		
		JButton btnDeleteUser = new JButton("Update User");
		btnDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeleteUser.setBounds(210, 187, 117, 29);
		contentPane.add(btnDeleteUser);
		
		JButton btnRemoveUser = new JButton("Remove User");
		btnRemoveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemoveUser.setBounds(408, 187, 117, 29);
		contentPane.add(btnRemoveUser);
		
	}
}
