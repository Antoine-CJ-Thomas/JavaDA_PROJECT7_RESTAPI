package com.nnk.springboot.repository;

import java.util.ArrayList;

import com.nnk.springboot.domain.CurvePoint;

public interface CurvePointRepositoryInterface {

	public void insertCurvePoint(CurvePoint curvePoint);
	
	public CurvePoint selectCurvePoint(Integer id);
	
	public ArrayList<CurvePoint> selectCurvePointList();
	
	public void updatetCurvePoint(Integer id, CurvePoint curvePoint);
	
	public void deleteCurvePoint(Integer id);
}