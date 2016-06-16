package com.company.controller;

import com.company.Service.*;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    private SettingsService settingsService;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SinglePageService singlePageService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView adminPanel(){
        return new ModelAndView("/admin/index","setting", settingsService.getSettings());

    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView adminHomePage = new ModelAndView();
        adminHomePage.addObject("posts",postService.list().size());
        adminHomePage.addObject("categoriessize", categoryService.getCategoryList().size());
        adminHomePage.addObject("pages", singlePageService.list().size());
        adminHomePage.setViewName("/admin/home");
        return adminHomePage;
    }

    /* Posts administration */

    @RequestMapping(value = "/addpostpage", method = RequestMethod.GET)
    public ModelAndView addPostPage() {
        ModelAndView page = new ModelAndView();
        page.addObject("post", postService.list());
        page.addObject("categories", categoryService.getCategoryList());
        page.setViewName("/admin/addpostpage");
        return page;
    }

    @RequestMapping(value = "/addpost", method = RequestMethod.POST)
    public ModelAndView addPost(Principal principal,
                                @RequestParam(value = "title") String title,
                                @RequestParam(value = "text") String text,
                                @RequestParam(value = "categoryId") int categoryId,
                                HttpServletRequest request,
                                HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            postService.addPost(getUser(principal), title, text, categoryId);
            return formationPage();
        } catch (Exception ex) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return null;
        }
    }

    /* Site Settings administration */

    @RequestMapping(value = "/setting", method = RequestMethod.GET)
    public ModelAndView setting(){
        ModelAndView settingPage = new ModelAndView();
        settingPage.addObject("setting", settingsService.getSettings());
        settingPage.setViewName("/admin/settings");
        return settingPage;
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


    /* Categories administration */

    @RequestMapping(value = "/categorysettings", method = RequestMethod.GET)
    public ModelAndView categorySettings(){
        ModelAndView categoryPage = new ModelAndView();
        categoryPage.addObject("categories", categoryService.getCategoryList());
        categoryPage.addObject("settings", settingsService.getSettings());
        categoryPage.setViewName("/admin/categorysettings");
        return categoryPage;
    }

    @RequestMapping(value = "/addcategory", method = RequestMethod.POST)
    public ModelAndView createCategory(@RequestParam(value = "categoryName") String categoryName){
        categoryService.addCategory(categoryName);
        return categorySettings();
    }

    @RequestMapping(value = "/categorydelete", method = RequestMethod.GET)
    public ModelAndView deleteCategory(@RequestParam(value = "id") int id){
        categoryService.removeCategory(id);
        return categorySettings();
    }

    /* Single page administration */

    @RequestMapping(value = "/addpage", method = RequestMethod.GET)
    public ModelAndView addPage(){
        return new ModelAndView("/admin/addSinglePage");
    }

    @RequestMapping(value = "/createpage", method = RequestMethod.POST)
    public ModelAndView createPage(@RequestParam(value = "title")String title,
                                   @RequestParam(value = "urlName")String urlName,
                                   @RequestParam(value = "content")String content,
                                   HttpServletResponse response){
        try {
            singlePageService.addPage(title, urlName,content);
            return addPage();
        }catch (Exception ex){
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return null;
        }
    }


    /* accessory methods */

    private ModelAndView formationPage(){
        ModelAndView page = new ModelAndView();
        page.addObject("post", postService.list());
        page.addObject("setting", settingsService.getSettings());
        page.setViewName("index");
        return page;
    }

    private String checkSitePattern(String s){
        switch (s){
            case ("Three Column"):{
                return "threecolumn";
            }
            case ("Two Column with left bar"):{
                return "twocolumn_left";
            }
            case ("Two Column with right bar"):{
                return "twocolumn_right";
            }
            default: return "singlecolumn";
        }
    }

    private User getUser(Principal principal){
        return userService.getUserByEmail(principal.getName());
    }

}
