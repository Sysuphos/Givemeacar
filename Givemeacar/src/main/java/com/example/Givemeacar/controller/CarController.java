package com.example.Givemeacar.controller;

import com.example.Givemeacar.model.Car;
import com.example.Givemeacar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CarController {

    @Autowired // find what need to be injected
    //myInterface myBean
    private CarRepository carRepository;

    //get all cars
    @GetMapping("/cars")
    public List<Car> getALLCar(){
        return carRepository.findAll();
    }

    //create car
    @PostMapping("/cars")
    public Car createCar(@RequestBody Car car) {
        return carRepository.save(car);
    }
}
