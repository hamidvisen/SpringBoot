package com.learning.SpringBootLearning1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
//	@RequestMapping("home")	
////	@ResponseBody
//	public String Home(HttpServletRequest req, HttpServletResponse res) {
//		
//		HttpSession session = req.getSession();
//		
//		String name = req.getParameter("name");
//		session.setAttribute("name", name);
//		System.out.println("hi heelo");
//		return "home";
//	}
	
//	Requestparam : name naam k parameter se My Name ki value lenge
	
//	@RequestMapping("home")	
//	public String Home(@RequestParam("name") String myName, HttpSession session) {
//		
//		
//	
//		session.setAttribute("name", myName);
//		System.out.println("hi heelo");
//		return "home";
//	}
	
//	ModelAndView class ko sikh rhe h
//	@RequestMapping("home")	
//	public ModelAndView Home(@RequestParam("name") String myName) {
//		
//		
//	ModelAndView mv = new ModelAndView();
//	
//	mv.addObject("name", myName);
//	mv.setViewName("home");
//	
//	return mv;
//		
//	
//	}
	
//	multiple params send krte h class object k through
	
	@RequestMapping("home")	
	public ModelAndView Home(Alien alien) {
		
		
	ModelAndView mv = new ModelAndView();
	
	mv.addObject("obj", alien);
	mv.setViewName("home");
	
	return mv;
		
	
	}


}
