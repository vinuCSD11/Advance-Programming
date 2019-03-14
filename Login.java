package Book.lk;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.lang.ClassCastException;
import java.lang.Exception;
import java.sql.PreparedStatement;

import java.sql.Connection;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.util.Collection;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField Uid;
	private JTextField Uname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Collection con=(Collection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Book","root","root");
		}catch(Exception e1){System.out.println(e1);

}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param pd 
	 */
	public Login(Object pd) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserid = new JLabel("UserID");
		lblUserid.setBounds(74, 87, 46, 14);
		contentPane.add(lblUserid);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(74, 112, 78, 32);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(74, 158, 46, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(140, 155, 86, 20);
		contentPane.add(passwordField);
		
		Uid = new JTextField();
		Uid.setBounds(140, 84, 86, 20);
		contentPane.add(Uid);
		Uid.setColumns(10);
		
		Uname = new JTextField();
		Uname.setBounds(140, 118, 86, 20);
		contentPane.add(Uname);
		Uname.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e, JLabel username, JLabel password, Component frame) {
				String UID= Uid.getText();
				String  uname =username.getText();
				String pd=password.getText();
		
				
				if(uname.equals("Admin")&& pd.equals("123")) 
				{
				
			      //wel.setVisible(true);
			 //     wel1.setWelcomeMessage("Welcome:"+uname);
//			      JLabel label = new JLabel("Welcome:"+uname);
//			      wel.getContentPane().add(label);
				
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
		btnNewButton.setBounds(60, 201, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SignUp");
		btnNewButton_1.setBounds(192, 201, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(321, 201, 89, 23);
		contentPane.add(btnNewButton_2);
	}

	public Login() {
		getContentPane().setLayout(null);
		// TODO Auto-generated constructor stub
	}
}
