package com.mat.mvc.dao;

import java.util.List;

public interface ReplyDAO {
	
	public List<ReplyVO> readReply(int bno) throws Exception;
	
	// 댓글 조회
	public void write(ReplyVO vo) throws Exception;

	// 댓글 수정
	public void modify(ReplyVO vo) throws Exception;

	// 댓글 삭제
	public void delete(int rno) throws Exception;
	
	// 단일 댓글 조회
	public ReplyVO replySelect(ReplyVO vo) throws Exception;

}
