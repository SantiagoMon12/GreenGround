/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.greeng.dao;

import com.greeng.connection.ConnectionDB;
import com.greeng.model.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author santi
 */
public class DaoProduct {

    JdbcTemplate jdbcTemplate;
    ConnectionDB connection;

    /**
     * AddProduct method allows add a new product to the seller.
     *
     * @param newProduct contains the information to create a new product.
     * @return a integer value to validate it in the test section.
     *
     */
    public int addProduct(Product newProduct) {
        String sql = "insert into tbproduct (pro_serial, pro_name, pro_description, pro_expiration_date, pro_batch_date, pro_price, pro_status) "
                + "values (?,?,?,?,?,?,?)";
        int validation = this.jdbcTemplate.update(sql, new Product(newProduct.getPro_serial(),
                newProduct.getPro_name(), newProduct.getPro_description(),
                newProduct.getPro_expiration_date(), newProduct.getPro_batch_date(),
                newProduct.getPro_price(), newProduct.getPro_status()));
        return validation;
    }

    /**
     * viewProductByName allows view a specify product finded for their name
     *
     * @param pro_name contains the name to find the specify product
     * @return a list that contains the product information.
     *
     */
    public Product viewProductByName(String pro_name) {
        String sql = "select * from tbproduct where pro_name like " + pro_name;
        try {
            Product product = this.jdbcTemplate.queryForObject(sql, Product.class);
            return product;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * viewProductBySerial allows view a specify product finded for their serial
     *
     * @param pro_serial contains the name to find the specify product
     * @return a list that contains the product information.
     *
     */
    public List viewProductById(int pro_id) {
        String sql = "select * from tbproduct where pro_serial like " + pro_id;
        List product = this.jdbcTemplate.queryForList(sql);

        return product;
    }
    
    public List viewAllProducts(){
        String sql = "select * from tbproduct";
        List allProducts = this.jdbcTemplate.queryForList(sql);
        
        return allProducts;
    }
    
    /**
     * udpateProductGET allows show the information about the product to update and verify what you need to modify.
     * @param pro_serial helps to find the specify object.
     * @return a Product object that contains the information of the object to modify.
     **/

    public Product updateProductGET(String pro_serial) {
        Product currentPro = new Product();
        String sql = "select * from tbproduct where pro_serial like " + pro_serial;

        return (Product) this.jdbcTemplate.query(sql, new ResultSetExtractor<Product>() {
           
            public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    currentPro.setPro_serial(rs.getString("pro_serial"));
                    currentPro.setPro_name(rs.getString("pro_name"));
                    currentPro.setPro_description(rs.getString("pro_description"));
                    currentPro.setPro_expiration_date(LocalDate.parse(rs.getString("pro_expiration_date")));
                    currentPro.setPro_batch_date(LocalDate.parse(rs.getString("pro_batch_date")));
                    currentPro.setPro_price(rs.getLong("pro_price"));
                    currentPro.setPro_status(rs.getString("pro_status"));
                }

                return currentPro;
            }
        });
    }

    public void updateProductPOST(Product pro) {
        String sql = "update tbproduct set pro_id = '" + pro.getPro_id()+ "', pro_name = '" + pro.getPro_name() + "'"
                + ", pro_description = '" + pro.getPro_description() + "', pro_expiration_date = '" + pro.getPro_expiration_date() + "', pro_batch_date = '" + pro.getPro_batch_date() + "'" + ", pro_price = '" + pro.getPro_price() + "'" + ", pro_status = '" + pro.getPro_status() + "'" 
                + "where pro_id = " + pro.getPro_id();

    }

    /**
     * this method allows delete a product by their serial number.
     *
     * @param pro_id contains the product's serial number
     * @return a integer value to validate it in the test section.
     *
     */
    public int deleteProductById(int pro_id) {
        String sql = "delete from tbproducts where pro_id = " + pro_id;
        int validation = this.jdbcTemplate.update(sql);
        return validation;

    }

}
