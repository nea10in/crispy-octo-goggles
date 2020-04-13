package com.neha.MyFirstSpringBootProject.rest.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neha.MyFirstSpringBootProject.rest.models.PostRequest;
import com.neha.MyFirstSpringBootProject.rest.models.PostResponse;
import com.neha.MyFirstSpringBootProject.rest.models.SampleResponse;

@RestController
public class WebController {
	
	@RequestMapping("/sample")
	public SampleResponse Sample(@RequestParam(value = "name",
	defaultValue = "Robot") String name) {
		SampleResponse response = new SampleResponse();
		response.setId(1);
		
		if(name.contains("Sana"))
		{
			response.setStr("Invalid@#$%#");
		}
		else
		{
			
			response.setStr("Your name is "+name);
			
		}
		return response;
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public PostResponse Test(@RequestBody PostRequest inputPayload) {
		PostResponse response = new PostResponse();
		response.setId(inputPayload.getI()*100);
		response.setMessage("Hello " + inputPayload.getName());
		response.setExtra("Some text");
		return response;
	}
	
	
}
