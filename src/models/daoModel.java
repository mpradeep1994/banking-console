/** 
NAME 				:PRADEEP RAJA MOHAN
DATE  				:4/06/2016
FILE NAME			:daoModel
SOURCE FILE NAME	:daoModel.java
LAB					:4
Program to  parse the bank csv file to an array and insert into the database 
and retrive the data and display it in a JTabel
*/

package models;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import banking.BankRecords;
// create a class daoModel which create table and insert data into table and retrive data
public class daoModel {

	private static Statement statement= null;

	/**
	 * Used to create a table in DB
	 * @throws Exception throws exception
	 */
	public void createTable() throws Exception{
		try	{
		
			statement= connector.getConnection().createStatement();
			
			String sql =" CREATE TABLE IF NOT EXISTS `p_moha_tab` (" +
				 " `id` char(10) NOT NULL  ,"+
				  "`income` NUMERIC(8,2) DEFAULT NULL,"+
				  "`pep` varchar(3) DEFAULT NULL, "+
				  "PRIMARY KEY(id) )";

		statement.execute(sql);
		//System.out.println("Connecting to database... creating table");
		
		System.out.println("table created into the DB");
		statement.close();
		}
	
	catch( SQLException e){
		System.out.println("error in creating table");	
	System.out.println(e.getMessage());	
	System.exit(0);
	}
	}
	
	/**
	 * Inserts data in the Table
	 * @param user user data
	 * @throws Exception throws Exception
	 */
	public void insertrows(BankRecords[] user) throws Exception{
		try	{
			statement = connector.getConnection().createStatement();
			String sqlinsert=null;
			
			for (int i=0; i< user.length ; i++)
			{
				 sqlinsert ="INSERT INTO p_moha_tab(id,income,pep)"+
				"VALUES ('"+user[i].getID()+"','"+user[i].getIncome()+"','"+user[i].getPep()+"')";
				
		statement.executeUpdate(sqlinsert);
	
		
			}
			System.out.println("record inserted into the table P_moha_tab");
			statement.close();
			
		}	
		
	catch( SQLException e){
		
		System.out.println("insert error");
		System.out.println(e.getMessage());	
		System.exit(0);

	}
}


/**
 * retrive data from the dB using the select Query
 * 	
 * @return result set
 */
public static ResultSet getrows(){
		
		 try {
			 
    		statement = connector.getConnection().createStatement();	    
    	    ResultSet res = statement.executeQuery("SELECT * FROM p_moha_tab order by pep desc");
       	    return res;
    	    
		 }
		 catch (SQLException e) {
			 e.printStackTrace();
			 System.exit(0);
			 }
		 return null;
	}
}
    	