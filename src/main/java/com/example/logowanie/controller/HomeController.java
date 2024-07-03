package com.example.logowanie.controller;

import com.example.logowanie.repository.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller

public class HomeController {
    @GetMapping({"/home"})
    public String home(){
        return "home";
    }
}