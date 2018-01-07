package Datafeed_pkg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.DefaultCaret;

//This Class provides the show student records scrreen

public class ShowStudentView {
	
	static JTextField tf2 = new JTextField();
	static JTextArea ta=new JTextArea();
	static JPanel jp = new JPanel();

	ShowStudentView() {

		jp.setBounds(00, 00, 700, 600);
		jp.setLayout(null);
		jp.setBackground(null);
		jp.setVisible(true);
		
		//Label

		JLabel l = new JLabel("		        DataFeed Tool");
		l.setBounds(110, 20, 500, 50);
		l.setFont(new Font("Comic Sans MS", 00, 36));
		l.setForeground(new Color(1, 87, 155));
		l.setVisible(true);
		jp.add(l);
		
		//TextField (non editable)

		JTextField l1 = new JTextField("	    Enter Student Info");
		l1.setBounds(00, 100, 700, 50);
		l1.setBackground(new Color(1, 87, 155));
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Comic Sans MS", 00, 30));
		l1.setEditable(false);
		l1.setVisible(true);
		jp.add(l1);

		//button
		
		JButton jb = new JButton("Show");
		jb.setFont(new Font("Comic Sans MS", 00, 20));
		jb.setBounds(550, 500, 100, 40);
		jb.setBackground(new Color(1, 87, 155));
		jb.setForeground(Color.white);
		jp.add(jb);
		
		//Button
		
		JButton jb1=new JButton("Exit");
		jb1.setFont(new Font("Comic Sans MS",00,20));
		jb1.setBounds(50, 500, 100, 40);
		jb1.setBackground(new Color(1,87,155));
		jb1.setForeground(Color.white);
		jp.add(jb1);
		
		//Button
		
		JButton jb2 = new JButton("Show All");
		jb2.setFont(new Font("Comic Sans MS", 00, 20));
		jb2.setBounds(350, 500, 150, 40);
		jb2.setBackground(new Color(1, 87, 155));
		jb2.setForeground(Color.white);
		jp.add(jb2);
		
		//Button
		
		JButton jb3 = new JButton("Clear");
		jb3.setFont(new Font("Comic Sans MS", 00, 20));
		jb3.setBounds(200, 500, 100, 40);
		jb3.setBackground(new Color(1, 87, 155));
		jb3.setForeground(Color.white);
		jp.add(jb3);
		
		//LAbel

		JLabel l3 = new JLabel("Student ID : ");
		l3.setBounds(100, 200, 150, 35);
		l3.setForeground(new Color(1, 87, 155));
		l3.setFont(new Font("Comic Sans MS", 00, 20));
		l3.setVisible(true);
		jp.add(l3);
		
		//texxtfield to enter student ID

		JTextField tf1 = new JTextField();
		tf1.setBounds(250, 200, 200, 35);
		tf1.setFont(new Font("Comic Sans MS", 00, 20));
		tf1.setVisible(true);
		tf1.setForeground(new Color(1, 87, 155));
		jp.add(tf1);
		
		//textfield that shows the count of total records in database
		
		
		tf2.setBounds(620, 230, 60, 25);
		tf2.setFont(new Font("Comic Sans MS", 00, 20));
		tf2.setVisible(false);
		tf2.setForeground(new Color(1, 87, 155));
		jp.add(tf2);
		
		//textArea where all the records will show
		
		ta.setBounds(20, 285, 660, 210);
		ta.setEditable(true);
		ta.setAutoscrolls(true);
		ta.setText("");
		ta.setFont(new Font("Comic Sans MS", 00, 15));
		ta.setForeground(new Color(1, 87, 155));
		ta.setVisible(true);
		jp.add(ta);
		
		//scrollbarr addition to the texxt area
		
		JScrollPane scrollPane = new JScrollPane(ta);
		scrollPane.setBounds(20,285,680,210);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jp.add(scrollPane);
		ta.setVisible(true);
		
		//TextField that shows the heading of the columns
		
		JTextField l4 = new JTextField("S_ID\tFirstName  \t   LastName   \tCourse\t\tAddress");
		l4.setBounds(20, 255, 660, 30);
		l4.setEditable(false);
		l4.setBackground(new Color(1,87,155));
		l4.setForeground(Color.white);
		l4.setFont(new Font("Comic Sans MS", 00, 15));
		l4.setVisible(true);
		jp.add(l4);
		
		//Actions upon clicking the buttons
		
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Action
				Operations.displayone(Integer.parseInt(tf1.getText()));
			}
		});

		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControllerClass.returntomenu(jp);
			}
		});
		
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Action
				Operations.displayall();
				tf2.setVisible(true);
			}
		});
		
		jb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Action
				ta.setText(null);
				tf2.setText(null);
			}
		});
		
	}
}
