package com.example.sandwich;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichController {

    @RequestMapping("/")
    public String showForm() {
        return "sandwich";
    }

    @RequestMapping("/save")
    public String save(@RequestParam(value = "condiment", required = false) String[] condiment, Model model) {
        model.addAttribute("selectedCondiments", condiment);
        return "result";
    }


//    @RequestMapping("/")
//    public ModelAndView showForm() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/WEB-INF/views/sandwich.jsp"); // Chỉ rõ đường dẫn
//        return modelAndView;
//    }
//
//    @RequestMapping("/save")
//    public ModelAndView save(String[] condiment) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/WEB-INF/views/result.jsp"); // Chỉ rõ đường dẫn
//        modelAndView.addObject("selectedCondiments", condiment);
//        return modelAndView;
//    }
}
