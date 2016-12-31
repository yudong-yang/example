package cn.com.duiba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping("/404")
    public String notFound() {
        return "error/404";
    }
    
    @RequestMapping("/500")
    public String ServerError() {
        return "error/500";
    }
}