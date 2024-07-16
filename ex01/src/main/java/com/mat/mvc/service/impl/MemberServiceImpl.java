package com.mat.mvc.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mat.mvc.dao.MemberDAO;
import com.mat.mvc.dao.MemberVO;
import com.mat.mvc.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO dao;

	// 회원가입
	@Override
	public void register(MemberVO vo) throws Exception {
		dao.register(vo);
	}

	// 로그인
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		return dao.login(vo);
	}

	// 회원정보 수정

	@Override
	public void update(MemberVO vo) throws Exception {
		dao.update(vo);
	}

	// 회원 탈퇴
	@Override
	public void withdrawal(MemberVO vo) throws Exception {
		dao.withdrawal(vo);
	}

	// 아이디 확인
	@Override
	public MemberVO IDCheck(String userID) throws Exception {
		return dao.IDCheck(userID);
	}

}
