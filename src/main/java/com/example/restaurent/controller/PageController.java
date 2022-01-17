package com.example.restaurent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pages")
public class PageController {

  @GetMapping("/main")
  public ModelAndView main(){
    return new ModelAndView("/html/main"); // "/" 디폴트 경로가 resources/templates이다
  }
}

