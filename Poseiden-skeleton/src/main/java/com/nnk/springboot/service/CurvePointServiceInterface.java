package com.nnk.springboot.service;

import java.util.ArrayList;

import com.nnk.springboot.domain.CurvePoint;

/**
 * This interface allows to implement curve point service methods
*/
public interface CurvePointServiceInterface {

	/**
	 * Create a CurvePoint
	 * @param curvePoint : data of the CurvePoint to create
	 */
	public void createCurvePoint(CurvePoint curvePoint);
	
	/**
	 * Read a CurvePoint
	 * @param id : id of the CurvePoint to read
     * @return The CurvePoint that was read
	 */
	public CurvePoint readCurvePoint(Integer id);
	
	/**
	 * Read the CurvePoint list
     * @return The CurvePoint list that was read
	 */
	public ArrayList<CurvePoint> readCurvePointList();
	
	/**
	 * Update a CurvePoint
	 * @param id : id of the CurvePoint to update
	 * @param curvePoint : data of the CurvePoint to update
	 */
	public void updateCurvePoint(Integer id, CurvePoint curvePoint);

	/**
	 * Delete a CurvePoint
	 * @param id : id of the CurvePoint to delete
	 */
	public void deleteCurvePoint(Integer id);
}
