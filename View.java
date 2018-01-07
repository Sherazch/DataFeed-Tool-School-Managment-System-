package Datafeed_pkg;

import java.awt.*;
import javax.swing.*;

//This class provides the frame in the project, this is the only frame and contains all the panels in it

public class View extends JFrame {
	
	// to show in the middle of the screen of any system
	int x=(int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2);
	int y=(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
	View(){
		
		//Frame atrributes
		
		setTitle("Data Feed Tool");
		setBounds(x-350,y-300,700,600);
		setVisible(true);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
}
