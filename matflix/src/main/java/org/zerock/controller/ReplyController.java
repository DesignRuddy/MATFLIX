package org.zerock.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/replies/")
@RestController
@Log4j
@AllArgsConstructor
public class ReplyController {

	private ReplyService service;

	// create() 메서드는 @PostMapping으로 POST 방식으로만 동작하도록 설계하고,
	// consumes와 produces를 이용해서 JSON 방식의 데이터만 처리하도록 하고,
	// 문자열을 반환하도록 설계합니다. create()의 파라미터는 @RequestBody를 적용해서
	// JSON 데이터를 ReplyVO 타입으로 변환하도록 지정합니다.
	// create() 메서드는 내부적으로 ReplyServiceImpl을 호출해서 register()를 호출하고,
	// 댓글이 추가된 숫자를 확인해서 브라우저에서 '200 OK' 혹은 '500 Internal Server Error'를
	// 반환하도록 처리 합니다.
	// Page729 스프링 시큐리티 : 아래 1줄 소스 추가 코딩
    // ReplyController에서는 댓글 등록이 로그인한 사용자인지를 확인하도록 합니다.
	// (웹페이지에서 새로운 댓글 추가하려고 할때 댓글 작성자(replyer)는 고정된 형태로 보이게 되고,
	//  전송 시 CSRF 토큰이 같이 전송 처리 됩니다)
	@PreAuthorize("isAuthenticated()")
	@PostMapping(value = "/new",
			consumes = "application/json",
			produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		log.info("ReplyVO 댓글 객체 = " + vo);
		
		int insertCount = service.register(vo);
		
		log.info("등록된 댓글 개수 = " + insertCount);
		
		// return문은 삼항 연산자로 처리함
		return insertCount == 1
		? new ResponseEntity<String>("success", HttpStatus.OK)
		: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 앞서 댓글 등록된 게시글의 댓글 목록을 확인하는 getList() 메서드 선언
	// ReplyController의 getList()는 Criteria를 이용해서 파라미터를 수집하는데,
	// '/{bno}/{page}'의 'page'값은 Criteria를 생성해서 직접 처리해야 합니다.
	// 게시물의 번호는 @PathVariable을 이용해서 파라미터(매개변수)로 처리하고
	// YARC 브라우저에서 테스트해 봅니다.
	// Page435 : ReplyController에서는 ReplyService에 새롭게 추가된
	//           getListPage() 메서드를 호출하고 데이터를 전송하는 형태로 수정합니다.
	@GetMapping(value = "/pages/{bno}/{page}",
			produces = {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_UTF8_VALUE})
	// ReplyController의 getList()는 Criteria를 이용해서 파라미터를 수집합니다.
	// 이때, '/{bno}/{page}'의 'page'값은 Criteria를 생성해서 직접 처리해 줍니다.
	// 즉, 게시물의 번호(bno)는 @PathVariable을 이용해서 파라미터로 처리해 줍니다.
	// 웹브라우저에 http://localhost/replies/pages/1638659/1 를 입력해서
	// 확인해 봅니다. 이때, 1638659은 게시물의 번호(bno) 변수값이고, 1은 페이지(page)의 변수값입니다.
	public ResponseEntity<ReplyPageDTO> getList(
			@PathVariable("page") int page,
			@PathVariable("bno") Long bno){
		
		//	log.info("특정 게시글에 등록된 댓글의 리스트 목록 내용 확인!");
					
			Criteria cri = new Criteria(page, 10);
			log.info("특정 게시글에 등록된 댓글의 리스트 목록 내용 확인! ==> " + bno);
			log.info(cri);
			
			// return new ResponseEntity<List<ReplyVO>>(service.getList(cri, bno), HttpStatus.OK);
			
			// Page435 : 기존(Page395)과 동일하게 JSON 데이터를 전송하지만 ReplyPageDTO
			// 객체를 JSON으로 전송하게 되므로, 특정 게시물의 댓글 목록을 조회하면
			// 'replyCnt'와 'list' 이름의 속성을 가지는 JSON 문자열 전송을 확인해 봅니다.
			return new ResponseEntity<ReplyPageDTO>(service.getListPage(cri, bno), HttpStatus.OK);
			}
	
	// 댓글 (상세)조회 get() 메서드 선언
	@GetMapping(value = "/{rno}",
			produces = {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyVO> get(
			@PathVariable("rno") Long rno){
			log.info("댓글 상세 조회 내용 확인! ==> " + rno);			
			return new ResponseEntity<>(service.get(rno),  HttpStatus.OK);
			}
	
	// 댓글 삭제를 위한 remove() 메서드 선언
	// Page732 ReplyController에서 스프링 시큐리티를 적용해 줍니다.
	// 그리고, JSON으로 전송되는 데이터를 처리하도록 아래와 같이 수정 코딩해 줍니다.
	@PreAuthorize("principal.username == #vo.replyer")
	@DeleteMapping(value = "/delete/{rno}",
			consumes = "application/json",
			produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@RequestBody ReplyVO vo,@PathVariable("rno") Long rno){
		log.info("댓글 삭제 처리 = " + rno);
		
		log.info("replyer 댓글 작성자 = " + vo.getReplyer());
		
		// return문은 삼항 연산자로 처리함
		return service.remove(rno) == 1
		? new ResponseEntity<String>("success", HttpStatus.OK)
		: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 댓글 수정은 'PUT' 방식이나 'PATCH' 방식을 이용하도록 처리합니다.
	// 실제 수정되는 데이터는 JSON 데이터 형식이므로 @RequestBody를 이용해서 처리합니다.
	// @RequestBody로 처리되는 데이터는 일반 파라미터(매개변수)나 @PathVariable 파라미터를
	// 처리할 수 없기 때문에 직접 처리해 주는 부분을 주의해야 합니다.
	// Page734 스프링 시큐리티 적용 : 아래 1줄 소스 코딩해 줌.
	@PreAuthorize("principal.username == #vo.replyer")
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH},
			value = "/modify/{rno}",
			consumes = "application/json",
			produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(
			@RequestBody ReplyVO vo,
			@PathVariable("rno") Long rno){
		vo.setRno(rno);
		log.info("rno 댓글 번호 = " + rno);
		log.info("modify 수정 처리 = " + vo);
		
		return service.modify(vo) == 1
				? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);				
	}	
}



