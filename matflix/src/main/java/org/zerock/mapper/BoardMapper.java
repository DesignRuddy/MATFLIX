package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {

// Page185 마이바티스 @Select 애노테이션 활용 게시판 글 조회 연습
//		SELECT * from tbl_board WHERE bno > 0;
//		@Select("SELECT * FROM tbl_board WHERE bno > 0")
//		public List<BoardVO> getList();
		
		// Page187 마이바티스 xml 활용 게시판 글 조회 연습
		public List<BoardVO> getList();
		
		// Page293 앞서 작성한 Criteria 타입을 파라미터로 사용하는
		// getListWithPaging() 메서드를 작성합니다.
		public List<BoardVO> getListWithPaging(Criteria cri);
		
		// create(insert) 처리를 위한 insert()와 insertSelectKey() 추상 메서드 정의
		public void insert(BoardVO board);
		
		public void insertSelectKey(BoardVO board);
		
		// read(select) 처리를 위한 read() 추상 메서드 정의
		public BoardVO read(Long bno);
		
		// delete 처리를 위한 delete() 추상 메서드 정의
		public int delete(Long bno);
		
		// update 처리 : 게시물의 업데이트는 제목, 내용, 작성자를 수정 처리 합니다.
		// 업데이트할 때는 최종 수정 시간을 데이터베이스 내 현재 시간으로 수정 처리 합니다.
		// update는 delete와 마찬가지로 "몇 개의 데이터가 수정되었는가"를 처리할 수 있도록
		// int 타입으로 메서드를 설계합니다.
		// update 처리를 위한 update() 추상 메서드 정의
		public int update(BoardVO board);
		
		// Page 322 getTotalCount() 메서드 추가
		// BoardMapper 인터페이스에 getTotalCount() 메서드를 정의하고
		// BoardMapper.xml 파일에 SQL을 처리합니다.
		// getTotalCount() 메서드는 게시물의 목록과 전체  데이터 수를 구하는
		// Criteria 파라미터를 전달 받도록 처리 합니다. 이것은 추후 검색에서 필요합니다. 
		public int getTotalCount(Criteria cri);
		
		// Page481 BoardMapper 인터페이스에 새롭게 replyCnt를 업데이트하는 메서드 추가
		// 새롭게 추가된 updateReplyCnt() 메서드는 해당 게시물의 번호인 bno와 증가나 감소를
		// 의미하는 amount 변수에 파라미터를 받을 수 있도록 처리합니다. 이것은 댓글이 등록되면
		// 1이 증가하고, 댓글이 삭제되면 1이 감소하기 때문입니다. MyBatis의 SQL을 처리하기
		// 위해서는 기본적으로 하나의 파라미터 타입을 사용하기 때문에 위와 같이 2개 이상의 데이터를
		// 전달하려면 @Param이라는 어노테이션을 이용해서 처리할 수 있습니다.
		// 댓글이 추가되면 반정규화된 tbl_board 테이블에 replycnt 칼럼이 업데이터되어야
		// 하기 때문에 BoardMapper.xml에 updateReplyCnt 구문을 추가해야만 합니다.	
		public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
	}

