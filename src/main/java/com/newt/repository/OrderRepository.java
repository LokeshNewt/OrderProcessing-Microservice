package com.newt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.newt.model.Orders;

@Repository
public interface  OrderRepository extends CrudRepository<Orders, Integer> {

	public Orders findOrdersByorderId(int id);

}
