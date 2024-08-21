package com.teresabat.github.crud.controller;


import com.teresabat.github.crud.models.Car;
import com.teresabat.github.crud.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public List<Car> findAll()
    {
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public Car findById(@PathVariable Long id)
    {
        return carService.getCarById(id);
    }

    @PostMapping
    public Car createCar(@RequestBody Car car)
    {
        return carService.saveCar(car);
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable Long id, @RequestBody Car car)
    {
        Car carAtual = carService.getCarById(id);
        if (carAtual != null)
        {
            carAtual.setMarca(car.getMarca());
            carAtual.setModelo(car.getModelo());
            carAtual.setAno(car.getAno());
            return carService.saveCar(carAtual);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id)
    {
        carService.deleteCar(id);
    }
}
