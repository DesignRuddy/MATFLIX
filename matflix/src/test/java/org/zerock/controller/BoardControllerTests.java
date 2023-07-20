package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
// Test for Controller
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml","file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class BoardControllerTests {

	@Setter(onMethod_ = {@Autowired})
	private WebApplicationContext ctx;
	
	// MockMvc는 "가짜 mvc"라고 생각하면 됩니다. 가짜로 URL과 파라미터 등을 브라우저에서
	// 사용하는 것처럼 만들어서 Controller를 실행해 볼 수 있습니다.
	// 아래에 testList()는 MockMvcRequestBuilders라는 존재를 이용해서
	// GET 방식의 호출을 합니다. 이후에는 BoardController의 getList()에서 반환된 결과를 이용해서
	// Model에 어떤 데이터들이 담겨 있는지 확인합니다.
	// Tomcat을 통해서 프론트앤드 실행되는 확인이 아닌 백엔드 테스트 방식으로 실행하는 것과
	// 동일하게 실행 테스트 확인을 할 수 있습니다.
	private MockMvc mockMvc;
	
	// 스프링에서 WebApplicationContext를 이용하는데,
	// @Before 어노테이션이 적용된 setup() 메서드에서는 import할때 JUnit을 이용합니다.
	// @Before가 적용된 setup() 메서드는 모든 테스트 사전에(Before) 매번 실행되는 메서드가 됩니다.
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
//	@Test
//	public void testList() throws Exception {
//		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView().getModelMap());
//	}
	
//	@Test
//	public void testRegister() throws Exception {
//		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
//				.param("title", "BoardControllerTest 등록 새글 제목")
//				.param("content", "BoardControllerTest 등록 새글 내용")
//				.param("writer", "김국진")
//				).andReturn().getModelAndView().getViewName();
//		
//		log.info(resultPage);
//	}
	
//	@Test
//	public void testGet() throws Exception {
//		log.info(mockMvc.perform(MockMvcRequestBuilders
//				.get("/board/get")
//				.param("bno", "1"))
//				.andReturn()
//				.getModelAndView().getModelMap());
//	}
	
//	@Test
//	public void testModify() throws Exception {
//		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
//				.param("bno", "21")
//				.param("title", "오늘은 화요일 수정 테스트!")
//				.param("content", "오늘은 화요일 내용 테스트!")
//				.param("writer", "김연아"))
//				.andReturn().getModelAndView().getViewName();
//		log.info(resultPage);
//	}	
	
//	@Test
//	public void testRemove() throws Exception {
//		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
//				.param("bno", "1")
//				).andReturn().getModelAndView().getViewName();
//		log.info(resultPage);
//	}	
	
	@Test
	public void testListPaging() throws Exception {
		log.info(mockMvc.perform(
				MockMvcRequestBuilders.get("/board/list")
				.param("pageNum", "2")
				.param("amount", "10"))
				.andReturn().getModelAndView().getModelMap());
	}
	
}

