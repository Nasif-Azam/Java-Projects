import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class HomePage extends JFrame {

	private JPanel HomePageLay;
	private JTextField textField_Pass;
	private JTextField textField_ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 418);
		HomePageLay = new JPanel();
		HomePageLay.setBackground(new Color(220, 20, 60));
		HomePageLay.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(HomePageLay);
		HomePageLay.setLayout(null);
		this.setLocationRelativeTo(null);

		JTextPane brandName = new JTextPane();
		brandName.setText("Cash Transaction System");
		brandName.setForeground(Color.WHITE);
		brandName.setFont(new Font("Times New Roman", Font.BOLD, 24));
		brandName.setEditable(false);
		brandName.setBackground(new Color(220, 20, 60));
		brandName.setBounds(79, 26, 263, 35);
		HomePageLay.add(brandName);

		JButton btnMin = new JButton("-");
		btnMin.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
//				this.setState(JFrame.ICONIFIED);
			}
		});
		btnMin.setForeground(Color.WHITE);
		btnMin.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnMin.setBorder(null);
		btnMin.setBackground(new Color(220, 20, 60));
		btnMin.setBounds(359, 10, 31, 35);
		HomePageLay.add(btnMin);

		JButton btnClose = new JButton("X");
		btnClose.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnClose.setForeground(Color.WHITE);
		btnClose.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnClose.setBorder(null);
		btnClose.setBackground(new Color(220, 20, 60));
		btnClose.setBounds(377, 10, 49, 37);
		HomePageLay.add(btnClose);

		JComboBox dropBox = new JComboBox();
		dropBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dropBox.setModel(new DefaultComboBoxModel(new String[] { "Admin", "User" }));
		dropBox.setToolTipText("");
//		dropBox.setName("");
		dropBox.setFont(new Font("Times New Roman", Font.BOLD, 18));
		dropBox.setBounds(159, 112, 110, 27);
		HomePageLay.add(dropBox);

		JTextPane txtpnSelectRole = new JTextPane();
		txtpnSelectRole.setText("Select Role");
		txtpnSelectRole.setForeground(Color.WHITE);
		txtpnSelectRole.setFont(new Font("Times New Roman", Font.BOLD, 18));
		txtpnSelectRole.setEditable(false);
		txtpnSelectRole.setBackground(new Color(220, 20, 60));
		txtpnSelectRole.setBounds(54, 112, 95, 27);
		HomePageLay.add(txtpnSelectRole);

		JTextPane txtpnUserId = new JTextPane();
		txtpnUserId.setText("User ID");
		txtpnUserId.setForeground(Color.WHITE);
		txtpnUserId.setFont(new Font("Times New Roman", Font.BOLD, 18));
		txtpnUserId.setEditable(false);
		txtpnUserId.setBackground(new Color(220, 20, 60));
		txtpnUserId.setBounds(79, 165, 70, 27);
		HomePageLay.add(txtpnUserId);

		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setText("Password");
		txtpnPassword.setForeground(Color.WHITE);
		txtpnPassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
		txtpnPassword.setEditable(false);
		txtpnPassword.setBackground(new Color(220, 20, 60));
		txtpnPassword.setBounds(64, 202, 85, 27);
		HomePageLay.add(txtpnPassword);

		textField_Pass = new JTextField();
		textField_Pass.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textField_Pass.setColumns(10);
		textField_Pass.setBorder(null);
		textField_Pass.setBounds(159, 202, 213, 27);
		HomePageLay.add(textField_Pass);

		textField_ID = new JTextField();
		textField_ID.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textField_ID.setColumns(10);
		textField_ID.setBorder(null);
		textField_ID.setBounds(159, 165, 213, 27);
		HomePageLay.add(textField_ID);

		JButton btnClear = new JButton("Registration");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration RP = new Registration();
				RP.setVisible(true);
				dispose();
			}
		});
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnClear.setBackground(new Color(255, 140, 0));
		btnClear.setBounds(114, 282, 140, 29);
		HomePageLay.add(btnClear);

		JButton btnLogin = new JButton("Log in");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SR = dropBox.getSelectedItem().toString();
				String ID = textField_ID.getText();
				String Pass = textField_Pass.getText();
				AdminPanel AP = new AdminPanel();
				UserPanel UP = new UserPanel();
				Registration Reg = new Registration();

				class useres extends AdminPanel {
					public void userInfo() {
						Connection con = con();
//						ShowDataBase();
						ArrayList<String> listID = new ArrayList<String>();
						ArrayList<String> listPass = new ArrayList<String>();
						try {
							String query = "Select ID, Password from adminPanel";
							PreparedStatement pst = con.prepareStatement(query);
							ResultSet rs = pst.executeQuery();

							while (rs.next()) {
								listID.add(rs.getString("ID"));
								listPass.add(rs.getString("Password"));
//								System.out.print(rs.getString("ID"));
//								System.out.println("    ");
//								System.out.print(rs.getString("Password"));
							}

						} catch (Exception e) {
							System.out.println("Showing Error!! " + e);
						}

						if (ID.isEmpty() && Pass.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Plz fill ID and Password");
						} else if (ID.equals("Nasif") && Pass.equals("123") && SR.equals("Admin")) {
							AP.setVisible(true);
							dispose();
						} else if (ID.equals("Azam") && Pass.equals("123") && SR.equals("User")) {
							UP.setVisible(true);
							dispose();
						} else if (ID.contains(ID) && Pass.contains(Pass) && SR.equals("User")) {
							for (int i = 0; i < listID.size(); i++) {
								if (ID.equals(listID.get(i)) && Pass.equals(listPass.get(i))) {
									System.out.println("asdasdasd");
									UP.setVisible(true);
									dispose();
								}
							}
						} else {
							JOptionPane.showMessageDialog(null, "Incorrect ID and Password");
							textField_ID.setText(null);
							textField_Pass.setText(null);
						}
					}
				}
				useres UI = new useres();
				UI.userInfo();
			}

		});
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnLogin.setBackground(new Color(65, 105, 225));
		btnLogin.setBounds(270, 282, 102, 29);
		HomePageLay.add(btnLogin);
	}

}
