package com.nnk.springboot.service;

import java.util.ArrayList;

import com.nnk.springboot.domain.CurvePoint;

public interface CurvePointServiceInterface {

	public void createCurvePoint(CurvePoint curvePoint);

	public CurvePoint readCurvePoint(Integer id);

	public ArrayList<CurvePoint> readCurvePointList();

	public void updateCurvePoint(Integer id, CurvePoint curvePoint);

	public void deleteCurvePoint(Integer id);
}
