package com.kh.mfw.member.model.service;

import java.sql.Connection;

import com.kh.mfw.member.model.dao.MemberDAO;
import com.kh.mfw.member.model.dto.MemberDTO;
import com.kh.mfw.member.model.util.jdbcUtil;

public class MemberService {

	public MemberDTO login(MemberDTO member) {
		
		// 서비스단에서 **유효성 검사(Validation)하기** (DB 가기전 ID,PW 값의 검증)  
		// => 단일책임 원칙을 위반해서 유효성검사하는 클래스로 보내버려야
//		if(member.getMemberId().length() > 10 || member.getMemberPw().length() > 20) {
//			return member=null;
//		}
		Connection conn = jdbcUtil.getConnection();
		MemberDTO loginMember = new MemberDAO().login(conn, member);
		return loginMember;
	}
	
	public int signUp(MemberDTO member) {
		Connection conn = jdbcUtil.getConnection();
		int result = new MemberDAO().checkId(conn, member.getMemberId());
		if (result > 0) {
			return result;
			}
		conn = jdbcUtil.getConnection();
		new MemberDAO().signUp(conn, member);
		return result;
		
	}
	
}