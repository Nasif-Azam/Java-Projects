import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class UserPanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPanel frame = new UserPanel();
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
	public UserPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 418);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 20, 60));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextPane txtpnUserPanel = new JTextPane();
		txtpnUserPanel.setText("User Panel");
		txtpnUserPanel.setForeground(Color.WHITE);
		txtpnUserPanel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		txtpnUserPanel.setEditable(false);
		txtpnUserPanel.setBackground(new Color(220, 20, 60));
		txtpnUserPanel.setBounds(147, 10, 138, 35);
		contentPane.add(txtpnUserPanel);

		JButton btnBack = new JButton("<");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage HP = new HomePage();
				HP.setVisible(true);
				dispose();
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnBack.setBorder(null);
		btnBack.setBackground(new Color(220, 20, 60));
		btnBack.setBounds(10, 10, 21, 29);
		contentPane.add(btnBack);

		JButton btnNewButton = new JButton("Check Balance");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(161, 95, 141, 29);
		contentPane.add(btnNewButton);

		JButton btnSendMoney = new JButton("Send Money");
		btnSendMoney.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSendMoney.setBounds(161, 151, 141, 29);
		contentPane.add(btnSendMoney);

		JButton btnPayment = new JButton("Payment");
		btnPayment.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnPayment.setBounds(161, 195, 141, 29);
		contentPane.add(btnPayment);

		JButton btnSavings = new JButton("Savings");
		btnSavings.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSavings.setBounds(161, 251, 141, 29);
		contentPane.add(btnSavings);
		this.setLocationRelativeTo(null);
	}
}
