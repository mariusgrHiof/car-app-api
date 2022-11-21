package no.marius.carappapi.repo;

import no.marius.carappapi.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface CarRepo extends JpaRepository<Car, Long> {

}
