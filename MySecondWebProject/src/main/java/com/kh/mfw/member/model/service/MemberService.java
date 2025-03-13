package com.kh.mfw.member.model.service;

import org.apache.ibatis.session.SqlSession;

import static com.kh.mfw.common.Template.getSqlSession;
import com.kh.mfw.member.model.dto.MemberDTO;

public class MemberService {
	
	public MemberDTO login(MemberDTO member) {
		
		// JDBCUtil클래스로부터
		// static Method로 구현해놓은
		// getConnection 메서드를 호출하여
		// Connection객체를 반환받았음
		SqlSession sqlSession = getSqlSession();
		
		return null;
	}
}