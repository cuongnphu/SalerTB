package com.markettb.controller;


import com.markettb.model.Product;
import com.markettb.model.Team;
import com.markettb.service.ProductService;
import com.markettb.service.TeamService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.List;


@Controller
public class ProductController {

    private Logger log = Logger.getLogger(ProductController.class);
    private ProductService productService;
    private TeamService teamService;

    @Autowired
    public void setProductService(ProductService productService){
        this.productService = productService;
    }

    @Autowired
    public void setTeamService(TeamService teamService){
        this.teamService = teamService;
    }

    @RequestMapping(value = "/product/{team_id}",method = RequestMethod.GET)
    public ModelAndView getProduct(@ModelAttribute("product")Product product, @PathVariable("team_id")int team_id){
        /*Initialize ModelAndView*/
        ModelAndView model = new ModelAndView("view/product");

        /* GET last 5 Product */
        List<Product> productList = this.productService.getLast5Products();

        /*GET list team by team_id*/
        List<Team> teamList = null;
        if(team_id == 0)
            teamList = this.teamService.getAllTeamsByActive();
        else
            teamList = this.teamService.getAllTeamsByTeamIdAndActive(team_id,true);

        /* SETTER for model attribute*/
        model.addObject("productList",productList);
        model.addObject("teamList",teamList);
        return model;
    }

    @RequestMapping(value = "/postproduct",method = RequestMethod.POST)
    public ModelAndView postProduct(@ModelAttribute("product")Product product){
        log.info("Create a new Product !!!");
        this.productService.saveProduct(product);
        return new ModelAndView("redirect:/product/0");
    }

    @RequestMapping(value = "/editproduct/{id}",method = RequestMethod.GET)
    public ModelAndView editProduct(@ModelAttribute("product")Product product,@PathVariable("id")int id){
        /*Initialzie ModelAndView */
        ModelAndView model = new ModelAndView("edit/edit_product");

        /*Get product by Id*/
        Product prod = this.productService.getProductById(id);

        /* GET last 5 Product */
        List<Product> productList = this.productService.getLast5Products();

        /*SETTER for model attribute*/
        model.addObject("product",prod);
        model.addObject("productList",productList);

        return model;
    }

    @RequestMapping(value = "/updateproduct",method = RequestMethod.POST)
    public ModelAndView updateProduct(@ModelAttribute("product")Product product){
        if(this.productService.getProductById(product.getId())!= null){
            log.info("Update a Product by Id = " + product.getId());
            this.productService.updateProduct(product);
        }else{
            log.info("Create a new Product !!! ");
            this.productService.saveProduct(product);
        }

        return new ModelAndView("redirect:/product/0");
    }

    @RequestMapping(value = "/deleteproduct/{id}")
    public ModelAndView deleteProduct(@PathVariable("id")int id){
        /*DELETE a product by Id*/
        if(id > 0){
            log.info("DELETE a Product by Id = "+ id);
            this.productService.deleteProduct(id);
        }

        return new ModelAndView("redirect:/product/0");

    }

}
