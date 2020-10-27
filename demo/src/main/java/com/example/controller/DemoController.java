package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.UserModel;

@Controller
public class DemoController {
	
	//öğrenilenler
	
	//springframework
		//@Controller
	
	//springframework.web
		//@RequestMapping(..)
		//@ModelAttribute
		//ModelAndView.setViewName(@Nullable String viewName)
		//ModelAndView.addObject(String attributeName, @Nullable Object attributeValue)
	
	//GET  http://127.0.0.1:8080/
	@RequestMapping(value= "/" ) //client belirtilen adrese request yaptığında bu kısım çalışır
	public String index() {
		return "index"; //severdan cliente, cevap olarak index.html dosyası renderlenecek
	}
	
	
	//POST http://127.0.0.1:8080/save
	@RequestMapping(value= "/save", method=RequestMethod.POST) //belirtilen adrese client veri gönderir post request ile
	public ModelAndView save(@ModelAttribute UserModel userModel) { //clientden @ModelAttribute sayesinde form'daki name value vasıtasıyla userModel datası alınır 
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user-data-save");  //cliente cevap olarak yeni gösterilecek view, user-data-save.html
		modelAndView.addObject("userObj", userModel); //clientden gönderilen userModel datasına  viewden userObj adıyla erişilir
		return modelAndView;
		
	}
}
