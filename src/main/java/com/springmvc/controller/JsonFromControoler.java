package com.springmvc.controller;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springmvc.bean.JsonInfo;
import com.springmvc.bean.JsonInfoType;
import com.springmvc.dao.JsonInfoDao;
import com.springmvc.json.JsonInfoParser;
import com.springmvc.util.AjaxUtils;

@Controller
@RequestMapping("jsonform")
public class JsonFromControoler {
	
	@Autowired
	private JsonInfoParser jsoninfoParser;
	
	@Autowired
	private JsonInfoDao  jsoninfoDao;
	
	@ModelAttribute("ajaxRequest")
	public void ajaxAttibute(WebRequest request,Model model){
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}
	
	@ModelAttribute("jsoninfo")
	public JsonInfo getJsoninfo(){
		return new JsonInfo();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public void jsonform(){
		//ApplicationContext context=new ClassPathXmlApplicationContext(new String[]{"spring.xml"});
		//SqlSessionFactory sqlSessionFactory=context.getBean("sqlSessionFactory",SqlSessionFactory.class);
	}

	@RequestMapping(method=RequestMethod.POST)
	public String submit(JsonInfo jsoninfo,Model model,RedirectAttributes redirectAttr){
		ArrayList<JsonInfo> list=null;
		try{
		   // list=jsoninfoParser.readJsonInfo();
		}catch(Exception e){
			model.addAttribute("message", e.getMessage());
			return null;
		}
		
		jsoninfoDao.insertJsonInfo(jsoninfo);
		
		if(list==null){
			list=new ArrayList<JsonInfo>();
		}
		list.add(jsoninfo);
		JsonInfoType type=new JsonInfoType();
		type.setJsoninfos(list);
		try{
		   jsoninfoParser.writeJsonInfo(type);
		}catch(Exception e){
			model.addAttribute("message", e.getMessage());
			return null;
		}
		redirectAttr.addAttribute("message", "输入成功！");
		return "redirect:/index";
	}
}
