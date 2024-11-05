package demo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class dbSQL { // might have to write this
	// code in the gamePrep 
	
	public static void main(String[] args) {
		Connection conn = null ;
		
		try {
			
			// load the database driver
			Class.forName("org.sqlite.JDBC");
			System.out.println("Driver Loaded");
			
			//create a connection string and connect to database
			String dbURL = "jdbc:sqlite:frogger.db";
			conn = DriverManager.getConnection(dbURL);
			
			//if succesfull
			if(conn != null) {
				System.out.println("connected to database");
				
				// Showing the meta-data for database
				DatabaseMetaData db = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver Name: "+ db.getDriverName());
				System.out.println("Driver Version: "+ db.getDriverVersion());
				System.out.println("Product Name: "+ db.getDatabaseProductName());
				System.out.println("Product Version: "+ db.getDatabaseProductVersion());
				
				// create a table using prepared - statement 
				String sqlCreateTable = "CREATE TABLE IF NOT EXISTS COMPANY" + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"
						+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "+ "NAME TEXT NOT NULL" + "SCORE  INT NOT NULL) ";
				
				try (PreparedStatement pstmtCreateTable = conn.prepareStatement(sqlCreateTable)) {
					pstmtCreateTable.executeUpdate();
					System.out.println("Table Successfully Created");
				}
				
				
			}
		
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
	}

}
