package com.mat.mvc.service;

import java.util.List;

import com.mat.mvc.dao.ReplyVO;

public interface ReplyService {
	
	//댓글 조회
	public List<ReplyVO> readReply(int bno) throws Exception;
	
	// 댓글 작성
	public void write(ReplyVO vo) throws Exception;

	// 댓글 수정
	public void modify(ReplyVO vo) throws Exception;

	// 댓글 삭제
	public void delete(int rno) throws Exception;
	
	// 단일 댓글 조회
	public ReplyVO replySelect(ReplyVO vo) throws Exception;

}
