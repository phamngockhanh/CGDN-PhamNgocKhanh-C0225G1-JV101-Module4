package com.kainmvc.may_tinh_ca_nhan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CalculatorController {

    @RequestMapping("/calculator")
    public String calculator(){
        return "calculator";
    }

    @PostMapping("/calculator")
    public String calculatorResult(@RequestParam(defaultValue = "0") int num1, @RequestParam(defaultValue = "0") int num2, @RequestParam String cal, RedirectAttributes attributes){
        Integer result  = null;
        String mess = null ;
        switch (cal){
            case "Addition(+)":
                result = num1 + num2;
                break;
            case "Subtraction(-)":
                result = num1 - num2;
                break;
            case "Multiplication(X)":
                result = num1 * num2;
                break;
            case "Division(/)":
                if(num2==0){
                    mess = "Không có phép chia cho 0";
                    break;
                }else{
                    result = num1 / num2;
                    break;
                }
            default:
                mess = "Vui lòng nhập số";
                break;
        }
        attributes.addFlashAttribute("result",result);
        attributes.addFlashAttribute("mess",mess);
        attributes.addFlashAttribute("num1",num1);
        attributes.addFlashAttribute("num2",num2);
        return  "redirect:/calculator";
    }
}
