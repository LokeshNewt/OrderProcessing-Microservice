package com.newt.controller;

import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

 
 
import com.newt.model.Orders;
import com.newt.repository.OrderRepository;
import com.wordnik.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/ordersprocessing")
public class OrderController {
	
	private static final Logger logger = Logger.getLogger(OrderController.class);
	@Autowired
	private OrderRepository orderRepository;	
	@Autowired
    private Notifications notifications;   
	
	@RequestMapping(value = "/{id}/{orderStatus}" ,method = RequestMethod.PUT)
	@ApiOperation(value = "put orders")
	public Orders processOrder(@PathVariable("id") int id,@PathVariable("orderStatus") String orderStatus){
		logger.info("Updating Orderstatus for " + id);	   
		Orders order = orderRepository.findOrdersByorderId(id);
	 try{
      if(order.getOrderId()==id){
    	  logger.info("Orders is  Id is  found");
	    	if(order.getOrderStatus().equalsIgnoreCase("pending")){
	    		 order.setOrderStatus("processing");
	    		 orderRepository.save(order);
	    		}else if(!(order.getOrderStatus().equalsIgnoreCase("pending"))){
	    			  notifications.sendNotification("order is under processing");
	    			  logger.info("Order is not processed....");
	    		}
	    	}
	  
	    	
	 
	else{
	          	
		logger.info("Order is not found..");
		}
	  
	 }catch(Exception e){e.printStackTrace();}  	    
		return order ;
}
}
