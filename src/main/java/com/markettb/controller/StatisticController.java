package com.markettb.controller;


import com.markettb.model.*;
import com.markettb.service.OrderBillService;
import com.markettb.service.ProductService;
import com.markettb.service.TeamService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


@Controller
public class StatisticController {
    private Logger log = Logger.getLogger(StatisticController.class);
    private OrderBillService orderBillService;
    private TeamService teamService;
    private ProductService productService;

    /*Inject object Services*/
    @Autowired
    public void setOrderBillService(OrderBillService orderBillService) {
        this.orderBillService = orderBillService;
    }

    @Autowired
    public void setTeamService(TeamService teamService) {
        this.teamService = teamService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    /*START Statistic page*/
    @RequestMapping(value = "/statistic", method = RequestMethod.GET)
    public ModelAndView getStatistic() {
        // Initialize a ModelAndView
        ModelAndView model = new ModelAndView("view/statistic");

        /* Initialize StatisticOrder*/
        StatisticOrder statisticOrder = new StatisticOrder();
        /* GET listOrder */
        try {
            List<OrderBill> orderBillList = this.orderBillService.getAllOrderBillByDateBetween(
                    new SimpleDateFormat("dd/MM/yyyy").parse("10/07/2019"),
                    new SimpleDateFormat("dd/MM/yyyy").parse("17/07/2019"));
            int total = 0;
            for (int i = 0; i < orderBillList.size(); i++)
                total += orderBillList.get(i).getTotal();
            statisticOrder.setOrderBillList(orderBillList);
            statisticOrder.setStatisticTotal(total);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // SETTER for model attribute
        model.addObject("statisticOrder", statisticOrder);
        return model;

    }

    /*POST request statistic*/
    @RequestMapping(value = "/statisticsale", method = RequestMethod.POST)
    public ModelAndView postStatistic(@ModelAttribute("statisticOrder") StatisticOrder statisticOrder) {
        // Initialize a ModelAndView
        ModelAndView model = new ModelAndView("view/statistic");

        /* Initialize StatisticOrder*/
        StatisticOrder statistic = new StatisticOrder();

        /* GET listOrder */
        List<OrderBill> orderBillList = this.orderBillService.getAllOrderBillByDateBetween(
                statisticOrder.getOrderBillList().get(0).getDate(),
                statisticOrder.getOrderBillList().get(statisticOrder.getOrderBillList().size() - 1).getDate());
        int total = 0;
        for (int i = 0; i < orderBillList.size(); i++)
            total += orderBillList.get(i).getTotal();
        statistic.setOrderBillList(orderBillList);
        statistic.setStatisticTotal(total);

        // SETTER for model attribute
        model.addObject("statisticOrder", statistic);
        return model;
    }

    /*GET Statistic Product page*/
    @RequestMapping(value = "/statisticproduct", params = {"teamId", "teamName"}, method = RequestMethod.GET)
    public ModelAndView getStatisticProduct(@ModelAttribute("modelTeam") Team team, @RequestParam(value = "teamId") int team_Id, @RequestParam(value = "teamName") String teamName) {
        /*Initialize a ModelAndView */
        ModelAndView model = new ModelAndView("view/statisticproduct");

        /*GET list team by team_id*/
        List<Team> teamList = null;
        if (team_Id == 0)
            teamList = this.teamService.getAllTeamsByActive();
        else
            teamList = this.teamService.getAllTeamsByTeamId(team_Id);

        /*Initialize StatisticProduct*/
        StatisticProduct statisticProduct = new StatisticProduct();
        List<Product> productList = null;

        /*GET ListProduct by teamName*/
        if(teamName != null)
            productList = this.productService.getAllProductsByName(teamName);
        else
            productList = this.productService.getLast5Products();

        int total = 0;
        for(int i=0;i<productList.size();i++)
            total += productList.get(i).getTotal();
        statisticProduct.setProductList(productList);
        statisticProduct.setStatisticTotal(total);

        /*SETTER for Model Attribute*/
        model.addObject("teamList", teamList);
        model.addObject("statisticProduct",statisticProduct);

        return model;
    }

    /*POST request statistic Product*/
    @RequestMapping(value = "/poststatisticproduct",method = RequestMethod.POST)
    public ModelAndView postStatisticProduct(@ModelAttribute("modelTeam") Team team){
        String teamName = team.getName();
        String encodedName ="";
        try {
            encodedName = URLEncoder.encode(teamName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new ModelAndView("redirect:/statisticproduct?teamId=" + 0 + "&teamName=" + encodedName);
    }

}
