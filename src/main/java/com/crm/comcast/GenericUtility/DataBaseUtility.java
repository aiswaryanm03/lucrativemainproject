package com.crm.comcast.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;
import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	static Driver driver;
	static Connection connection;
	static ResultSet result;
	/**
	 * This method will perform the mysql database connection
	 * @throws SQLException
	 */
	public void connectDB()throws SQLException
	{
		try {
			driver=new Driver();
			DriverManager.registerDriver(driver);
			connection=DriverManager.getConnection(IConstants.JDBC_URL_STRING,IConstants.JDBC_USERNAME,IConstants.JDBC_PASSWORD);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	
	}
	/**
	 * This method will close MySQL database connection
	 * @throws SQLException
	 */
	public void closeDB()throws SQLException
	{
		try {
			connection.close();
		}
		catch(Exception e)
		{
			
		}
	}
		/**
		 * This method will execute the querry
	     * @param query
	     * @return result
	     * @throws Throwable
		 */
		public ResultSet ExecuteQuery(String Query) throws Throwable
		{
			result=connection.createStatement().executeQuery(Query);
			return result;
			
		}
		/**
		 * This method will execute the querry
	     * @param query
	     * @return result
	     * @throws Throwable
		 */
		public  int ExecuteUpdate(String Query) throws Throwable
		{
			int result=connection.createStatement().executeUpdate(Query);
			return result;
			
		}
//		/**
//		 * This method will execute querry based on querry and it will verify the data. 
//		 * @param querry
//		 * @param columnName
//		 * @param expectedData
//		 * @return
//		 * @throws Throwable
//		 */
//		public boolean executeQuerryAndVerify(String querry,int columnName,String expectedData) throws Throwable {
//			boolean flag=false;
//			result=connection.createStatement().executeQuery(querry);
//			while(result.next()) {
//				if(result.getString(columnName).equals(expectedData)) {
//					flag=true;
//					break;
//				}
//			}
//			if(flag) {
//				System.out.println(expectedData+"==>Data is verified in the data base table");
//				return flag;
//			}else {
//				System.out.println(expectedData+"==>data is not verified in the database");
//				return flag;
//			}
//	         
//		}


	}


