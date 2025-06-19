package com.kainmvc.hom_thu_dien_tu.controller;

import com.kainmvc.hom_thu_dien_tu.entity.Email;
import com.kainmvc.hom_thu_dien_tu.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmailController {
    @Autowired
    private IEmailService emailService;
    @GetMapping("/email/{id}")
    public String email(@PathVariable int id,Model model){
        Email email = emailService.findById(id);
        model.addAttribute("email",email);
        return "email";
    }

    @PostMapping("/email")
    public String update(@ModelAttribute("email") Email email) {
        emailService.update(email);
        return "redirect:/list-email";
    }

    @GetMapping("/list-email")
    public String emailList(Model model){
        List<Email> emailList = emailService.findAll();
        model.addAttribute("emailList",emailList);
        return "list_email";
    }

}
