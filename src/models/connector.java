/** 
NAME 				:PRADEEP RAJA MOHAN
DATE  				:4/06/2016
FILE NAME			:Connector
SOURCE FILE NAME	:Connector.java
LAB					:4
Program to  parse the bank csv file to an array and insert into the database 
and retrive the data and display it in a JTabel
*/

package models;
//import the required SQl class required. 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connector {

		static Connection connect= null;

		// JDBC driver name and database URL
	    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
	    //string contains the URL for the DB
	    static final String DB_URL = "jdbc:mysql://www.papademas.net:3306/510labs";
 	   //Database credentials
	    static final String USER = "db510";
	    static final String PASS = "510";
/**
 * It creates the connection to the database
 * @return connection
 */
	   public static Connection getConnection(){
		   try{ 
			// sets the Driver for the Program
			Class.forName("com.mysql.jdbc.Driver");  
			//establish connection for the database based on the Username and password
			connect = DriverManager.getConnection(DB_URL, USER,PASS);
			connect.createStatement();
			
			}
			catch(SQLException e){
			System.out.println("Problem while connecting: contact Administrator ");
			System.out.println(e.getMessage());
			}
			catch (ClassNotFoundException e){
			System.out.println("Problem while connecting: contact Administrator");
			e.printStackTrace();
			}
		return connect;	
	}
	
}
	

