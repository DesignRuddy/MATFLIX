package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {

	private Long rno;  // 댓글 등록 번호를 나타내는 rno 필드 선언!
	private Long bno;  // 게시글 등록 번호를 나타내는 bno 필드 선언!
	
	private String reply;   // 댓글 내용을 나타내는 reply 필드 선언!
	private String replyer; // 댓글 작성자를 나타내는 replyer 필드 선언!
	private Date replyDate; // 댓글 등록일을 나타내는 replyDate 필드 선언!
	private Date updateDate; // 댓글 갱신일을 나타내는 updateDate 필드 선언!
	
}


