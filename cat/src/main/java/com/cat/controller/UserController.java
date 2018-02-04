package com.cat.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cat.constant.Constant;
import com.cat.domain.User;
import com.cat.service.UserService;
import com.cat.utils.Utils;


@Controller
@RequestMapping ("/user/")
public class UserController 
{
	@Autowired
	private UserService userService;
	

	@RequestMapping(value = "queryUserById.do" ,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String queryUserById(HttpServletRequest request, HttpServletResponse response)
	{
		Integer userId = Integer.valueOf(request.getParameter("userId"));
		User user = userService.selectUserById(userId);
		return user.toString();
		
	}
	
	@RequestMapping(value = "addUser.do" ,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String addUser(HttpServletRequest request, HttpServletResponse response)
	{
		String username = Utils.decode(Utils.decode(request.getParameter("username")));
		String pazzword = Utils.decode(Utils.decode(request.getParameter("pazzword")));
		String useremail = Utils.decode(Utils.decode(request.getParameter("useremail")));
		
		String result = Constant.FAIL;
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("username", username);
		paramMap.put("pazzword", pazzword);
		paramMap.put("useremail", useremail);
		
		if(addUserParamValid(paramMap))
		{
			User user = userService.queryUserByName(username);
			if(null == user)
			{
				userService.addUser(paramMap);
				result = Constant.SUCCESS;
			}
			else
			{
				result = Constant.REPEAT;
			}
		}
		
		return result;
	}
	
	
	/**
	 * 增加用户的参数校验
	 * @param paramMap
	 * @return
	 */
	private boolean addUserParamValid(Map<String,String> paramMap)
	{
		boolean bFlag = true;
		for (String key : paramMap.keySet()) 
		{
			if("username".equals(key) || "pazzword".equals(key))
			{
				if(Utils.isBlank(paramMap.get(key)))
				{
					bFlag = false;
					break;
				}
			}
		}
		return bFlag;
	}
	
	
}
