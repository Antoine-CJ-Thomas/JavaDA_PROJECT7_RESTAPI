package com.nnk.springboot.repository;

import java.util.ArrayList;

import com.nnk.springboot.domain.CurvePoint;

/**
 * This interface allows to implement curve point repository methods
*/
public interface CurvePointRepositoryInterface {
	
	/**
	 * Insert a CurvePoint in the CurvePoint table
	 * @param curvePoint : data of the CurvePoint to insert
	 */
	public void insertCurvePoint(CurvePoint curvePoint);
	
	/**
	 * Select a CurvePoint in the CurvePoint table
	 * @param id : id of the CurvePoint to select
     * @return The CurvePoint that was selected
	 */
	public CurvePoint selectCurvePoint(Integer id);

	/**
	 * Select the CurvePoint list of the CurvePoint table
     * @return The CurvePoint list that was selected
	 */
	public ArrayList<CurvePoint> selectCurvePointList();
	
	/**
	 * Update a CurvePoint in the CurvePoint table
	 * @param id : id of the CurvePoint to update
	 * @param curvePoint : data of the CurvePoint to update
	 */
	public void updateCurvePoint(Integer id, CurvePoint curvePoint);

	/**
	 * Delete a CurvePoint in the CurvePoint table
	 * @param id : id of the CurvePoint to delete
	 */
	public void deleteCurvePoint(Integer id);
}