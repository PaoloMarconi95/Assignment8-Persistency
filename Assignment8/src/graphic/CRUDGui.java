package graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import design.pattern.*;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class CRUDGui extends JFrame {


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
	private JTextField bestfriendCreate;
	private JTextField bestfriendRead;


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


	public CRUDGui() {
		setBounds(100, 100, 547, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Output pane first
		JTextArea userOut = new JTextArea();
		userOut.setWrapStyleWord(true);
		userOut.setEditable(false);
		userOut.setLineWrap(true);
		userOut.setBounds(162, 178, 363, 66);
		contentPane.add(userOut);

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
		passwordCreate.setBounds(201, 79, 108, 26);
		contentPane.add(passwordCreate);

		bestfriendCreate = new JTextField();
		bestfriendCreate.setBounds(395, 79, 130, 26);
		contentPane.add(bestfriendCreate);

		JLabel lblNewLabel = new JLabel("Best Friend");
		lblNewLabel.setBounds(326, 84, 69, 16);
		contentPane.add(lblNewLabel);

		JButton btnCreateUser = new JButton("Create User");
		btnCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Address address = new Address(addressCreate.getText());
				User user = new User(idCreate.getText(), nameCreate.getText(), address,
						new String(passwordCreate.getPassword()), bestfriendCreate.getText());
				Database db = Database.getInstance();
				String out = "User Correctly Created";
				if(!(User.insert(user, db))) {
					if(User.findById(user.getId(), db) == null)
					out = "Cannot create the user since the bestfriend with user id =  " + bestfriendCreate.getText() 
					+ " does not exist.";
					else {
						out = "User with id = " + idCreate.getText() + " already exists";
					}
				}
				userOut.setText(null);
				userOut.append(out);
			}
		});
		btnCreateUser.setBounds(18, 79, 117, 29);
		contentPane.add(btnCreateUser);

		// Labels and text input for other CRUD operations
		JLabel lblId_1 = new JLabel("Id");
		lblId_1.setBounds(201, 145, 19, 16);
		contentPane.add(lblId_1);

		idRead = new JTextField();
		idRead.setBounds(214, 140, 95, 26);
		contentPane.add(idRead);
		idRead.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(139, 84, 61, 16);
		contentPane.add(lblPassword);

		nameRead = new JTextField();
		nameRead.setColumns(10);
		nameRead.setBounds(91, 256, 129, 26);
		contentPane.add(nameRead);

		addressRead = new JTextField();
		addressRead.setColumns(10);
		addressRead.setBounds(361, 256, 164, 26);
		contentPane.add(addressRead);

		JLabel label_1 = new JLabel("Name");
		label_1.setBounds(43, 261, 36, 16);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("Address");
		label_2.setBounds(298, 261, 51, 16);
		contentPane.add(label_2);

		passwordRead = new JPasswordField();
		passwordRead.setBounds(89, 294, 130, 26);
		contentPane.add(passwordRead);

		JLabel label_3 = new JLabel("Password");
		label_3.setBounds(18, 299, 61, 16);
		contentPane.add(label_3);

		JButton btnFindUser = new JButton("Read User");
		btnFindUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database db = Database.getInstance();
				User result = User.findById(idRead.getText(), db);
				String out;
				if(result != null) {
				out = "I found this correspondance ; \n" +
							"name = " + result.getName() + "; " +
							"address = " + result.getAddress().getName() + "; " +
							"password = " + result.getPassword() + "; " +
							"bestfriend = " + result.getBestfriend() + "; ";
				}
				else {
					out = "No result found with id = " + idRead.getText();
				}				
				userOut.setText(null);
				userOut.append(out);
			}
		});
		btnFindUser.setBounds(384, 140, 117, 29);
		contentPane.add(btnFindUser);

		JButton btnDeleteUser = new JButton("Update User");
		btnDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database db = Database.getInstance();
				String out = "User does not exists with id " + idRead.getText();
				User user = User.findById(idRead.getText(), db);
				if(user != null) {
				// If the new best friend does not exists, cancel the operation
				if (User.findById(bestfriendRead.getText(), db) == null ||
						Address.findByName(user.getAddress().getName(), db) == null) {
					out = "Bestfriend or Address does not exist";
				} else {
						String[] param = new String[4];
						param[0] = nameRead.getText();
						param[1] = addressRead.getText();
						param[2] = new String(passwordRead.getPassword());
						param[3] = bestfriendRead.getText();
						User.update(idRead.getText(), param, db);
						out = "User correctly updated";
					}
				}
				userOut.setText(null);
				userOut.append(out);
				
			}
		});
		btnDeleteUser.setBounds(33, 197, 117, 29);
		contentPane.add(btnDeleteUser);

		JButton btnRemoveUser = new JButton("Remove User");
		btnRemoveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database db = Database.getInstance();
				User user = User.findById(idRead.getText(), db);
				String out;
				if (user != null) {
					if (User.remove(user, db)) {
						out = "User correctly removed";
					} else {
						out = "Something went wrong with user's deletion";
					}
				} else {
					out = "No result found with id = " + idRead.getText();
				}
				userOut.setText(null);
				userOut.append(out);
			}
		});
		btnRemoveUser.setBounds(33, 140, 117, 29);
		contentPane.add(btnRemoveUser);

		JLabel lblBestFriend = new JLabel("Best Friend");
		lblBestFriend.setBounds(280, 299, 75, 16);
		contentPane.add(lblBestFriend);

		bestfriendRead = new JTextField();
		bestfriendRead.setBounds(361, 294, 164, 26);
		contentPane.add(bestfriendRead);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 547, 135);
		contentPane.add(tabbedPane);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(0, 117, 547, 222);
		contentPane.add(tabbedPane_1);

	}
}