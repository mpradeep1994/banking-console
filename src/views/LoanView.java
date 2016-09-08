/** 
NAME 				:PRADEEP RAJA MOHAN
DATE  				:4/06/2016
FILE NAME			:LoanView
SOURCE FILE NAME	:LoanView.java
LAB					:4
Program to  parse the bank csv file to an array and insert into the database 
and retrive the data and display it in a JTabel
*/

package views;
// import packages required for creating JFrame and event handling
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

//import the daoModel
import models.daoModel;
// class loan view 
/**
 * 
 * @author pradeep
 *Loan view retrives and displays the data in the Jtable
 */
public class LoanView {
  		
	   //declare all variable that are required for JFrame and its components
       private static JFrame frontFrame;
	   private static JLabel headerLabel;
	 
	   private static JButton Records;
	   private static JButton exit;
	  //vector of vector of object which is used to store the data rows extracted from database
	   static Vector<Vector<Object>>  data = new Vector<Vector<Object>>();
	   //column vector is created to store the column header details
       static  Vector<String> column = new Vector<String>(); 
      /**
       * It creates the Jframe and creates the Jtable
       */
       public LoanView()
	   {
    	   	  //create java frame 	
	       	  frontFrame = new JFrame("Bank Menu");
	       	  //set size for the frame
	      	  frontFrame.setSize(500,400);
	      	  //create a Jlable to store a label 
		      headerLabel = new JLabel("WELCOME TO BANK OF IIT",JLabel.CENTER );
		      //create show record button
		      Records = new JButton("Show Records");
		      //create jbutton to close he window
		      exit = new JButton("close");
		      //set layout for the JFrame
		      frontFrame.setLayout(new FlowLayout());
		      
		      //add all the components to the JFrame
    	      frontFrame.add(headerLabel, BorderLayout.CENTER);
		      frontFrame.add(Records);
		      frontFrame.add(exit);
		      frontFrame.setVisible(true);  
		      ButtonHandler handler = new ButtonHandler();
		      //add the Action Handler
		      Records.addActionListener(handler);
	   }
      
       /**
        * create a method JTable to retrieve Result set 
        * Metadata is taken from the resultset
        * @return table data
        */
       static JTable records()
       {
		   try {
	        	 ResultSet res;
	        	 res = daoModel.getrows();
	        	 ResultSetMetaData metaData = res.getMetaData();
	        	 int columns = metaData.getColumnCount();
	        	 //get column names from table!
	        	 String cols = ""; 
	        	 for (int i = 1; i <= columns ; i++) {
	        	   cols = metaData.getColumnName(i);
	        	   
	        	   //add the extracted column details into the column variable
	        	   column.add(cols);
	        	 }
	        	 
	        	 //get row data from table!
	        	 while (res.next()) {
	        		
	        		 Vector<Object> row = new Vector<Object>(columns);
	        		for (int i = 1; i <= columns; i++) {
	        			row.addElement(res.getObject(i));
	        		} 
	        		//add the row details to the data variable
	        	   data.addElement(row);
	        	 }
	        	 JTable table = new JTable(data,column);
	  		 	 return table;
		  	  }   	     
	          catch (Exception e) {
	      	    e.printStackTrace();
	        }
		return null;
	   } 
       //class handler handles the action for the button
		class ButtonHandler implements ActionListener{
		      public  void actionPerformed(ActionEvent e) {

		    	  if(e.getSource() == Records)
		            {
		    		//create a jtable and add it to the Jframe
		    		  JTable table= new JTable();
		    		  table= LoanView.records();
		       		  frontFrame.setSize(500, 400);
		    		  frontFrame.add(table);
		    		  frontFrame.add(new JScrollPane(table));
		    		  frontFrame.pack();
		    		  frontFrame.remove(Records);
		    		  frontFrame.setVisible(true);
		          }
		    	  else if(e.getSource() == exit)
		    	  {
		    		  frontFrame.dispose();
		    		  System.exit(0);
		    	  }
		      }
		}
}


	    
      

       	

