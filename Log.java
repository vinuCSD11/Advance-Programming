package Book.lk;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Log extends JFrame {

	protected static final JLabel Uid = null;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JPasswordField passwordField_3;
	protected JLabel username;
	protected JLabel password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Log frame = new Log();
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
	public Log() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserid = new JLabel("UserID");
		lblUserid.setBounds(78, 47, 46, 14);
		contentPane.add(lblUserid);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(78, 96, 46, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(78, 154, 46, 14);
		contentPane.add(lblPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e, Component frame) {
				
				String lblUserid= btnNewButton.getText();
				String  lblUsername =btnNewButton.getText();
				String lblPassword=btnNewButton.getText();
				
				String i_d="";
				String v_un="";
				   String v_pw="";
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Book", "root", "root");
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("\"select UserID, username,password from book where username='\"+ uname + \"'\"");
					while (rs.next())
						//System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
						i_d=rs.getString(1);
						v_un = rs.getString(2);
					v_pw = rs.getString(3); 
					con.close();
				} catch (Exception e1) {
					System.out.println(e);
				}
		
				
				if(lblUsername.equals("Admin")&& lblPassword.equals("123")) 
				{
					Welcome wel = new Welcome();
					
					JOptionPane.showMessageDialog(frame , "You are succes");
					
					}
				else
				{
					JOptionPane.showMessageDialog(frame , "You are not Allow");
				}

			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}

			
		});
		btnNewButton.setBounds(35, 210, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(167, 210, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Signup");
		btnNewButton_2.setBounds(286, 210, 89, 23);
		contentPane.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(231, 44, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(231, 93, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(320, 154, -80, 20);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(269, 151, -29, 20);
		contentPane.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(276, 166, -44, 20);
		contentPane.add(passwordField_2);
		
		passwordField_3 = new JPasswordField();
		passwordField_3.setBounds(231, 151, 86, 28);
		contentPane.add(passwordField_3);
	}
}
