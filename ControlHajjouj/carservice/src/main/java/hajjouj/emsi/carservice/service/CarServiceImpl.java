package hajjouj.emsi.carservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import hajjouj.emsi.carservice.beans.Car;
import hajjouj.emsi.carservice.beans.Client;
import hajjouj.emsi.carservice.model.CarResponse;
import hajjouj.emsi.carservice.repository.CarRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService{
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private RestTemplate restTemplate;
    private final String URL="http://localhost:8888";
    @Override
    public List<CarResponse> findAll() {
        List<Car> cars = carRepository.findAll();
        Client[] clients = restTemplate.getForObject(URL+"/api/client", Client[].class);
        return cars.stream().map(car -> mapToCarResponse(car, clients)).toList();
    }

    private CarResponse mapToCarResponse(Car car, Client[] clients) {
        Client foundClient = Arrays.stream(clients)
                .filter(client -> client.getClient_id() == car.getId())
                .findFirst()
                .orElse(null);

        return CarResponse.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .client(foundClient)
                .matricue(car.getMatricule())
                .model(car.getModel())
                .build();
    }

    @Override
    public CarResponse findById(Long id) throws Exception {
        Car car= carRepository.findById(id).orElseThrow(()->new Exception("Invalid Car Id"));
        Client client = restTemplate.getForObject(this.URL+"/api/client/"+car.getId(),Client.class);
        return CarResponse.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .client(client)
                .matricue(car.getMatricule())
                .model(car.getModel())
                .build();
    }

    @Override
    public void save(CarResponse car) {
        Car car1 = new Car();
        car1.setId(car.getClient().getClient_id());
        car1.setModel(car.getModel());
        car1.setBrand(car.getBrand());
        car1.setMatricule(car.getMatricue());

        carRepository.save(car1);
    }

    @Override
    public void delete(Long id) throws Exception {
        Car car = carRepository.findById(id).orElseThrow(()->new Exception("Invalid Id"));
        carRepository.delete(car);
    }

    @Override
    public void update(CarResponse carResponse, Long id) throws Exception {
        Car car = carRepository.findById(id).orElseThrow(()->new Exception("Invalid ID"));
        car.setId(carResponse.getClient().getClient_id());
        car.setModel(carResponse.getModel());
        car.setBrand(carResponse.getBrand());
        car.setMatricule(carResponse.getMatricue());

        carRepository.save(car);
    }
}
