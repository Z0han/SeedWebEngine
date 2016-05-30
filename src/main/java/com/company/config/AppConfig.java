package com.company.config;

import com.company.DAO.Impl.SettingsDAOImpl;
import com.company.DAO.PostDAO;
import com.company.DAO.Impl.PostDaoImpl;
import com.company.DAO.SettingsDAO;
import com.company.DAO.UserDAO;
import com.company.DAO.Impl.UserDAOImpl;
import com.company.Service.Impl.PostServiceImpl;
import com.company.Service.Impl.SettingsServiceImpl;
import com.company.Service.Impl.UserDetailsServiceImpl;
import com.company.Service.PostService;
import com.company.Service.SettingsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by User on 12.05.2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.company")
public class AppConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public EntityManager entityManager(){
        EntityManagerFactory enf = Persistence.createEntityManagerFactory("SeedWebEngine");
        return enf.createEntityManager();
    }

    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        // указываем где будут лежать наши веб-страницы
        resolver.setPrefix("/WEB-INF/pages/");
        // формат View который мы будем использовать
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        resolver.setOrder(1);
        return resolver;
    }

    @Bean
    public PostDAO postDAO(){
        return new PostDaoImpl();
    }

    @Bean
    public UserDAO userDAO(){
        return new UserDAOImpl();
    }

    @Bean
    public SettingsDAO settingsDAO(){
        return new SettingsDAOImpl();
    }

    @Bean
    public PostService postService() {
        return new PostServiceImpl();
    }

    @Bean
    public SettingsService settingsService(){
        return new SettingsServiceImpl();
    }

    @Bean
    public UserDetailsService getUserDetailsService(){
        return new UserDetailsServiceImpl();
    }

    @Bean
    public CommonsMultipartResolver multipartResolver(){
        return new CommonsMultipartResolver();
    }
}
