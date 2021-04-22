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

/**
 * This class allows to interact with a relational database management system of type MySQL
*/
@Component
public class DataBaseConfigurationMySql implements DataBaseConfigurationInterface {

	private Logger logger = LogManager.getLogger(getClass().getSimpleName());

	private String url;
	private String user;
	private String password;

	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;

	public DataBaseConfigurationMySql() {
		logger.info("DataBaseConfigurationMySql()");

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
		logger.info("executeUpdate(" + queryList + ")");

		connection = null;
		statement = null;

		try {

			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();

			connection.setAutoCommit(false);

			for (String query : queryList) {

				statement.executeUpdate(query);
			}

			connection.commit();

		} catch (SQLException e1) {

			logger.error(e1);

			if (connection != null) {

				try {

					connection.rollback();

				} catch (SQLException e2) {

					logger.error(e2);
				}
			}
		}
	}

	@Override
	public ResultSet executeQuery(ArrayList<String> queryList) {
		logger.info("executeQuery(" + queryList + ")");

		connection = null;
		statement = null;
		resultSet = null;

		try {

			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();

			connection.setAutoCommit(false);

			for (String query : queryList) {

				resultSet = statement.executeQuery(query);
			}

		} catch (SQLException e1) {

			logger.error(e1);

			if (connection != null) {

				try {

					connection.rollback();

				} catch (SQLException e2) {

					logger.error(e2);
				}
			}
		}

		return resultSet;
	}

	@Override
	public void close() {
		logger.info("close()");

		if (statement != null) {

			try {

				statement.close();

			} catch (SQLException e) {

				logger.error(e);
			}
		}

		if (connection != null) {

			try {

				connection.close();

			} catch (SQLException e) {

				logger.error(e);
			}
		}
	}
}
