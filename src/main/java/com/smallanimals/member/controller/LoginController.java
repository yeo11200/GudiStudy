package com.smallanimals.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	
	 @RequestMapping("/memberInfo/login/loginPage") 
	 public String page() throws Exception {
	 System.out.println("��Ʈ�ѷ��Դϴ�.");
	 return "memberInfo/login/loginPage"; }
	 
	 @RequestMapping(value="/access_denied_page")
	    public String accessDeniedPage() throws Exception {
	        return "/access_denied_page";
	 }

	 
}
