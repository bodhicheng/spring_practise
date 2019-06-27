package com.wisely.spring_practise.web.ch4_3;

import com.wisely.spring_practise.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller //1
@RequestMapping("/anno") //2
public class DemoAnnoController {
    @RequestMapping(produces = "text/plain;charset=UTF-8") //3
    public @ResponseBody String index(HttpServletRequest request) { //4
        return "url:" + request.getRequestURI() + " can access";
    }

    @RequestMapping(value = "/pathvar/{str}", produces = "text/plain;charset=UTF-8") //5
    public @ResponseBody String demoPathVar(@PathVariable String str, HttpServletRequest request) {
        return "url:" + request.getRequestURI() + " can access,str: " + str;
    }

    @RequestMapping(value = "/requestParam", produces = "text/plain;charset=UTF-8") //6
    public @ResponseBody String pathRequestParam(Long id, HttpServletRequest request) {
        return "url:" + request.getRequestURI() + " can access,id: " + id;
    }

    @RequestMapping(value = "/obj", produces = "application/json;charset=UTF-8") //7
    @ResponseBody //8
    private String passObj(DemoObj obj, HttpServletRequest request) {
        return "url" + request.getRequestURI() + "can access, obj id: " + obj.getId() + " obj name:" + obj.getName();
    }

    @RequestMapping(value = { "/name1", "/name2"}, produces = "text/plain;charset=UTF-8") //9
    private @ResponseBody  String  remove(HttpServletRequest request) {
        return "url" + request.getRequestURI() + "can access";
    }
}
