package com.smallanimals.member.controller;


import java.security.Principal;


import java.net.URLDecoder;


import java.util.Locale;







import org.mariadb.jdbc.internal.logging.Logger;
import org.mariadb.jdbc.internal.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smallanimals.member.service.MemberService;
import com.smallanimals.member.vo.MemberVO;

@Controller
public class LoginController {
	@Autowired
	private MemberService memberService;
	
	

	Logger logger = LoggerFactory.getLogger(getClass());

	
	@RequestMapping(value = "../main")
	public String main() throws Exception {
		return "../main";
	}
	
	@RequestMapping("/memberInfo/login/loginPage") 
	 public String page() throws Exception {
		 return "memberInfo/login/loginPage";
	 
	 }
	 
	 @RequestMapping(value="/access_denied_page")
	    public String accessDeniedPage() throws Exception {
	        return "/access_denied_page";
	 }

	 @RequestMapping(value = "/memberInfo/join/register1", method = {RequestMethod.GET, RequestMethod.POST})

		public String register1(Locale locale, Model model) {
			logger.info("Welcome home! The client locale is {}.", locale);
			
			
			
			return "memberInfo/join/register1";
		}
	@RequestMapping(value = "/memberInfo/join/register2", method = {RequestMethod.GET, RequestMethod.POST})
		public String register2(Locale locale, Model model) {
			logger.info("Welcome home! The client locale is {}.", locale);
			
			
			return "memberInfo/join/register2";
		}

	
	@RequestMapping("/registerMember")
	public String insertMaember(MemberVO vo) {
		System.out.println("vo:" + vo);
		memberService.registerMember(vo);
		return "redirect:/";

	}

	@RequestMapping(value = "/memberInfo/join/successlogin", method = { RequestMethod.GET, RequestMethod.POST })
	public String successlogin(Model model) {
		return "memberInfo/join/successlogin";
	}
	
	// 아이디 중복체크
	@ResponseBody
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	public int idCheck(@RequestBody String userId) throws Exception {
		String user_id = URLDecoder.decode(userId, "UTF-8");
		logger.info("post idCheck");
		System.out.println("아이디 중복체크 입니다 확인 해 주세요");
		
		MemberVO idCheck = memberService.idCheck(user_id);
		
		int result = 0;
		 if(idCheck !=null) {
			 result =1;
		 }
		return result;
	}
	
	@RequestMapping(value = "/memberInfo/modify/Member_Modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String Member_Modify(Principal principal, Model model) {
		String user_id = currentUserName(principal);
		System.out.println("아이디 " + user_id);
		MemberVO membervo = memberService.memberInfo(user_id);
		System.out.println(membervo.getUserId());
		
		model.addAttribute("memberInfo",membervo);
		System.out.println("memberInfo.userNickname"+membervo.getUserNickname());
		return "memberInfo/modify/Member_Modify";
	}

	@RequestMapping(value = "/memberInfo/modify/changepwd", method = { RequestMethod.GET, RequestMethod.POST })
	public String changepwd(Principal principal, Model model) {
		String userId = currentUserName(principal);
		MemberVO membervo = memberService.memberInfo(userId);
		System.out.println(membervo.getUserId());
		
		model.addAttribute("memberInfo",membervo);

		return "memberInfo/modify/changepwd";
	}
	//회원 정보 수정
	@RequestMapping(value = "/memberUpdate")
	public String memberUpdate(@ModelAttribute MemberVO vo) {
		
		memberService.memberUpdate(vo);
		System.out.println("LoginController 구간" + vo);
		return "redirect:/main/main";
	}
	//로그인 컨트롤러는 이렇게 작성했구요
	

	@GetMapping("/username")
	@ResponseBody
	public String currentUserName(Principal principal) {
		return principal.getName();
	}
}

