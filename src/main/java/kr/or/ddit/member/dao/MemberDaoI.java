package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.model.MemberVO;

public interface MemberDaoI {
	
	public MemberVO getMember(String userId);
	
//	public List<MemberVO> selectAllMember();
//	
//	public List<MemberVO> getPageMember(SqlSession sqlSession ,PageVO pageVo);
//	
//	public int getMemberTotalCnt(SqlSession sqlSession);
//	
//	public int insertMember(MemberVO memberVo);
//	
//	public int deleteMember(String userid);
//
//	public int updateMember(MemberVO memberVo);
//	
	
}
