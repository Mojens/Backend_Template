package com.example.template.template.service;

import com.example.template.template.dto.CarResponse;
import com.example.template.template.entity.Car;
import com.example.template.template.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

  CarRepository carRepository;

  public CarService(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  public List<CarResponse> getAllCars(){
    List<Car> carList = carRepository.findAll();
    //.collect(Collectors.toList()); Den her tager i mod null værdier, hvorimod .toList() tager ikke i mod null værdier
    return carList.stream().map(c -> new CarResponse(c,true)).toList();
  }

}
