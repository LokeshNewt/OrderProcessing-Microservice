package com.newt.controller;

import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

 
 
import com.newt.model.Orders;
import com.newt.repository.OrderRepository;
import com.wordnik.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
    private Notifications notifications;
	/*
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "get orders1")
    public Orders find(@PathVariable Integer id) {
           return orderRepository.findOne(id);        
    }
	*/
   
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@RequestMapping("update/{id}/{orderStatus}")
	@ApiOperation(value = "put orders")
	public Orders processOrder(@PathVariable("id") int id,@PathVariable("orderStatus") String orderStatus){
		System.out.println("Updating Orderstatus for " + id);
	   
		Orders order = orderRepository.findOrdersByorderId(id);
	 try{
      if(order.getOrderId()==id){
	      	System.out.println("Orders is  Id is  found");
	    	if(order.getOrderStatus().equalsIgnoreCase("pending")){
	    		 order.setOrderStatus("processing");
	    		 orderRepository.save(order);
	    		}else if(!(order.getOrderStatus().equalsIgnoreCase("pending"))){
	    			  notifications.sendNotification("order is under processing");
	    			System.out.println("Order is not processed....");
	    		}
	    	}
	  
	    	
	 
	else{
	          	
		  System.out.println("Order is not found..");
		}
	  
	 }catch(Exception e){e.printStackTrace();}  	    
		return order ;
}
}
