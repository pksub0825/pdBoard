package com.mysite2.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

import com.mysite2.pd.model.PdDAO;
import com.mysite2.pd.model.PdDTO;
import com.mysite2.pd.model.PdService;

@Controller
@RequestMapping("/pd/pdInsert.do")
public class PdInsertController {
	private PdService pdService;
	public PdInsertController() {
		System.out.println("PdInsertController()생성");
	}
	public void setPdService(PdService pdService) {
		System.out.println("setpdService()호출");
		this.pdService = pdService;
	}
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView insertGet(){
		System.out.println("get : insertGet()");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/pd/pdWrite");
		//WEB-INF/view /pd/pdWrite .jsp
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView insertPost(@ModelAttribute("pdDto") PdDTO pdDto ){
		//파라미터값?, 사용자가 입력한 값은?
		System.out.println("POST : insertPost(), pdDto :"+pdDto);
		//DB처리작업
		//PdDAO dao=new PdDAO();
		//dao.insertPd(pdBean);
		try {
			int n = pdService.insertPd(pdDto);
			System.out.println("상품 등록 성공, n="+n);
		} catch (SQLException e) {
			System.out.println("상품 등록 실패!");
			e.printStackTrace();
		}
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:/pd/pdList.do");
		return mav;
	}
}//class 
