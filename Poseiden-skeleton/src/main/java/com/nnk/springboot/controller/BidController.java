package com.nnk.springboot.controller;

import com.nnk.springboot.domain.Bid;
import com.nnk.springboot.service.BidService;
import com.nnk.springboot.service.BidServiceInterface;

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
public class BidController {
	// TODO: Inject Bid service

	private static final Logger logger = LogManager.getLogger("BidController");

	@Autowired
	private BidServiceInterface bidServiceInterface;

	public BidController() {
		logger.info("BidController");

		bidServiceInterface = new BidService();
	}

	@RequestMapping("/bidList/list")
	public String home(Model model) {
		logger.info("home");
		// TODO: call service find all bids to show to the view

		model.addAttribute("bidList", bidServiceInterface.readBidList());

		return "bidList/list";
	}

	@GetMapping("/bidList/add")
	public String addBidForm(Bid bid) {
		logger.info("addBidForm");

		return "bidList/add";
	}

	@PostMapping("/bidList/validate")
	public String validate(@Valid Bid bid, BindingResult result, Model model) {
		logger.info("validate");
		// TODO: check data valid and save to db, after saving return bid list

		bidServiceInterface.createBid(bid);

		return "bidList/add";
	}

	@GetMapping("/bidList/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		logger.info("showUpdateForm");
		// TODO: get Bid by Id and to model then show to the form

		model.addAttribute("bid", bidServiceInterface.readBid(id));

		return "bidList/update";
	}

	@PostMapping("/bidList/update/{id}")
	public String updateBid(@PathVariable("id") Integer id, @Valid Bid bid, BindingResult result, Model model) {
		logger.info("updateBid");
		// TODO: check required fields, if valid call service to update Bid and return
		// list Bid

		bidServiceInterface.updateBid(id, bid);

		return "redirect:/bidList/list";
	}

	@GetMapping("/bidList/delete/{id}")
	public String deleteBid(@PathVariable("id") Integer id, Model model) {
		logger.info("deleteBid");
		// TODO: Find Bid by Id and delete the bid, return to Bid list

		bidServiceInterface.deleteBid(id);

		return "redirect:/bidList/list";
	}
}
