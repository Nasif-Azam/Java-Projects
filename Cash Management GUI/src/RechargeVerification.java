import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class RechargeVerification extends JFrame {

	private JPanel RechargeAccLay;
	private JTextField txtUserName;
	private JTextField textCode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RechargeVerification frame = new RechargeVerification();
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

	public RechargeVerification() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 418);
		RechargeAccLay = new JPanel();
		RechargeAccLay.setBackground(new Color(220, 20, 60));
		RechargeAccLay.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(RechargeAccLay);
		RechargeAccLay.setLayout(null);

		JTextPane txtpnRegistrationAcc = new JTextPane();
		txtpnRegistrationAcc.setText("Recharge Account");
		txtpnRegistrationAcc.setForeground(Color.WHITE);
		txtpnRegistrationAcc.setFont(new Font("Times New Roman", Font.BOLD, 24));
		txtpnRegistrationAcc.setEditable(false);
		txtpnRegistrationAcc.setBackground(new Color(220, 20, 60));
		txtpnRegistrationAcc.setBounds(118, 10, 210, 35);
		RechargeAccLay.add(txtpnRegistrationAcc);

		JTextPane txtpnInstr = new JTextPane();
		txtpnInstr.setBorder(null);
		txtpnInstr.setText("To active your account you need to recharge at least 500/= tk");
		txtpnInstr.setForeground(Color.WHITE);
		txtpnInstr.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtpnInstr.setEditable(false);
		txtpnInstr.setBackground(new Color(220, 20, 60));
		txtpnInstr.setBounds(10, 103, 416, 66);
		RechargeAccLay.add(txtpnInstr);

		txtUserName = new JTextField();
		txtUserName.setBorder(null);
		txtUserName.setEditable(false);
		txtUserName.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtUserName.setBackground(new Color(220, 20, 60));
		txtUserName.setForeground(Color.WHITE);
		txtUserName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtUserName.setColumns(10);
		txtUserName.setBounds(10, 70, 154, 33);
		RechargeAccLay.add(txtUserName);

		textCode = new JTextField();
		textCode.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textCode.setColumns(10);
		textCode.setBorder(null);
		textCode.setBounds(133, 277, 154, 33);
		RechargeAccLay.add(textCode);

		JButton btnVerCode = new JButton("Verify Code");
		btnVerCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				codeChecker();
			}
		});
		btnVerCode.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnVerCode.setBorder(null);
		btnVerCode.setBounds(133, 320, 154, 35);
		RechargeAccLay.add(btnVerCode);
		this.setLocationRelativeTo(null);

	}

	String codeArr[] = new String[1];
	String allAlp = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String allChars = "0123456789" + allAlp;

	public void randomWord() {
		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			int randomIndex = random.nextInt(allChars.length());
			sb.append(allChars.charAt(randomIndex));
		}
		String temp = sb.toString();
		codeArr[0] = temp;
		JOptionPane.showMessageDialog(null, codeArr[0]);
		System.out.println(codeArr[0]);
	}

	public void codeChecker() {
		System.out.println("Verification Code is : " + codeArr[0]);
		System.out.println("User Typed Code is :   " + textCode.getText());
		if (textCode.getText().contains(codeArr[0])) {
			System.out.println("Done!!");
			Registration R = new Registration();
			R.SaveToDataBase();
		} else {
			System.out.println("Verification code isn't match!!");
		}

	}

//	public String getName() {
//		return txtUserName.setText("Dear " + name + " Sir,");
//		
//	}
}
