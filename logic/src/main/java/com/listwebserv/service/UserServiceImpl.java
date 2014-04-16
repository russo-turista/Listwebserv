package com.listwebserv.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.listwebserv.dao.UsersDAO;
import com.listwebserv.domain.User;

@Service
public class UserServiceImpl implements UserService  {

	@Autowired
	private UsersDAO usersDAO;
	
	@Override
    public User getUser(String login) {
        User user = new User();
        user = usersDAO.getUserDB(login);
        return user;
    }

	@Override
	public  void setUser(User user) {		
		usersDAO.setUserDB(user);
	}
	
}
