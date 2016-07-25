package org.spring.boot.api.business.test;

import org.spring.boot.api.base.BaseRequestBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@RequestMapping("/test")
	public BaseRequestBean getTestRequestBean(){
		return new BaseRequestBean("000000","success");
	}

}
