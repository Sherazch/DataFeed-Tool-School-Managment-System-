package Datafeed_pkg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

//This  class provides login screen to enter username and password

public class PasswordField {

	JPanel jp = new JPanel();

	PasswordField() {

		jp.setBounds(00, 00, 700, 600);
		jp.setLayout(null);
		jp.setBackground(null);
		jp.setVisible(true);

		//label
		
		JLabel l = new JLabel("		        DataFeed Tool");
		l.setBounds(110, 20, 500, 50);
		l.setFont(new Font("Comic Sans MS", 00, 36));
		l.setForeground(new Color(1, 87, 155));
		l.setVisible(true);
		jp.add(l);

		//Textfield (non editable)
		
		JTextField l1 = new JTextField("	    Enter Credentials");
		l1.setBounds(00, 100, 700, 50);
		l1.setBackground(new Color(1, 87, 155));
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Comic Sans MS", 00, 30));
		l1.setEditable(false);
		l1.setVisible(true);
		jp.add(l1);

		//button
		
		JButton jb = new JButton("Next");
		jb.setFont(new Font("Comic Sans MS", 00, 20));
		jb.setBounds(550, 500, 100, 40);
		jb.setBackground(new Color(1, 87, 155));
		jb.setForeground(Color.white);
		jp.add(jb);
		
		//button
		
		JButton jb1=new JButton("Exit");
		jb1.setFont(new Font("Comic Sans MS",00,20));
		jb1.setBounds(50, 500, 100, 40);
		jb1.setBackground(new Color(1,87,155));
		jb1.setForeground(Color.white);
		jp.add(jb1);

		//label
		
		JLabel l3 = new JLabel("Username    : ");
		l3.setBounds(100, 250, 150, 40);
		l3.setForeground(new Color(1, 87, 155));
		l3.setFont(new Font("Comic Sans MS", 00, 20));
		l3.setVisible(true);
		jp.add(l3);

		//label
		
		JLabel l5 = new JLabel("Password     : ");
		l5.setBounds(100, 300, 150, 40);
		l5.setForeground(new Color(1, 87, 155));
		l5.setFont(new Font("Comic Sans MS", 00, 20));
		l5.setVisible(true);
		jp.add(l5);

		//textfield to enter the username
		
		JTextField tf1 = new JTextField();
		tf1.setBounds(250, 250, 200, 35);
		tf1.setFont(new Font("Comic Sans MS", 00, 20));

		//textfield to enter the password
		
		JTextField tf2 = new JTextField();
		tf2.setBounds(250, 300, 200, 35);
		tf2.setFont(new Font("Comic Sans MS", 00, 20));

		tf1.setVisible(true);
		tf2.setVisible(true);
		tf1.setBackground(Color.white);
		tf2.setBackground(Color.white);
		tf1.setForeground(new Color(1, 87, 155));
		tf2.setForeground(new Color(1, 87, 155));
		jp.add(tf1);
		jp.add(tf2);

		//Actions upon clicking buttons
		
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((tf1.getText().isEmpty()) || (tf2.getText().isEmpty())) {
					JOptionPane
							.showMessageDialog(null,
									"\tInvalid username / password \n Username / password cannot be null");
				}
				else{
					if(verify(tf1.getText(),tf2.getText())){
						ControllerClass.adminscreen();
					}
				}
			}
		});

		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
	}

	// For validation
	public static boolean verify(String u, String p) {
		boolean tmp = false;
		boolean rtn=false;
		String passcode, temp = "";
		while (tmp == false) {
			String user = u;

			try {
				Class.forName("com.mysql.jdbc.Driver");			// database connector
			} catch (Exception e) {
				System.out.println("ERROR :: " + e.getMessage());
			}
			try {
				String host = "jdbc:mysql://localhost/datafeed_database";		
				String username = "root";
				String password = "";
				Connection con = DriverManager.getConnection(host, username,
						password);				//establishing connection to databse
				Statement st = (Statement) con.createStatement();
				String sql = "SELECT * FROM credentials WHERE Username='" + user+"'";		//Query
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
					// System.out.println(rs.getString(1)+"\t"+rs.getString(2));
					temp = crypto(rs.getString(2));			//to encrypt
				}

				passcode = p;
				if (temp.equals(passcode)) {
					JOptionPane.showMessageDialog(null,
							"\tLog in Succesfully !");
					tmp = true;
					rtn=true;
				} else{
					JOptionPane.showMessageDialog(null,
							"\tInvalid username / password");p="";u="";break;}

				con.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"ERROR(1) :: " + e.getMessage()
								+ "\nInValid Credentials!");p="";u="";
				break;
			}
		}
		return rtn;
	}

	
	// method to reverse the order of password
	public static String crypto(String sen) {
		String array = new StringBuffer(sen).reverse().toString();
		return array;

	}
}