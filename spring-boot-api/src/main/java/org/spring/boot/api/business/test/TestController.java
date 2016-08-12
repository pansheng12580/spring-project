package org.spring.boot.api.business.test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.spring.boot.api.base.BaseRequestBean;
import org.spring.boot.api.business.test.bean.CityJson;
import org.spring.boot.api.business.test.bean.CityJson_area;
import org.spring.boot.api.business.test.bean.CityJson_city;
import org.spring.boot.api.business.test.bean.OtherCityJson;
import org.spring.boot.api.business.test.bean.OtherCityJson_area;
import org.spring.boot.api.business.test.bean.OtherCityJson_city;
import org.spring.boot.api.util.LogUtil;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
@Api(value = "test-api", description = "测试test-api", position = 1)
@RestController
@RequestMapping("/test")
public class TestController {
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	
	@ApiOperation(value = "测试",notes = "测试接口")
	@RequestMapping(value="/test",method=RequestMethod.GET
		,produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public BaseRequestBean getTestRequestBean(){
		LogUtil.i(this.getClass(), "/test");
//		jdbcTemplate.execute("INSERT INTO TEST VALUES(1, 'Hello');");
		return new BaseRequestBean("000000","success");
	}
	
	@ApiOperation(value="测试json数据格式转换",httpMethod="GET",notes="基于第三方json格式错乱，制定一个转换url",produces="application/json;charset=UTF-8")
	@RequestMapping(value ="/testJson",method=RequestMethod.GET)
	public BaseRequestBean getTestJson(){
		LogUtil.i(this.getClass(), "===开始测试数据");
//		jdbcTemplate.execute("INSERT INTO TEST VALUES(1, 'Hello');");
		try {
//			ClassPathResource cResource = new ClassPathResource("city.json");
//			Reader in = new FileReader("city.json");
//			String temp = FileCopyUtils.copyToString(new InputStreamReader(cResource.getInputStream(), "UTF-8"));
			String temp = FileCopyUtils.copyToString(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("city.json")));
			//开始解析参数
			CityJson json = JSON.parseObject(temp,CityJson.class);
			//转换参数
			OtherCityJson otherCityJson = TestController.getOtherCityJson(json);
			
			System.out.println("===解析文件参数成功");
			System.out.println(JSON.toJSONString(otherCityJson,true));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new BaseRequestBean("000000","success");
	}
	
	public static OtherCityJson getOtherCityJson(CityJson cityJson){
		OtherCityJson otherCityJson = new OtherCityJson();
		if(cityJson != null){
			if(cityJson.getBean() != null && cityJson.getBean().size() > 0){
				//开始解析cityjson
				List<OtherCityJson_city> tempList = new ArrayList<>();
				for(int i=0;i<cityJson.getBean().size();i++){
					tempList.add(TestController.getOtherCityJson_city(cityJson.getBean().get(i)));
				}
				otherCityJson.setBean(tempList);
			}
		}
		return otherCityJson;
	}
	
	
	public static OtherCityJson_area getOtherCityJson_area(CityJson_area CityJson_area){
		OtherCityJson_area target = new OtherCityJson_area();
		target.setName(CityJson_area.getCt());
		
		List<String> strList = new ArrayList<>();
		strList.add(CityJson_area.getCv());//地区代码
		
 		target.setArea(strList);
		return target;
	}
	
	public static OtherCityJson_city getOtherCityJson_city(CityJson_city CityJson_city){
		OtherCityJson_city target = new OtherCityJson_city();
		target.setName(CityJson_city.getP());
		
		List<OtherCityJson_area> list = new ArrayList<>();
		for(CityJson_area area:CityJson_city.getC()){
			list.add(TestController.getOtherCityJson_area(area));
		}
		target.setCity(list);
		
		return target;
	}
	

}
