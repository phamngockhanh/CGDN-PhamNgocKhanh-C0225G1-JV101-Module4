package com.kainmvc.gia_vi_sandwich.controller;

import com.kainmvc.gia_vi_sandwich.entity.Sandwich;
import com.kainmvc.gia_vi_sandwich.service.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CondimentsController {

    @Autowired
    private ISandwichService sandwichService ;
    @GetMapping("/condiments")
    public String list(Model model){
        List<Sandwich> sandwichList = sandwichService.listSandwich();
        model.addAttribute("sandwichList",sandwichList);
        return "sandwich_list";
    }
    @RequestMapping("/save")
    public String save (@RequestParam("condiment") String [] condiment,@RequestParam("name") String name){
        String condiments = String.join(", ",condiment);
        sandwichService.add(new Sandwich(name,condiments));
        return "redirect:/condiments";
    }
}
