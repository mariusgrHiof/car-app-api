package no.marius.carappapi.controller;

import no.marius.carappapi.model.Car;
import no.marius.carappapi.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars(){
        List<Car> cars = carService.findAllCars();

        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") Long id){

        Car car = carService.findCarById(id);

        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Car> addCar(@RequestBody Car car){
        Car newCar = carService.addCar(car);

        return new ResponseEntity<>(car, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Car> updateCar(@RequestBody Car car){
        Car updateCar = carService.updateCar(car);

        return new ResponseEntity<>(updateCar, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable("id") Long id){
        carService.deleteCar(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
