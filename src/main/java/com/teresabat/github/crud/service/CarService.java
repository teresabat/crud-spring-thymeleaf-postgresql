package com.teresabat.github.crud.service;

import com.teresabat.github.crud.models.Car;
import com.teresabat.github.crud.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService
{

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars()
    {
        return carRepository.findAll();
    }

    public Car getCarById(Long id)
    {
        return carRepository.findById(id).orElse(null);
    }

    public Car saveCar(Car car)
    {
        return carRepository.save(car);
    }

    public void deleteCar(Long id)
    {
        carRepository.deleteById(id);
    }
}
