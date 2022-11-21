package no.marius.carappapi.controller;

import no.marius.carappapi.model.Car;
import no.marius.carappapi.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CarController {

  private CarServiceImpl carServiceImpl;

  @Autowired
  public CarController(CarServiceImpl carServiceImpl) {

    this.carServiceImpl = carServiceImpl;
  }

  @GetMapping("/cars")
  public ResponseEntity<List<Car>> getAllCars() {
    List<Car> cars = carServiceImpl.getAllCars();

    return new ResponseEntity<>(cars, HttpStatus.OK);
  }

  @GetMapping("/cars/{id}")
  public ResponseEntity<Car> getCar(@PathVariable("id") long id) {
    Car car = carServiceImpl.getCarById(id);
    return new ResponseEntity<>(car, HttpStatus.OK);
  }

  @PostMapping("/car/add")
  public ResponseEntity<Car> createCar(@RequestBody Car car) {
    Car newCar = carServiceImpl.createCar(car);
    return new ResponseEntity<>(newCar, HttpStatus.CREATED);
  }

  @PutMapping("/car/update/{id}")
  public ResponseEntity<Car> updateCar(@RequestBody Car updateCar, @PathVariable("id") Long id) {
    Car car = carServiceImpl.getCarById(id);
    car.setHp(updateCar.getHp());
    car.setMake(updateCar.getMake());
    car.setModel(updateCar.getModel());
    car.setImageUrl(updateCar.getImageUrl());

    carServiceImpl.updateCar(car);


    return new ResponseEntity<>(car, HttpStatus.OK);
  }


  @DeleteMapping("/car/delete/{id}")
  public ResponseEntity<?> deleteCar(@PathVariable("id") Long id) {
    Car car = carServiceImpl.getCarById(id);
    carServiceImpl.deleteCar(id);


    return new ResponseEntity<>(car, HttpStatus.OK);

  }

}
