package com.apap.tutorial7.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.apap.tutorial7.rest.CarDetail;
import com.apap.tutorial7.rest.Setting;

@RestController
@RequestMapping("/model")
public class ModelController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping()
	private CarDetail getModels(@RequestParam("factory") String factory) throws Exception {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		String path = Setting.carQueryUrl + "?cmd=getModels&make=" + factory + "&year=" + year;
		System.out.println(path);
		return restTemplate.getForObject(path, CarDetail.class);
	}
	
}
