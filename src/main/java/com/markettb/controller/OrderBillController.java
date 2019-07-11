package com.markettb.controller;

import com.markettb.model.Bill;
import com.markettb.model.OrderBill;
import com.markettb.model.TabOrder;
import com.markettb.service.BillService;
import com.markettb.service.OrderBillService;
import net.bytebuddy.asm.Advice;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class OrderBillController {
    private Logger log = Logger.getLogger(OrderBillController.class);
    private OrderBillService orderBillService;
    private BillService billService;

    @Autowired
    public void setOrderBillService(OrderBillService orderBillService){
        this.orderBillService = orderBillService;
    }

    @Autowired
    public void setBillService(BillService billService){
        this.billService = billService;
    }

    @RequestMapping(value="/start",method = RequestMethod.GET)
    public ModelAndView getStart(@ModelAttribute("orderBill") OrderBill orderBill){
        // Initialize a ModelAndView
        ModelAndView model = new ModelAndView("view/order");
        return model;
    }

    @RequestMapping(value = "/postorder",method = RequestMethod.POST)
    public ModelAndView saveOrderBill(@ModelAttribute("orderBill") OrderBill orderBill){
        log.info("Create a new OrderBill !!! ");
        int id = this.orderBillService.saveGetIdOrderBill(orderBill);
        return new ModelAndView("redirect:/orderdetail/"+id);
    }

    @RequestMapping(value = "/orderdetail/{id}",method = RequestMethod.GET)
    public ModelAndView createOrderDetail(@ModelAttribute("tabOrder")TabOrder tabOrder, @PathVariable("id") int id){
        // Initialize a ModelAndView
        ModelAndView model = new ModelAndView("view/orderdetail");

        // Get OrderBill by Id
        OrderBill orderBill = orderBillService.getOrderBillById(id);
        log.info(orderBill);

        // Get List Bills by Order_Id
        List<Bill> billList = this.billService.getAllBillsByOrderId(id);

        /* SETTER for modelAttribute object*/
        tabOrder.setBillList(billList);
        tabOrder.setOrderBill(orderBill);

        /*ModelView add Object*/
        model.addObject("tabOrder",tabOrder);

        return model;
    }

    @RequestMapping(value = "/postorderdetail",method = RequestMethod.POST)
    public ModelAndView saveOrderDetail(@ModelAttribute("tabOrder") TabOrder tabOrder){
        int totalOrderBill = 0;

        // Save or Update Bill
        if (tabOrder.getBillList() != null) {
            for (int i = 0; i < tabOrder.getBillList().size(); i++) {
                int total = tabOrder.getBillList().get(i).getPrice() * tabOrder.getBillList().get(i).getQuantity();
                totalOrderBill += total;
                if (this.billService.getBillById(tabOrder.getBillList().get(i).getId()) != null){
                    log.info("Update a Bill by id=" + tabOrder.getBillList().get(i).getId());
                    this.billService.updateBill(tabOrder.getBillList().get(i));
                }else{
                    log.info("Save a new Bill !!!");
                    this.billService.saveBill(tabOrder.getBillList().get(i));
                }
            }
        }

        // Update a Order
        if (this.orderBillService.getOrderBillById(tabOrder.getOrderBill().getId()) != null) {
            log.info("Update a Order by id = " + tabOrder.getOrderBill().getId());
            OrderBill orderBill = tabOrder.getOrderBill();
            orderBill.setTotal(totalOrderBill);
            this.orderBillService.updateOrderBill(orderBill);
        }

        int order_Id =  tabOrder.getOrderBill().getId();
        return new ModelAndView("redirect:/printorderdetail/" + order_Id);
    }

    @RequestMapping(value = "/printorderdetail/{id}",method = RequestMethod.GET)
    public ModelAndView printOrderDetail(@PathVariable("id") int id){
        // Initialize a ModelAndView
        ModelAndView model = new ModelAndView("view/printdetail");

        // Get OrderBill by Id
        OrderBill orderBill = orderBillService.getOrderBillById(id);
        log.info(orderBill);

        // Get List Bills by Order_Id
        List<Bill> billList = this.billService.getAllBillsByOrderId(id);

        /* SETTER for modelAttribute object*/
        TabOrder tabOrder = new TabOrder();
        tabOrder.setBillList(billList);
        tabOrder.setOrderBill(orderBill);

        /*ModelView add Object*/
        model.addObject("tabOrder",tabOrder);

        return model;

    }


}
