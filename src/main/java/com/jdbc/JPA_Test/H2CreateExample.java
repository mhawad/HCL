package com.jdbc.JPA_Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**

6.Lets say you retrieve all the employee information then you need to filter the records by the condition sal>5000 and employee name starts with B and age >21

after implementation of these menus driven program, you can further improve the program with the help of stream ,lambda expression and functional interface.


*/
public class H2CreateExample {

	private static final String createTableSQL = "create table employees (" + "  id  int primary key,"
			+ "  name varchar(20)," + "  dob varchar(20)," + "  salary varchar(20)," + "  age varchar(20) ) ";

	private static final String INSERT_EMPLOYEES_SQL = "INSERT INTO employees"
			+ "  (id, name, dob, salary, age) VALUES " + " (?, ?, ?, ?, ?);";

	private static final String QUERY = "select id,name,dob,salary,age from employees where id =?";

	public static void main(String[] argv) throws SQLException {
		H2CreateExample createTableExample = new H2CreateExample();

		try (Connection connection = H2JDBCUtils.getConnection()) {
			createTableExample.createTable(connection);
			createTableExample.insertRecord(connection);
			createTableExample.selectRecord(connection);
		} catch (SQLException e) {
			// print SQL exception information
			H2JDBCUtils.printSQLException(e);
		}

	}

	public void createTable(Connection connection) throws SQLException {

		System.out.println(createTableSQL);
		// Step 1: Establishing a Connection
		try {
			// Step 2:Create a statement using connection object
			Statement statement = connection.createStatement();
			{

				// Step 3: Execute the query or update query
				statement.execute(createTableSQL);
			}
		} catch (SQLException e) {
			// print SQL exception information
			H2JDBCUtils.printSQLException(e);
		}
	}

	// information
	public void insertRecord(Connection connection) throws SQLException {
		System.out.println(INSERT_EMPLOYEES_SQL);
		// Step 1: Establishing a Connection
		try {
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEES_SQL);
			preparedStatement.setInt(1, 1357);
			preparedStatement.setString(2, "Tony");
			preparedStatement.setString(3, "02/03/1987");
			preparedStatement.setString(4, "$55,000");
			preparedStatement.setString(5, "30");

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			// print SQL exception information
			H2JDBCUtils.printSQLException(e);
		}

		// Step 4: try-with-resource statement will auto close the connection.
	}

	public void selectRecord(Connection connection) throws SQLException {
		try {

			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1, 1);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int dob = rs.getInt("dob");
				int salary = rs.getInt("salary");
				int age = rs.getInt("age");
				System.out.println(id + "," + name + "," + dob + "," + salary + "," + age);
			}
		} catch (SQLException e) {
			H2JDBCUtils.printSQLException(e);
		}
	}
}
