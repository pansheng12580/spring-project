package org.spring.boot.api.business.test;

import org.spring.boot.api.base.BaseRequestBean;
import org.spring.boot.api.util.LogUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/test")
	public BaseRequestBean getTestRequestBean(){
		LogUtil.i(this.getClass(), "/test");
//		jdbcTemplate.execute("INSERT INTO TEST VALUES(1, 'Hello');");
		return new BaseRequestBean("000000","success");
	}

}
