package com.teresabat.github.crud.controller;

import com.teresabat.github.crud.models.Car;
import com.teresabat.github.crud.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FrontendController {

    @Autowired
    private CarService carService;

    @GetMapping("/")
    public String index(Model model)
    {
        model.addAttribute("car", carService.getAllCars());
        return "index";
    }

    @GetMapping("/form")
    public String showForm(Model model)
    {
        model.addAttribute("car", new Car());
        return "form";
    }

    @GetMapping("/form/{id}")
    public String form(@PathVariable Long id, Model model)
    {
        model.addAttribute("car", carService.getCarById(id));
        return "form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Car car)
    {
        carService.saveCar(car);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id)
    {
        carService.deleteCar(id);
        return "redirect:/";
    }
}
