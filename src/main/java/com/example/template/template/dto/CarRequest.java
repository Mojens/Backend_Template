package com.example.template.template.dto;

import com.example.template.template.entity.Car;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CarRequest {

  private Integer id;
  private String brand;
  private String model;
  private String color;
  private Integer kilometers;

  public static Car getCarEntity(CarRequest carRequest){
    return Car.builder()
        .id(carRequest.id)
        .brand(carRequest.brand)
        .model(carRequest.model)
        .color(carRequest.color)
        .kilometers(carRequest.kilometers)
        .build();
  }

  public CarRequest(Car c){
    this.id = c.getId();
    this.brand = c.getBrand();
    this.model = c.getModel();
    this.color = c.getColor();
    this.kilometers = c.getKilometers();
  }

}
