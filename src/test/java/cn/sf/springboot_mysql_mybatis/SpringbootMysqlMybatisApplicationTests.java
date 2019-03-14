package cn.sf.springboot_mysql_mybatis;

import cn.sf.springboot_mysql_mybatis.controller.HelloController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMysqlMybatisApplicationTests {

    private MockMvc mvc;

    @Autowired
    private HelloController helloController;
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(helloController).build();
    }

    @Test
    public void contextLoads() throws Exception{
        mvc.perform(get("/index").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello visitor")));
    }

    @Test
    public void testUserController() throws Exception {
        RequestBuilder builder = null;
        builder = get("/users/").param("name","");
        mvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("No record")));
/*
        builder = get("/users/")
                .param("jy");
*/
    }

}
