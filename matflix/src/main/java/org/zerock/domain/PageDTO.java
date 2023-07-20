package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

// 화면에 페이징 처리를 위한 여러 정보를 전달하는 PageDTO 클래스 작성
@Getter
@ToString
public class PageDTO {

	private int startPage; // 시작 페이지를 나타내는 startPage 필드 선언!
	private int endPage;   // 끝 페이지를 나타내는 endPage 필드 선언!
	private boolean prev, next; // 이전(prev), 다음(next) 필드 선언!
	
	private int total; // 전체 글의 수를 나타내는 total 필드 선언!
	// 페이지번호(pageNum)와 수량(amount)을 하나의 객체로 표현한 cri 필드 선언!
	private Criteria cri;
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		// 페이징의 끝 번호(endPage) 계산식을 적용합니다.
		// 여기서는 페이지 번호가 10개씩 보인다고 가정합니다.
		this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;
		// 만약 화면에 10개씩 글을 보여준다면 시작 번호(startPage)는
		// 끝 번호(endPage)에서 9라는 값을 뺀 값이 됩니다.
		this.startPage = this.endPage - 9;
		
		int realEnd = (int)(Math.ceil((total*1.0)/cri.getAmount()));
		
		// total을 통한 endPage의 재계산
		// 만약, 끝 번호(endPage)와 한 페이지당 출력되는 데이터 수(amount)의 곱이
		// 전체 데이터 수(total)보다 크다면 끝 번호(endPage)는
		// 다시 total을 이용해서 다시 계산되어야 합니다.
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		// 이전(prev)의 경우, 시작 번호(startPage)가 1보다 큰 경우라면 존재하게 됩니다.
		this.prev = this.startPage > 1;
		
		// 다음(next)으로 가는 링크의 경우 realEnd가 끝 번호(endPage)보다 큰 경우에만
        // 존재하게 됩니다.
		this.next = this.endPage < realEnd;
	} 
	
	
	
}
