package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {

	private static String url = "jdbc:mysql://localhost:3306/jdbc";
	private static String userName = "root";
	private static String password = "test";

	public static void main(String[] args) {

		try {
			
			//test

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, userName, password);
			System.out.println("connection ---> " + connection);
			
			Statement statm = connection.createStatement();
			
			String create = "Insert into jdbc.employee (name,city,salary,id) values ('akbar','rmg','6000','3')";
			
			String update = "Update jdbc.employee Set name='SA' where id='2'";
			
			String delete = "Delete from jdbc.employee where id=2";
			
			String fetch = "Select * from jdbc.employee";
			
			int executeUpdate = statm.executeUpdate(create);
			
			ResultSet executeQuery = statm.executeQuery(fetch);
			
			while(executeQuery.next()) {
				
				System.out.println(executeQuery.getString(1));
				System.out.println(executeQuery.getString(2));
				System.out.println(executeQuery.getInt(3));
				System.out.println(executeQuery.getInt(4));
				
				
				
			}
			
			
			
			System.out.println("executeUpdate ---> "+executeUpdate);

		} catch (Exception e) {
			System.out.println("Exception in SQL ----> " + e);
			e.printStackTrace();
		}
	}

}
