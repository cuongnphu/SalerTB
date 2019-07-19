package com.markettb.controller;


import com.markettb.model.OrderBill;
import com.markettb.model.StatisticOrder;
import com.markettb.service.OrderBillService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


@Controller
public class StatisticController {
    private Logger log = Logger.getLogger(OrderBillController.class);
    private OrderBillService orderBillService;

    /*Inject object Services*/
    @Autowired
    public void setOrderBillService(OrderBillService orderBillService) {
        this.orderBillService = orderBillService;
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
}
