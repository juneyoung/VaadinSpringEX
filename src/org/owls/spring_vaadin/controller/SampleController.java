package org.owls.spring_vaadin.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/"})
public class SampleController {
	
	@RequestMapping(value={"", "index"})
	public ModelAndView index (){
		ModelAndView mav = new ModelAndView();
		Map<String, String> model = new HashMap<String, String>();
		model.put("msg", "Hello, spring-vaadin");
		mav.setViewName("index");
		mav.addObject(model);
		return mav;
	}
};