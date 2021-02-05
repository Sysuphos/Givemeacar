package com.example.Givemeacar.repository;

import com.example.Givemeacar.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//We extends our interface to the JpaRepository wich provide database implementation methods
//then we enter Jpa entity and the type of primaryKey
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
