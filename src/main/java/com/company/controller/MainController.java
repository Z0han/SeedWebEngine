package com.company.controller;

import com.company.Service.CategoryService;
import com.company.Service.PostService;
import com.company.Service.SettingsService;
import com.company.Service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private SettingsService settingsService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        return formationPage();
    }

    @RequestMapping("/delete")
    public ModelAndView delete(@RequestParam(value="id") int id) {
        postService.removePost(id);
        return formationPage();
    }

    @RequestMapping(value = "/registration")
    public String registration(){
        return "registration";
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public ModelAndView addUser(@RequestParam(value = "email") String email,
                                @RequestParam(value = "password") String pass,
                                @RequestParam(value = "nick") String nick,
                                HttpServletRequest request,
                                HttpServletResponse response){
        try{
            String md5pass = new DigestUtils().md5Hex(pass);
            userService.addUser(email,md5pass, nick);
            return formationPage();
        }catch (Exception ex){
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return null;
        }
    }


    private ModelAndView formationPage(){
        ModelAndView page = new ModelAndView();
        page.addObject("post", postService.list());
        page.addObject("setting", settingsService.getSettings());
        page.setViewName("index");
        return page;
    }
}
