package com.swan.springbootdev.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api")
public class SwaggerDemoController {
	
	@GetMapping("board")
	public Map<String, String> boardSearch(){
		Map<String, String> res = new HashMap<String, String>();
		res.put("id", "1");
		res.put("title", "Swagger 사용법");
		res.put("content", "Swagger 사용법 내용입니다.");
		res.put("tag", "Swagger");
		return res;
	}
	
}
