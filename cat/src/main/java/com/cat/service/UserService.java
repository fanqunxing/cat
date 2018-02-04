package com.cat.service;

import java.util.List;
import java.util.Map;

import com.cat.domain.User;

/**
 * 
 * @author Ⱥ��
 *
 */
public interface UserService 
{
	User selectUserById(Integer userId);

	List<User> queryUserByNameAndId(Map<String, String> paramMap);

	void addUser(Map<String, String> paramMap);

	User queryUserByName(String username);
}
