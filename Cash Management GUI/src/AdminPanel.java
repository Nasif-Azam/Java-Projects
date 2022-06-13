import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class AdminPanel extends JFrame {

	private JPanel AdminLayout;
	protected JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel frame = new AdminPanel();
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
	public AdminPanel() {
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				ShowDataBase();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 499);
		AdminLayout = new JPanel();
		AdminLayout.setBackground(new Color(220, 20, 60));
		AdminLayout.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(AdminLayout);
		AdminLayout.setLayout(null);

		JTextPane txtpnAdminPanel = new JTextPane();
		txtpnAdminPanel.setEditable(false);
		txtpnAdminPanel.setForeground(new Color(255, 255, 255));
		txtpnAdminPanel.setBackground(new Color(220, 20, 60));
		txtpnAdminPanel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		txtpnAdminPanel.setText("Admin Panel");
		txtpnAdminPanel.setBounds(147, 10, 138, 35);
		AdminLayout.add(txtpnAdminPanel);

		JButton btnBack = new JButton("<");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage HP = new HomePage();
				HP.setVisible(true);
				dispose();
			}
		});
		btnBack.setBorder(null);
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.setBackground(new Color(220, 20, 60));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnBack.setBounds(10, 10, 21, 29);
		AdminLayout.add(btnBack);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Times New Roman", Font.BOLD, 18));
		scrollPane.setBounds(10, 64, 539, 307);
		AdminLayout.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null }, },
				new String[] { "ID", "Full Name", "Mobile", "Mail", "Password", "Re-type Password", "Balance" }));
//		table.getColumnModel().getColumn(0).setPreferredWidth(30);
//		table.getColumnModel().getColumn(1).setPreferredWidth(80);
//		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		scrollPane.setViewportView(table);
		this.setLocationRelativeTo(null);

//		table = new JTable();
//		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, },
//				new String[] { "ID", "Name", "Mobile", "Password" }));
//		scrollPane.setViewportView(table);

	}

	Connection con() {
		try {
//			String driver = "com.mysql.jdbc.Driver";
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost/transaction system";
			Class.forName(driver);
//			return DriverManager.getConnection(url, "root", "root");
			return DriverManager.getConnection(url, "root", "");
		} catch (Exception e) {
			System.out.println("Connection Failed!!  " + e);
		}
		return null;
	}

	public void ShowDataBase() {
		Connection con = con();
		try {
			String query = "Select * from adminPanel";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {
			System.out.println("Showing Error!! " + e);
		}
	}
}
