package com.kh.mfw.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.mfw.member.model.dto.MemberDTO;
import com.kh.mfw.member.model.util.jdbcUtil;

public class MemberDAO {


	
	/**
	 * Login
	 * @param member ID, PW 필드가 Setting 된 DTO
	 * @return
	 */
	public MemberDTO login(Connection conn, MemberDTO member) {
		String sql= """
				SELECT MEMBER_ID, MEMBER_PW, MEMBER_NAME, EMAIL, ENROLL_DATE 
				FROM KH_MEMBER 
				WHERE MEMBER_ID=? AND MEMBER_PW=?
				""";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		MemberDTO result = null;
		
		try{
			conn = DriverManager.getConnection("jdbc:oracle:thin:@112.221.156.34:12345:XE","KH04_KDW","KH1234");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = new MemberDTO();
				result.setMemberId(rset.getString("MEMBER_ID"));
				result.setMemberPw(rset.getString("MEMBER_PW"));
				result.setMemberName(rset.getString("MEMBER_NAME"));
				result.setEmail(rset.getString("EMAIL"));
				result.setEnrollDate(rset.getDate("ENROLL_DATE"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			jdbcUtil.queryClose(pstmt, conn, rset);
			
		}
		
		
		return result;
	}
	public int checkId(Connection conn, String memberId) {
		String sql = """
				SELECT COUNT(*) 
				FROM KH_MEMBER 
				WHERE MEMBER_ID = ?
				""";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result=0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			rset.next();
			result = rset.getInt("COUNT(*)");
			/*
			 * case 1 : count(*) 그룹함수를 사용했을 때
			 * 					무조건 ResultSet이 1행이 존재함
			 * 					컬럼값이 0 / 1 인 것으로 조회결과 판별
			 * 
			rset.next();
			return rset.getInt("COUNT(*)");
			 */
			
			/*
			 * case 2 : MEMBER_ID 컬럼을 조회한 경우
			 * 
			 * 					
			 */
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.queryClose(pstmt, conn, rset);
		}
		
		return result;
	}
	
	public void signUp(Connection conn, MemberDTO member) {
		String sql = """
				INSERT INTO KH_MEMBER
				VALUES (?, ?, ?, ?, DEFAULT)
				""";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getEmail());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.updateClose(pstmt, conn);
		}
	}
}