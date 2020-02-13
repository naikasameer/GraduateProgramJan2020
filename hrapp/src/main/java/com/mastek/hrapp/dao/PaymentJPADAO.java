package com.mastek.hrapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.hrapp.entities.Payment;

@Repository
public interface PaymentJPADAO extends 
				CrudRepository<Payment, Integer>{

}
