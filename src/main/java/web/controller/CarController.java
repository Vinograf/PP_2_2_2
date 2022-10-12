package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;
import web.service.CarServiceImp;

@Controller
@RequestMapping(value = "/cars")
public class CarController {
    @Autowired
    private final CarService carService = new CarServiceImp();

    @GetMapping()
    public String printCar (@RequestParam(value = "count", defaultValue = "5") int count , Model model) {
        model.addAttribute("cars", carService.printCar(count));

        return "cars";
    }
}