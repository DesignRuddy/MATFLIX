package org.zerock.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
	
		log.warn("Login Success 로그인 성공!");
		
		List<String> roleNames = new ArrayList<String>();
		authentication.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());
		});
		
	// Page638 CustomLoginSuccessHandler는 로그인 한 사용자에 부여된 권한 Authentication 객체를
	// 이용해서 사용자가 가진 모든 권한을 문자열로 체크합니다. 만일, 사용자가 'ROLE_ADMIN' 권한을 가졌다면
	// 로그인 후에 바로 '/sample/admin'으로 이동하게 하는 방식입니다.

		log.warn("ROLE NAMES 롤 이름 : " + roleNames);
		if (roleNames.contains("ROLE_ADMIN")) {
			
			// Page711 소스 코딩할 때, 아래 1줄 주석 처리하고, 밑에 /board/list 수정 코딩함.
//			response.sendRedirect("/sample/admin");
			response.sendRedirect("/board/list");
			return;
		}
		
		if (roleNames.contains("ROLE_MEMBER")) {
			
			// Page711 소스 코딩할 때, 아래 1줄 주석 처리하고, 밑에 /board/list 수정 코딩함.
//			response.sendRedirect("/sample/member");
			response.sendRedirect("/board/list");
			return;
		}
		
		response.sendRedirect("/");		
	}
}
