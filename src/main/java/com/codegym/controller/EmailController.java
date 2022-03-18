package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/thang")
public class EmailController {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static Pattern pattern;
    private Matcher matcher;
    public EmailController(){
        pattern = Pattern.compile(EMAIL_REGEX);
    }
    @GetMapping
        private String moveToWelcome(){
        return "index";
    }

    @PostMapping
    private ModelAndView validateEmail(String email){

        String email_in = email;
        boolean isValid = this.validate(email_in);
        if (!isValid){
            ModelAndView modelAndView = new ModelAndView("index");
            modelAndView.addObject("message","Email is invalid!");
            return modelAndView;


        }else{
            ModelAndView modelAndView = new ModelAndView("success");
            return modelAndView;
        }
    }
    private boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();

    }


}
