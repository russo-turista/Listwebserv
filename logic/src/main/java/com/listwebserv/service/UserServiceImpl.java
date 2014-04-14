package com.listwebserv.service;

import java.sql.Timestamp;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;
import org.w3c.dom.UserDataHandler;

import com.listwebserv.dao.ListServDAO;
import com.listwebserv.domain.User;

@Service
public class UserServiceImpl implements UserService  {

	@Autowired
	private ListServDAO listservDAO;
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
<<<<<<< HEAD:logic/src/main/java/com/listwebserv/security/UserServiceImpl.java
public  void setUser(User user) {		
		listservDAO.addUser(user.getName(), user.getLogin(), passwordEncoder.encodePassword(user.getPassword(), null),
					user.getEmail(), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()),
				    user.getActive(),user.getAdmin());
=======
	public  void setUser(User user) {		
		listservDAO.addUser(user.getName(), user.getLogin(), passwordEncoder.encodePassword(user.getPassword(), null), user.getEmail(),
					        new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()),
				            user.getActive(),user.getAdmin());
>>>>>>> eaa8205c4935c198c43e66344bdf98fd3d1720d9:logic/src/main/java/com/listwebserv/service/UserServiceImpl.java
	}
	
}
