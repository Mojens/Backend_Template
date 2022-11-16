package com.example.template.template.api;

import com.example.template.template.dto.CarResponse;
import com.example.template.template.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {
  CarService carService;

  public CarController(CarService carService) {
    this.carService = carService;
  }

  @GetMapping
  List<CarResponse> getAllCars(){
    return carService.getAllCars();
  }
}
