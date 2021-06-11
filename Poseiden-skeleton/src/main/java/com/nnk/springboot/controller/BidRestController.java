package com.nnk.springboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nnk.springboot.domain.Bid;
import com.nnk.springboot.service.BidService;
import com.nnk.springboot.service.BidServiceInterface;

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
 * This class allows to intercept bid REST requests
 */
@RestController
public class BidRestController {

	private Logger logger = LogManager.getLogger(getClass().getSimpleName());
	
	private ObjectMapper objectMapper = new ObjectMapper();

	private BidServiceInterface bidServiceInterface;
	
	/**
	 * Creates a new BidRestController
	 */
	public BidRestController() {
		logger.info("bidController()");

		bidServiceInterface = new BidService();
	}

	/**
	 * Creates a new BidRestController with the specified BidServiceInterface
	 * @param bidServiceInterface : service that this controller will use
	 */
	public BidRestController(BidServiceInterface bidServiceInterface) {
		logger.info("bidController(" + bidServiceInterface + ")");

		this.bidServiceInterface = bidServiceInterface;
	}

	/**
	 * Intercepts the creating request of a bid
	 * @param bid : data of the bid to create
	 * @param bindingResult : serves as result holder
	 */
	@PostMapping("/bid/create")
	public void createBid(@Valid Bid bid, BindingResult bindingResult) {
		logger.info("createBid(" + bid + "," + bindingResult + ")");

		if (bindingResult.hasErrors() == false) {

			bidServiceInterface.createBid(bid);
		}
	}

	/**
	 * Intercepts the getting request of a bid
	 * @param id : id of the bid to read
     * @return Return the bid (JSon)
	 */
	@GetMapping("/bid/read")
	public String readBid(@RequestParam Integer id) throws JsonProcessingException {
		logger.info("readBid(" + id + ")");

        return objectMapper.writeValueAsString(bidServiceInterface.readBid(id));
	}

	/**
	 * Intercepts the updating request of a bid
	 * @param id : id of the bid to update
	 * @param bid : data of the bid to update
	 * @param bindingResult : serves as result holder
	 */
	@PutMapping("/bid/update")
	public void updateBid(@RequestParam("id") Integer id, @Valid Bid bid, BindingResult bindingResult) {
		logger.info("updateBid(" + id + "," + bid + "," + bindingResult + ")");

		if (bindingResult.hasErrors() == false) {

			bidServiceInterface.updateBid(id, bid);
		}
	}

	/**
	 * Intercepts the deleting request of a bid
	 * @param id : id of the bid to delete
	 */
	@DeleteMapping("/bid/delete")
	public void deleteBid(@RequestParam("id") Integer id) {
		logger.info("deleteBid(" + id + ")");
		
		bidServiceInterface.deleteBid(id);
	}
}