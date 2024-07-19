package com.numbers.web.app.controllers;

import com.numbers.web.app.models.NumberModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class NumberController {

    private NumberModel numberModel = new NumberModel();

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/addNumbers")
    public String addNumbers(@RequestParam("numbers") String numbers, Model model) {
        String[] numberArray = numbers.split(",");
        for (String numberStr : numberArray) {
            try {
                int number = Integer.parseInt(numberStr.trim());
                numberModel.addNumber(number);
            } catch (NumberFormatException e) {
                // Ignora valores que no sean números válidos
            }
        }
        return "redirect:/result";
    }

    @GetMapping("/result")
    public String result(Model model) {
        model.addAttribute("evenNumbers", numberModel.getEvenNumbers());
        return "result";
    }

    @PostMapping("/sumEvenNumbers")
    public String sumEvenNumbers(Model model) {
        model.addAttribute("evenNumbers", numberModel.getEvenNumbers());
        model.addAttribute("sum", numberModel.sumEvenNumbers());
        return "result";
    }
}
