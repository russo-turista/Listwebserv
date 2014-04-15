package com.listwebserv.service;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;
import org.w3c.dom.UserDataHandler;

import com.listwebserv.dao.ServersDAO;
import com.listwebserv.domain.User;

@Service
public class UserServiceImpl implements UserService  {

	@Autowired
	private ServersDAO listservDAO;
	@Autowired 
	private ShaPasswordEncoder passwordEncoder;
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Override
    public User getUser(String login) {
        User user = new User();
        user = listservDAO.getUniqueUser(login);
        return user;
    }

	@Override
	public  void setUser(User user) {		
		listservDAO.addUser(user.getName(), user.getLogin(), passwordEncoder.encodePassword(user.getPassword(), null), user.getEmail(),
					        new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()),
				            user.getActive(),user.getAdmin());
	}
	
}
