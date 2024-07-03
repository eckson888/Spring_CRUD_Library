package com.example.logowanie.controller;

import com.example.logowanie.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminPanelController {
    @Autowired
    private BookService bookService;

    @RequestMapping(path = {"/adminpanel"}, method = RequestMethod.GET)
    public String adminpanel(Model model) {
        model.addAttribute("books", this.bookService.getAll());
        return "adminpanel";
    }

}
