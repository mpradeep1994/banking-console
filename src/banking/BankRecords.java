package banking;


/** 
NAME 				:PRADEEP RAJA MOHAN
DATE  				:4/06/2016
FILE NAME			:BankRecords
SOURCE FILE NAME	:BankRecords.java
LAB					:4
Program to  parse the bank csv file to an array and insert into the database  
*/

//import the necessary util class 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * implement the client interface
 * @param ...
 */

public class BankRecords implements Client {

	//declare the variable required
	private String id;
	private Integer age;
	private String sex;
	private double income;
	private String region;
	private String married;
	private Integer children;
	private String car;
	private String save_act;
	private String current_act;
	private String mortgage;
	private String pep;
	
	//create an List of List array to store the csv values
	static List<List<String>> array = new ArrayList<>();	
		
	public static BankRecords  user[] = new BankRecords[600];
	
	/**
	 * implement the client interface read the data from the csv and stores it to the array list
	 * readData() is used to parse csv file into a List of List of String  array
	 *  
	 */
	
	public void readData()
	{	
		//path of the CSV file to be imported
		 String csvFile = "bank-Detail.csv";
		 String splitBy = ",";	
		//String []client;
		BufferedReader reader = null;
		String record;
		try
		{	//read the content from the  csv file 
			reader = new BufferedReader(new FileReader(csvFile));
			while ((record = reader.readLine()) != null) {

				// use comma as separator
				//client = record.split(splitBy);
				array.add(Arrays.asList(record.split(splitBy)));
				//reader.close();	
						
		}
			//System.out.println(array);
			
		}
		//catch the exception thrown
		catch (FileNotFoundException e){
			System.out.println("Given file not found: "+csvFile);
			System.exit(0);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
}
	
	/**
	 * implement the client interface Processdata and stores it to the list of list array
	 * processData() is used to process the array into a list of BankRecord object
	 * 
	 */
	
	public  void processData()
	{
		for(int recordLine=0;recordLine<600;recordLine++)
		{
			
		//creating object definition for each of the 600 objects.
		try {
			
			user[recordLine] = new BankRecords();			
			user[recordLine].setID(array.get(recordLine).get(0));
			user[recordLine].setAge(Integer.parseInt(array.get(recordLine).get(1)));
			user[recordLine].setSex(array.get(recordLine).get(2));
			user[recordLine].setIncome(Float.parseFloat(array.get(recordLine).get(4)));
			user[recordLine].setRegion(array.get(recordLine).get(3));
			user[recordLine].setMarried(array.get(recordLine).get(5));
			user[recordLine].setChildren(Integer.parseInt(array.get(recordLine).get(6)));
			user[recordLine].setCar(array.get(recordLine).get(7));
			user[recordLine].setSave_act(array.get(recordLine).get(8));
			user[recordLine].setCurrent_act(array.get(recordLine).get(9));
			user[recordLine].setMortgage(array.get(recordLine).get(10));
			user[recordLine].setPep(array.get(recordLine).get(11));
			
		} 
		//catch the exception thrown
		catch (IndexOutOfBoundsException e) {
			// File was not opened.
			System.out.println("Contact Administrator: Unexpected Error ");
			System.exit(0);
		}
		//
	
		}
	//	writeData();
	}
	//Getter and setter for the variables used in the program
	public void setID(String id){
		this.id= id;
	
	}	
	
	/**
	 *  the region of Client
	 */
	 
	public void setAge(int age)
	{
	this.age= age;
	}
	
	/**
	 *  sex Sets the sex for Client
	 */
	public void setSex(String sex){
		this.sex= sex;
	}
	/**
	 * @param income Sets the income for Client
	 */
	public void setIncome(double income){
		this.income= income;
		
	}
	/**
	 * @param region Sets the region for ClientDetails.
	 */
	public void setRegion(String region){
		this.region= region;
		//System.out.print(region+"\t");
	}
	/**
	 * @param married Sets the married for ClientDetails.
	 */
	public void setMarried(String married){
		this.married= married;
		
	}
	/**
	 * @param children Sets the children for ClientDetails.
	 */
	public void setChildren(int children){
		this.children= children;
		
	}
	/**
	 * @param car Sets the car for ClientDetails.
	 */
	public void setCar(String car){
		this.car= car;
		
	}
	/**
	 * @param save_act Sets the save_act for ClientDetails.
	 */
	public void setSave_act(String save_act){
		this.save_act= save_act;
		
	}
	/**
	 * @param current_act Sets the current_act for ClientDetails.
	 */
	public void setCurrent_act(String current_act){		
		this.current_act= current_act;
		
	}
	/**
	 * @param mortgage Sets the mortgage for ClientDetails.
	 */
	public void setMortgage(String mortgage){
		this.mortgage= mortgage;
	}
	/**
	 * @param pep Sets the pep for ClientDetails.
	 */
	public void setPep(String pep){
		this.pep= pep;
		
	}
	
	
	/**
	 * return the ID of Client
	 */
	public String getID()
	{
		return id;
	}
	/**
	 * print the age of Client
	 */
	public int getAge()
	{
		return age;
		//System.out.printf(" %-4d ",age);
	}
	/**
	 * return the sex of Client
	 */
	public String getSex()
	{
		return sex;
		//System.out.printf("%-10s",sex);
	}
	/**
	 * return the income of Client
	 */
	public double getIncome()
	{
		return income;
		//System.out.printf("%-15s", income);
	}
	/**
	 * return the region of Client
	 */
	public String getRegion()
	{	return region;
		//System.out.printf("%-15s",region);
	}
	/**
	 * return the married status of Client
	 */
	public String getMarried()
	{	return married;
		//System.out.print(married+"\t");
	}
	/**
	 * return the number of children of Client
	 */
	public int getChildren()
	{
		return children;
		//System.out.print(children+"\t");
	}
	/**
	 * return the car of Client
	 */
	public String  getCar()
	{
		return car; 
		//System.out.print(car+"\t");
	}
	/**
	 * return the save_act of Client
	 */
	public String getSave_act( )
	{
		return save_act;
	//	System.out.print(save_act+"\t");
	}
	/**
	 * return the region of Client
	 */
	public String getCurrent_act()
	{
		return current_act;
		//System.out.print(current_act+"\t");
	}
	/**
	 * print the mortgage of Client
	 */
	public String getMortgage()
	{
		return mortgage;
		//System.out.printf("%s",mortgage+"\t");
	}
	/**
	 * return the pep of Client
	 */
	public String getPep()
	{
		return pep;
		///System.out.print(pep+"\t");
	}

	/**
	 *print the first 25 records of the user details
	  */
	
	
	public  void writeData()
	{
		
		try{
		if (array.get(0) != null ){
		
		System.out.print("  ID \t  AGE \t SEX \t REGION \t INCOME \t MORTAGE\n");
		for(int recordLine=0;recordLine<25;recordLine++)
		{
			user[recordLine].getID();
			user[recordLine].getAge();
			user[recordLine].getSex();
			user[recordLine].getRegion();
			user[recordLine].getIncome();
			user[recordLine].getMortgage();
		System.out.print("\n");
		
		}
		}
	}
	//catch the exception thrown
	catch (Exception e){
		//values not set to the instance variable
		System.out.println("wite :Contact Administrator: Unexpected Error ");
		System.exit(0);
	}
			
	}
}
