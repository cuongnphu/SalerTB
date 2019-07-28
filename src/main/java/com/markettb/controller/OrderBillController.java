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

    /*Inject object Services*/
    @Autowired
    public void setOrderBillService(OrderBillService orderBillService) {
        this.orderBillService = orderBillService;
    }

    @Autowired
    public void setBillService(BillService billService) {
        this.billService = billService;
    }

    /* START HomePage*/
    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public ModelAndView getStart(@ModelAttribute("orderBill") OrderBill orderBill) {
        // Initialize a ModelAndView
        ModelAndView model = new ModelAndView("view/order");

        /* GET last 5 Order */
        List<OrderBill> orderBillList = this.orderBillService.getLast5OrderBills();

        /* SETTER for model attribute*/
        model.addObject("listOrderBill", orderBillList);
        return model;
    }

    /* POST new a OrderBill */
    @RequestMapping(value = "/postorder", method = RequestMethod.POST)
    public ModelAndView saveOrderBill(@ModelAttribute("orderBill") OrderBill orderBill) {
        log.info("Create a new OrderBill !!! ");
        int id = this.orderBillService.saveGetIdOrderBill(orderBill);
        return new ModelAndView("redirect:/orderdetail/" + id);
    }

    /* GET a OrderBill detail  */
    @RequestMapping(value = "/orderdetail/{id}", method = RequestMethod.GET)
    public ModelAndView createOrderDetail(@ModelAttribute("tabOrder") TabOrder tabOrder, @PathVariable("id") int id) {
        // Initialize a ModelAndView
        ModelAndView model = new ModelAndView("view/orderdetail");

        // Get OrderBill by Id
        OrderBill orderBill = orderBillService.getOrderBillById(id);
        log.info(orderBill);

        // Get List Bills by Order_Id
        List<Bill> billList = this.billService.getAllBillsByOrderId(id);

        /* Add more 5 bill in list for input data easy*/
        for (int i = 0; i < 5; i++) {
            Bill bill = new Bill();
            bill.setOrderId(id);
            billList.add(bill);
        }

        /* SETTER for modelAttribute object*/
        tabOrder.setBillList(billList);
        tabOrder.setOrderBill(orderBill);

        /*ModelView add Object*/
        model.addObject("tabOrder", tabOrder);

        return model;
    }

    /* POST a OrderBill detail  : OrderBill and Bills*/
    @RequestMapping(value = "/postorderdetail", method = RequestMethod.POST)
    public ModelAndView saveOrderDetail(@ModelAttribute("tabOrder") TabOrder tabOrder) {
        int totalOrderBill = 0;

        // Save or Update Bill
        if (tabOrder.getBillList() != null) {
            for (int i = 0; i < tabOrder.getBillList().size(); i++)
                if (tabOrder.getBillList().get(i).getPrice() > 0 && tabOrder.getBillList().get(i).getQuantity() > 0) {
                    int total = tabOrder.getBillList().get(i).getPrice() * tabOrder.getBillList().get(i).getQuantity();
                    totalOrderBill += total;
                    if (this.billService.getBillById(tabOrder.getBillList().get(i).getId()) != null) {
                        log.info("Update a Bill by id=" + tabOrder.getBillList().get(i).getId());
                        this.billService.updateBill(tabOrder.getBillList().get(i));
                    } else {
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

        /* Redirect Print OrderBill page */
        int order_Id = tabOrder.getOrderBill().getId();
        return new ModelAndView("redirect:/printorderdetail/" + order_Id);
    }

    /* DELETE a OrderBill when not include Bills */
    @RequestMapping(value = "/deleteorder/{id}")
    public ModelAndView deleteOrderBill(@PathVariable("id") int id) {
        /*Delete a OrderBill when it does not include Bill*/
        List<Bill> billList = this.billService.getAllBillsByOrderId(id);
        if (billList.size() == 0)
            this.orderBillService.deleteOrderBill(id);
        else {
            int totalOrderBill = 0;

            /*GET total of OrderBill*/
            for (int i = 0; i < billList.size(); i++)
                if (billList.get(i).getPrice() > 0 && billList.get(i).getQuantity() > 0)
                    totalOrderBill += (billList.get(i).getPrice() * billList.get(i).getQuantity());

            // Update new total for OrderBill
            if (this.orderBillService.getOrderBillById(id) != null) {
                log.info("Update a Order by id = " + id);
                OrderBill orderBill = this.orderBillService.getOrderBillById(id);
                orderBill.setTotal(totalOrderBill);
                this.orderBillService.updateOrderBill(orderBill);
            }
        }
        return new ModelAndView("redirect:/start");
    }

    /* GOTO Print OrderBill detail page*/
    @RequestMapping(value = "/printorderdetail/{id}", method = RequestMethod.GET)
    public ModelAndView printOrderDetail(@PathVariable("id") int id) {
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
        model.addObject("tabOrder", tabOrder);

        return model;
    }


}
