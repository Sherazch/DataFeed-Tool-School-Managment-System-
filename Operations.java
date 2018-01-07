package Datafeed_pkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.text.DefaultCaret;

//This  class generates the queries for insert/delete/edit/show data from database

public class Operations {

	// to insert new student
	public static void add(int a, String b, String c, String d, String e) {
		try {
			Class.forName("com.mysql.jdbc.Driver");		// databse connector

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "ERROR :: " + e1.getMessage());
		}

		try {
			String host = "jdbc:mysql://localhost/datafeed_database";
			String username = "root";
			String password = "";
			Connection con = DriverManager.getConnection(host, username,		// to open connection with database
					password);
			Statement st = con.createStatement();
			st.executeUpdate("INSERT INTO student_info(S_ID,FirstName,LastName,Address,Course)"	//Query
					+ " VALUES("
					+ a
					+ ",'"
					+ b
					+ "','"
					+ c
					+ "','"
					+ d
					+ "','"
					+ e + "')");

			con.close();				// connection to database is closed
		} catch (Exception i) {
			JOptionPane
					.showMessageDialog(null, "ERROR(1) :: " + i.getMessage());
		}
		
	}

	
	//	********* All methods have similar structure and explanation except the query is differnet ********
	
	
	
	// to delete a student
	public static void delete(int a) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR :: " + e.getMessage());
		}

		try {
			String host = "jdbc:mysql://localhost/datafeed_database";
			String username = "root";
			String password = "";
			Connection con = DriverManager.getConnection(host, username,
					password);
			Statement st = (Statement) con.createStatement();
			st.executeUpdate("DELETE  FROM student_info" + " WHERE S_ID="
					+ a + ";");
			con.close();
			JOptionPane.showMessageDialog(null,"Deleted Successfully");
		} catch (Exception e) {
			JOptionPane
					.showMessageDialog(null, "ERROR(1) :: " + e.getMessage());
		}
		
	}

	// to update a record
	public static void updaterecord(int a, String b, String c, String d,
			String e) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (Exception x) {
			JOptionPane.showMessageDialog(null, "ERROR :: " + x.getMessage());
		}

		try {
			String host = "jdbc:mysql://localhost/datafeed_database";
			String username = "root";
			String password = "";
			Connection con = DriverManager.getConnection(host, username,
					password);
			Statement st = (Statement) con.createStatement();
			st.executeUpdate("UPDATE student_info " + " SET FirstName ='" + b
					+ "',LastName='" + c + "',Address='" + d + "',Course='" + e
					+ "'" + " Where S_ID = " + a + ";");
			con.close();
			JOptionPane.showMessageDialog(null,"Updated Successfully");
		} catch (Exception y) {
			JOptionPane.showMessageDialog(null,"ERROR(1) :: " + y.getMessage());
		}
		
	}
	
	// to update Password
	public static void updatepassword(String b, String c) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (Exception x) {
			JOptionPane.showMessageDialog(null, "ERROR :: " + x.getMessage());
		}

		try {
			String host = "jdbc:mysql://localhost/datafeed_database";
			String username = "root";
			String password = "";
			Connection con = DriverManager.getConnection(host, username,
					password);
			Statement st = (Statement) con.createStatement();
			st.executeUpdate("UPDATE credentials " + " SET Password ='" + c
					+ "' " + " WHERE Username = '" + b + "';");
			con.close();
			JOptionPane.showMessageDialog(null,"Updated Successfully");
		} catch (Exception y) {
			JOptionPane.showMessageDialog(null,"ERROR(1) :: " + y.getMessage());
		}
		
	}

	// to show all records
	public static void displayall(){
		int counter=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"ERROR :: " + e.getMessage());
		}

		try {
			String host = "jdbc:mysql://localhost/datafeed_database";
			String username = "root";
			String password = "";
			Connection con = DriverManager.getConnection(host, username,
					password);
			Statement st = (Statement) con.createStatement();
			String sql = "select* from student_info";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				ShowStudentView.ta.append("\n"+ rs.getString(1) + "\t"
						+ rs.getString(2) + "\t" + rs.getString(3) + "\t\t"
						+ rs.getString(5) + "\t\t" + rs.getString(4));
				counter++;
			}
			con.close();
			ShowStudentView.tf2.setText(""+counter);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"ERROR(1) :: " + e.getMessage());
		}
	}
	
	//to show only one record
	public static void displayone(int a){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"ERROR :: " + e.getMessage());
		}

		try {
			String host = "jdbc:mysql://localhost/datafeed_database";
			String username = "root";
			String password = "";
			Connection con = DriverManager.getConnection(host, username,
					password);
			Statement st = (Statement) con.createStatement();
			String sql = "select* from student_info Where S_ID="+a;
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				ShowStudentView.ta.setText("\n" + rs.getString(1) + "\t"
						+ rs.getString(2) + "\t" + rs.getString(3) + "\t\t"
						+ rs.getString(5) + "\t\t" + rs.getString(4));
				StudentView.ta.setText("\n" + rs.getString(1) + "\t"
						+ rs.getString(2) + "\t" + rs.getString(3) + "\t\t"
						+ rs.getString(5) + "\t\t" + rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"ERROR(1) :: " + e.getMessage());
		}
	}
}
