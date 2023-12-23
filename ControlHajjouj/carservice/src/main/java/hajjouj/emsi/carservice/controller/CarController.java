package hajjouj.emsi.carservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import hajjouj.emsi.carservice.beans.Car;
import hajjouj.emsi.carservice.beans.Client;
import hajjouj.emsi.carservice.model.CarResponse;
import hajjouj.emsi.carservice.service.CarService;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000/","http://localhost:4200/"})
@RequestMapping("api/car")
public class CarController {
    @Autowired
    private CarService carService;
    @GetMapping
    public List<CarResponse> findAll(){
        return carService.findAll();
    }

    @GetMapping("/{id}")
    public CarResponse findById(@PathVariable Long id) throws Exception {return carService.findById(id);}

    @PostMapping
    public void add(@RequestBody CarResponse car){carService.save(car);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws Exception {carService.delete(id);}

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,@RequestBody CarResponse carResponse) throws Exception {carService.update(carResponse,id);}
}
