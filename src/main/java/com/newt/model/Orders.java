package com.newt.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orders {
	
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int orderId;
  private Date orderDate;
  private Integer customerId;
  private String orderType;
  private String orderStatus;
  private Date cancelDate;
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public Date getOrderDate() {
	return orderDate;
}
public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}
public Integer getCustomerId() {
	return customerId;
}
public void setCustomerId(Integer customerId) {
	this.customerId = customerId;
}
public String getOrderType() {
	return orderType;
}
public void setOrderType(String orderType) {
	this.orderType = orderType;
}
public String getOrderStatus() {
	return orderStatus;
}
public void setOrderStatus(String orderStatus) {
	this.orderStatus = orderStatus;
}
public Date getCancelDate() {
	return cancelDate;
}
public void setCancelDate(Date cancelDate) {
	this.cancelDate = cancelDate;
}
 
  

}
