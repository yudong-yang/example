package cn.com.duiba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/middle")
public class indexController {

    @RequestMapping("/test")
    public String notFound() {
        return "/fp_middle/duiba";
    }
    
    @RequestMapping("/500")
    public String ServerError() {
        return "/error/500";
    }
}