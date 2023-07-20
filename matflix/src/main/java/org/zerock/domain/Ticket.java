package org.zerock.domain;

import lombok.Data;

@Data
public class Ticket {

	private int tno;      // 티켓 번호(tno)
	private String owner; // 소유자(owner)
	private String grade; // 등급(grade)
}
