package com.kainmvc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ExchangController {
    @GetMapping("/exchange")
    public String printMoney(Model model){
        return "exchange";
    }
@PostMapping("/exchange")
public String exchange(@RequestParam("usd") int usd, Model model){
    int vnd = usd * 25000;
    model.addAttribute("vnd",vnd);
    model.addAttribute("usd",usd);
    return "exchange";
}
}
