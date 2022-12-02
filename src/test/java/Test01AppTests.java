//import com.springboot.live_comm.App;
//import com.springboot.live_comm.controller.HelloController;
//import com.springboot.live_comm.services.UserService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
////引用的spring-test依赖要与spring_web中的spring-web一致
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {UserService.class, HelloController.class})
//public class Test01AppTests {
//    @Autowired
//    UserService userService;
//    @Autowired
//    HelloController controller;
//    @Autowired
//    WebApplicationContext wac;
//    MockMvc mockMvc;
//
//
//    @Before
//    public void before() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
//    }
//
//    @Test
//    public void test1() {
//        MvcResult mvcResult = mockMvc.perform(
//                MockMvcRequestBuilders.get("hello").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("a.name","三国")
//        );
//    }
//
//    @Test
//    public void contextLoads() {
//        userService.getUserById(1);
//    }
//}
