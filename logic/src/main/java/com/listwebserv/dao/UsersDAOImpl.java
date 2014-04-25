/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listwebserv.dao;

import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.listwebserv.domain.Server;
import com.listwebserv.domain.User;

/**
 *
 * Реализация интрефейса {@link ServersDAO}
 */
@Repository
public class UsersDAOImpl implements UsersDAO {

	@Autowired 
	private ShaPasswordEncoder passwordEncoder;
	
	@Autowired
	private User user;
    
    private String sql = "";
    
    /**
     * переменная типа {@link JdbcTemplate} экземпляр класса
     * SimpleJdbcTemplate
     */
   // private JdbcTemplate jdbcTemplate;

    /**
     * Реализуем jdbcTemplate, передаем параметры соединения
     *
     * @param dataSource {@link DataSource}
     */
    @Resource
    private JdbcOperations jdbcTemplate;

    private RowMapper<User> rowMapperUser = new RowMapper<User>() {
    	// принемает параметры с базы данных
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        	user = new User();
        	user.setUserId(rs.getLong("iduser"));
        	user.setName(rs.getString("name"));
        	user.setLogin(rs.getString("login"));
        	user.setEmail(rs.getString("email"));
        	user.setAdmin(rs.getBoolean("admin"));
        	user.setActive(rs.getBoolean("active"));
        	user.setPassword(rs.getString("password"));
        	
            return user;
        }
    };


	public void setUserDB(User user){
		sql = "INSERT INTO users (NAME, LOGIN, PASSWORD, EMAIL, CREATED, LASTLOGIN, ACTIVE, ADMIN)VALUES(?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, user.getName(), user.getLogin(), passwordEncoder.encodePassword(user.getPassword(), null), 
								 user.getEmail(), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 
								 user.getActive(), user.getAdmin());		
	}

	public User getUserDB(String login) {
		sql = "SELECT * FROM users WHERE login = ?";
		return jdbcTemplate.queryForObject(sql, rowMapperUser, login);    
	}
	public User getUserDB(Long userID) {
		sql = "SELECT * FROM users WHERE iduser = ?";
		return jdbcTemplate.queryForObject(sql, rowMapperUser, userID);    
	}

	@Override
	public List<User> getListUserDB() {
		sql = "SELECT * from users";
		return jdbcTemplate.query(sql, rowMapperUser);
	}

	
}
