package com.nnk.springboot.controller;

import com.nnk.springboot.domain.Trade;
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

@Controller
public class TradeController {

	private Logger logger = LogManager.getLogger(getClass().getSimpleName());

	private TradeServiceInterface tradeServiceInterface;

	public TradeController() {
		logger.info("TradeController()");

		tradeServiceInterface = new TradeService();
	}

	@RequestMapping("/trade/list")
	public String home(Model model) {
		logger.info("home(" + model + ")");

		model.addAttribute("tradeList", tradeServiceInterface.readTradeList());

		return "/trade/list.html";
	}

	@GetMapping("/trade/add")
	public String addTrade(Trade trade) {
		logger.info("addTrade(" + trade + ")");

		return "/trade/add.html";
	}

	@PostMapping("/trade/validate")
	public String validate(@Valid Trade trade, BindingResult bindingResult, Model model) {
		logger.info("validate(" + trade + "," + bindingResult + "," + model + ")");

		if (bindingResult.hasErrors() == false) {

			tradeServiceInterface.createTrade(trade);

			return "redirect:/trade/list";
		}

		return "/trade/add.html";
	}

	@GetMapping("/trade/update/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		logger.info("showUpdateForm(" + id + "," + model + ")");

		model.addAttribute("trade", tradeServiceInterface.readTrade(id));

		return "/trade/update.html";
	}

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

	@GetMapping("/trade/delete/{id}")
	public String deleteTrade(@PathVariable("id") Integer id, Model model) {
		logger.info("deleteTrade(" + id + "," + model + ")");

		tradeServiceInterface.deleteTrade(id);

		return "redirect:/trade/list";
	}
}
