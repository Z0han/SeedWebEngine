package com.company.controller;

import com.company.Service.PostService;
import com.company.Service.SettingsService;
import com.company.Service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by User on 12.05.2016.
 */
@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private SettingsService settingsService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("index", "post", postService.list());
    }

    @RequestMapping(value = "/addpage", method = RequestMethod.POST)
    public String addPage(Model model) {
        return "addpage";
    }

    @RequestMapping(value = "/addpost", method = RequestMethod.POST)
    public ModelAndView addPost(@RequestParam(value = "autorId") int authorId,
                                @RequestParam(value = "title") String title,
                                @RequestParam(value = "text") String text,
                                HttpServletRequest request,
                                HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            postService.addPost(authorId, title, text);
            return new ModelAndView("index", "post", postService.list());
        } catch (Exception ex) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return null;
        }
    }

    @RequestMapping("/delete")
    public ModelAndView delete(@RequestParam(value="id") int id) {
        postService.removePost(id);
        return new ModelAndView("index", "post", postService.list());
    }

    @RequestMapping(value = "/registration")
    public String registration(Model model){
        return "registration";
    }

    @RequestMapping(value = "adduser", method = RequestMethod.POST)
    public ModelAndView addUser(@RequestParam(value = "email") String email,
                                @RequestParam(value = "password") String pass,
                                HttpServletRequest request,
                                HttpServletResponse response){
        try{
        String md5pass = new DigestUtils().md2Hex(pass);
        userService.addUser(email,md5pass);
        return new ModelAndView("index", "post", postService.list());
        }catch (Exception ex){
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return null;
        }
    }

    @RequestMapping(value = "/settings", method = RequestMethod.POST)
    public SettingsService settings(){
        return settingsService;
    }
}
