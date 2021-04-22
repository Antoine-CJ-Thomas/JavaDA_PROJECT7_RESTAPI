package com.nnk.springboot.controller;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.service.CurvePointService;
import com.nnk.springboot.service.CurvePointServiceInterface;

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

	public CurvePointController() {
		logger.info("CurvePointController()");

		curvePointServiceInterface = new CurvePointService();
	}

	@RequestMapping("/curvePoint/list")
	public String home(Model model) {
		logger.info("home(" + model + ")");

		model.addAttribute("curvePointList", curvePointServiceInterface.readCurvePointList());

		return "/curvePoint/list.html";
	}

	@GetMapping("/curvePoint/add")
	public String addCurvePointForm(CurvePoint curvePoint) {
		logger.info("addCurvePointForm(" + curvePoint + ")");

		return "/curvePoint/add.html";
	}

	@PostMapping("/curvePoint/validate")
	public String validate(@Valid CurvePoint curvePoint, BindingResult bindingResult, Model model) {
		logger.info("validate(" + curvePoint + "," + bindingResult + "," + model + ")");

		if (bindingResult.hasErrors() == false) {

			curvePointServiceInterface.createCurvePoint(curvePoint);

			return "redirect:/curvePoint/list";
		}

		return "/curvePoint/add.html";
	}

	@GetMapping("/curvePoint/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		logger.info("showUpdateForm(" + id + "," + model + ")");

		model.addAttribute("curvePoint", curvePointServiceInterface.readCurvePoint(id));

		return "/curvePoint/update.html";
	}

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

	@GetMapping("/curvePoint/delete/{id}")
	public String deleteCurvePoint(@PathVariable("id") Integer id, Model model) {
		logger.info("deleteCurvePoint(" + id + "," + model + ")");

		curvePointServiceInterface.deleteCurvePoint(id);

		return "redirect:/curvePoint/list";
	}
}