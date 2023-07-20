package org.zerock.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class CommonController {

	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("access Denied 접근이 거부 되었습니다! ==> " + auth);
		model.addAttribute("msg", "AccessDenied 접근 거부");
	}
	
	// Page632 loginInput() 메서드는 GET 방식으로 접근하고, 에러 메시지와 로그아웃 메시지를 파라미터로 사용합니다.
	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		log.info("error 에러 발생 : " + error);
		log.info("logout 로그 아웃 : " + logout);
		
		if(error != null) {
			model.addAttribute("error", "Login Error Check Your Account : 고객님의 계정 로그인 에러를 확인해 주시기 바랍니다!");
		}
		
		if(logout != null) {
			model.addAttribute("logout", "Logout 로그아웃!");
		}
	}
	
	// Page640 GET 방식으로 로그아웃을 결정하는 페이지에 대한 logoutGET() 메서드를 처리합니다.
	@GetMapping("/customLogout")
	public void logoutGET() {
		log.info("custom logout 사용자 정의 로그아웃");
	}
	
}
