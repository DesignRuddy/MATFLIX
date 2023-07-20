package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

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
public class ReplyMapperTests {

	// 테스트 하기 전에 테스트를 수행할 bno(기존 작성 게시물 번호)가 
	// 있는지(존재하는지) 확인하고, 기존 작성 게시물 번호 bno에 댓글을 
	// 추가 등록합니다. 그렇기 때문에 기존 작성 게시물 번호를
	// 배열 변수 넣고 테스트 하도록 합니다.
	private Long[] bnoArr = {1638664L, 1638663L, 1638661L, 1638660L, 1638659L};
	
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
//	@Test
//	public void testCreate() {
//		IntStream.rangeClosed(1, 10).forEach(i -> {
//			ReplyVO vo = new ReplyVO();
//			
//			// 게시물의 번호
//			vo.setBno(bnoArr[i % 5]);
//			vo.setReply("댓글 테스트 " + i);
//			vo.setReplyer("replyer" + i);
//			
//			mapper.insert(vo);			
//		});
//	}
	
//	@Test
//	public void testMapper() {
//		log.info(mapper);
//	}
	
//	@Test
//	public void testRead() {
//		Long targetRno = 2L;
//		ReplyVO vo = mapper.read(targetRno);
//		log.info(vo);
//	}	
	
//	@Test
//	public void testDelete() {
//		Long targetRno = 11L;
//		mapper.delete(targetRno);
//		log.info(targetRno);
//	}
	
//	@Test
//	public void testUpdate() {
//		Long targetRno = 10L;
//		ReplyVO vo = mapper.read(targetRno);
//		vo.setReply("오늘은 즐거운 금요일입니다~!");
//		int count = mapper.update(vo);
//		log.info("수정 처리가 된 데이터 수량 = " + count);
//	}
	
	/*
	@Test
	public void testList() {
		Criteria cri = new Criteria();
		// bnoArr[0] = 1638664L
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);
		replies.forEach(reply -> log.info(reply));
	}
	*/
	
	@Test
	public void testList2() {
		// 2page에 10개 데이터 log info 레벨 화면 출력
		Criteria cri = new Criteria(2, 10); 
		
		// 페이징 확인을 위해 댓글이 20개 이상 있는
		// bno 게시글 번호를 하나 준비합니다. 1638659L
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 1638659L);
		
		replies.forEach(reply -> log.info(reply));
	}
}



