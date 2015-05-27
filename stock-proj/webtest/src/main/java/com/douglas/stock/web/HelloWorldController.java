package com.douglas.stock.web;

/**
 * Author: wgz
 * Date:   15/4/18
 * Time:   上午10:39
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller
public class HelloWorldController {

    @RequestMapping("/hello")
    public ModelAndView handleRequest() {
        //1、收集参数、验证参数
        //2、绑定参数到命令对象
        //3、将命令对象传入业务对象进行业务处理
        //4、选择下一个页面
        ModelAndView mv = new ModelAndView();
        //添加模型数据 可以是任意的POJO对象
        mv.addObject("message", "Hello World!");
        //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
        mv.setViewName("hello");
        return mv;
    }


    @RequestMapping("/ping")
    public @ResponseBody String ping() {
        return "Alive";
    }
}

