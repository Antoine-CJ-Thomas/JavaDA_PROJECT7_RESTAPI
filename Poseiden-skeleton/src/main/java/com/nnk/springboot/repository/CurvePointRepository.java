package com.nnk.springboot.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.nnk.springboot.configuration.DataBaseConfigurationInterface;
import com.nnk.springboot.configuration.DataBaseConfigurationMySql;
import com.nnk.springboot.domain.CurvePoint;

/**
 * This class allows to prepare queries for the curve point table and send them to the database configured
 */
@Component
public class CurvePointRepository implements CurvePointRepositoryInterface {

	private Logger logger = LogManager.getLogger(getClass().getSimpleName());

	private DataBaseConfigurationInterface dataBaseConfigurationInterface;
	
	public CurvePointRepository() {
		logger.info("CurvePointRepository()");
		
		dataBaseConfigurationInterface = new DataBaseConfigurationMySql();
	}
	
	public CurvePointRepository(DataBaseConfigurationInterface dataBaseConfigurationInterface) {
		logger.info("CurvePointRepository(" + dataBaseConfigurationInterface + ")");

		this.dataBaseConfigurationInterface = dataBaseConfigurationInterface;
	}

	@Override
	public void insertCurvePoint(CurvePoint curvePoint) {
		logger.info("insertCurvePoint(" + curvePoint + ")");
		
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
		logger.info("selectCurvePoint(" + id + ")");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = "SELECT * FROM curvepoint WHERE Id=" + id + ";";
        
        queryList.add(query);
        
		ResultSet resultSet = dataBaseConfigurationInterface.executeQuery(queryList);
		
		CurvePoint curvePoint = null;
		
    	try {

			if (resultSet.next()) {
				
				curvePoint = new CurvePoint();

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
		logger.info("selectCurvePointList()");
		
        ArrayList<String> queryList = new ArrayList<String>();

        String query = "SELECT * FROM curvepoint";
        
        queryList.add(query);
        
		ResultSet resultSet = dataBaseConfigurationInterface.executeQuery(queryList);

		ArrayList<CurvePoint> curvePointList = new ArrayList<CurvePoint>();
		
    	try {

    		while (resultSet.next()) {

				CurvePoint curvePoint = new CurvePoint();

				curvePoint.setId(resultSet.getInt("Id"));
				curvePoint.setCurveId(resultSet.getInt("CurveId"));
				curvePoint.setAsOfDate(resultSet.getTimestamp("asOfDate"));
				curvePoint.setTerm(resultSet.getDouble("term"));
				curvePoint.setValue(resultSet.getDouble("value"));
				curvePoint.setCreationDate(resultSet.getTimestamp("creationDate"));
				
				curvePointList.add(curvePoint);
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
	public void updateCurvePoint(Integer id, CurvePoint curvePoint) {
		logger.info("updateCurvePoint(" + id + "," + curvePoint + ")");
		
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
		logger.info("deleteCurvePoint(" + id + ")");
		
        ArrayList<String> queryList = new ArrayList<String>();
        
        String query = "DELETE FROM curvepoint WHERE Id= " + id + ";";
        
        queryList.add(query);
        
        dataBaseConfigurationInterface.executeUpdate(queryList);
		
	}
}