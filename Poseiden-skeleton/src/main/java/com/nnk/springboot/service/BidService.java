package com.nnk.springboot.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.Bid;
import com.nnk.springboot.repository.BidRepository;
import com.nnk.springboot.repository.BidRepositoryInterface;

@Service
public class BidService implements BidServiceInterface {
	
	@Autowired
	private BidRepositoryInterface bidRepositoryInterface;

	public BidService() {
		
		bidRepositoryInterface = new BidRepository();
	}

	@Override
	public void createBid(Bid bid) {
		
		bidRepositoryInterface.insertBid(bid);
	}


	@Override
	public Bid readBid(Integer id) {
		
		return bidRepositoryInterface.selectBid(id);
	}


	@Override
	public ArrayList<Bid> readBidList() {
		
		return bidRepositoryInterface.selectBidList();
	}


	@Override
	public void updateBid(Integer id, Bid bid) {
		
		bidRepositoryInterface.updatetBid(id, bid);
	}


	@Override
	public void deleteBid(Integer id) {
		
		bidRepositoryInterface.deleteBid(id);
	}
}
