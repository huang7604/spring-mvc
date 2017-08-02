package com.springmvc.controller;

import javax.mail.Address;
import javax.mail.internet.InternetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springmvc.bean.UserInfo;
import com.springmvc.server.MailSend;
import com.springmvc.util.AjaxUtils;

@Controller
@RequestMapping("/userform")
public class LoginController {

	@Autowired
	private MailSend mailSend;
	
	@ModelAttribute("ajaxRequest")
	public void ajaxAttibute(WebRequest request,Model model){
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}
	
	@ModelAttribute("userinfo")
	public UserInfo getUserinfo(){
		return new UserInfo();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public void userform(){
		//return "userform";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(UserInfo userinfo,Model model,RedirectAttributes redirectAttr){
		try{
			loginAndSend(userinfo);
		}catch(Exception e){
			model.addAttribute("message","登录失败"+e.getMessage());
			return null;
		}
		
	    String message="登录成功!";
	    redirectAttr.addAttribute("message", message);
	    
		return "redirect:/index";
	}
	
	private void loginAndSend(UserInfo userinfo) throws Exception{
		String subject="登录-spring-mvc成功！";
		String text="欢迎光临！";
		Address[] toAddress={new InternetAddress(userinfo.getEmail())};
		mailSend.sendMail(toAddress, subject, text);
	}
	
}
