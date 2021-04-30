package com.nnk.springboot.controller;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.service.LoginService;
import com.nnk.springboot.service.LoginServiceInterface;
import com.nnk.springboot.service.TradeService;
import com.nnk.springboot.service.TradeServiceInterface;

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
 * This class allows to intercept trade requests
 */
@Controller
public class TradeController {

	private Logger logger = LogManager.getLogger(getClass().getSimpleName());

	private TradeServiceInterface tradeServiceInterface;
	private LoginServiceInterface loginServiceInterface;
	
	/**
	 * Creates a new TradeController
	 */
	public TradeController() {
		logger.info("TradeController()");

		tradeServiceInterface = new TradeService();
		loginServiceInterface = new LoginService();
	}

	/**
	 * Creates a new TradeController with the specified TradeServiceInterface and LoginServiceInterface
	 * @param tradeServiceInterface : trade service that this controller will use
	 * @param loginServiceInterface : login service that this controller will use
	 */
	public TradeController(TradeServiceInterface tradeServiceInterface, LoginServiceInterface loginServiceInterface) {
		logger.info("TradeController(" + tradeServiceInterface + "," + loginServiceInterface + ")");

		this.tradeServiceInterface = tradeServiceInterface;
		this.loginServiceInterface = loginServiceInterface;
	}

	/**
	 * Intercepts the request of the trade list table
	 * @param model : defines a holder for model attributes
     * @return The trade list template
	 */
	@RequestMapping("/trade/list")
	public String home(Model model) {
		logger.info("home(" + model + ")");

		model.addAttribute("username", loginServiceInterface.getUsername());

		model.addAttribute("tradeList", tradeServiceInterface.readTradeList());

		return "/trade/list.html";
	}

	/**
	 * Intercepts the get request of the trade creation form
	 * @param trade : data of the Trade to create
     * @return The trade creation form template
	 */
	@GetMapping("/trade/add")
	public String addTradeForm(Trade trade) {
		logger.info("addTradeForm(" + trade + ")");

		return "/trade/add.html";
	}

	/**
	 * Intercepts the post request of the trade creation form
	 * @param trade : data of the Trade to create
	 * @param bindingResult : serves as result holder
	 * @param model : defines a holder for model attributes
     * @return Return the trade list template or redirect to the trade creation form
	 */
	@PostMapping("/trade/validate")
	public String validate(@Valid Trade trade, BindingResult bindingResult, Model model) {
		logger.info("validate(" + trade + "," + bindingResult + "," + model + ")");

		if (bindingResult.hasErrors() == false) {

			tradeServiceInterface.createTrade(trade);

			return "redirect:/trade/list";
		}

		return "/trade/add.html";
	}

	/**
	 * Intercepts the get request of the trade update form
	 * @param id : id of the trade to update
	 * @param model : defines a holder for model attributes
     * @return Return the trade update form template
	 */
	@GetMapping("/trade/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		logger.info("showUpdateForm(" + id + "," + model + ")");

		model.addAttribute("trade", tradeServiceInterface.readTrade(id));

		return "/trade/update.html";
	}

	/**
	 * Intercepts the post request of the trade update form
	 * @param id : id of the trade to update
	 * @param trade : data of the Trade to update
	 * @param bindingResult : serves as result holder
	 * @param model : defines a holder for model attributes
     * @return Return the trade list template or redirect to the trade update form
	 */
	@PostMapping("/trade/update/{id}")
	public String updateTrade(@PathVariable("id") Integer id, @Valid Trade trade, BindingResult bindingResult,
			Model model) {
		logger.info("updateTrade(" + id + "," + trade + "," + bindingResult + "," + model + ")");

		if (bindingResult.hasErrors() == false) {

			tradeServiceInterface.updateTrade(id, trade);

			return "redirect:/trade/list";
		}

		return "/trade/update.html";
	}

	/**
	 * Intercepts the get request of the trade delete
	 * @param id : id of the trade to delete
	 * @param model : defines a holder for model attributes
     * @return Return the trade list template
	 */
	@GetMapping("/trade/delete/{id}")
	public String deleteTrade(@PathVariable("id") Integer id, Model model) {
		logger.info("deleteTrade(" + id + "," + model + ")");

		tradeServiceInterface.deleteTrade(id);

		return "redirect:/trade/list";
	}
}
