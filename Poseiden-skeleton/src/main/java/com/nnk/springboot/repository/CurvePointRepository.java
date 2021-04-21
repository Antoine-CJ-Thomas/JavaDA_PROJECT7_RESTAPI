package com.nnk.springboot.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nnk.springboot.configuration.DataBaseConfigurationInterface;
import com.nnk.springboot.configuration.DataBaseConfigurationMySql;
import com.nnk.springboot.domain.CurvePoint;

@Component
public class CurvePointRepository implements CurvePointRepositoryInterface {

	private static final Logger logger = LogManager.getLogger("CurvePointRepository");

	@Autowired
	private DataBaseConfigurationInterface dataBaseConfigurationInterface;
	
	public CurvePointRepository() {
		logger.info("CurvePointRepository");
		
		dataBaseConfigurationInterface = new DataBaseConfigurationMySql();
	}

	@Override
	public void insertCurvePoint(CurvePoint curvePoint) {
		logger.info("insertCurvePoint");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query 	
		
			= "INSERT INTO "
			
				+ "curvepoint ("
				
					+ "CurveId,"
					+ "term,"
					+ "value)"
					
				+ "VALUES ("
			
					+ " " + curvePoint.getCurveId() + ","
					+ "'" + curvePoint.getTerm() + "',"
					+ " " + curvePoint.getValue() + ");";
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}

	@Override
	public CurvePoint selectCurvePoint(Integer id) {
		logger.info("selectCurvePoint");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = "SELECT * FROM curvepoint WHERE Id=" + id + ";";
        
        queryList.add(query);
        
		ResultSet resultSet = dataBaseConfigurationInterface.executeQuery(queryList);
		
		CurvePoint curvePoint = new CurvePoint();
		
    	try {

			if (resultSet.next()) {

				curvePoint.setId(resultSet.getInt("Id"));
				curvePoint.setCurveId(resultSet.getInt("CurveId"));
				curvePoint.setAsOfDate(resultSet.getTimestamp("asOfDate"));
				curvePoint.setTerm(resultSet.getDouble("term"));
				curvePoint.setValue(resultSet.getDouble("value"));
				curvePoint.setCreationDate(resultSet.getTimestamp("creationDate"));
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
            
		} finally {
			
			try {
				
				if (resultSet != null) {
					
					resultSet.close();
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			dataBaseConfigurationInterface.close();
	    }
        
		return curvePoint;
	}

	@Override
	public ArrayList<CurvePoint> selectCurvePointList() {
		logger.info("selectCurvePointList");
		
        ArrayList<String> queryList = new ArrayList<String>();

        String query = "SELECT * FROM curvepoint";
        
        queryList.add(query);
        
		ResultSet resultSet = dataBaseConfigurationInterface.executeQuery(queryList);

		ArrayList<CurvePoint> curvePointList = new ArrayList<CurvePoint>();
		
    	try {

			if (resultSet.next()) {
				
				curvePointList.add(new CurvePoint());

				curvePointList.get(curvePointList.size()-1).setId(resultSet.getInt("Id"));
				curvePointList.get(curvePointList.size()-1).setCurveId(resultSet.getInt("CurveId"));
				curvePointList.get(curvePointList.size()-1).setAsOfDate(resultSet.getTimestamp("asOfDate"));
				curvePointList.get(curvePointList.size()-1).setTerm(resultSet.getDouble("term"));
				curvePointList.get(curvePointList.size()-1).setValue(resultSet.getDouble("value"));
				curvePointList.get(curvePointList.size()-1).setCreationDate(resultSet.getTimestamp("creationDate"));
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
            
		} finally {
			
			try {
				
				if (resultSet != null) {
					
					resultSet.close();
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			dataBaseConfigurationInterface.close();
	    }
        
		return curvePointList;
	}

	@Override
	public void updatetCurvePoint(Integer id, CurvePoint curvePoint) {
		logger.info("updatetCurvePoint");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query 	
		
			= "UPDATE curvepoint "
			
				+ "SET "
				
					+ "CurveId=" + "" + curvePoint.getCurveId() + ","
					+ "term=" + "" + curvePoint.getTerm() + ","
					+ "value=" + "" + curvePoint.getValue() + ""
		
    			+ "WHERE Id=" + id + ";";
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
        		
	}

	@Override
	public void deleteCurvePoint(Integer id) {
		logger.info("deleteCurvePoint");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = "DELETE FROM curvepoint WHERE Id= " + id + ";";
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}
}
