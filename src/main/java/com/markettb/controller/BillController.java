package com.markettb.controller;


import com.markettb.service.BillService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class BillController {
    private Logger log = Logger.getLogger(OrderBillController.class);
    private BillService billService;

    @Autowired
    public void setBillService(BillService billService){
        this.billService = billService;
    }

    @RequestMapping(value = "/orderdetail/bill/{order_id}/delete/{id}")
    public ModelAndView deleteBill(@PathVariable("id") int id, @PathVariable("order_id") int order_id){
        /*Delete a Bill by Id*/
        if(id > 0){
            log.info("Delete a Bill by Id = " + id);
            billService.deleteBill(id);
        }

        /*Initialize variable for redirection page*/
        RedirectView rv = new RedirectView();
        rv.setContextRelative(true);
        rv.setUrl("/orderdetail/" + order_id);

        return new ModelAndView(rv);
    }


}
