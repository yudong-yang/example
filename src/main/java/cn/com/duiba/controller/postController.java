package cn.com.duiba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.duiba.PostRepository.PostRepository;

@Controller
@RequestMapping("/post")
public class postController {

	@Autowired
    private PostRepository postRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        return "post";
    }
}
