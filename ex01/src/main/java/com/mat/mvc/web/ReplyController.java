package com.mat.mvc.web;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mat.mvc.dao.ReplyVO;
import com.mat.mvc.service.ReplyService;

@Controller
@RequestMapping("/reply/*")
public class ReplyController {
	
	@Inject
	private ReplyService replyService;
	
	// 댓글 작성
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String postWirte(ReplyVO vo) throws Exception {
	    
	    replyService.write(vo);
	    
	    return "redirect:/board/view?bno=" + vo.getBno();
	}
	
	// 댓글 단일 조회 (수정 페이지)
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void getMofidy(@RequestParam("bno") int bno, @RequestParam("rno") int rno, Model model) throws Exception {
	    
	    ReplyVO vo = new ReplyVO();
	    vo.setBno(bno);
	    vo.setRno(rno);
	    
	    ReplyVO reply = replyService.replySelect(vo);
	         
	    model.addAttribute("reply", reply);
	}
	
	// 댓글 수정
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String postModify(ReplyVO vo) throws Exception {

	    replyService.modify(vo);

	    return "redirect:/board/view?bno=" + vo.getBno();
	}
	
	// 댓글 삭제
		@RequestMapping(value = "/delete", method = RequestMethod.GET)
		public String getDelete(@RequestParam("rno") int rno) throws Exception {

			replyService.delete(rno);

			return "redirect:/board/list";
		}

}
