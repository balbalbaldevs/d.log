package com.dlog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MainController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setView(new RedirectView("/swagger-ui.html"));
		return mv;
    }

}
