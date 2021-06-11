package com.nnk.springboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.service.TradeService;
import com.nnk.springboot.service.TradeServiceInterface;

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
 * This class allows to intercept trade REST requests
 */
@RestController
public class TradeRestController {

	private Logger logger = LogManager.getLogger(getClass().getSimpleName());
	
	private ObjectMapper objectMapper = new ObjectMapper();

	private TradeServiceInterface tradeServiceInterface;
	
	/**
	 * Creates a new TradeRestController
	 */
	public TradeRestController() {
		logger.info("tradeController()");

		tradeServiceInterface = new TradeService();
	}

	/**
	 * Creates a new TradeRestController with the specified TradeServiceInterface
	 * @param tradeServiceInterface : service that this controller will use
	 */
	public TradeRestController(TradeServiceInterface tradeServiceInterface) {
		logger.info("tradeController(" + tradeServiceInterface + ")");

		this.tradeServiceInterface = tradeServiceInterface;
	}

	/**
	 * Intercepts the creating request of a trade
	 * @param trade : data of the trade to create
	 * @param bindingResult : serves as result holder
	 */
	@PostMapping("/trade/create")
	public void createTrade(@Valid Trade trade, BindingResult bindingResult) {
		logger.info("createTrade(" + trade + "," + bindingResult + ")");

		if (bindingResult.hasErrors() == false) {

			tradeServiceInterface.createTrade(trade);
		}
	}

	/**
	 * Intercepts the getting request of a trade
	 * @param id : id of the trade to read
     * @return Return the trade (JSon)
	 */
	@GetMapping("/trade/read")
	public String readTrade(@RequestParam Integer id) throws JsonProcessingException {
		logger.info("readTrade(" + id + ")");

        return objectMapper.writeValueAsString(tradeServiceInterface.readTrade(id));
	}

	/**
	 * Intercepts the updating request of a trade
	 * @param id : id of the trade to update
	 * @param trade : data of the trade to update
	 * @param bindingResult : serves as result holder
	 */
	@PutMapping("/trade/update")
	public void updateTrade(@RequestParam("id") Integer id, @Valid Trade trade, BindingResult bindingResult) {
		logger.info("updateTrade(" + id + "," + trade + "," + bindingResult + ")");

		if (bindingResult.hasErrors() == false) {

			tradeServiceInterface.updateTrade(id, trade);
		}
	}

	/**
	 * Intercepts the deleting request of a trade
	 * @param id : id of the trade to delete
	 */
	@DeleteMapping("/trade/delete")
	public void deleteTrade(@RequestParam("id") Integer id) {
		logger.info("deleteTrade(" + id + ")");
		
		tradeServiceInterface.deleteTrade(id);
	}
}