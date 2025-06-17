package com.kainmvc.ung_dung_tu_dien.controller;

import com.kainmvc.ung_dung_tu_dien.service.ITranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TranslateController {
    @Autowired
    private ITranslateService translateService;

    @GetMapping("/translate")

    public String translate(){
        return "translate";
    }

    @PostMapping("/translate")

    public String translate(@RequestParam("vietnamese") String vietnamese, Model model){
        String english = translateService.findByKey(vietnamese);
        if(english==null){
            String wrong = "Không có từ này trong từ điển";
            model.addAttribute("wrong",wrong);
        }
        model.addAttribute("english",english);
        model.addAttribute("vietnamese",vietnamese);
        return "translate";
    }
}
