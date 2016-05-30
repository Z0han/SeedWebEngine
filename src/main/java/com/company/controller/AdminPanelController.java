package com.company.controller;

import com.company.Service.PostService;
import com.company.Service.SettingsService;
import com.company.Service.UserService;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

/**
 * Created by User on 12.05.2016.
 */
@Controller
@RequestMapping("/swe-admin")
public class AdminPanelController {

    @Autowired
    SettingsService settingsService;

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/addpage", method = RequestMethod.POST)
    public String addPage(Model model) {
        return "addpage";
    }

    @RequestMapping(value = "/setting", method = RequestMethod.GET)
    public ModelAndView setting(){
        ModelAndView settingPage = new ModelAndView();
        settingPage.addObject("setting", settingsService.getSettings());
        settingPage.setViewName("settings");
        return settingPage;
    }

    @RequestMapping(value = "/addpost", method = RequestMethod.POST)
    public ModelAndView addPost(Principal principal,
                                @RequestParam(value = "title") String title,
                                @RequestParam(value = "text") String text,
                                HttpServletRequest request,
                                HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            postService.addPost(getUser(principal), title, text);
            return formationPage();
        } catch (Exception ex) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return null;
        }
    }

    @RequestMapping(value = "/updatesetting", method = RequestMethod.POST)
    public ModelAndView updateSetting(@RequestParam(value = "siteTitle") String title,
                                      @RequestParam(value = "sitePattern") String pattern,
                                      @RequestParam(value = "siteDescription") String description,
                                      HttpServletResponse response){
        try{
            settingsService.setSettings(title, checkSitePattern(pattern), description);
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

    private String checkSitePattern(String s){
        if(s.equals("Three Column")) return "threecolumn";
        else if(s.equals("Two Column with left bar")) return "twocolumn_left";
        else if(s.equals("Two Column with right bar")) return "twocolumn_right";
        else return "singlecolumn";
    }

    private User getUser(Principal principal){
        User user = userService.getUserByEmail(principal.getName());
        return user;
    }

}
