package com.nnk.springboot.controller;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.service.CurvePointService;
import com.nnk.springboot.service.CurvePointServiceInterface;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class CurvePointController {
	// TODO: Inject Curve Point service

	private static final Logger logger = LogManager.getLogger("CurvePointController");

	@Autowired
	private CurvePointServiceInterface curvePointServiceInterface;

	public CurvePointController() {
		logger.info("CurvePointController");

		curvePointServiceInterface = new CurvePointService();
	}

	@RequestMapping("/curvePoint/list")
	public String home(Model model) {
		logger.info("home");
		// TODO: find all Curve Point, add to model

		model.addAttribute("bidList", curvePointServiceInterface.readCurvePointList());

		return "curvePoint/list";
	}

	@GetMapping("/curvePoint/add")
	public String addCurvePointForm(CurvePoint bid) {
		logger.info("addCurvePointForm");

		return "curvePoint/add";
	}

	@PostMapping("/curvePoint/validate")
	public String validate(@Valid CurvePoint curvePoint, BindingResult result, Model model) {
		logger.info("validate");
		// TODO: check data valid and save to db, after saving return Curve list

		curvePointServiceInterface.createCurvePoint(curvePoint);

		return "curvePoint/add";
	}

	@GetMapping("/curvePoint/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		logger.info("showUpdateForm");
		// TODO: get CurvePoint by Id and to model then show to the form

		model.addAttribute("curvePoint", curvePointServiceInterface.readCurvePoint(id));

		return "curvePoint/update";
	}

	@PostMapping("/curvePoint/update/{id}")
	public String updateCurvePoint(@PathVariable("id") Integer id, @Valid CurvePoint curvePoint, BindingResult result,
			Model model) {
		logger.info("updateCurvePoint");
		// TODO: check required fields, if valid call service to update Curve and return
		// Curve list

		curvePointServiceInterface.updateCurvePoint(id, curvePoint);

		return "redirect:/curvePoint/list";
	}

	@GetMapping("/curvePoint/delete/{id}")
	public String deleteCurvePoint(@PathVariable("id") Integer id, Model model) {
		logger.info("deleteCurvePoint");
		// TODO: Find Curve by Id and delete the Curve, return to Curve list

		curvePointServiceInterface.deleteCurvePoint(id);

		return "redirect:/curvePoint/list";
	}
}
