package com.example.template.template.repository;

import com.example.template.template.entity.Car;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {

  List<Car> findAllByBrand(String brand, Pageable pageable);
  List<Car> findAllByColor(String color, Pageable pageable);
  List<Car> findAllByModel(String model, Pageable pageable);
  List<Car> findAllByKilometers(int kilometers, Pageable pageable);
}
