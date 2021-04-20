package com.nnk.springboot.configuration;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface DataBaseConfigurationInterface {

    public void executeUpdate(ArrayList<String> queryList);
    public ResultSet executeQuery(ArrayList<String> queryList);
    public void close();
}
