package org.zerock.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board2/*")
@AllArgsConstructor
public class BoardController2 {

	private BoardService service;
	
//	@GetMapping("/list")
//	public void list(Model model) {
//		log.info("list 처리가 이루어집니다!");
//		model.addAttribute("list", service.getList());
//	}
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("list 처리가 이루어집니다!" + cri);
		model.addAttribute("list", service.getList(cri));
		
		// Page322 ~ Page324까지 14.6 MyBatis에서 전체 데이터의 개수 처리
		// 부분에서 아래 PageDTO 매개변수 200에 대해서
		// getTotalCount() 메서드 활용 수정 코딩해 줍니다.		
//		model.addAttribute("pageMaker", new PageDTO(cri, 200));
		
		int total = service.getTotal(cri);
		log.info("전체 데이터 수량 = " + total);
		model.addAttribute("pageMaker", new PageDTO(cri, total));		
	}	
	
	// Page238 게시물의 등록 작업은 POST 방식으로 처리하지만,
	// 화면에서 입력을 받아야 하므로 GET 방식으로 입력 페이지를 볼 수 있도록
	// BoardController에 register() 메서드를 추가합니다.
	// 이때, register() 메서드는 입력 페이지를 보여주는 역할만을 하기 때문에
	// 별도의 처리가 필요하지 않습니다.
	@GetMapping("/register")
	// Page712 아래 1줄 스프링 시큐리티 어노테이션 추가 : @PreAuthorize 어노테이션의 표현식으로
	// isAuthenticated()를 사용하였으며, 이것은 어떠한 사용자든 로그인이 성공한 사용자만이 해당 기능을
	// 사용할 수 있다는 것을 의미합니다.
	@PreAuthorize("isAuthenticated()")
	public void register() {
		
	}	
	
	// @PostMapping() POST 방식 URL 메핑
	// register() 메서드는 String을 리턴 타입으로 지정하고, Redirect Attributes를
	// 파라미터로 지정합니다. 이것은 등록 작업이 끝난 후 다시 목록 화면으로 이동하기 위함이며,
	// 추가적으로 새롭게 등록된 게시물의 번호를 같이 전달하기 위해서 RedirectAttributes를
	// 이용합니다. 이때, 리턴 시에는 "redirect:" 접두어를 사용하는데,
	// 이것을 이용하면 스프링 MVC가 내부적으로 response.sendRedirect()를 처리해 주기
	// 때문에 편리합니다.
	// BoardController에서 register() 메서드는 "redirect:/board/list"를
	// 전송하는데 브라우저는 이를 통보받은 후 "/board/list"로 이동하게 됩니다.
	// BoardController에서 redirect 처리를 할 때 RedirectAttributes라는
	// 특별한 타입의 객체를 이용합니다. addFlashAttribute()메서드의 경우, 이러한
	// 처리에 적합하며, 그 이유는 일회성으로만 데이터를 전달하기 때문입니다.
	// addFlashAttribute() 메서드로 보관된 데이터는 단 한 번만 사용할 수 있게 보관됩니다.
	// (내부적으로는 HttpSession을 이용해서 처리함)
	// Page712 아래 1줄 스프링 시큐리티 어노테이션 추가 : @PreAuthorize 어노테이션의 표현식으로
	// isAuthenticated()를 사용하였으며, 이것은 어떠한 사용자든 로그인이 성공한 사용자만이 해당 기능을
	// 사용할 수 있다는 것을 의미합니다.
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/register") // @PostMapping() POST 방식 URL 메핑
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("글등록 처리를 합니다!" + board);
		service.register(board);
		
		// addFlashAttribute() 메서드는 일회성으로만 데이터를 전달하기 때문에
		// addFlashAttribute() 메서드로 보관된 데이터는 단 한 번만 사용할 수 있게 
		// 보관됩니다.
		rttr.addFlashAttribute("result", board.getBno());		
		
		return "redirect:/board2/list";		
	}	
	
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("/get or modify");
		model.addAttribute("board", service.get(bno));
	}

	// Page720 : 게시물의 수정은 파라미터로 Board 타입의 객체를 받도록 설계 되었기에,
	// 아래와 같이 #board.writer 로 작성자 확인 적용합니다.
	@PreAuthorize("principal.username == #board.writer")
	@PostMapping("/modify")
	public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("글수정 처리가 되었습니다! ==> " + board);
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
	
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board2/list";
	}
	
	// Page580, Page581 파일 삭제 처리
	// 파일 삭제 처리도 조회와 유사하게 BoardController와 테스트 코드를 작성합니다.
	// 이때, 삭제는 반드시 POST 방식으로만 처리합니다.
	// Page720 : 아래 1줄 스프링 시큐리티 어노테이션 추가해 줌
	// 삭제의 경우, 기존에는 파라미터(매개변수)로 게시물의 번호 bno만을 받았지만,
	// 작성자를 의미하는 writer를 같이 추가해서 @PreAuthorize로 검사하도록 합니다.
	@PreAuthorize("principal.username == #writer")
	@PostMapping("/remove")
	// Page720 아래 1줄 소스 수정 코딩 : 기존과 달리 파라미터(매개변수)로 writer가 추가된 부분과
	// 해당 파라미터를 @PreAuthorize에서 '#writer'를 이용해서 처리해 줍니다.
	public String remove(@RequestParam("bno") Long bno,  @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr, String writer) {
		log.info("글삭제 처리가 되었습니다! ==> " + bno);		
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:/board2/list";
	}	
}






