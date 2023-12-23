package hajjouj.emsi.carservice.service;

import java.util.List;

import hajjouj.emsi.carservice.beans.Car;
import hajjouj.emsi.carservice.model.CarResponse;

public interface CarService {
    List<CarResponse> findAll();
    CarResponse findById(Long id) throws Exception;
    void save(CarResponse car);
    void delete(Long id) throws Exception;
    void update(CarResponse carResponse, Long id) throws Exception;
    
}
