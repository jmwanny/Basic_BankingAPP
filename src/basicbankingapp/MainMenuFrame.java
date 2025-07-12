package basicbankingapp;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;

public class MainMenuFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static double balance = 0;
	DecimalFormat df = new DecimalFormat("₱#,##0.00");


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { 
			public void run() {
				try {
					MainMenuFrame frame = new MainMenuFrame();
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
	public MainMenuFrame() {
		setResizable(false);
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(28, 57, 87));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" BasicBankApp");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(360, 51, 510, 49);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 35));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Deposit");
		btnNewButton.setBackground(new Color(224, 242, 247));
		btnNewButton.setIcon(new ImageIcon(MainMenuFrame.class.getResource("/resources/fixed-deposit-icon-vector-remove.png")));
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton.setBounds(212, 188, 185, 82);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input =  JOptionPane.showInputDialog(null,"Enter amount to deposit:", "Deposit", 1);
				
				if(input!=null) {
					try {
						double depositAmount = Double.parseDouble(input);   
						 if(depositAmount>0) {
							 balance+=depositAmount;
							 JOptionPane.showMessageDialog(null,"Successfully deposited " + df.format(depositAmount) + " on your account. ");
							 
						 } else {
							 JOptionPane.showMessageDialog(null,"Please enter a positive number", "Error", 2);
						 } 
					} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Please enter a numerical value!", "Error",0);
				}
			}}}
		);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Withdraw");
		btnNewButton_1.setBackground(new Color(224, 242, 247));
		btnNewButton_1.setIcon(new ImageIcon(MainMenuFrame.class.getResource("/resources/withdraw-removebg-preview (1).png")));
		btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnNewButton_1.setBounds(587, 188, 185, 81);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
String input =  JOptionPane.showInputDialog(null,"Enter amount to withdraw:", "Withdraw", 1);
				
				if(input!=null) {
					try {
						double withdrawAmount = Double.parseDouble(input);
						 if(withdrawAmount>0) {
							 if(balance>=withdrawAmount) {
							 balance-=withdrawAmount;
							 JOptionPane.showMessageDialog(null,"Successfully withdrawn " + df.format(withdrawAmount) + " on your account. ");
							 } else {
							 JOptionPane.showMessageDialog(null,"Insufficient funds!", "Error", 2);
							 }
						 } else {
							 JOptionPane.showMessageDialog(null,"Please enter a positive number!", "Error", 2);
						 }  
					} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Please enter a numerical value!", "Error",0);
				}
			}}
			}
		);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton(" Check Balance");
		btnNewButton_2.setBackground(new Color(224, 242, 247));
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_2.setIcon(new ImageIcon(MainMenuFrame.class.getResource("/resources/balance-removebg-preview (1).png")));
		btnNewButton_2.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnNewButton_2.setBounds(360, 363, 278, 82);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				JOptionPane.showMessageDialog(null, "Balance: " + df.format(balance), "Balance", 1);
				
				
			}
		});
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("      Exit");
		btnNewButton_3.setBackground(new Color(224, 242, 247));
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_3.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnNewButton_3.setIcon(new ImageIcon(MainMenuFrame.class.getResource("/resources/exit-removebg-preview (1) (1).png")));
		btnNewButton_3.setBounds(398, 527, 205, 82);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit? ", "Exit", JOptionPane.YES_NO_OPTION, 2);
				
				if (result==JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null,"Thank you for using BasicBankApp!", "Message", 1);
					JOptionPane.showMessageDialog(null,"Developed by JAM Tech (Juan_Anthony_Mychaiel)", "Message", 1);
					System.exit(0);
				
				}
			}
		});
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("\"Bank Better, Live Easier\"");
		lblNewLabel_1.setFont(new Font("Arial Unicode MS", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(408, 103, 185, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MainMenuFrame.class.getResource("/resources/output-onlinepngtools (1).png")));
		lblNewLabel_2.setBounds(0, 0, 1008, 661);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(MainMenuFrame.class.getResource("/resources/output-onlinepngtools (3) (1).png")));
		lblNewLabel_3.setBounds(456, 0, 72, 65);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(MainMenuFrame.class.getResource("/resources/output-onlinepngtools (4) (1).png")));
		lblNewLabel_4.setBounds(908, 563, 90, 87);
		contentPane.add(lblNewLabel_4);
	}
}
