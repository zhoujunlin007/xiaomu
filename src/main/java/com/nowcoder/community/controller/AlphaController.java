package com.nowcoder.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @RequestMapping("/hello")
    @ResponseBody  // 不加注解就返回HTML
    public String sayHello() {
        return "Hello Spring Boot!";
    }

    @RequestMapping("http")
    public void http(HttpServletRequest request, HttpServletResponse response) {
        // 获取请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {  // 遍历
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + ": " + value);
        }
        System.out.println(request.getParameter("code"));  // 获取相应的参数

        // 返回响应数据
        response.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter writer = response.getWriter();
            writer.write("<h1>牛客网</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // /students?current=1&limit=20
    @RequestMapping(path = "/students", method = RequestMethod.GET)
    @ResponseBody
    /*public String getStudents(int current, int limit){
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }*/
    public String getStudents(
//                                   对应参数名        可以无该参数       默认参数值
                @RequestParam(name = "current", required = false, defaultValue = "1") int current,
                @RequestParam(name = "limit", required = false, defaultValue = "10") int limit) {
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }

    // /students/123
    @RequestMapping(path = "/students/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathParam("id") int id) {
        System.out.println(id);

        return "a student";
    }

    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name, int age) {
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    // 响应HTML数据
    @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    public ModelAndView getTeacher() {
        ModelAndView modelAndView = new ModelAndView();
        // 需要几个就添加几个
        modelAndView.addObject("name", "小沐");
        modelAndView.addObject("age", 30);

        modelAndView.setViewName("/demo/view");  // 对应模板的html
        return modelAndView;
    }

    @RequestMapping(path = "/school", method = RequestMethod.GET)
    public String getSchool(Model model) {
        model.addAttribute("name", "小沐大学");
        model.addAttribute("age", 21);
        return "/demo/view";
    }

    // 响应JSON数据（异步请求）
    // Java对象  ->  JSON字符串  ->  JS对象
    @RequestMapping(path = "/emp", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getEmp() {
        Map<String, Object> emp = new HashMap<>();
        emp.put("name", "小沐");
        emp.put("age", 21);
        emp.put("salary", 8000);
        return emp;
    }

    @RequestMapping(path = "/emps", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> getEmps() {
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> emp = new HashMap<>();
        emp.put("name", "小沐");
        emp.put("age", 21);
        emp.put("salary", 8000);

        Map<String, Object> emp2 = new HashMap<>();
        emp2.put("name", "小沐2");
        emp2.put("age", 21);
        emp2.put("salary", 9000);

        Map<String, Object> emp3 = new HashMap<>();
        emp3.put("name", "小沐3");
        emp3.put("age", 21);
        emp3.put("salary", 10000);

        list.add(emp);
        list.add(emp2);
        list.add(emp3);

        return list;
    }
}
