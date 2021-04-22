package com.nnk.springboot.service;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.Bid;
import com.nnk.springboot.repository.BidRepository;
import com.nnk.springboot.repository.BidRepositoryInterface;

@Service
public class BidService implements BidServiceInterface {

	private Logger logger = LogManager.getLogger(getClass().getSimpleName());

	private BidRepositoryInterface bidRepositoryInterface;

	public BidService() {
		logger.info("BidService()");

		bidRepositoryInterface = new BidRepository();
	}

	@Override
	public void createBid(Bid bid) {
		logger.info("createBid(" + bid + ")");

		bidRepositoryInterface.insertBid(bid);
	}

	@Override
	public Bid readBid(Integer id) {
		logger.info("readBid(" + id + ")");

		return bidRepositoryInterface.selectBid(id);
	}

	@Override
	public ArrayList<Bid> readBidList() {
		logger.info("readBidList()");

		return bidRepositoryInterface.selectBidList();
	}

	@Override
	public void updateBid(Integer id, Bid bid) {
		logger.info("updateBid(" + id + "," + bid + ")");

		bidRepositoryInterface.updateBid(id, bid);
	}

	@Override
	public void deleteBid(Integer id) {
		logger.info("deleteBid(" + id + ")");

		bidRepositoryInterface.deleteBid(id);
	}
}