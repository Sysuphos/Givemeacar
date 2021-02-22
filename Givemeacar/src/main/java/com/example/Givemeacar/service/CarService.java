package com.example.Givemeacar.service;

import com.example.Givemeacar.exception.ResourceNotFoundException;
import com.example.Givemeacar.model.Car;
import com.example.Givemeacar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CarService {
    @Autowired // find what need to be injected
    //myInterface myBean
    private CarRepository carRepository;

    //get all cars
    public List<Car> getALLCar(){
        return carRepository.findAll();
    }
    //create car
    public Car createCar(Car car) {
        return carRepository.save(car);
    }
    // get car by id
    public ResponseEntity <Car> getCarById(Long id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Car not exist with id : " + id));

        return ResponseEntity.ok(car);
    }
    //update car
    public ResponseEntity<Car> updateCar(Long id, Car carDetails){
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car not exist with id : " + id));

        car.setEtat(carDetails.getEtat());
        car.setAvailable(carDetails.getAvailable());
        car.setKilometrage(carDetails.getKilometrage());
        car.setModel(carDetails.getModel());
        car.setAgency(carDetails.getAgency());
        car.setMarque(carDetails.getMarque());

        Car updatedCar = carRepository.save(car);
        return ResponseEntity.ok(updatedCar);
    }
    //delete car
    public ResponseEntity<Map<String, Boolean>> deleteCar(Long id){
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car not exist with id : " + id));

        carRepository.delete(car);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);

    }
}
