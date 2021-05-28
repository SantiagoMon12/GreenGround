/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.greeng.connection;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author santi
 */
public class ConnectionDB {
  
    public DriverManagerDataSource con() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/dbgreeng");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    } 
    
}
