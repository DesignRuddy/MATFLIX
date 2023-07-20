package org.zerock.sample;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

//ex00 프로젝트 클릭 선택 - 우클릭 - Properties - Java Build Path
//- Add Library - JUnit 선택 - Next - JUnit4 선택 - Finish 클릭
//ex00 프로젝트 클릭 선택 - 우클릭 - New - JUnit Test Case
//- Package: 란에 org.zerock.sample 입력
//- Name: 란에 SampleTests 입력 - Next - Finish 클릭

//@RunWith 어노테이션은 현재 테스트 코드가 스프링을 실행하는 역할을 할 것이이라는 것을 나타냅니다.
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration 어노테이션은 속성값의 문자열 설정으로 지정된 클래스나 문자열을 이용해서
//필요한 객체들을 스프링 내에 객체로 등록하게 됩니다(이것을 스프링의 빈으로 등록된다고 표현합니다)
//이때, SpringMVC 프로젝트 생성시 자동으로 생성된 root-context.xml 경로 지정을 할 수도 있으며,
//보통 문자열은 'classpath:'나 'file:'을 이용할 수 있습니다.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//@Log4j 어노테이션은 Lombok을 이용해서 로그를 기록하는 Logger를 변수로 생성합니다.
//별도의 Logger 객체의 선언이 없이도 Log4j 라이브러리와 설정이 존재한다면 바로 사용이 가능합니다.
@Log4j
public class SampleTests {

	// @Autowired는 해당 인스턴스 변수가 스프링으로부터 자동으로 주입해 달라는 표시입니다.
	// 이때, 스프링은 정상적으로 주입이 가능하다면 obj(객체) 변수에 Restaurant 타입의
	// 객체를 주입하게 됩니다.
	
	@Setter(onMethod_ = {@Autowired})
	private Restaurant restaurant;
	
	
	@Test  // @Test는 JUnit에서 테스트 대상을 표시하는 어노테이션입니다.
	public void testExist() {  // testExist() 메서드 선언

		// assertNotNull() 메서드는 restaurant 변수가 null이 아니어야만
		// 테스트 성공을 의미합니다.
		assertNotNull(restaurant);
		
		log.info(restaurant);
		log.info("===================================");
		log.info(restaurant.getChef());
	}
}

