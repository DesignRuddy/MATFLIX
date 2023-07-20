package org.zerock.mapper;

import org.apache.ibatis.annotations.Insert;

public interface Sample1Mapper {

//	INSERT into tbl_sample1(col1) VALUES('테스트1');
	@Insert("INSERT into tbl_sample1(col1) VALUES(#{data})")
	public int insertCol1(String data);
	
}
