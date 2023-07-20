package org.zerock.security;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

//@RunWith 어노테이션은 현재 테스트 코드가 스프링을 실행하는 역할을 할 것이라는 것을 나타냅니다.
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration 어노테이션은 속성값의 문자열 설정으로 지정된 클래스나 문자열을 이용해서
//필요한 객체들을 스프링 내에 객체로 등록하게 됩니다(이것을 스프링의 빈으로 등록된다고 표현합니다)
//이때, SpringMVC 프로젝트 생성시 자동으로 생성된 root-context.xml 경로 지정을 할 수도 있으며,
//보통 문자열은 'classpath:'나 'file:'을 이용할 수 있습니다.
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",  "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
//@Log4j 어노테이션은 Lombok을 이용해서 로그를 기록하는 Logger를 변수로 생성합니다.
//별도의 Logger 객체의 선언이 없이도 Log4j 라이브러리와 설정이 존재한다면 바로 사용이 가능합니다.
@Log4j
public class MemberTests {

	@Setter(onMethod_ = @Autowired)
	private PasswordEncoder pwencoder;
	
	@Setter(onMethod_ = @Autowired)
	private DataSource ds;
	
	// Page654 JDBC SQL문 테스트
//	@Test
	public void testInsertMember() {
		// INSERT INTO tbl_member(USERID, USERPW, USERNAME) VALUES('jangnara', '1234', '장나라');
		String sql = "INSERT INTO tbl_member(USERID, USERPW, USERNAME) VALUES(?, ?, ?)";
		
		for (int i = 0; i < 100; i++) {  // i = 0부터 99까지 100개
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(2, pwencoder.encode("pw" + i));
				
				if (i < 80) {         // i = 0부터 79까지 80개는 user, 일반 사용자
					pstmt.setString(1, "user" + i);
					pstmt.setString(3, "일반사용자" + i);
				} else if (i < 90) {  // i = 80부터 89번까지 10개는 manager, 운영자
					pstmt.setString(1, "manager" + i);
					pstmt.setString(3, "운영자" + i);					
				} else {              // 90부터 99까지 10개는 admin, 관리자
					pstmt.setString(1, "admin" + i);
					pstmt.setString(3, "관리자" + i);
				}
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
				}
			}
		}  // end for문
	}  // end testInsertMember() 메서드
	
	// Page655, Page656 : 생성된 사용자에 권한 추가하기 테스트
//	@Test
	public void testInsertAuth() {
//		INSERT INTO tbl_member_auth(USERID, AUTH) VALUES('jangnara', 'ROLE_ADMIN');
		String sql = "INSERT INTO tbl_member_auth(USERID, AUTH) VALUES(?, ?)";
		
		for (int i = 0; i < 100; i++) {  // i = 0부터 99까지 100개
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				
				if (i < 80) {         // i = 0부터 79까지 80개는 user, 일반 사용자
					pstmt.setString(1, "user" + i);
					pstmt.setString(2, "ROLE_USER");
				} else if (i < 90) {  // i = 80부터 89번까지 10개는 manager, 운영자
					pstmt.setString(1, "manager" + i);
					pstmt.setString(2, "ROLE_MEMBER");					
				} else {              // 90부터 99까지 10개는 admin, 관리자
					pstmt.setString(1, "admin" + i);
					pstmt.setString(2, "ROLE_ADMIN");
				}
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
				}
			}			
		} // end for문
	} // end testInsertAuth() 메서드

}
