package no.marius.carappapi.service;

import no.marius.carappapi.model.Car;

import java.util.List;

public interface CarService {
  List<Car> getAllCars();

  Car getCarById(Long id);

  Car createCar(Car car);

  Car updateCar(Car car);

  void deleteCar(long id);
}
