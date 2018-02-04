package com.cat.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cat.constant.Constant;
import com.cat.domain.User;
import com.cat.service.UserService;
import com.cat.utils.Utils;



@Controller
@RequestMapping ("/login/")
public class LoginController 
{
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "login.do" ,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String login(HttpServletRequest request, HttpServletResponse response)
	{
		String username = Utils.decode(Utils.decode(request.getParameter("username")));
		String pazzword = Utils.decode(Utils.decode(request.getParameter("pazzword")));
		
		if(Utils.isBlank(username,pazzword))
		{
			return Constant.FAIL;
		}
		
		String result = Constant.FAIL;
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("username", username);
		paramMap.put("pazzword", pazzword);
		
		List<User> userlist = userService.queryUserByNameAndId(paramMap);
		if(userlist != null && userlist.size() == 1)
		{
			String useId = userlist.get(0).getUserId().toString();
			HttpSession session = request.getSession();
			session.setAttribute("useId", useId);
			result = Constant.SUCCESS;
		}
		return result;
	}
	
	@RequestMapping(value = "logout.do" ,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public void logout(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		session.removeAttribute("useId");
		try 
		{
			response.sendRedirect("/cat/index/login.jsp");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping(value = "test.do" ,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String test(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		return (String) session.getAttribute("useId");
	}
	
}
