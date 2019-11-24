package graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import design.pattern.User;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class UserGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserGui frame = new UserGui(null);
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
	public UserGui(User user) {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea out = new JTextArea();
		out.setLineWrap(true);
		out.setEditable(false);
		out.setBounds(75, 95, 304, 162);
		contentPane.add(out);
		
		JLabel welcomeLabel = new JLabel("Welcome to your login page, " + user.getName());
		welcomeLabel.setBounds(75, 29, 304, 16);
		contentPane.add(welcomeLabel);
		
		JLabel infoLabel = new JLabel("This is your information:");
		infoLabel.setBounds(75, 67, 304, 16);
		contentPane.add(infoLabel);
		
		String output = "Your Id : " + user.getId() + "\n" +
				"Your Name : " + user.getName() + "\n" +
				"Your Address : " + user.getAddress() + "\n" +
				"Your Password : " + user.getPassword() + "\n" +
				"Your Bestfriend : " + user.getBestfriend();
		out.append(output);
		}
}
