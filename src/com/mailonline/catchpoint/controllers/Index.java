package com.mailonline.catchpoint.controllers;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openqa.selenium.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mailonline.catchpoint.Schedulers.Scheduler;

@Controller
public class Index {

	@Autowired
	Scheduler sc;

	
	@RequestMapping(value = { "/" }, method = { RequestMethod.GET }  , produces = "text/html")
	public @ResponseBody String HTML( HttpServletRequest request,  HttpServletResponse response) {
		StringBuilder htmlbuilder = new StringBuilder();
		//htmlbuilder.append("<script src=\"https://code.jquery.com/jquery-3.3.1.min.js\" integrity=\"sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=\" crossorigin=\"anonymous\" ></script>\n");
		
		
		htmlbuilder.append("<iframe width=0 height=0 src=\"consent\"> </iframe>");
		
		htmlbuilder.append(sc.getHtml());
	
	
		
		Set<Cookie> cookies = sc.getCookies();
		cookies.forEach(cookie -> {
			String name = cookie.getName();
			String value = cookie.getValue();
			System.out.println(name);
			response.addCookie(new javax.servlet.http.Cookie(name,value));
			
		});
		
		return htmlbuilder.toString();
	}
	
	
	
	@RequestMapping(value = { "/consent" }, method = { RequestMethod.GET })
	public String consent( HttpServletRequest request,  HttpServletResponse response) {
		response.setHeader("origin", "cmp.dmgmediaprivacy.co.uk");
		response.setHeader("location", "cmp.dmgmediaprivacy.co.uk");
		response.setHeader("host", "cmp.dmgmediaprivacy.co.uk");
		response.addCookie(new javax.servlet.http.Cookie("euconsent","BOOn927OOn927ABABBENAj-AAAAXN7_______9______9uz_Gv_r_f__3nW0739P3A_7_O3_7m_-zzV48_lrQR1CPAE"));
		response.addCookie(new javax.servlet.http.Cookie("uuid","2b16cc34-6195-4417-bd65-cd39a99cff7a"));
		return "redirect:https://cmp.dmgmediaprivacy.co.uk";
	}
	
}
