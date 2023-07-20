package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {

	// 기존 게시글에 댓글을 추가하는 insert() 메서드 선언
	public int insert(ReplyVO vo); 
	
	// 특정 댓글의 내용을 읽어주는 read() 메서드 선언
	public ReplyVO read(Long rno); 

	// 특정 댓글의 내용을 삭제 처리하는 delete() 메서드 선언
	public int delete(Long rno);
	
	// 특정 댓글의 내용을 수정 처리하는 update() 메서드 선언
	public int update(ReplyVO reply);
	
	// MyBatis는 두 개 이상의 데이터를 파라미터로 전달하기 위해
	// 1) 별도의 객체로 구성하거나,
	// 2) Map을 이용하는 방식,
	// 3) @Param을 이용해서 이름을 사용하는 방식을 활용합니다.
	public List<ReplyVO> getListWithPaging(
			@Param("cri") Criteria cri,
			@Param("bno") Long bno);

	// Page432 댓글의 숫자 파악 : 댓글들을 페이징 처리하기 위해서는 해당 게시물의 전체 댓글의
	// 숫자를 파악해서 화면에 보여주어야 합니다. 그러기 위해서, ReplyMapper 인터페이스에
	// getCountByBno() 추상 메서드를 추가합니다.
	public int getCountByBno(Long bno);
}

