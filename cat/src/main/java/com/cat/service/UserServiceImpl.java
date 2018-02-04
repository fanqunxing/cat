package com.cat.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cat.dao.UserDao;
import com.cat.domain.User;

/**
 * 
 * @author Ⱥ��
 *
 */

@Service
public class UserServiceImpl implements UserService
{
	@Autowired  
    private UserDao userDao;

	public User selectUserById(Integer userId) 
	{
		return userDao.selectUserById(userId);
	}

	public List<User> queryUserByNameAndId(Map<String, String> paramMap) 
	{
		return userDao.queryUserByNameAndId(paramMap);
	}

	public void addUser(Map<String, String> paramMap) 
	{
		userDao.addUser(paramMap);
	}

	public User queryUserByName(String username) 
	{
		return userDao.queryUserByName(username);
	}

}
