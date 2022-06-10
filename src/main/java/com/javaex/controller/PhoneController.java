package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
public class PhoneController {

	// 필드

	// 생성자

	// 메소드 gs

	// 메소드 일반
	@RequestMapping(value="/test", method = {RequestMethod.GET,RequestMethod.POST})
	public String test() {
		
		System.out.println("PhoneController>test");
		//다오
		
		
		return "/WEB-INF/views/test.jsp";
	}
	
	//등록
	@RequestMapping(value="/write", method = {RequestMethod.GET,RequestMethod.POST} )
	public String write(@RequestParam("name") String name,@RequestParam("hp") String hp,@RequestParam("company") String company) {
		System.out.println("PhoneController>write");
		
		//vo로 묶기
		PersonVo personVo = new PersonVo(name,hp,company);
		System.out.println(personVo);
		//다오로 저장
		PhoneDao phoneDao = new PhoneDao();
		
		phoneDao.personInsert(personVo);
		
		return "";
	}
	// 등록메소드 폼
	@RequestMapping(value="writeForm", method = {RequestMethod.GET,RequestMethod.POST})
	public String writeForm() {
		System.out.println("PhoneController>writeForm");
		return "/WEB-INF/views/writeForm.jsp";
	}
	// 수정폼메소드
	
	// 삭제메소드
	
	// 리스트메소드

}
