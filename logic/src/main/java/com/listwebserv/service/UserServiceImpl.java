package com.listwebserv.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.listwebserv.dao.UsersDAO;
import com.listwebserv.domain.Server;
import com.listwebserv.domain.User;

@Service
public class UserServiceImpl implements UserService  {

	@Autowired
	private UsersDAO usersDAO;
	private Map<String, String > mapIdUsers= new HashMap<String, String>();
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

	@Override
	public List<User> getListUsers() {
		return usersDAO.getListUserDB();
	}

	@Override
	public Map<String, String> getMapIdUsers() {
		for (User listItem : usersDAO.getListUserDB()){
			mapIdUsers.put(listItem.getUserId().toString(), listItem.getName());
		}
		return mapIdUsers;
	}

	@Override
	public void setMapIdUsers(Map<String, String> mapUsers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUser(Long userID) {
		
		return usersDAO.getUserDB(userID);
	}
	
}
