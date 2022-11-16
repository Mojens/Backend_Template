package com.example.template.template.service;

import com.example.template.template.dto.CarResponse;
import com.example.template.template.entity.Car;
import com.example.template.template.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

  CarRepository carRepository;

  public CarService(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  public List<CarResponse> getAllCars(){
    List<Car> carList = carRepository.findAll();
    return carList.stream().map(c -> new CarResponse(c)).toList();
  }

}
