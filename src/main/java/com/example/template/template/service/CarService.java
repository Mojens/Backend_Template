package com.example.template.template.service;

import com.example.template.template.dto.CarResponse;
import com.example.template.template.entity.Car;
import com.example.template.template.repository.CarRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

  CarRepository carRepository;

  public CarService(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  public List<CarResponse> getAllCars() {
    List<Car> carList = carRepository.findAll();
    //.collect(Collectors.toList()); Den her tager i mod null værdier, hvorimod .toList() tager ikke i mod null værdier
    return carList.stream().map(c -> new CarResponse(c, true)).toList();
  }

  public List<CarResponse> getAllCars(Pageable pageable) {
    Page<Car> carPage = carRepository.findAll(pageable);
    //.collect(Collectors.toList()); Den her tager i mod null værdier, hvorimod .toList() tager ikke i mod null værdier
    return carPage.stream().map(c -> new CarResponse(c, true)).toList();
  }

  public List<CarResponse> filter(String column, String value, Pageable p) {
    return switch (column) {
      case "brand" -> carRepository.findAllByBrand(value, p).stream().map(c -> new CarResponse(c, true)).toList();
      case "color" -> carRepository.findAllByColor(value, p).stream().map(c -> new CarResponse(c, true)).toList();
      case "model" -> carRepository.findAllByModel(value, p).stream().map(c -> new CarResponse(c, true)).toList();
      case "kilometers" ->
          carRepository.findAllByKilometers(Integer.parseInt(value), p).stream().map(c -> new CarResponse(c, true)).toList();
      default -> null;
    };

  }


}
