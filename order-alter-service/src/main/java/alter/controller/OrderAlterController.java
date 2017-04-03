package alter.controller;

import alter.domain.Order;
import alter.service.OrderAlterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class OrderAlterController {

    @Autowired
    private OrderAlterService orderService;

    @RequestMapping(path = "/welcome", method = RequestMethod.GET)
    public String home() {
        return "Welcome to [ Order Service ] !";
    }

    @RequestMapping(path = "/findOrders/{accountId}", method = RequestMethod.GET)
    public ArrayList<Order> findOrdersByAccountId(@PathVariable long accountId){
        return orderService.findOrdersByAccountId(accountId);
    }

    @RequestMapping(path = "/createNewOrders", method = RequestMethod.POST)
    public Order createNewAccount(@RequestBody Order newOrder){
        return orderService.create(newOrder);
    }

    @RequestMapping(path = "/saveOrderInfo", method = RequestMethod.PUT)
    public Order saveAccountInfo(@RequestBody Order order){
        return orderService.saveChanges(order);
    }

}
