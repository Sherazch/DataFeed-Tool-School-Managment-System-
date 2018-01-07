package Datafeed_pkg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// This class provides the interface for the import file screen

public class ImportFileView {

	JPanel jp = new JPanel();

	ImportFileView() {

		jp.setBounds(00, 00, 700, 600);
		jp.setLayout(null);
		jp.setBackground(null);
		jp.setVisible(true);

		// Label

		JLabel l = new JLabel("		        DataFeed Tool");
		l.setBounds(110, 20, 500, 50);
		l.setFont(new Font("Comic Sans MS", 00, 36));
		l.setForeground(new Color(1, 87, 155));
		l.setVisible(true);
		jp.add(l);

		// textfield (non editable)

		JTextField l1 = new JTextField("	    Enter Source of File");
		l1.setBounds(00, 100, 700, 50);
		l1.setBackground(new Color(1, 87, 155));
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Comic Sans MS", 00, 30));
		l1.setEditable(false);
		l1.setVisible(true);
		jp.add(l1);

		// button

		JButton jb = new JButton("Import");
		jb.setFont(new Font("Comic Sans MS", 00, 20));
		jb.setBounds(550, 500, 100, 40);
		jb.setBackground(new Color(1, 87, 155));
		jb.setForeground(Color.white);
		jp.add(jb);

		// button

		JButton jb1 = new JButton("Exit");
		jb1.setFont(new Font("Comic Sans MS", 00, 20));
		jb1.setBounds(50, 500, 100, 40);
		jb1.setBackground(new Color(1, 87, 155));
		jb1.setForeground(Color.white);
		jp.add(jb1);

		// label

		JLabel l3 = new JLabel("Source : ");
		l3.setBounds(100, 200, 100, 35);
		l3.setForeground(new Color(1, 87, 155));
		l3.setFont(new Font("Comic Sans MS", 00, 20));
		l3.setVisible(true);
		jp.add(l3);

		// text field to enter the path of file

		JTextField tf1 = new JTextField();
		tf1.setBounds(200, 200, 450, 35);
		tf1.setFont(new Font("Comic Sans MS", 00, 15));
		tf1.setVisible(true);
		tf1.setForeground(new Color(1, 87, 155));
		jp.add(tf1);

		// button to browse files

		JButton jb2 = new JButton("Browse");
		jb2.setFont(new Font("Comic Sans MS", 00, 13));
		jb2.setBounds(570, 175, 80, 25);
		jb2.setBackground(new Color(1, 87, 155));
		jb2.setForeground(Color.white);
		jp.add(jb2);

		// text area to show the instructions to load the path correctly

		JTextArea ta = new JTextArea();
		ta.setBounds(50, 265, 600, 200);
		ta.setEditable(false);
		ta.setAutoscrolls(true);
		ta.setText("\n\t\t***** INSTRUCTIONS *****\n\n"
				+ "=>  Save excel file in .xls extension.\n"
				+ "=>  Enter file source without quotation marks.\n"
				+ "=>  Always place double backslash instead of single.\n"
				+ "=>  Reconfirm the entered path.");
		ta.setFont(new Font("Comic Sans MS", 00, 15));
		ta.setForeground(new Color(1, 87, 155));
		ta.setVisible(true);
		jp.add(ta);

		// Actions upon clicking buttons

		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Action
				if (tf1.getText() == null) {
					JOptionPane.showMessageDialog(null,
							"Source Path cannot be empty !");
				} else {
					try {
						ImportFile.read(tf1.getText());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,
								"\t\tInvalid Path\n" + e.getMessage());
					}
				}
			}
		});

		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControllerClass.returntomenu(jp);
			}
		});

		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Action
				try {
					ImportFile.read(browse());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "\t\tInvalid Path\n"
							+ e.getMessage());
				}
			}
		});

	}

	// method to browse a file and get path automatically

	public static String browse() {
		String path = "";

		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("choosertitle");
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		chooser.setAcceptAllFileFilterUsed(false);

		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			// System.out.println("\nComon you fucking file\n"+"getCurrentDirectory(): "
			// + chooser.getCurrentDirectory());
			path = chooser.getSelectedFile().toString();
			System.out.println("getSelectedFile() : " + path);
		} else {
			JOptionPane.showMessageDialog(null,
					"\t Invalid Path !\nPath is empty !");
		}

		return path;
	}
}
