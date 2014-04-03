package com.listwebserv.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.listwebserv.domain.User;
import com.listwebserv.security.enums.UserRoleEnum;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService {
	
	@Autowired
	private User user;
	@Autowired
    private UserService userService;
 
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        // с помощью нашего сервиса UserService получаем User
        user = userService.getUser(login);
        // указываем роли для этого пользовател
        System.out.println("Login: " + login + "  " + user.getLogin());
        System.out.println("user.getAdmin(): " + user.getAdmin() + "  " + UserRoleEnum.ADMIN.name());
        System.out.println("user.getPassword(): " + user.getPassword());
        
        
        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority( user.getAdmin() ? UserRoleEnum.ADMIN.name()
        														: UserRoleEnum.USER.name()));
 
        // на основании полученныйх даных формируем объект UserDetails
        // который позволит проверить введеный пользователем логин и пароль
        // и уже потом аутентифицировать пользователя
        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(user.getLogin(), 
                                                                       user.getPassword(), 
                                                                       roles);
 
        return userDetails;
    }
}
