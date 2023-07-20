package org.zerock.mapper;

import org.zerock.domain.MemberVO;

//Page661, Page662 : 회원에 대한 정보는 MyBatis를 이용해서 처리할 것이므로 MemberMapper를 작성해서
//tbl_member와 tbl_member_auth 테이블에 데이터를 추가하고, 조회할 수 있도록 작성합니다.
//Member 객체를 가져오는 경우에는 한 번에 tbl_member와 tbl_member_auth를 조인해서 처리할 수 있는 방식으로
//MyBatis의 ResultMap이라는 기능을 사용합니다.
//하나의 MemberVO 인스턴스는 내부적으로 여러 개의 AuthVO를 가지는데, 이를 흔히 '1+N 관계'라고 합니다.
//즉, 하나의 데이터가 여러 개의 하위 데이터를 포함하고 있는 것을 의미합니다.
//MyBatis의 ResultMap을 이용하면 하나의 쿼리로 MemberVO와 내부의 AuthVO의 리스트까지 처리할 수 있습니다.
public interface MemberMapper {

	public MemberVO read(String userid);	
}
