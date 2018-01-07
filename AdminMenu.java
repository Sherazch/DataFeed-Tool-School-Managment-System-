package Datafeed_pkg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

// this class provide admin menu interface after logging in successfully

public class AdminMenu {
	
	JPanel jp=new JPanel();
	
	AdminMenu(){
	jp.setBounds(00, 00, 700,600);
	jp.setLayout(null);
	jp.setBackground(null);
	jp.setVisible(false);
	
	//label
	JLabel l=new JLabel("           DataFeed Tool");
	l.setBounds(110,20,500,50);
	l.setFont(new Font("Comic Sans MS",00,36));
	l.setForeground(new Color(1,87,155));
	l.setVisible(true);
	jp.add(l);
	
	//TextField (non editable)
	JTextField l1=new JTextField("	       Admin Menu");
	l1.setBounds(00,100,700,50);
	l1.setBackground(new Color(1,87,155));
	l1.setForeground(Color.WHITE);
	l1.setFont(new Font("Comic Sans MS",00,30));
	l1.setEditable(false);
	l1.setVisible(true);
	jp.add(l1);
	
	//Buttons
	JButton jb1=new JButton("Add Record");
	JButton jb2=new JButton("Delete Record");
	JButton jb3=new JButton("Edit Record");
	JButton jb4=new JButton("Import Records");
	JButton jb5=new JButton("Reset Password");
	JButton jb6=new JButton("View Records");
	JButton jb7=new JButton("Exit");
	
	jb1.setBounds(250, 180, 200, 40);
	jb2.setBounds(250, 230, 200, 40);
	jb3.setBounds(250, 280, 200, 40);
	jb4.setBounds(250, 320, 200, 40);
	jb5.setBounds(250, 370, 200, 40);
	jb6.setBounds(250, 420, 200, 40);
	jb7.setBounds(250, 470, 200, 40);
	
	jb1.setFont(new Font("Comic Sans MS", 00, 20));
	jb2.setFont(new Font("Comic Sans MS", 00, 20));
	jb3.setFont(new Font("Comic Sans MS", 00, 20));
	jb4.setFont(new Font("Comic Sans MS", 00, 20));
	jb5.setFont(new Font("Comic Sans MS", 00, 20));
	jb6.setFont(new Font("Comic Sans MS", 00, 20));
	jb7.setFont(new Font("Comic Sans MS", 00, 20));
	
	jb1.setVisible(true);
	jb2.setVisible(true);
	jb3.setVisible(true);
	jb4.setVisible(true);
	jb5.setVisible(true);
	jb6.setVisible(true);
	jb7.setVisible(true);
	
	jb1.setBackground(Color.white);
	jb1.setForeground(new Color(1, 87, 155));
	jb2.setBackground(Color.white);
	jb2.setForeground(new Color(1, 87, 155));
	jb3.setBackground(Color.white);
	jb3.setForeground(new Color(1, 87, 155));
	jb4.setBackground(Color.white);
	jb4.setForeground(new Color(1, 87, 155));
	jb5.setBackground(Color.white);
	jb5.setForeground(new Color(1, 87, 155));
	jb6.setBackground(Color.white);
	jb6.setForeground(new Color(1, 87, 155));
	jb7.setBackground(Color.white);
	jb7.setForeground(new Color(1, 87, 155));
	
	jp.add(jb1);
	jp.add(jb2);
	jp.add(jb3);
	jp.add(jb4);
	jp.add(jb5);
	jp.add(jb6);
	jp.add(jb7);
	
	//Actions performed when buttons are clicked on admin menu
	
	jb1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		ControllerClass.addscreen();
		}
	});
	
	jb2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		ControllerClass.deletescreen();
		}
	});
	
	jb3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		ControllerClass.editscreen();
		}
	});
	
	jb4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		ControllerClass.importscreen();
		}
	});
	
	jb5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			ControllerClass.changepasswordscreen();
		}
	});
	
	jb6.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		ControllerClass.showscreen();
		}
	});
	
	jb7.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		System.exit(0);
		}
	});
	
}

}
