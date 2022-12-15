package com.jarod.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CookiesController {
    @RequestMapping(value = "/hello",method = {RequestMethod.GET})
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @RequestMapping(value = "/c",method = {RequestMethod.GET})
    public String checkcookies(HttpServletRequest request, HttpServletResponse response){
        System.out.println("22222");
        Cookie[] cookies= request.getCookies();
        for (Cookie c:cookies){
            c.setMaxAge(0);
            response.addCookie(c);
            System.out.println("Delete cookies successful");
        }
        return "signin";
    }
    @RequestMapping(value = "index",method = {RequestMethod.GET})
    public String indexpage(){
        return "index";
    }

    @RequestMapping(value = "signinpage",method = {RequestMethod.GET})
    public String signinpage(){
        return "signin";
    }

    @RequestMapping(value = "movie",method = {RequestMethod.GET})
    public String moviepage(){
        return "movies";
    }

    @RequestMapping(value = "tvshow",method = {RequestMethod.GET})
    public String tvshow(){
        return "tv-shows";
    }

    @RequestMapping(value = "tips",method = {RequestMethod.GET})
    public String tips(){
        return "tips";
    }

    @RequestMapping(value = "moviesingle",method = {RequestMethod.GET})
    public String moviesinglepage(){
        return "movie-single";
    }

    @RequestMapping(value = "collection",method = {RequestMethod.GET})
    public String collectionpage(){
        return "collection";
    }

    @RequestMapping(value = "display",method = {RequestMethod.GET})
    public String displaypage(){
        return "display";
    }

    @RequestMapping(value = "signup_page",method = {RequestMethod.GET})
    public String signup(){
        return "signup";
    }

}


