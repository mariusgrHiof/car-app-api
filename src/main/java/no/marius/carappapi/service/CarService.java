package no.marius.carappapi.service;

import no.marius.carappapi.exception.UserNotFoundException;
import no.marius.carappapi.model.Car;
import no.marius.carappapi.repo.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepo carRepo;

    @Autowired
    public CarService(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    public Car addCar(Car car) {
        car.setMake("Ford");
        car.setModel("Focus RS MK3");
        car.setHp(410);

        return carRepo.save(car);
    }

    public List<Car> findAllCars(){
        return carRepo.findAll();
    }

    public Car updateCar(Car car){
        return carRepo.save(car);
    }

    public Car findCarById(Long id){
        return carRepo.findCarById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found") );
    }

    public void deleteCar(Long id){
        carRepo.deleteCarById(id);
    }


}
