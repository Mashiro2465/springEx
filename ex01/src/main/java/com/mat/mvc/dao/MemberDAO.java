package com.mat.mvc.dao;

public interface MemberDAO {
	// 회원 가입
	public void register(MemberVO vo) throws Exception;

	// 로그인
	public MemberVO login(MemberVO vo) throws Exception;

	// 회원정보 수정
	public void update(MemberVO vo) throws Exception;

	// 회원탈퇴
	public void withdrawal(MemberVO vo) throws Exception;

	// 아이디 확인
	public MemberVO IDCheck(String userID) throws Exception;


}
