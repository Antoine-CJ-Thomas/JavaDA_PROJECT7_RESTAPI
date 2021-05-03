package com.nnk.springboot.controller;

import com.nnk.springboot.domain.Bid;
import com.nnk.springboot.service.BidService;
import com.nnk.springboot.service.BidServiceInterface;
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
 * This class allows to intercept bid requests
 */
@Controller
public class BidController {

	private Logger logger = LogManager.getLogger(getClass().getSimpleName());
	
	private BidServiceInterface bidServiceInterface;
	private LoginServiceInterface loginServiceInterface;
	
	/**
	 * Creates a new BidController
	 */
	public BidController() {
		logger.info("BidController()");

		bidServiceInterface = new BidService();
		loginServiceInterface = new LoginService();
	}

	/**
	 * Creates a new BidController with the specified BidServiceInterface and LoginServiceInterface
	 * @param bidServiceInterface : bid service that this controller will use
	 * @param loginServiceInterface : login service that this controller will use
	 */
	public BidController(BidServiceInterface bidServiceInterface, LoginServiceInterface loginServiceInterface) {
		logger.info("BidController(" + bidServiceInterface + "," + loginServiceInterface + ")");

		this.bidServiceInterface = bidServiceInterface;
		this.loginServiceInterface = loginServiceInterface;
	}

	/**
	 * Intercepts the request of the bid list table
	 * @param model : defines a holder for model attributes
     * @return The bid list template
	 */
	@RequestMapping("/bidList/list")
	public String home(Model model) {
		logger.info("home(" + model + ")");

		model.addAttribute("username", loginServiceInterface.getUsername());

		model.addAttribute("bidList", bidServiceInterface.readBidList());

		return "/bidList/list.html";
	}

	/**
	 * Intercepts the get request of the bid creation form
	 * @param bid : data of the Bid to create
     * @return The bid creation form template
	 */
	@GetMapping("/bidList/add")
	public String addBidForm(Bid bid) {
		logger.info("addBidForm(" + bid + ")");

		return "/bidList/add.html";
	}

	/**
	 * Intercepts the post request of the bid creation form
	 * @param bid : data of the Bid to create
	 * @param bindingResult : serves as result holder
	 * @param model : defines a holder for model attributes
     * @return Return the bid list template or redirect to the bid creation form
	 */
	@PostMapping("/bidList/validate")
	public String validate(@Valid Bid bid, BindingResult bindingResult, Model model) {
		logger.info("validate(" + bid + "," + bindingResult + "," + model + ")");

		if (bindingResult.hasErrors() == false) {

			bidServiceInterface.createBid(bid);

			return "redirect:/bidList/list";
		}

		return "/bidList/add.html";
	}

	/**
	 * Intercepts the get request of the bid update form
	 * @param id : id of the bid to update
	 * @param model : defines a holder for model attributes
     * @return Return the bid update form template
	 */
	@GetMapping("/bidList/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		logger.info("showUpdateForm(" + id + "," + model + ")");

		model.addAttribute("bid", bidServiceInterface.readBid(id));

		return "/bidList/update.html";
	}

	/**
	 * Intercepts the post request of the bid update form
	 * @param id : id of the bid to update
	 * @param bid : data of the Bid to update
	 * @param bindingResult : serves as result holder
	 * @param model : defines a holder for model attributes
     * @return Return the bid list template or redirect to the bid update form
	 */
	@PostMapping("/bidList/update/{id}")
	public String updateBid(@PathVariable("id") Integer id, @Valid Bid bid, BindingResult bindingResult, Model model) {
		logger.info("updateBid(" + id + "," + bid + "," + bindingResult + "," + model + ")");

		if (bindingResult.hasErrors() == false) {

			bidServiceInterface.updateBid(id, bid);

			return "redirect:/bidList/list";
		}

		return "/bidList/update.html";
	}

	/**
	 * Intercepts the get request of the bid delete
	 * @param id : id of the bid to delete
	 * @param model : defines a holder for model attributes
     * @return Return the bid list template
	 */
	@GetMapping("/bidList/delete/{id}")
	public String deleteBid(@PathVariable("id") Integer id, Model model) {
		logger.info("deleteBid(" + id + "," + model + ")");

		bidServiceInterface.deleteBid(id);

		return "redirect:/bidList/list";
	}
}