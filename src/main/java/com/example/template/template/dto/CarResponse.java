package com.example.template.template.dto;

import com.example.template.template.entity.Car;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarResponse {

  private int id;
  private String brand;
  private String model;
  private String color;
  private int kilometers;

  public CarResponse(Car c) {
    this.id = c.getId();
    this.brand = c.getBrand();
    this.model = c.getModel();
    this.color = c.getColor();
    this.kilometers = c.getKilometers();
  }
}
