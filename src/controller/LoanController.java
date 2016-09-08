/** 
NAME 				:PRADEEP RAJA MOHAN
DATE  				:4/06/2016
FILE NAME			:LoanController
SOURCE FILE NAME	:LoanController.java
LAB					:4
Program to  parse the bank csv file to an array and insert into the database 
and retrive the data and display it in a JTabel
*/
package controller;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//import all files from other package like model, controller and views 
import banking.BankRecords;
import models.daoModel;
import views.LoanView;
//create a LoanController class which extends the bank record file
public class LoanController extends BankRecords
{
	/**
	 * 	main function begins
	 */

    public static void main(String args[]) 
	{		
    	//create object for BankRecord File 
		BankRecords obj = new BankRecords();
		obj.readData();
		obj.processData();
		//create object for daoModel
		daoModel do1 = new daoModel(); 
		System.out.println("Connecting to database succesfull");
		try
		{
		//create table function is called to create a table in the database 	
		do1.createTable();
		//pass the bankRecord array to the insert function to insert the rows into the database
		do1.insertrows(user);
	    //instantiate the LoanView class 
		new LoanView();
		}
		catch(Exception e){
			System.out.println("error occured accessing the database: please contact Administrator ");
		}
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Cur dt=" + timeStamp + "\nProgrammed By PRADEEP RAJA MOHAN\n");		
		}
}
 

	  


