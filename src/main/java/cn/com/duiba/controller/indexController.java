package cn.com.duiba.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.duiba.PostRepository.UserRepository;
import cn.com.duiba.entity.Users;

@Controller
@RequestMapping("/middle")
public class indexController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userrepository;
    
    @RequestMapping("/test")
    public String notFound() {
        return "/fp_middle/duiba";
    }
    
    @RequestMapping("/500")
    public String ServerError() {
        return "/error/500";
    }
    
    @RequestMapping("/ajax")
    public String testajax() {
        return "ajax";
    }
    
    
    @RequestMapping("/formajax")
    public String formajax() {
        return "formajax";
    }
    
    
    
    @RequestMapping("/data")
    @ResponseBody
    public String data(HttpServletRequest request ) {
    	String FirstName=request.getParameter("FirstName");
    	String LastName=request.getParameter("LastName");
        return FirstName+"::==::"+LastName;
    }
    
    
    @RequestMapping("/findbyid")
    @ResponseBody
    public List<Users> selectall(){
        logger.info("从数据库读取Student集合");
        List<Users> users =  userrepository.findAll();  
        return users;
    }
    
    @RequestMapping("/adduser")
    @ResponseBody
    public String adduser(){
        logger.info("往数据库中插入数据");
        List<Users> us = new ArrayList<Users>();
        for (int i = 0; i < 10000; i++) {
        	Users u1 = new Users("张晓明", "zhangxm123");
        	Users u2 = new Users("王小虎", "wangxh132");
        	Users u3 = new Users("李晓红", "lixh213");
        	Users u4 = new Users("赵晓东", "zhaoxd231");
        	Users u5 = new Users("周晓霞", "zhouxx321");
        	Users u6 = new Users("吴晓红", "wuxh312");
        	Users u7 = new Users("郑新民", "zhengxm145");
        	Users u8 = new Users("钱晓东", "qianxd154");
        	us.add(u1);us.add(u2);us.add(u3);us.add(u4);
        	us.add(u5);us.add(u6);us.add(u7);us.add(u8);
		}
        userrepository.save(us);     
        return "save success";
    }
    
    @RequestMapping("/findname")
    @ResponseBody
    public Set<String> selectname(){
        logger.info("从数据库读取Student集合");
        List<Users> users =  userrepository.findAll();
        Set<String> names = new HashSet<String>();
        for (int i = 0; i < users.size(); i++) {
        	names.add(users.get(i).getName());
        }	
        return names;
    }
    
    
    @RequestMapping("/findlist")
    @ResponseBody
    public List<String> selectlist(){
        logger.info("从数据库读取Student集合");
        List<Users> users =  userrepository.findAll();
        List<String> names = new ArrayList<String>();
        for (int i = 0; i < users.size(); i++) {
        	names.add(users.get(i).getName());
        }	
        return names;
    }
    
    @RequestMapping("/findAllname")
    public String findtname(Model model){
        logger.info("从数据库读取Student集合");
        List<String> names = userrepository.findname();
        model.addAttribute("names", names);
        return "ajax";
    }
    
    
}