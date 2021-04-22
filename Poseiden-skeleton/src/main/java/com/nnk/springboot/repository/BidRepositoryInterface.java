package com.nnk.springboot.repository;

import java.util.ArrayList;

import com.nnk.springboot.domain.Bid;

public interface BidRepositoryInterface {

	public void insertBid(Bid bid);
	
	public Bid selectBid(Integer id);
	
	public ArrayList<Bid> selectBidList();
	
	public void updateBid(Integer id, Bid bid);
	
	public void deleteBid(Integer id);
}