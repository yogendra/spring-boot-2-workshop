package io.humourmind.cnspringcity.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class RefreshCityController {

	@Value("${hello.there: Hi there!}")
	private String refreshValue;

	@RequestMapping("/checkRefresh")
	public String checkRefresh(){
		return refreshValue;
	}


}
