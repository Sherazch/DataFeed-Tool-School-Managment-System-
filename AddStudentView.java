package Datafeed_pkg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

// This class provides the interface where you can add a new student into a database

public class AddStudentView {

	JPanel jp = new JPanel();

	AddStudentView() {

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

		//TextField (not editable)
		JTextField l1 = new JTextField("	    Enter Student Info");
		l1.setBounds(00, 100, 700, 50);
		l1.setBackground(new Color(1, 87, 155));
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Comic Sans MS", 00, 30));
		l1.setEditable(false);
		l1.setVisible(true);
		jp.add(l1);

		//button
		JButton jb = new JButton("Add");
		jb.setFont(new Font("Comic Sans MS", 00, 20));
		jb.setBounds(550, 500, 100, 40);
		jb.setBackground(new Color(1, 87, 155));
		jb.setForeground(Color.white);
		jp.add(jb);

		//button
		JButton jb1 = new JButton("Exit");
		jb1.setFont(new Font("Comic Sans MS", 00, 20));
		jb1.setBounds(50, 500, 100, 40);
		jb1.setBackground(new Color(1, 87, 155));
		jb1.setForeground(Color.white);
		jp.add(jb1);

		//Label
		JLabel l3 = new JLabel("First Name    : ");
		l3.setBounds(100, 200, 150, 35);
		l3.setForeground(new Color(1, 87, 155));
		l3.setFont(new Font("Comic Sans MS", 00, 20));
		l3.setVisible(true);
		jp.add(l3);

		///Label
		JLabel l5 = new JLabel("Last Name     : ");
		l5.setBounds(100, 250, 150, 35);
		l5.setForeground(new Color(1, 87, 155));
		l5.setFont(new Font("Comic Sans MS", 00, 20));
		l5.setVisible(true);
		jp.add(l5);

		//Label
		JLabel l6 = new JLabel("Course     : ");
		l6.setBounds(100, 300, 150, 35);
		l6.setForeground(new Color(1, 87, 155));
		l6.setFont(new Font("Comic Sans MS", 00, 20));
		l6.setVisible(true);
		jp.add(l6);

		//Label
		JLabel l7 = new JLabel("Student ID   : ");
		l7.setBounds(100, 350, 150, 35);
		l7.setForeground(new Color(1, 87, 155));
		l7.setFont(new Font("Comic Sans MS", 00, 20));
		l7.setVisible(true);
		jp.add(l7);

		//Label
		JLabel l8 = new JLabel("Address     : ");
		l8.setBounds(100, 400, 150, 35);
		l8.setForeground(new Color(1, 87, 155));
		l8.setFont(new Font("Comic Sans MS", 00, 20));
		l8.setVisible(true);
		jp.add(l8);

		//TextField to enter FirstName
		JTextField tf1 = new JTextField();
		tf1.setBounds(250, 200, 200, 35);
		tf1.setFont(new Font("Comic Sans MS", 00, 20));

		//TextField to enter LastName
		JTextField tf2 = new JTextField();
		tf2.setBounds(250, 250, 200, 35);
		tf2.setFont(new Font("Comic Sans MS", 00, 20));

		//TextField to enter Course
		JTextField tf3 = new JTextField();
		tf3.setBounds(250, 300, 200, 35);
		tf3.setFont(new Font("Comic Sans MS", 00, 20));

		//TextField to enter ID
		JTextField tf4 = new JTextField();
		tf4.setBounds(250, 350, 200, 35);
		tf4.setFont(new Font("Comic Sans MS", 00, 20));

		//TextField to enter Address
		JTextField tf5 = new JTextField();
		tf5.setBounds(250, 400, 200, 80);
		tf5.setFont(new Font("Comic Sans MS", 00, 20));

		tf1.setVisible(true);
		tf2.setVisible(true);
		tf3.setVisible(true);
		tf4.setVisible(true);
		tf5.setVisible(true);
		tf1.setBackground(Color.white);
		tf2.setBackground(Color.white);
		tf3.setBackground(Color.white);
		tf4.setBackground(Color.white);
		tf5.setBackground(Color.white);
		tf1.setForeground(new Color(1, 87, 155));
		tf2.setForeground(new Color(1, 87, 155));
		tf3.setForeground(new Color(1, 87, 155));
		tf4.setForeground(new Color(1, 87, 155));
		tf5.setForeground(new Color(1, 87, 155));
		jp.add(tf1);
		jp.add(tf2);
		jp.add(tf3);
		jp.add(tf4);
		jp.add(tf5);

		// Actions perfformed when buttons are clicked
		
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Action
				Operations.add(Integer.parseInt(tf4.getText()), tf1.getText(),
						tf2.getText(), tf5.getText(), tf3.getText());
				JOptionPane.showMessageDialog(null,"Inserted Successfully");
			}
		});

		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControllerClass.returntomenu(jp);
			}
		});

	}
}
