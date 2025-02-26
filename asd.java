package com.example.Car.Controllers;

import com.example.Car.Models.CarModel;
import com.example.Car.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.coyote.http11.Constants.a;

@RestController
public class CarController {
    @Autowired
    private CarRepository carRepository;
//    @PostMapping("/Add") //json format output
//    public ResponseEntity<Map<String,String>> addCar(@RequestBody CarModel c){
//        CarModel cobj = CarRepository.save(c);
//        Map<String,String> response = new HashMap<>();
//        response.put("status" ,"success");
//        return ResponseEntity.ok(response);
//    }

    @PostMapping("/CarEntry")
    public String carEntry(@RequestBody CarModel m){
        CarModel movieObj = carRepository.save(m);
        return "Car added successfully. " ;
    }

    @GetMapping("/Viewall")
    public ResponseEntity<List<CarModel>> viewcar(){
        return ResponseEntity.ok(carRepository.findAll());
    }

    @PostMapping("/SearchVehicle")
    public ResponseEntity<List<CarModel>> search(@RequestBody CarModel a){
        List<CarModel> carObj = carRepository.searchVehicle(a.vno);
        //String name1 = carObj.get(0).colour;
        return ResponseEntity.ok(carObj);
    }

    @PostMapping("/update")
    public String update(@RequestBody CarModel c){
        carRepository.updatevehicle(c.vno,c.colour,c.company,c.mrp,c.name);
        return "Success";

    }


}


