package com.nnk.springboot.repository;

import java.util.ArrayList;

import com.nnk.springboot.domain.CurvePoint;

/**
 * This interface allows to implement curve point repository methods
*/
public interface CurvePointRepositoryInterface {

	public void insertCurvePoint(CurvePoint curvePoint);
	
	public CurvePoint selectCurvePoint(Integer id);
	
	public ArrayList<CurvePoint> selectCurvePointList();
	
	public void updateCurvePoint(Integer id, CurvePoint curvePoint);
	
	public void deleteCurvePoint(Integer id);
}