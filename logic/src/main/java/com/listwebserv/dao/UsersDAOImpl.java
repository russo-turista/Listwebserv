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
import org.springframework.stereotype.Repository;

import com.listwebserv.domain.Servers;
import com.listwebserv.domain.User;

/**
 *
 * Реализация интрефейса {@link ServersDAO}
 */
@Repository
public class UsersDAOImpl implements UsersDAO {

    
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
    
    /*public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }*/

    private RowMapper<User> rowMapperUser = new RowMapper<User>() {

        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        	user = new User();
        	user.setName(rs.getString("name"));
        	user.setLogin(rs.getString("login"));
        	user.setAdmin(rs.getBoolean("admin"));
        	user.setActive(rs.getBoolean("active"));
        	user.setPassword(rs.getString("password"));
        	
            return user;
        }
    };


	public void setUserDb(String name, String login, String password, String email, Timestamp created, Timestamp lastLogin, boolean active, boolean admin){
		sql = "INSERT INTO users (NAME, LOGIN, PASSWORD, EMAIL, CREATED, LASTLOGIN, ACTIVE, ADMIN)VALUES(?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,name, login, password, email, created, lastLogin, active, admin);		
	}

	public User getUserDB(String login) {
		sql = "SELECT * FROM users WHERE LOGIN = ?";
		return jdbcTemplate.queryForObject(sql, rowMapperUser, login);    
	}

	@Override
	public void setUserDB(String name, String login, String password,
			String email, Timestamp created, Timestamp lastLogin,
			boolean active, boolean admin) {
		// TODO Auto-generated method stub
		
	}
	
}
