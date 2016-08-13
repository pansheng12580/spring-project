/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.spring.boot.api.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author pantheon
 * @since 2016/8/12 22:25
 */
//@Configuration
//@EnableWebMvc   屏蔽掉webMVCconfigurerAdapter,让springboot自动管理
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	/*
	 * pringBoot默认已经将classpath:/META-INF/resources/和classpath:/META-INF/resources/webjars/映射
     * 所以该方法不需要重写，如果在SpringMVC中，可能需要重写定义（我没有尝试）
     * 重写该方法需要 extends WebMvcConfigurerAdapter
	 */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/wiki/**").addResourceLocations("classpath:/wiki/");
        //swagger api文档映射静态资源
//        registry.addResourceHandler("/api/**").addResourceLocations("classpath:/static/swagger-ui/");
    }
    /**
     * 允许跨域请求
     */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");
	}

//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.enableContentNegotiation(new MappingJackson2JsonView());
//        registry.freeMarker().cache(false);
//    }
//
//    @Bean
//    public FreeMarkerConfigurer freeMarkerConfigurer() {
//        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
//        configurer.setTemplateLoaderPath("/WEB-INF/");
//        return configurer;
//    }
}
