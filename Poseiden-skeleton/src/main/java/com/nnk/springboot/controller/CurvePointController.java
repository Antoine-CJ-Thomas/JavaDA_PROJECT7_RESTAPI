package com.nnk.springboot.controller;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.service.CurvePointService;
import com.nnk.springboot.service.CurvePointServiceInterface;
import com.nnk.springboot.service.LoginService;
import com.nnk.springboot.service.LoginServiceInterface;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * This class allows to intercept curve point requests
 */
@Controller
public class CurvePointController {

	private Logger logger = LogManager.getLogger(getClass().getSimpleName());

	private CurvePointServiceInterface curvePointServiceInterface;
	private LoginServiceInterface loginServiceInterface;
	
	/**
	 * Creates a new CurvePointController
	 */
	public CurvePointController() {
		logger.info("CurvePointController()");

		curvePointServiceInterface = new CurvePointService();
		loginServiceInterface = new LoginService();
	}
	/**
	 * Creates a new CurvePointController with the specified CurvePointServiceInterface and LoginServiceInterface
	 * @param curvePointServiceInterface : curve point service that this controller will use
	 * @param loginServiceInterface : login service that this controller will use
	 */
	public CurvePointController(CurvePointServiceInterface curvePointServiceInterface, LoginServiceInterface loginServiceInterface) {
		logger.info("CurvePointController(" + curvePointServiceInterface + "," + loginServiceInterface + ")");

		this.curvePointServiceInterface = curvePointServiceInterface;
		this.loginServiceInterface = loginServiceInterface;
	}

	/**
	 * Intercepts the request of the curve point list table
	 * @param model : defines a holder for model attributes
     * @return The curve point list template
	 */
	@RequestMapping("/curvePoint/list")
	public String home(Model model) {
		logger.info("home(" + model + ")");

		model.addAttribute("username", loginServiceInterface.getUsername());

		model.addAttribute("curvePointList", curvePointServiceInterface.readCurvePointList());

		return "/curvePoint/list.html";
	}

	/**
	 * Intercepts the get request of the curve point creation form
	 * @param curvePoint : data of the CurvePoint to create
     * @return The curve point creation form template
	 */
	@GetMapping("/curvePoint/add")
	public String addCurvePointForm(CurvePoint curvePoint) {
		logger.info("addCurvePointForm(" + curvePoint + ")");

		return "/curvePoint/add.html";
	}

	/**
	 * Intercepts the post request of the curve point creation form
	 * @param curvePoint : data of the CurvePoint to create
	 * @param bindingResult : serves as result holder
	 * @param model : defines a holder for model attributes
     * @return Return the curve point list template or redirect to the curve point creation form
	 */
	@PostMapping("/curvePoint/validate")
	public String validate(@Valid CurvePoint curvePoint, BindingResult bindingResult, Model model) {
		logger.info("validate(" + curvePoint + "," + bindingResult + "," + model + ")");

		if (bindingResult.hasErrors() == false) {

			curvePointServiceInterface.createCurvePoint(curvePoint);

			return "redirect:/curvePoint/list";
		}

		return "/curvePoint/add.html";
	}

	/**
	 * Intercepts the get request of the curve point update form
	 * @param id : id of the curve point to update
	 * @param model : defines a holder for model attributes
     * @return Return the curve point update form template
	 */
	@GetMapping("/curvePoint/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		logger.info("showUpdateForm(" + id + "," + model + ")");

		model.addAttribute("curvePoint", curvePointServiceInterface.readCurvePoint(id));

		return "/curvePoint/update.html";
	}

	/**
	 * Intercepts the post request of the curve point update form
	 * @param id : id of the curve point to update
	 * @param curvePoint : data of the CurvePoint to update
	 * @param bindingResult : serves as result holder
	 * @param model : defines a holder for model attributes
     * @return Return the curve point list template or redirect to the curve point update form
	 */
	@PostMapping("/curvePoint/update/{id}")
	public String updateCurvePoint(@PathVariable("id") Integer id, @Valid CurvePoint curvePoint,
			BindingResult bindingResult, Model model) {
		logger.info("updateCurvePoint(" + id + "," + curvePoint + "," + bindingResult + "," + model + ")");

		if (bindingResult.hasErrors() == false) {

			curvePointServiceInterface.updateCurvePoint(id, curvePoint);

			return "redirect:/curvePoint/list";
		}

		return "/curvePoint/update.html";
	}

	/**
	 * Intercepts the get request of the curve point delete
	 * @param id : id of the curve point to delete
	 * @param model : defines a holder for model attributes
     * @return Return the curve point list template
	 */
	@GetMapping("/curvePoint/delete/{id}")
	public String deleteCurvePoint(@PathVariable("id") Integer id, Model model) {
		logger.info("deleteCurvePoint(" + id + "," + model + ")");

		curvePointServiceInterface.deleteCurvePoint(id);

		return "redirect:/curvePoint/list";
	}
}