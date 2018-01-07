package Datafeed_pkg;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

//This class provides interface for selecting user's role i.e. student or administrator

public class FirstView {
	
	JPanel jp=new JPanel();
	
	FirstView(){
	
		
		jp.setBounds(00, 00, 700,600);
		jp.setLayout(null);
		jp.setBackground(null);
		jp.setVisible(false);
		
		//Label
		
		JLabel l=new JLabel("Welcome to DataFeed Tool");
		l.setBounds(110,20,500,50);
		l.setFont(new Font("Comic Sans MS",00,36));
		l.setForeground(new Color(1,87,155));
		l.setVisible(true);
		jp.add(l);
		
		//textfield (non editable)
		
		JTextField l1=new JTextField("	   Select Your Role");
		l1.setBounds(00,100,700,50);
		l1.setBackground(new Color(1,87,155));
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Comic Sans MS",00,30));
		l1.setEditable(false);
		l1.setVisible(true);
		jp.add(l1);
		
		//Button
		
		JButton jb=new JButton("Next");
		jb.setFont(new Font("Comic Sans MS",00,20));
		jb.setBounds(550, 500, 100, 40);
		jb.setBackground(new Color(1,87,155));
		jb.setForeground(Color.white);
		jp.add(jb);
		
		//Button
		
		JButton jb1=new JButton("Exit");
		jb1.setFont(new Font("Comic Sans MS",00,20));
		jb1.setBounds(50, 500, 100, 40);
		jb1.setBackground(new Color(1,87,155));
		jb1.setForeground(Color.white);
		jp.add(jb1);
		
		//Radio Button
		
		JRadioButton jrb1=new JRadioButton();
		jrb1.setFont(new Font("Comic Sans MS",00,25));
		jrb1.setBounds(250,230,200,50);
		jrb1.setText("Administrator");
		jrb1.setBackground(null);
		jrb1.setForeground(new Color(1,87,155));
		jp.add(jrb1);
		
		//Radio Button
		
		JRadioButton jrb2=new JRadioButton();
		jrb2.setFont(new Font("Comic Sans MS",00,25));
		jrb2.setBounds(250,290,200,50);
		jrb2.setText("Student");
		jrb2.setBackground(null);
		jrb2.setForeground(new Color(1,87,155));
		jp.add(jrb2);
		
		//Action upon clicking buttons
		
		jrb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			jrb2.setSelected(false);
			jrb1.setSelected(true);
			}
		});

		jrb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jrb1.setSelected(false);
				jrb2.setSelected(true);
	}
});
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(jrb1.isSelected()== true){
					ControllerClass.passwordview();
					}
					else if (jrb2.isSelected()==true){
						ControllerClass.stdview();
					}
			}
		});
		
	}
	
}
