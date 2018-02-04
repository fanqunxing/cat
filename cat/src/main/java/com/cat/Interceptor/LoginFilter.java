package com.cat.Interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cat.utils.Utils;

public class LoginFilter implements Filter
{
	private String[] whiteList;

	public void destroy() 
	{
		
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException 
	{
		boolean isFilter = true;
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String path = request.getServletPath();
		String useId = (String) request.getSession().getAttribute("useId");
		if(!Utils.isBlank(useId))
		{
			chain.doFilter(request, response);
			return;
		}
		
		for(String white : whiteList)
		{
			if(white.equals(path) || isStaticSrc(path))
			{
				isFilter = false;
				break;
			}
		}
		
		if(!isFilter)
		{
			chain.doFilter(request, response);
		}
		else
		{
			response.setStatus(302);
			response.sendRedirect("/cat/index/login.jsp");
		}
		
		
	}

	public void init(FilterConfig filterConfig) throws ServletException 
	{
		whiteList = filterConfig.getInitParameter("white").split(",");
	}
	
	private boolean isStaticSrc(String str)
	{
		boolean bFlag = false;
		do 
		{
			if(str.endsWith(".css"))
			{
				bFlag = true;
				break;
			}
			if(str.endsWith(".js"))
			{
				bFlag = true;
				break;
			}
			if(str.endsWith(".jpg"))
			{
				bFlag = true;
				break;
			}
			if(str.endsWith(".png"))
			{
				bFlag = true;
				break;
			}
			if(str.endsWith(".ico"))
			{
				bFlag = true;
				break;
			}
		}
		while(false);
		
		return bFlag;
	}

}
