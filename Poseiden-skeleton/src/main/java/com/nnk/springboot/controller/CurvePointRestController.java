package com.nnk.springboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.service.CurvePointService;
import com.nnk.springboot.service.CurvePointServiceInterface;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * This class allows to intercept curvePoint REST requests
 */
@RestController
public class CurvePointRestController {

	private Logger logger = LogManager.getLogger(getClass().getSimpleName());
	
	private ObjectMapper objectMapper = new ObjectMapper();

	private CurvePointServiceInterface curvePointServiceInterface;
	
	/**
	 * Creates a new CurvePointRestController
	 */
	public CurvePointRestController() {
		logger.info("curvePointController()");

		curvePointServiceInterface = new CurvePointService();
	}

	/**
	 * Creates a new CurvePointRestController with the specified CurvePointServiceInterface
	 * @param curvePointServiceInterface : service that this controller will use
	 */
	public CurvePointRestController(CurvePointServiceInterface curvePointServiceInterface) {
		logger.info("curvePointController(" + curvePointServiceInterface + ")");

		this.curvePointServiceInterface = curvePointServiceInterface;
	}

	/**
	 * Intercepts the creating request of a curvePoint
	 * @param curvePoint : data of the curvePoint to create
	 * @param bindingResult : serves as result holder
	 */
	@PostMapping("/curvePoint/create")
	public void createCurvePoint(@Valid CurvePoint curvePoint, BindingResult bindingResult) {
		logger.info("createCurvePoint(" + curvePoint + "," + bindingResult + ")");

		if (bindingResult.hasErrors() == false) {

			curvePointServiceInterface.createCurvePoint(curvePoint);
		}
	}

	/**
	 * Intercepts the getting request of a curvePoint
	 * @param id : id of the curvePoint to read
     * @return Return the curvePoint (JSon)
	 */
	@GetMapping("/curvePoint/read")
	public String readCurvePoint(@RequestParam Integer id) throws JsonProcessingException {
		logger.info("readCurvePoint(" + id + ")");

        return objectMapper.writeValueAsString(curvePointServiceInterface.readCurvePoint(id));
	}

	/**
	 * Intercepts the updating request of a curvePoint
	 * @param id : id of the curvePoint to update
	 * @param curvePoint : data of the curvePoint to update
	 * @param bindingResult : serves as result holder
	 */
	@PutMapping("/curvePoint/update")
	public void updateCurvePoint(@RequestParam("id") Integer id, @Valid CurvePoint curvePoint, BindingResult bindingResult) {
		logger.info("updateCurvePoint(" + id + "," + curvePoint + "," + bindingResult + ")");

		if (bindingResult.hasErrors() == false) {

			curvePointServiceInterface.updateCurvePoint(id, curvePoint);
		}
	}

	/**
	 * Intercepts the deleting request of a curvePoint
	 * @param id : id of the curvePoint to delete
	 */
	@DeleteMapping("/curvePoint/delete")
	public void deleteCurvePoint(@RequestParam("id") Integer id) {
		logger.info("deleteCurvePoint(" + id + ")");
		
		curvePointServiceInterface.deleteCurvePoint(id);
	}
}