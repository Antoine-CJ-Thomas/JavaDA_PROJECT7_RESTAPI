package com.nnk.springboot.controller;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.service.TradeService;
import com.nnk.springboot.service.TradeServiceInterface;

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
public class TradeController {
    // TODO: Inject Trade service
	
	@Autowired
	private TradeServiceInterface tradeServiceInterface;
	
	public TradeController() {
		
		tradeServiceInterface = new TradeService();
	}

    @RequestMapping("/trade/list")
    public String home(Model model) {
        // TODO: find all Trade, add to model
    	
    	model.addAttribute("tradeList", tradeServiceInterface.readTradeList());
    	
        return "trade/list";
    }

    @GetMapping("/trade/add")
    public String addTrade(Trade trade) {
    	
        return "trade/add";
    }

    @PostMapping("/trade/validate")
    public String validate(@Valid Trade trade, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Trade list
    	
    	tradeServiceInterface.createTrade(trade);
    	
        return "trade/add";
    }

    @GetMapping("/trade/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get Trade by Id and to model then show to the form

    	model.addAttribute("tradeList", tradeServiceInterface.readTrade(id));
    	
        return "trade/update";
    }

    @PostMapping("/trade/update/{id}")
    public String updateTrade(@PathVariable("id") Integer id, @Valid Trade trade, BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Trade and return Trade list
    	
    	tradeServiceInterface.updateTrade(id, trade);
    	
        return "redirect:/trade/list";
    }

    @GetMapping("/trade/delete/{id}")
    public String deleteTrade(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Trade by Id and delete the Trade, return to Trade list
    	
    	tradeServiceInterface.deleteTrade(id);
    	
        return "redirect:/trade/list";
    }
}
