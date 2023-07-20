package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	// Page484 다음 2줄 소스 추가 코딩해줌.
	// ReplyServiceImple 클래스에서 새로운 댓글이 추가되거나 삭제되는 상황이 발생하면
	// BoardMapper와 ReplyMapper를 같이 이용해서 처리할 수 있게 BoardMapper를 추가해 줍니다.
	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;		

	// Page485 ReplyServiceImpl 클래스에서 댓글 등록을 담당하는 메서드에
	// @Transactional 처리를 해줍니다.
	@Transactional
	@Override
	public int register(ReplyVO vo) {
		log.info("댓글 등록이 정상적으로 처리 되었습니다! " + vo);
		
		// Page485 다음 1줄 소스 추가 코딩해 줍니다.
		boardMapper.updateReplyCnt(vo.getBno(), 1);
		
		return mapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		log.info("댓글 상세보기 기능입니다!" + rno);
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		log.info("댓글 수정 기능입니다!" + vo);
		return mapper.update(vo);
	}

	// Page485 ReplyServiceImpl 클래스에서 댓글 삭제를 담당하는 메서드에
	// @Transactional 처리를 해줍니다.
	@Transactional
	@Override
	public int remove(Long rno) {
		log.info("댓글 삭제 기능입니다! " + rno);
		
		// Page485 다음 2줄 소스 추가 코딩해 줍니다.
		ReplyVO vo = mapper.read(rno);
		boardMapper.updateReplyCnt(vo.getBno(), -1);
		
		return mapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		log.info("댓글 목록 조회 기능입니다! " + bno);
		return mapper.getListWithPaging(cri, bno);
	}

	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long bno) {		
		return new ReplyPageDTO(
				mapper.getCountByBno(bno),
				mapper.getListWithPaging(cri, bno));
	}
	
}
