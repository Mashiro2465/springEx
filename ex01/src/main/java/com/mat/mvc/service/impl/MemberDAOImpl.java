package com.mat.mvc.service.impl;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.mat.mvc.dao.MemberDAO;
import com.mat.mvc.dao.MemberVO;

@Service
public class MemberDAOImpl implements MemberDAO {

	//마이 바티스
		@Inject
		private SqlSession sql;
		
		//매퍼
		private static String namespace = "com.board.mappers.member";
		
		//회원가입 
		@Override
		public void register(MemberVO vo) throws Exception{
			sql.insert(namespace + ".register", vo);
			
		}
		
		//로그인
		@Override
		public MemberVO login(MemberVO vo) throws Exception{
			return sql.selectOne(namespace + ".loginBcrypt", vo);
		}
		
		//회원정보 수정
		@Override
		public void update(MemberVO vo) throws Exception{
			sql.update(namespace + ".update", vo);
		}
		
		// 회원 탈퇴
		@Override
		public void withdrawal(MemberVO vo) throws Exception{
			sql.delete(namespace +".withdrawal", vo);
		}
		
		// 아이디 확인
		@Override
		public MemberVO IDCheck(String userID) throws Exception{
			return sql.selectOne(namespace + ".IDCheck", userID);
		}
}
