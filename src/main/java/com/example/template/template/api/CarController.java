package com.example.template.template.api;

import com.example.template.template.dto.CarResponse;
import com.example.template.template.service.CarService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@CrossOrigin
public class CarController {
  CarService carService;

  public CarController(CarService carService) {
    this.carService = carService;
  }

  @GetMapping
  List<CarResponse> getAllCars(Pageable p) {
    return carService.getAllCars(p);
  }

  @GetMapping("/all")
  List<CarResponse> getAllCars() {
    return carService.getAllCars();
  }

  @GetMapping("/filter")
  List<CarResponse> getAllCars(@RequestParam("column") String column, @RequestParam("value") String value, Pageable p) {
    return carService.filter(column,value,p);
  }

}
