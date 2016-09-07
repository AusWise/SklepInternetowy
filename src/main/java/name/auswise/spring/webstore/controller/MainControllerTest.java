package name.auswise.spring.webstore.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import name.auswise.spring.webstore.AppConfig;
import name.auswise.spring.webstore.model.User;
import name.auswise.spring.webstore.service.ProductService;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:/WEB-INF/web.xml"}, classes={AppConfig.class})
@WebAppConfiguration
public class MainControllerTest {
	
	private MockMvc mockMvc;
	
//	@Autowired
//	ProductService productService;
	
	@Test
	public void findAll_ShouldAddProductsToModelAndRenderProductsView() throws Exception {
		assertNull(mockMvc);
	}
}
