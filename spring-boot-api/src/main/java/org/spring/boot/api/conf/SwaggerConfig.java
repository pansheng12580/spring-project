package org.spring.boot.api.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

/**
 * swagger配置文件
 * @author pantheon
 * @since 2016/8/12
 */
@Configuration
@EnableSwagger
public class SwaggerConfig {
	
	private SpringSwaggerConfig springSwaggerConfig;
	
	@Autowired
	public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
		this.springSwaggerConfig = springSwaggerConfig;
	}
	
	@Bean
	public SwaggerSpringMvcPlugin customImplementation(){
		//设置api暴露接口的文档
		String[] includePatterns = {"/test.*","/users.*","/cities.*","/countries.*"};
		return  new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
		.apiInfo(new ApiInfo("后台API"
				, "this is a simple api doc."
				, "http://pansheng.picp.net/api-docs"
				, null
				, null
				, null))
//		.pathProvider(new SwaggerPathProvider() {
//			@Override
//			protected String getDocumentationPath() {
//				return "/restapi";
//			}
//			
//			@Override
//			protected String applicationPath() {
//				return "/restapi";
//			}
//		})
		.useDefaultResponseMessages(false)
		.apiVersion("1.0.0")
		.includePatterns(includePatterns);
	}

}
