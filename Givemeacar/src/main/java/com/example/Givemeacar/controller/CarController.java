package com.example.Givemeacar.controller;

import com.example.Givemeacar.model.Car;
import com.example.Givemeacar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class CarController {

    @Autowired // find what need to be injected
    //myInterface myBean
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }
    //get all cars
    @GetMapping("/cars")
    public List<Car> getALLCar(){
        return carService.getALLCar();
    }
    //create car
    @PostMapping("/cars")
    public void createCar(@RequestBody Car car) {
        carService.createCar(car);
    }
    // get car by id
    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }
    //update car
    @PutMapping("/cars/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car carDetails){

        return carService.updateCar(id, carDetails);
   }

    //delete car
    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCar(@PathVariable Long id){

       return carService.deleteCar(id);

    }


}
