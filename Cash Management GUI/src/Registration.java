import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.util.StringUtils;

public class Registration extends JFrame {

	private JPanel RegistrationLay;
	private JTextField textFullName;
	private JTextField textMobile;
	private JTextField textMail;
	private JTextField textPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	RechargeVerification RV = new RechargeVerification();
	private JTextField textBalance;
	private JTextField txtVerificationCode;

	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 418);
		RegistrationLay = new JPanel();
		RegistrationLay.setBackground(new Color(220, 20, 60));
		RegistrationLay.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(RegistrationLay);
		RegistrationLay.setLayout(null);
		this.setLocationRelativeTo(null);

		JTextPane txtpnRegistration = new JTextPane();
		txtpnRegistration.setText("Registration");
		txtpnRegistration.setForeground(Color.WHITE);
		txtpnRegistration.setFont(new Font("Times New Roman", Font.BOLD, 24));
		txtpnRegistration.setEditable(false);
		txtpnRegistration.setBackground(new Color(220, 20, 60));
		txtpnRegistration.setBounds(147, 10, 138, 35);
		RegistrationLay.add(txtpnRegistration);

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
		RegistrationLay.add(btnBack);

		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setForeground(new Color(255, 255, 255));
		lblFullName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblFullName.setBounds(89, 55, 82, 21);
		RegistrationLay.add(lblFullName);

		textFullName = new JTextField();
		textFullName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFullName.setBounds(181, 58, 154, 19);
		RegistrationLay.add(textFullName);
		textFullName.setColumns(10);

		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setForeground(Color.WHITE);
		lblMobile.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMobile.setBounds(116, 98, 55, 21);
		RegistrationLay.add(lblMobile);

		textMobile = new JTextField();
		textMobile.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textMobile.setColumns(10);
		textMobile.setBounds(181, 101, 154, 19);
		RegistrationLay.add(textMobile);

		JLabel lblMail = new JLabel("Mail");
		lblMail.setForeground(Color.WHITE);
		lblMail.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMail.setBounds(135, 141, 36, 21);
		RegistrationLay.add(lblMail);

		textMail = new JTextField();
		textMail.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textMail.setColumns(10);
		textMail.setBounds(181, 144, 154, 19);
		RegistrationLay.add(textMail);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPassword.setBounds(93, 186, 78, 21);
		RegistrationLay.add(lblPassword);

		textPass = new JTextField();
		textPass.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textPass.setColumns(10);
		textPass.setBounds(181, 189, 154, 19);
		RegistrationLay.add(textPass);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				RechargeAccount RA = new RechargeAccount(textFullName.getText().toString(),
//						textMail.getText().toString());
//				Save SV = new Save();
//				RA.balanceCheaker();

//				RA.balanceCheaker();

				RV.setVisible(true);
				dispose();
//				String M = RA.getTextBalance();
//				JOptionPane.showMessageDialog(null, "sadasdad : " + M);
//
				SaveToDataBase();
				textFullName.setText(null);
				textMobile.setText(null);
				textMail.setText(null);
				textPass.setText(null);
			}
		});
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSubmit.setBounds(236, 317, 99, 29);
		RegistrationLay.add(btnSubmit);

		textBalance = new JTextField();
		textBalance.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textBalance.setColumns(10);
		textBalance.setBorder(null);
		textBalance.setBounds(89, 241, 154, 19);
		RegistrationLay.add(textBalance);

		JButton btnAM = new JButton("Add Money");
		btnAM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				balanceCheaker();
			}
		});
		btnAM.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnAM.setBorder(null);
		btnAM.setBounds(249, 240, 154, 19);
		RegistrationLay.add(btnAM);

		JTextPane txtpnInstr = new JTextPane();
		txtpnInstr.setText("To active your account you need to recharge at least 500/= tk");
		txtpnInstr.setForeground(Color.WHITE);
		txtpnInstr.setFont(new Font("Times New Roman", Font.BOLD, 18));
		txtpnInstr.setEditable(false);
		txtpnInstr.setBorder(null);
		txtpnInstr.setBackground(new Color(220, 20, 60));
		txtpnInstr.setBounds(10, 217, 426, 52);
		RegistrationLay.add(txtpnInstr);

		txtVerificationCode = new JTextField();
		txtVerificationCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtVerificationCode.setText(getName());
			}
		});
		txtVerificationCode.setForeground(Color.LIGHT_GRAY);
		txtVerificationCode.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtVerificationCode.setColumns(10);
		txtVerificationCode.setBorder(null);
		txtVerificationCode.setBounds(89, 271, 154, 19);
		RegistrationLay.add(txtVerificationCode);

		JButton btnAM_1 = new JButton("Add Money");
		btnAM_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnAM_1.setBorder(null);
		btnAM_1.setBounds(249, 270, 154, 19);
		RegistrationLay.add(btnAM_1);
		this.setLocationRelativeTo(null);
	}

//	INSERT INTO `adminpanel` (`ID`, `Full Name`, `Mobile`, `Mail`, `Password`, `Re-type Password`) VALUES ('1', 'Nasif Azam', '01794814850', 'nasifazam99.gmail.com', 'nasif123', 'nasif123');

	public void balanceCheaker() {
		try {
			while (StringUtils.isStrictlyNumeric(textBalance.getText())) {
				if (Integer.parseInt(textBalance.getText()) < 500) {
					JOptionPane.showMessageDialog(null, "Need to add at least 500/=");
				} else {
					JOptionPane.showMessageDialog(null, "Done!!");
					System.out.println(textBalance.getText());
					RV.randomWord();
				}
				break;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void SaveToDataBase() {
		AdminPanel AP = new AdminPanel();
		Connection con = AP.con();
		try {
			String query = "insert into adminpanel values(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			HomePage HP = new HomePage();
			int[] userID = new int[100];
			int ID = (int) (Math.random() * (100 - 1 + 1) + 1);
			for (int i = 0; i < userID.length; i++) {
				userID[i] = ID;
				System.out.print(userID[i]);
				break;
			}
//			String M = balanceCheaker();
//			JOptionPane.showMessageDialog(null, "sadasdad : " + M);
			ps.setInt(1, ID);
			ps.setString(2, textFullName.getText());
			ps.setString(3, textMobile.getText());
			ps.setString(4, textMail.getText());
			ps.setString(5, textPass.getText());
			ps.setString(6, textBalance.getText());
//			RC.balanceCheaker();
			ps.execute();

			JOptionPane.showMessageDialog(null, "Saved to database" + "Note your ID: " + ID);

		} catch (Exception e) {
			System.out.println("Saving Error!! " + e);
		}

	}

	public String getFullName() {
		return textFullName.getText();
	}

	public JTextField getTextFullName() {
		return textFullName;
	}
	//
//		public void setTextFullName(JTextField textFullName) {
//			this.textFullName = textFullName;
//		}

	public JTextField getTextMobile() {
		return textMobile;
	}
}
