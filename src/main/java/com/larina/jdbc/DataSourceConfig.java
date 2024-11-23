package com.larina.jdbc;
import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
	
    public static DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/stands_state");
        dataSourceBuilder.username("postgres");
        dataSourceBuilder.password("12345");
        return dataSourceBuilder.build();
    }
    
//    @Bean
//    DataSource dataSource() {
//    	return new EmbeddedDatabaseBuilder()
//    		.setType(EmbeddedDatabaseType.H2)
//    		.addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
//    		.build();
//    }
}