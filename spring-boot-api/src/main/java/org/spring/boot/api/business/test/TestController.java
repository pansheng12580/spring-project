package org.spring.boot.api.business.test;

import java.util.Properties;

import org.spring.boot.api.base.BaseRequestBean;
import org.spring.boot.api.util.LogUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@RequestMapping("/test")
	public BaseRequestBean getTestRequestBean(){
		LogUtil.i(this.getClass(), "/test");
		return new BaseRequestBean("000000","success");
	}

}
