package com.mat.mvc.web;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mat.mvc.dao.MemberVO;
import com.mat.mvc.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Inject
	MemberService service;

	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;

	// get
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void getRegister() throws Exception {
		logger.info("get register");
	}

	// post
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postRegister(MemberVO vo) throws Exception {
		logger.info("post register");

		String inputPass = vo.getUserPW();
		String pass = bcryptPasswordEncoder.encode(inputPass);
		vo.setUserPW(pass);

		service.register(vo);

		return "redirect:/";

	}

	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		logger.info("post login");

		HttpSession session = req.getSession();

		MemberVO login = service.login(vo);

		boolean passMatch = bcryptPasswordEncoder.matches(vo.getUserPW(), login.getUserPW());

		if (login != null && passMatch) {

			session.setAttribute("member", login);

		} else {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
		}

		return "redirect:/index";
	}

	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		logger.info("get logout");

		session.invalidate();

		return "redirect:/";
	}

	// 회원정보 수정 get
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void getUpdate() throws Exception {
		logger.info("get update");
	}

	// 회원정보 수정 post
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String postUpdate(HttpSession session, MemberVO vo) throws Exception {
		logger.info("post Update");

		service.update(vo);

		session.invalidate();

		return "redirect:/";
	}

	// 회원 탈퇴 get
	@RequestMapping(value = "/withdrawal", method = RequestMethod.GET)
	public void getWithdrawal() throws Exception {
		logger.info("get withdrawal");
	}

	// 회원 탈퇴 post
	@RequestMapping(value = "/withdrawal", method = RequestMethod.POST)
	public String postWithdrawal(HttpSession session, MemberVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("post withdrawal");

		MemberVO member = (MemberVO) session.getAttribute("member");

		String oldPW = member.getUserPW();
		String newPW = vo.getUserPW();
		
		boolean passMatch = bcryptPasswordEncoder.matches(newPW, oldPW);
		System.out.println(passMatch);
		
		if (passMatch) {
			service.withdrawal(vo);
			
			logout(session);
			return "redirect:/";
		} else {

		rttr.addFlashAttribute("msg", false);
		return "redirect:/member/withdrawal";

		}
	}

	// 회원 확인
	@ResponseBody
	@RequestMapping(value = "/IDCheck", method = RequestMethod.POST, produces = "application/json")
	public int postIDCheck(HttpServletRequest req) throws Exception {
		logger.info("post IDCheck");

		String userID = req.getParameter("userID");
		MemberVO IDCheck = service.IDCheck(userID);

		int result = 0;

		if (IDCheck != null) {
			result = 1;

		}
		return result;
	}

}
