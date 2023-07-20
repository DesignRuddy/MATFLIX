package com.spring.iamport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.iamport.dao.PaymentDAO;
import com.spring.iamport.model.PaymentVO;

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDAO dao;
	
	@Override
	public void insertPaymentSuccess(PaymentVO vo) {
		dao.insertPaymentSuccess(vo);		
	}
}
