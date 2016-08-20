package cn.com.duiba.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import cn.com.duiba.entity.Users;
import cn.com.duiba.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userservice;

    @RequestMapping("/list/{id}")
    public String selectId(@PathVariable("id") int id,Model model){
        logger.info("从数据库读取Student集合");
         model.addAttribute("list",userservice.selectById(id));
         return "listall";
    }
    
    @RequestMapping("/insert")
    public String insert(){
        logger.info("往表中插入数据");
        
        for (int i = 1; i <600; i++) {
			Users u = new Users();
			u.setId(i);
			u.setName("小明"+i);
			u.setPassword(i+10+"mima");
			userservice.insert(u);
		}
        return "success";
    }  
    
    
    @RequestMapping("/delete")
    public String delete(){
        logger.info("逐条删除");
        
        for (int i = 1; i <1000; i++) {
			userservice.delete(i);
		}
        return "success";
    } 
    
    @RequestMapping("/list")
    public String listall(Model model){
        logger.info("从数据库读取Student集合");
        int num=userservice.cuontnum();
	    List<Users> list = userservice.getListPage(1);
	    model.addAttribute("currentpage",1);
        model.addAttribute("list", list);
        model.addAttribute("num", num/10+1);
        return "listall";
    }
    
    
  @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteByid(@PathVariable("id") int id,Model model, @RequestParam("curpage") String curpage){
        logger.info("逐条删除");
	    userservice.delete(id);
	    return "redirect:/user/listbyid/"+ curpage ;
    } 
    
    
    @RequestMapping("/listbyid/{pname}")
    public String Listpate(@PathVariable("pname") int pname,Model model){
        logger.info("分页展示");
        int num=userservice.cuontnum();
	    List<Users> list = userservice.getListPage(pname);
	    model.addAttribute("currentpage",pname);
        model.addAttribute("list", list);
        model.addAttribute("num", num/10+1);
        return "listall";
    } 
    
    
    
    /**
     * 保存修改数据
     * @param user
     * @param model
     * @return
     */
     
     @RequestMapping(value = "/update", method = RequestMethod.POST)
     public String bb(Users user, Model model) {
     	model.addAttribute("user", user);
     	userservice.updata(user);
         return "redirect:/user/list";
     }
     
     /**
      * 跳转修改页面
      * @param id
      * @param model
      * @return
      */
     
     @RequestMapping("/update/{id}")
     public String update(@PathVariable("id") int id , Model model){
         logger.info("更新数据");
         Users user = new Users();
         user = userservice.selectById(id);
         model.addAttribute("user",user);
         return "update";
     }      
}
