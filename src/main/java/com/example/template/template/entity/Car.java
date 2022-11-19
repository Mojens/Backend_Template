package com.example.template.template.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;


@ToString
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
  @Id
  int id;

  String brand;

  String model;

  String color;

  int kilometers;
}
