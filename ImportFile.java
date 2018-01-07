package Datafeed_pkg;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

/*
 * This class provides the whole logic to import file  from the given path source
 * and store the data into the data base 
 */

public class ImportFile {

    private String inputFile;

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    //method takes path as input
    
    public static void read(String path) throws IOException  {
        File inputWorkbook = new File(path);
        Workbook w;
        WorkbookSettings ws=new WorkbookSettings();
        ws.setEncoding("Cp1252");			// encoder so that special characters remains the same
        Cell c1,c2,c3,c4,c5;
        int s1;
        String s2,s3,s4,s5;
        try {
            w = Workbook.getWorkbook(inputWorkbook,ws);
            // Get the first sheet
            Sheet sheet = w.getSheet(0);
            
            for(int i=0;i<sheet.getRows();i++){			// iteration contiues untill the last row
            	c1=sheet.getCell(0,i);					// fetch data from cell of 0th column and ith row
            	s1=Integer.parseInt(c1.getContents());
            	c2=sheet.getCell(1, i);
            	s2=c2.getContents();
            	c3=sheet.getCell(2, i);
            	s3=c3.getContents();
            	c4=sheet.getCell(3, i);
            	s4=c4.getContents();
            	c5=sheet.getCell(4, i);
            	s5=c5.getContents();
     //       	System.out.println(s1+"\t"+s2+"\t"+s3+"\t"+s4+"\t"+s5);
            	Operations.add(s1, s2, s3, s4, s5);
            	
            }
            JOptionPane.showMessageDialog(null,"Inserted Successfully");

        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null,"Error :: \n"+e.getMessage());
        }
    }
}
