package graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField input;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchGui frame = new SearchGui();
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
	public SearchGui() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setMaximumRowCount(3);
		comboBox.setBounds(113, 25, 136, 27);
		comboBox.addItem("Name");
		comboBox.addItem("Address");
		comboBox.addItem("Best Friend");
		contentPane.add(comboBox);
		
		JLabel lblSearchBy = new JLabel("Search by");
		lblSearchBy.setBounds(40, 29, 61, 16);
		contentPane.add(lblSearchBy);
		
		input = new JTextField();
		input.setBounds(278, 24, 152, 26);
		contentPane.add(input);
		input.setColumns(10);
		
		JTextArea textOutput = new JTextArea();
		textOutput.setEditable(false);
		textOutput.setBounds(32, 120, 381, 140);
		getContentPane().add(textOutput);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = Search(comboBox.getSelectedItem().toString(),
						input.getText());
				textOutput.append(output);
				
			}
		});
		btnSearch.setBounds(160, 79, 117, 29);
		contentPane.add(btnSearch);
	

	}
	
	
	public String Search(String by, String input) {
		// doQuery
		return input + by;
	}
}
