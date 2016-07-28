package cn.com.duiba.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cn.com.duiba.entity.Student;
import cn.com.duiba.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stu")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @RequestMapping("/list")
    public String ListStudent(Model model){
        logger.info("从数据库读取Student集合");
        List<Student> list = studentService.getList();
        model.addAttribute("list", list);
        return "liststu";
    }
    
    @RequestMapping("/insert")
    public String insert(){
        logger.info("往表中插入数据");
        
        for (int i = 1; i <100; i++) {
        	Student stu = new Student();
        	stu.setName("小明"+i);
        	stu.setAge(28);
        	stu.setBirthday(studentService.getdate("1988-09-08"));
        	stu.setChina(98.3);
        	stu.setMath(80.6);
        	stu.setEnglish(88.6);
        	stu.setHistory(78.6);
			studentService.insert(stu);
		}
        return "redirect:/stu/list";
        //return "success";
    }   
  
}
