/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.greeng.controller;

import com.greeng.dao.DaoProduct;
import com.greeng.model.Product;
import com.greeng.validation.ValidationProduct;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author santi
 */
public class ControllerProduct {

    /**
     * CRUD PRODUCT GET BY NAME GET BY NUMBER
     *
     */
    DaoProduct daoProduct;
    ValidationProduct valProduct;

    @RequestMapping(value = "add_product.htm", method = RequestMethod.GET)
    public ModelAndView addProduct() {
        ModelAndView mav = new ModelAndView();
        Product newProduct = new Product();
        mav.addObject("newProduct", newProduct);
        mav.setView("views/add_product");

        return mav;
    }

    @RequestMapping(value = "add_product.htm", method = RequestMethod.POST)
    public ModelAndView addProduct(Product newProduct) {
        ModelAndView mav = new ModelAndView();
        daoProduct.addProduct(newProduct);
        mav.setViewName("redirect:/add_product");

        return mav;
    }
    
    //test githubasd

    @RequestMapping(value = "update_product.htm", method = RequestMethod.GET)
    public ModelAndView udpateProduct(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        String pro_serial = req.getParameter("pro_serial");

        Product proInfo = daoProduct.updateProductGET(pro_serial);

        mav.addObject("product", new Product(proInfo.getPro_serial(),
                proInfo.getPro_name(),
                proInfo.getPro_description(),
                proInfo.getPro_expiration_date(),
                proInfo.getPro_batch_date(),
                proInfo.getPro_price(),
                proInfo.getPro_status()));
        mav.setViewName("views/update_prodcut");
        return mav;
    }

    @RequestMapping(value = "update_product.htm", method = RequestMethod.POST)
    public ModelAndView updateProduct(@ModelAttribute("product") Product pro, BindingResult result) {
        valProduct.validate(pro, result);
        ModelAndView mav = new ModelAndView();
        if (result.hasErrors()) {
            mav.addObject("product", pro);
            mav.setViewName("views/update_product");
            return mav;
        } else {
            daoProduct.updateProductPOST(pro);
            mav.setViewName("redirect:/menu.htm");
        }
        return mav;
    }

    @RequestMapping(value = "delete_product.htm")
    public ModelAndView deleteProductBySerial(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        int pro_id = Integer.parseInt(req.getParameter("pro_serial"));
        daoProduct.deleteProductById(pro_id);
        mav.setViewName("redirect:/menu.htm");
        return mav;
    }

    @RequestMapping(value = "view_product.htm", method = RequestMethod.GET)
    public ModelAndView viewProductById(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        int pro_id =Integer.parseInt(req.getParameter("pro_serial"));
        daoProduct.viewProductById(pro_id);
        mav.setView("views/view_product");
        return mav;
    }

    @RequestMapping(value = "view_product.htm", method = RequestMethod.GET)
    public ModelAndView viewProductByName(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        String pro_name = req.getParameter("pro_name");
        daoProduct.viewProductByName(pro_name);
        mav.setView("views/view_product");
        return mav;
    }

    @RequestMapping(value = "view_all_products.htm", method = RequestMethod.GET)
    public ModelAndView viewAllProducts() {
        ModelAndView mav = new ModelAndView();
        List allProducts = daoProduct.viewAllProducts();
        mav.addObject("allProducts", allProducts);
        mav.setViewName("views/view_all");
        return mav;
    }
}
