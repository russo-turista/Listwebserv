package com.listwebserv.settings.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jndi.JndiTemplate;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class JdbcConfig {
	private static final Logger logger = Logger.getLogger(JdbcConfig.class);
	@Bean
    public DataSource dataSource() {
		DataSource dataSource = null;
        JndiTemplate jndi = new JndiTemplate();
        try {
            dataSource = (DataSource) jndi.lookup("java:comp/env/jdbc/ServListDB");
        } catch (NamingException e) {
            logger.error("NamingException for java:comp/env/jdbc/yourname", e);
        }
        return dataSource;
    }
	@Bean
	public JdbcOperations jdbcOperations() {
	    return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
	    return new DataSourceTransactionManager(dataSource());
	}
}
