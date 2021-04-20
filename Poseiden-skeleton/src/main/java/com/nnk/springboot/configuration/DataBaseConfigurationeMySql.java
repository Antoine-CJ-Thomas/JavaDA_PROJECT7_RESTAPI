package com.nnk.springboot.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class DataBaseConfigurationeMySql implements DataBaseConfigurationInterface {

    private static final Logger logger = LogManager.getLogger("DataBaseConfigurationMySql");

	private String url;
	private String user;
	private String password;

	public DataBaseConfigurationeMySql() {

		Properties properties = new Properties();

		try {

			InputStream inputStream = new FileInputStream("src/main/resources/application.properties");

			if (inputStream != null) {

				properties.load(inputStream);

				url = properties.getProperty("spring.datasource.url");
				user = properties.getProperty("spring.datasource.username");
				password = properties.getProperty("spring.datasource.password");
			}

		} catch (IOException e) {
			
	        logger.error(e);
		}
	}

	@Override
	public void executeUpdate(ArrayList<String> queryList) {

		Connection connection = null;
		Statement statement = null;

		try {

			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();

			connection.setAutoCommit(false);
			
			for (String query : queryList) {

				statement.executeUpdate(query);
			}
			
			connection.commit();

		} catch (SQLException e) {
			
	        logger.error(e);
	        
			rollbackTransaction(connection);
			
		} finally {
			
			closeStatement(statement);
			closeConnection(connection);
		}
	}

	@Override
	public ResultSet executeQuery(ArrayList<String> queryList) {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {

			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();

			connection.setAutoCommit(false);
			
			for (String query : queryList) {

				resultSet = statement.executeQuery(query);
			}

		} catch (SQLException e) {
			
	        logger.error(e);
	        
			rollbackTransaction(connection);
			
		} finally {
			
//			closeStatement(statement);
//			closeConnection(connection);
		}
		
		return resultSet;
	}
	
	private void rollbackTransaction(Connection connection) {

		if (connection != null) {

			try {
				connection.rollback();
			} catch (SQLException e) {
		        logger.error(e);
			}
		}
	}
	
	private void closeStatement(Statement statement) {

		if (statement != null) {

			try {
				statement.close();
			} catch (SQLException e) {
		        logger.error(e);
			}
		}
	}
	
	private void closeConnection(Connection connection) {

		if (connection != null) {

			try {
				connection.close();
			} catch (SQLException e) {
		        logger.error(e);
			}
		}
	}
}
