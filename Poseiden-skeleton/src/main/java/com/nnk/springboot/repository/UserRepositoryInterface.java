package com.nnk.springboot.repository;

import java.util.ArrayList;

import com.nnk.springboot.domain.User;

/**
 * This interface allows to implement user repository methods
*/
public interface UserRepositoryInterface {

	/**
	 * Insert a User in the User table
	 * @param user : data of the User to insert
	 */
	public void insertUser(User user);
	
	/**
	 * Select a User in the User table
	 * @param username : name of the User to select
     * @return The User that was selected
	 */
	public User selectUser(String username);
	
	/**
	 * Select a User in the User table
	 * @param id : id of the User to select
     * @return The User that was selected
	 */
	public User selectUser(Integer id);

	/**
	 * Select the User list of the User table
     * @return The User list that was selected
	 */
	public ArrayList<User> selectUserList();
	
	/**
	 * Update a User in the User table
	 * @param id : id of the User to update
	 * @param user : data of the User to update
	 */
	public void updateUser(Integer id, User user);

	/**
	 * Delete a User in the User table
	 * @param id : id of the User to delete
	 */
	public void deleteUser(Integer id);
}