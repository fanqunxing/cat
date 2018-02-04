package com.cat.dao;

import java.util.List;
import java.util.Map;

import com.cat.domain.User;

/**
 * 
 * @author Ⱥ��
 *
 */
public interface UserDao 
{
	public User selectUserById(Integer userId);

	public List<User> queryUserByNameAndId(Map<String, String> paramMap);

	public void addUser(Map<String, String> paramMap);

	public User queryUserByName(String username);
}
