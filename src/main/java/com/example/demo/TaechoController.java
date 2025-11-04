package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TaechoController {
	@GetMapping("/Taecho")
	@ResponseBody
	
	public String index() {
		return "index";
	}
	
	@GetMapping("/")
    public String root() {
        return "redirect:/question/list";
    }
	
}
