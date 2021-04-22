package com.nnk.springboot.controller;

import com.nnk.springboot.domain.Bid;
import com.nnk.springboot.service.BidService;
import com.nnk.springboot.service.BidServiceInterface;

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
 * This class allows to intercept bid requests
 */
@Controller
public class BidController {

	private Logger logger = LogManager.getLogger(getClass().getSimpleName());

	private BidServiceInterface bidServiceInterface;

	public BidController() {
		logger.info("BidController()");

		bidServiceInterface = new BidService();
	}

	@RequestMapping("/bidList/list")
	public String home(Model model) {
		logger.info("home(" + model + ")");

		model.addAttribute("bidList", bidServiceInterface.readBidList());

		return "/bidList/list.html";
	}

	@GetMapping("/bidList/add")
	public String addBidForm(Bid bid) {
		logger.info("addBidForm(" + bid + ")");

		return "/bidList/add.html";
	}

	@PostMapping("/bidList/validate")
	public String validate(@Valid Bid bid, BindingResult bindingResult, Model model) {
		logger.info("validate(" + bid + "," + bindingResult + "," + model + ")");

		if (bindingResult.hasErrors() == false) {

			bidServiceInterface.createBid(bid);

			return "redirect:/bidList/list";
		}

		return "/bidList/add.html";
	}

	@GetMapping("/bidList/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		logger.info("showUpdateForm(" + id + "," + model + ")");

		model.addAttribute("bid", bidServiceInterface.readBid(id));

		return "/bidList/update.html";
	}

	@PostMapping("/bidList/update/{id}")
	public String updateBid(@PathVariable("id") Integer id, @Valid Bid bid, BindingResult bindingResult, Model model) {
		logger.info("updateBid(" + id + "," + bid + "," + bindingResult + "," + model + ")");

		if (bindingResult.hasErrors() == false) {

			bidServiceInterface.updateBid(id, bid);

			return "redirect:/bidList/list";
		}

		return "/bidList/update.html";
	}

	@GetMapping("/bidList/delete/{id}")
	public String deleteBid(@PathVariable("id") Integer id, Model model) {
		logger.info("deleteBid(" + id + "," + model + ")");

		bidServiceInterface.deleteBid(id);

		return "redirect:/bidList/list";
	}
}