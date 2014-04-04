package com.listwebserv.security;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

import com.listwebserv.dao.ListServDAO;
import com.listwebserv.domain.User;

@Service
public class UserServiceImpl implements UserService  {

	@Autowired
	private ListServDAO listservDAO;
	@Autowired 
	private ShaPasswordEncoder passwordEncoder;
	
	@Override
    public User getUser(String login) {
        User user = new User();
        user = listservDAO.getUniqueUser(login);
        //user.setLogin(login);
        //user.setPassword("7110eda4d09e062aa5e4a390b0a572ac0d2c0220");
        System.out.println("Check password encod: " + passwordEncoder.encodePassword(user.getPassword(), null));
        /*user.setLogin(login);
        user.setPassword("7110eda4d09e062aa5e4a390b0a572ac0d2c0220");*/ 
        return user;
    }

	@Override
	public  void setUser(User user) {		
		listservDAO.addUser(user.getName(), user.getLogin(), passwordEncoder.encodePassword(user.getPassword(), null),
					user.getEmail(), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()),
				    user.getActive(),user.getAdmin());
	}
}
