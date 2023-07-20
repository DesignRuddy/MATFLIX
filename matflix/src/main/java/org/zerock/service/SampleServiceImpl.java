package org.zerock.service;

import org.springframework.stereotype.Service;

//SampleServiceImpl 클래스를 작성할 때는 반드시! @Service 어노테이션을 추가해서
//스프링에서 빈으로 사용될 수 있도록 설정 처리 합니다.
@Service
public class SampleServiceImpl implements SampleService {

	@Override
	public Integer doAdd(String str1, String str2) throws Exception {
		return Integer.parseInt(str1) + Integer.parseInt(str2);
	}
}
