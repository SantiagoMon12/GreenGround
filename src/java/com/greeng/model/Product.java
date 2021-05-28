/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.greeng.model;

import java.time.LocalDate;

/**
 *
 * @author santi
 */
public class Product {

    private int pro_id;
    private String pro_serial;
    private String pro_name;
    private String pro_description;
    private LocalDate pro_expiration_date;
    private LocalDate pro_batch_date;
    private Long pro_price;
    private String pro_status;

    public Product() {
    }
    
    public Product(String pro_serial, String pro_name, String pro_description, LocalDate pro_expiration_date, LocalDate pro_batch_date, Long pro_price, String pro_status) {
        this.pro_serial = pro_serial;
        this.pro_name = pro_name;
        this.pro_description = pro_description;
        this.pro_expiration_date = pro_expiration_date;
        this.pro_batch_date = pro_batch_date;
        this.pro_price = pro_price;
        this.pro_status = pro_status;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_serial() {
        return pro_serial;
    }

    public void setPro_serial(String pro_serial) {
        this.pro_serial = pro_serial;
    }
    
    

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public String getPro_description() {
        return pro_description;
    }

    public void setPro_description(String pro_description) {
        this.pro_description = pro_description;
    }

    public LocalDate getPro_expiration_date() {
        return pro_expiration_date;
    }

    public void setPro_expiration_date(LocalDate pro_expiration_date) {
        this.pro_expiration_date = pro_expiration_date;
    }

    public LocalDate getPro_batch_date() {
        return pro_batch_date;
    }

    public void setPro_batch_date(LocalDate pro_batch_date) {
        this.pro_batch_date = pro_batch_date;
    }

    public Long getPro_price() {
        return pro_price;
    }

    public void setPro_price(Long pro_price) {
        this.pro_price = pro_price;
    }

    public String getPro_status() {
        return pro_status;
    }

    public void setPro_status(String pro_status) {
        this.pro_status = pro_status;
    }
    
    
    
}
