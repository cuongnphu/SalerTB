package com.markettb.controller;


import com.markettb.model.Product;
import com.markettb.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class ProductController {

    private Logger log = Logger.getLogger(ProductController.class);
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService){
        this.productService = productService;
    }

    @RequestMapping(value = "/product",method = RequestMethod.GET)
    public ModelAndView getProduct(@ModelAttribute("product")Product product){
        /*Initialize ModelAndView*/
        ModelAndView model = new ModelAndView("view/product");

        /* GET last 5 Product */
        List<Product> productList = this.productService.getLast5Products();

        /* SETTER for model attribute*/
        model.addObject("productList",productList);
        return model;
    }

    @RequestMapping(value = "/postproduct",method = RequestMethod.POST)
    public ModelAndView postProduct(@ModelAttribute("product")Product product){
        log.info("Create a new Product !!!");
        this.productService.saveProduct(product);
        return new ModelAndView("redirect:/product");
    }

}
