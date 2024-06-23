package org.example.controller;
import org.example.model.Product;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("")
    public String showList(Model model) {
        if (productService.showList().isEmpty()) {
            model.addAttribute("product", "ko có sản phẩm nào");
        } else {
            model.addAttribute("product", productService.showList());
        }
        return "/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("product", new Product());
        return "/add";
    }

    @PostMapping("/add")
    public String add(Product product) {
        productService.add(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        if (productService.findById(id) == null) {
            model.addAttribute("product", "ko có sản phẩm này");
            return "redirect:/product";
        } else {
            model.addAttribute("product", productService.findById(id));
            return "/delete";
        }

    }
    @PostMapping("/delete")
    public String delete (Product product) {
        productService.remove(product.getId());
        return "redirect:/product";
    }
    @GetMapping("/{id}/edit")
    public String showFormUpdate(@PathVariable int id, Model model){
        if(productService.findById(id)==null){
            model.addAttribute("product","ko có sản phẩm này");
            return "redirect:/product";
        }
        model.addAttribute("product",productService.findById(id));
        return "/edit";
    }
    @PostMapping("/edit")
    public String update(Product product){
        productService.update(product);
        return "redirect:/product";
    }

}
