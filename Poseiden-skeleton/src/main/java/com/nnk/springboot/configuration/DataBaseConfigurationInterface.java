package com.nnk.springboot.configuration;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * This interface allows to implement relational database management system methods
*/
public interface DataBaseConfigurationInterface {

    public void executeUpdate(ArrayList<String> queryList);
    
    public ResultSet executeQuery(ArrayList<String> queryList);
    
    public void close();
}
