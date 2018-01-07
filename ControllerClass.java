package Datafeed_pkg;

import java.io.IOException;
import java.io.InputStream;

import javax.swing.JPanel;

import jxl.WorkbookSettings;

/*
 * This class is the main driver of the project and have object of all other classes
 * all the buttons in the application upon clicking referd to this controller class
 *  where this class directs them about what to do next.  
 */

public class ControllerClass {
	
	
	// Objects of different classes in the project
	static FirstView fv=new FirstView();
	static View jf=new View();
	static PasswordField pf=new PasswordField();
	static AdminMenu am=new AdminMenu();
	static AddStudentView asv=new AddStudentView();
	static EditStudentView esv=new EditStudentView();
	static DeleteStudentView dsv=new DeleteStudentView();
	static ChangePasswordView cpv=new ChangePasswordView();
	static ShowStudentView ssv=new ShowStudentView();
	static ImportFileView ifv=new ImportFileView();
	static StudentView sv=new StudentView();
	
	//main method
	public static void main(String[]args){
		fv.jp.setVisible(true);
		jf.add(fv.jp);
		fv.jp.repaint();
	}
	
	//method to go to log in screen
	public static void passwordview(){
		fv.jp.setVisible(false);
		pf.jp.setVisible(true);
		jf.add(pf.jp);
		pf.jp.repaint();
	}
	
	//method to go to student screen
	public static void stdview(){
		fv.jp.setVisible(false);
		sv.jp.setVisible(true);
		jf.add(sv.jp);
		sv.jp.repaint();
	}

	//method to go to admin menu screen
	public static void adminscreen(){
		pf.jp.setVisible(false);
		am.jp.setVisible(true);
		jf.add(am.jp);
		am.jp.repaint();
	}
	
	//method to go to add new student screen
	public static void addscreen(){
		am.jp.setVisible(false);
		asv.jp.setVisible(true);
		jf.add(asv.jp);
		asv.jp.repaint();
	}
	
	//method to go to edit student record screen
	public static void editscreen(){
		am.jp.setVisible(false);
		esv.jp.setVisible(true);
		jf.add(esv.jp);
		esv.jp.repaint();
	}
	
	//method to go to delete student record screen
	
	public static void deletescreen(){
		am.jp.setVisible(false);
		dsv.jp.setVisible(true);
		jf.add(dsv.jp);
		dsv.jp.repaint();
	}
	
	//method to go to reset password screen
	public static void changepasswordscreen(){
		am.jp.setVisible(false);
		cpv.jp.setVisible(true);
		jf.add(cpv.jp);
		cpv.jp.repaint();
	}
	
	//method to go to display student records screen
	public static void showscreen(){
		am.jp.setVisible(false);
		ssv.jp.setVisible(true);
		jf.add(ssv.jp);
		ssv.jp.repaint();
	}
	
	//method to go to import records file screen
	
	public static void importscreen(){
		am.jp.setVisible(false);
		ifv.jp.setVisible(true);
		jf.add(ifv.jp);
		ifv.jp.repaint();
	}
	
	//method to return to admin menu from any screen
	public static void returntomenu(JPanel p){
		p.setVisible(false);
		am.jp.setVisible(true);
		am.jp.repaint();
	}

}
