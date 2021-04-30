package com.nnk.springboot.configuration;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * This interface allows to implement relational database management system methods
*/
public interface DataBaseConfigurationInterface {

	/**
	 * Execute all updates from a query list
	 * @param queryList : list of the queries to execute
	 */
    public void executeUpdate(ArrayList<String> queryList);
	
	/**
	 * Execute all queries from a query list
	 * @param queryList : list of the queries to execute
     * @return The ResultSet of executed queries
	 */
    public ResultSet executeQuery(ArrayList<String> queryList);

	/**
	 * Close connection and statement
	 */
    public void close();
}
