package com.spring.iamport.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.iamport.model.PaymentVO;
import com.spring.iamport.service.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService paymentService;		
	
	@RequestMapping(value = "/paymentProcess.do")
	public void paymentDone(@RequestBody PaymentVO vo) {
		paymentService.insertPaymentSuccess(vo);
	}	
	
	@RequestMapping(value = "/paymentDone.do")
	public ModelAndView fwdPaymentSuccessPage() {
		return new ModelAndView("paymentSuccess");
	}
	
	@RequestMapping(value = "/payment.do")
	public ModelAndView fwdPaymentPage() {
		return new ModelAndView("payment");
	}
	
	@RequestMapping(value = {"/", "/goMain.do"})
	public ModelAndView goMain() {
		return new ModelAndView("index");
	}
	
	
}
