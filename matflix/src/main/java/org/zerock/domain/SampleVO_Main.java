package org.zerock.domain;

public class SampleVO_Main {

	public static void main(String[] args) {
		SampleVO svo = new SampleVO();
		svo.setMno(10);
		svo.setFirstName("나라");
		svo.setLastName("장");
		System.out.println(svo.getMno() + ", " + svo.getFirstName() + ", " + svo.getLastName());
		
		SampleVO svo1 = new SampleVO(20, "희선", "김");
		System.out.println(svo1.getMno() + ", " + svo1.getFirstName() + ", " + svo1.getLastName());
	}
}
