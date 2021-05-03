package com.nnk.springboot.service;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repository.CurvePointRepository;
import com.nnk.springboot.repository.CurvePointRepositoryInterface;

/**
 * This class allows to interact with a curve point repository
 */
@Service
public class CurvePointService implements CurvePointServiceInterface {

	private Logger logger = LogManager.getLogger(getClass().getSimpleName());

	private CurvePointRepositoryInterface curvePointRepositoryInterface;

	/**
	 * Creates a new CurvePointService
	 */
	public CurvePointService() {
		logger.info("CurvePointService()");

		curvePointRepositoryInterface = new CurvePointRepository();
	}

	/**
	 * Creates a new CurvePointService with the specified CurvePointRepositoryInterface
	 * @param curvePointRepositoryInterface : repository that this service will use
	 */
	public CurvePointService(CurvePointRepositoryInterface curvePointRepositoryInterface) {
		logger.info("CurvePointService(" + curvePointRepositoryInterface + ")");

		this.curvePointRepositoryInterface = curvePointRepositoryInterface;
	}

	@Override
	public void createCurvePoint(CurvePoint curvePoint) {
		logger.info("createCurvePoint(" + curvePoint + ")");

		curvePointRepositoryInterface.insertCurvePoint(curvePoint);
	}

	@Override
	public CurvePoint readCurvePoint(Integer id) {
		logger.info("readCurvePoint(" + id + ")");

		return curvePointRepositoryInterface.selectCurvePoint(id);
	}

	@Override
	public ArrayList<CurvePoint> readCurvePointList() {
		logger.info("readCurvePointList()");

		return curvePointRepositoryInterface.selectCurvePointList();
	}

	@Override
	public void updateCurvePoint(Integer id, CurvePoint curvePoint) {
		logger.info("updateCurvePoint(" + id + "," + curvePoint + ")");

		curvePointRepositoryInterface.updateCurvePoint(id, curvePoint);
	}

	@Override
	public void deleteCurvePoint(Integer id) {
		logger.info("deleteCurvePoint(" + id + ")");

		curvePointRepositoryInterface.deleteCurvePoint(id);
	}
}