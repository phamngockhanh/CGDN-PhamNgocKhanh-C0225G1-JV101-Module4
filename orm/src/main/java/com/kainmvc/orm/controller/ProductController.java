package com.kainmvc.orm.controller;

import com.kainmvc.orm.entity.Product;
import com.kainmvc.orm.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final IProductService iProductService;

    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @GetMapping("")
    public String index(Model model) {
        List<Product> products = iProductService.findAll();
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("success", "Thêm thành công!!!");
        iProductService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("success", "Cập nhật thành công !!!");
        iProductService.update(product);
        return "redirect:/products";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id) {
        iProductService.remove(id);
        return "redirect:/products";
    }

    @GetMapping("/{id}/view")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/view";
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model) {
        List<Product> products = iProductService.search(keyword);
        model.addAttribute("products", products);
        model.addAttribute("keyword",keyword);
        return "index";
    }


}
