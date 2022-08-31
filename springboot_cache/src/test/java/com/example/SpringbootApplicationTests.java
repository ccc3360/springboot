package com.example;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.TUser;
import com.example.enums.SexEnum;
import com.example.mapper.TUserMapper;
import com.example.testcase.domain.Usercase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//@SpringBootTest
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)//不启动web环境
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)//以配置端口启动web环境
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)//以随机端口启动web环境
//1、发送虚拟请求，先开启虚拟MVC的调用
@AutoConfigureMockMvc
//为测试用例添加事务，spring boot会对测试用例对应的事务提交操作进行回滚
@Transactional
//如果想要在测试用例中提交事务，设置value为false
@Rollback(value = true)
class SpringbootApplicationTests {
    @Value("${test.ipaddress}")
    private String msg;
    @Autowired
    private TUserMapper tUserMapper;


    @Test
    void testpropertier(){
        System.out.println(msg);
    }
    @Test
    void contextLoads() {
//        Page<TUser> page=new Page<>(1,3);
//        Page<TUser> page1 = tUserMapper.selectPage(page, null);
//        System.out.println(page1);

          TUser tUser=new TUser();
          tUser.setName("aaaaa");
          tUser.setSex(1);
          tUser.setEmail("dasdasd@qq.com");
          tUser.setAge(15);
        int insert = tUserMapper.insert(tUser);
        System.out.println(insert);

//        TUser tUser = tUserMapper.selectById(1);
//        System.out.println(tUser.getSex());
    }
    //2、注入虚拟MVC调用对象
    @Test
    void testWeb(@Autowired MockMvc mvc) throws Exception {
        //创建虚拟请求
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/demo");
        //执行对应的请求
        mvc.perform(builder);
    }

    //匹配响应执行状态
    @Test
    void testStatus(@Autowired MockMvc mvc) throws Exception {
        //创建虚拟请求
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/demo");
        //匹配失败的请求，/demo1不存在
//        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/demo1");
        //执行对应的请求
        ResultActions actions = mvc.perform(builder);

        //设定预期值，与真实值对比，成功测试通过，失败测试失败
//        定义本次调用的预期值
        StatusResultMatchers status= MockMvcResultMatchers.status();
//        定义本次调用成功：状态200
        ResultMatcher ok=status.isOk();
//        添加预期值到本次调用中，与真实值对比
        actions.andExpect(ok);
    }

    //匹配响应体
    @Test
    void testBody(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/demo");
        ResultActions actions = mvc.perform(builder);

        //匹配执行结果
//        定义执行结果匹配器
        ContentResultMatchers content = MockMvcResultMatchers.content();
//        定义预期结果
        ResultMatcher resultMatcher = content.string("spring boot2222");
//        添加预期值到本次调用中，与真实值对比
        actions.andExpect(resultMatcher);
    }

    //匹配响应体(Json)
    @Test
    void testJson(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/demo");
        ResultActions actions = mvc.perform(builder);

        //匹配执行结果
//        定义执行结果匹配器
        ContentResultMatchers content = MockMvcResultMatchers.content();
//        定义预期结果
        ResultMatcher resultMatcher = content.json("{\"id\":1,\"name\":\"spring boot\"}");
//        添加预期值到本次调用中，与真实值对比
        actions.andExpect(resultMatcher);
    }

    //匹配响应头
    @Test
    void testContentType(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/demo");
        ResultActions actions = mvc.perform(builder);

        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher contenType = header.string("Content-Type","text/plain;charset=UTF-87");//多个7
        actions.andExpect(contenType);

    }

    @Autowired
    private Usercase usercase;

    @Test
    public void testProperties(){
        System.out.println(usercase);
    }

}
