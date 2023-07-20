package org.zerock.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import lombok.extern.log4j.Log4j;

//Page628 접근 제한이 된 경우에 다양한 처리를 하고 싶다면
//직접 AccessDeniedHandler 인터페이스를 구현하는 것이 좋습니다.
//예를들어, 접근 제한이 되었을 때 쿠키나 세션에 특정한 작업을 하거나
//HttpServletResponse에 특정한 헤더 정보를 추가하는 등의 행위를 할 경우에는
//직접 구현하는 방식을 더 권장합니다.
//아래의 CustomAccessDeniedHandler 클래스는 AccessDeniedHandler 인터페이스를 직접 구현합니다.
//인터페이스의 메서드는 handle() 메서드 뿐이며, HttpServletRequest, HttpServletResponse를 파라미터로
//사용하기 때문에 직접적으로 서블릿 API를 이용하는 처리가 가능합니다.
@Log4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		log.error("Access Denied Handler 접근 거부 핸들러 활용입니다!");
		log.error("Redirect 처리가 됩니다!");
		// 접근 제한에 걸리는 경우, 다음과 같이 리다이렉트하는 방식으로 동작하도록 지정합니다.
		response.sendRedirect("/accessError");		
	}
}
