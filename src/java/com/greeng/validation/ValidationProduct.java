/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.greeng.validation;

import com.greeng.model.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author santi
 */
public class ValidationProduct implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void validate(Object o, Errors errors) {
        Product product = (Product)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pro_id", "The field must not be blank or contains white spaces.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pro_name", "The field must not be blank or contains white spaces.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pro_description", "The field must not be blank or contains white spaces.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pro_expiration_date", "The field must not be blank or contains white spaces.");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pro_batch_date", "The field must not be blank or contains white spaces.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pro_price", "The field must not be blank or contains white spaces.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pro_status", "The field must not be blank or contains white spaces.");
        
        
    }
}
