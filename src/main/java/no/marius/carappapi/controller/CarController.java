package no.marius.carappapi.controller;

import no.marius.carappapi.model.Car;
import no.marius.carappapi.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "http://localhost:4200")
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

        return new ResponseEntity<>(newCar, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable("id") Long id, @RequestBody Car car){
        if(!Objects.equals(id, car.getId())) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Car updateCar = carService.updateCar(car);

        return new ResponseEntity<>(updateCar, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable("id") Long id){
        carService.deleteCar(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
