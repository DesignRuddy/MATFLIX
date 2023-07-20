package org.zerock.mapper;

import org.apache.ibatis.annotations.Insert;

public interface Sample2Mapper {

//	INSERT into tbl_sample2(col2) VALUES('테스트2');
	@Insert("INSERT into tbl_sample2(col2) VALUES(#{data})")
	public int insertCol2(String data);
	
}
