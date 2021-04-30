package com.nnk.springboot.service;

public interface LoginServiceInterface {

	/**
	 * Get the username of authenticated the user
	 * @return The user username or null if no user authenticated
	 */
	public String getUsername();
}
