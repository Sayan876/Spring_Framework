package com.jsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.dao.MerchantDao;
import com.jsp.dto.Merchant;

@Controller
public class MerchantController {
	@Autowired
  private MerchantDao mdao;
	
	@RequestMapping("/open-register")
	public ModelAndView openRegister(ModelAndView modelAndView) {
		modelAndView.setViewName("register");
		modelAndView.addObject("merch", new Merchant());
		return modelAndView;
	}
	
	@PostMapping(value="/save")
	@ResponseBody
	public String saveEmployee(@ModelAttribute(name="merch") Merchant merchant) {
		merchant = mdao.saveMerchant(merchant);
		return "<h2>Employee saved with id:"+merchant.getId()+"</h2>";
	}
	
	@RequestMapping("/open-update")
	public ModelAndView openupdate(ModelAndView modelAndView) {
		modelAndView.setViewName("update");
		modelAndView.addObject("merch", new Merchant());
		return modelAndView;
	}
	
	@PostMapping(value="/update")
	@ResponseBody
	public String updateMerchant(@ModelAttribute(name="merch") Merchant merchant) {
		merchant = mdao.updateMerchant(merchant);
		return "<h2>Employee saved with id:"+merchant.getId()+"</h2>";
	}
	
	@RequestMapping("/open-view")
	public String openView(@RequestParam String view) {
		return view;
	}
	
	@PostMapping(value="/verifybyphone")
	public ModelAndView verify(@RequestParam(name="phone") long phone, @RequestParam(name="password") String password) {
		
		Merchant mer = mdao.verify(phone, password);
		ModelAndView mv = new ModelAndView();
		if(mer!=null) {
			mv.setViewName("display");
			mv.addObject("mer",mer);
			return mv;
		}else {
			mv.setViewName("error");
			mv.addObject("message","invalid Phone number and password");
			return mv;
		}
	}
	
	@PostMapping(value="/verifybyemail")
	public ModelAndView verify(@RequestParam(name="email") String email, @RequestParam(name="password") String password) {
		
		Merchant mer = mdao.verify(email, password);
		ModelAndView mv = new ModelAndView();
		if(mer!=null) {
			mv.setViewName("display");
			mv.addObject("mer",mer);
			return mv;
		}else {
			mv.setViewName("error");
			mv.addObject("message","invalid Phone number and password");
			return mv;
		}
	}
}
