package com.nnk.springboot.service;

import java.util.ArrayList;

import com.nnk.springboot.domain.User;

/**
 * This interface allows to implement user service methods
*/
public interface UserServiceInterface {

	/**
	 * Create a User
	 * @param user : data of the User to create
	 */
	public void createUser(User user);

	/**
	 * Read a User
	 * @param id : id of the User to read
     * @return The User that was read
	 */
	public User readUser(Integer id);

	/**
	 * Read the User list
     * @return The User list that was read
	 */
	public ArrayList<User> readUserList();
	
	/**
	 * Update a User
	 * @param id : id of the User to update
	 * @param user : data of the User to update
	 */
	public void updateUser(Integer id, User user);

	/**
	 * Delete a User
	 * @param id : id of the User to delete
	 */
	public void deleteUser(Integer id);
}
