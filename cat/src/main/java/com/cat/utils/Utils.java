package com.cat.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.mysql.jdbc.StringUtils;

public class Utils 
{
	public static String decode(String str)
	{
		String result = "";
		if(!StringUtils.isNullOrEmpty(str))
		{
			try 
			{
				result = URLDecoder.decode(str, "UTF-8");
			} 
			catch (UnsupportedEncodingException e) 
			{
				e.printStackTrace();
			}
		}
		return result;
		
	}
	
	public static boolean isBlank(String... args)
	{
		boolean bFlag = false;
		for(String arg:args)
		{
			if(StringUtils.isNullOrEmpty(arg))
			{
				bFlag = true;
				break;
			}
		}
		return bFlag;
	}
}
