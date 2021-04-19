package com.nnk.springboot.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repository.CurvePointRepository;
import com.nnk.springboot.repository.CurvePointRepositoryInterface;

@Service
public class CurvePointService implements CurvePointServiceInterface {

	@Autowired
	private CurvePointRepositoryInterface curvePointRepositoryInterface;

	public CurvePointService() {
		
		curvePointRepositoryInterface = new CurvePointRepository();
	}

	@Override
	public void createCurvePoint(CurvePoint curvePoint) {
		
		curvePointRepositoryInterface.insertCurvePoint(curvePoint);
	}


	@Override
	public CurvePoint readCurvePoint(Integer id) {
		
		return curvePointRepositoryInterface.selectCurvePoint(id);
	}


	@Override
	public ArrayList<CurvePoint> readCurvePointList() {
		
		return curvePointRepositoryInterface.selectCurvePointList();
	}


	@Override
	public void updateCurvePoint(Integer id, CurvePoint curvePoint) {
		
		curvePointRepositoryInterface.updatetCurvePoint(id, curvePoint);
	}


	@Override
	public void deleteCurvePoint(Integer id) {
		
		curvePointRepositoryInterface.deleteCurvePoint(id);
	}
}
