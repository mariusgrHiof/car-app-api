package no.marius.carappapi.service;

import no.marius.carappapi.exception.CarNotFoundException;
import no.marius.carappapi.exception.UserNotFoundException;
import no.marius.carappapi.model.Car;
import no.marius.carappapi.repo.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
  private final CarRepo carRepo;

  @Autowired
  public CarServiceImpl(CarRepo carRepo) {
    this.carRepo = carRepo;
  }


  @Override
  public List<Car> getAllCars() {
    return carRepo.findAll();
  }

  @Override
  public Car getCarById(Long id) {
    return carRepo.findById(id).orElseThrow(() -> new CarNotFoundException("Car could not be found"));
  }

  @Override
  public Car createCar(Car car) {
    return carRepo.save(car);
  }

  @Override
  public Car updateCar(Car car) {
    return carRepo.save(car);
  }

  @Override
  public void deleteCar(long id) {
    carRepo.deleteById(id);
  }
}
