package com.nnk.springboot.service;

import java.util.ArrayList;

import com.nnk.springboot.domain.Bid;

public interface BidServiceInterface {

	public void createBid(Bid bid);

	public Bid readBid(Integer id);

	public ArrayList<Bid> readBidList();

	public void updateBid(Integer id, Bid bid);

	public void deleteBid(Integer id);
}
