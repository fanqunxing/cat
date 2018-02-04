package com.cat.service;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cat.baseTest.SpringTestCase;
import com.cat.domain.User;

public class UserServiceTest extends SpringTestCase
{
	@Autowired  
    private UserService userService;  
    Logger logger = Logger.getLogger(UserServiceTest.class);  
      
    @Test  
    public void selectUserByIdTest()
    {  
        User user = userService.selectUserById(10);  
        logger.debug("²éÕÒ½á¹û" + user);  
    }  
}
