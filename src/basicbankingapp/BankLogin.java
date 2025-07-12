package basicbankingapp;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class BankLogin extends JFrame {
    private final String correctPin = "1234";
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankLogin frame = new BankLogin();
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
	public BankLogin() {
		setTitle("BankLogin");
		setBackground(new Color(0, 255, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(28, 57, 87));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 36));
		passwordField.setBounds(365, 308, 295, 93);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("Enter your 4-digit PIN:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(385, 256, 287, 41);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 19));
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pinText = new String(passwordField.getPassword());
				if(!pinText.matches("\\d{4}")) {
				JOptionPane.showMessageDialog(null, "Please enter a 4-digit number! (Numbers only)", "Message", 0);
				return;
				}
				if (pinText.equals(correctPin)) {
					JOptionPane.showMessageDialog(null, "Login successful!");
					MainMenuFrame menu = new MainMenuFrame();
					menu.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Incorrect PIN. Try again.");
				}
			}
		});
			btnNewButton.setBounds(414, 462, 208, 67);
			contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setIcon(new ImageIcon(BankLogin.class.getResource("/resources/lock-removebg-preview (1).png")));
		lblNewLabel_1.setBounds(441, 127, 129, 117);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(BankLogin.class.getResource("/resources/output-onlinepngtools (6) (1).png")));
		lblNewLabel_2.setBounds(0, 0, 1008, 661);
		contentPane.add(lblNewLabel_2);
	}
}
