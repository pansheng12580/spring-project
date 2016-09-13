package org.spring.boot.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.boot.api.business.user.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=Application.class)
@WebAppConfiguration
public class ApplicationTest {
	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext context;
    @Autowired
    private CountryService countryService;
    
    @Before
    public void beforeConfig(){
    	mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
	
	@Test
	public void testCountry() throws Exception{
//		List<Country> list =  countryService.getAll(new Country());
//		Assert.assertNull(list);
		
		mockMvc.perform(get("/countries")
				.accept(MediaType.APPLICATION_JSON_UTF8)
				
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				);
	}
	

}
