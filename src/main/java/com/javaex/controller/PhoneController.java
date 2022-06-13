package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	@RequestMapping(value="list", method = {RequestMethod.GET,RequestMethod.POST})
	public String list(Model model) {
		System.out.println("PhoneController>list");
		
		PhoneDao phoneDao = new PhoneDao();
		
		List<PersonVo> pList = phoneDao.getPersonList();
		
		model.addAttribute("pList", pList);
		
		return "/WEB-INF/views/list.jsp";
	}

	/*
	 * // 등록
	 * 
	 * @RequestMapping(value = "write2", method = { RequestMethod.GET,
	 * RequestMethod.POST }) public String write2(@RequestParam("name") String
	 * name, @RequestParam("hp") String hp,
	 * 
	 * @RequestParam("company") String company) {
	 * System.out.println("PhoneController>write2");
	 * 
	 * // vo로 묶기 PersonVo personVo = new PersonVo(name, hp, company);
	 * System.out.println(personVo); // 다오로 저장 PhoneDao phoneDao = new PhoneDao();
	 * 
	 * phoneDao.personInsert(personVo);
	 * 
	 * return "redirect:/list"; }
	 */
	
	// 등록
	@RequestMapping(value = "write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController>write");
		
		//파라미터 꺼내기
		
		
		// vo로 묶기
		//PersonVo personVo = new PersonVo(name, hp, company);
		System.out.println(personVo);
		// 다오로 저장
		PhoneDao phoneDao = new PhoneDao();
		
		phoneDao.personInsert(personVo);
		
		return "redirect:/list";
	}

	// 등록메소드 폼
	@RequestMapping(value = "writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("PhoneController>writeForm");
		return "/WEB-INF/views/writeForm.jsp";
	}
	// 수정폼메소드
	@RequestMapping(value="updateForm",method = {RequestMethod.GET,RequestMethod.POST})
	public String modifyForm(Model model,@RequestParam("personId") int personId) {
		System.out.println("PhoneController>updateForm");
		
		PhoneDao pDao = new PhoneDao();
		
		PersonVo pVo = pDao.getPerson(personId);
		
		System.out.println(pVo);
		
		model.addAttribute("pVo",pVo);
		
		return "/WEB-INF/views/updateForm.jsp";
	}
	// 수정 메소드
	@RequestMapping(value="update",method= {RequestMethod.GET,RequestMethod.POST})
	public String update(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController>update");

		
		PhoneDao pDao = new PhoneDao();
		System.out.println(personVo);
		
		pDao.personUpdate(personVo);
		
		return "redirect:/list";
	}
	// 삭제메소드
	@RequestMapping(value="delete",method= {RequestMethod.GET,RequestMethod.POST})
	public String delete(@RequestParam("personId") int id) {
		System.out.println("PhoneController>delete");
		PhoneDao pDao = new PhoneDao();
		
		System.out.println(id);
		pDao.personDelete(id);
		
		
		return "redirect:/list";
	}
	// 리스트메소드

}
