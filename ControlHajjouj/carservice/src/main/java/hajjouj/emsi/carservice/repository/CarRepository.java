package hajjouj.emsi.carservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hajjouj.emsi.carservice.beans.Car;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> { }
