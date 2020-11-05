package kr.or.ddit.member.dao;


import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;

@Repository("memberDao")
public class MemberDao implements MemberDaoI{

	@Override
	public MemberVO getMember(String userId) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		MemberVO memberVO = sqlSession.selectOne("member.getMember",userId);
		sqlSession.close();
		
		return memberVO;
	}

	@Override
	public List<MemberVO> selectAllMember() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<MemberVO> memberList = sqlSession.selectList("member.selectAllMember");
		
		sqlSession.close();
		return memberList;
	}

	@Override
	public List<MemberVO> getPageMember(SqlSession sqlSession,PageVO pageVO) {
		return sqlSession.selectList("member.getPageMember",pageVO);
	}

	@Override
	public int getMemberTotalCnt(SqlSession sqlSession) {
		return sqlSession.selectOne("member.getMemberTotalCnt");
	}

	@Override
	public int insertMember(MemberVO memberVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int insertCnt = 0;
		try {
			insertCnt = sqlSession.insert("member.insertMember",memberVo);
		}catch (Exception e) {
			
		}
		
		if(insertCnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return insertCnt;
	}

	@Override
	public int deleteMember(String userid) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int deleteCnt = sqlSession.delete("member.deleteMember",userid);
		if(deleteCnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return deleteCnt;
	}

	@Override
	public int updateMember(MemberVO memberVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int updateCnt = sqlSession.update("member.updateMember",memberVo);
		
		if(updateCnt==1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return updateCnt;
	}

}
