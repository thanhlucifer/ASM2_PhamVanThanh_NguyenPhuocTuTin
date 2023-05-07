package com.example.ASM2_PhamVanThanh_NguyenPhuocTuTin.controller;

import com.example.ASM2_PhamVanThanh_NguyenPhuocTuTin.model.Car;
import com.example.ASM2_PhamVanThanh_NguyenPhuocTuTin.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{licensePlate}")
    public Car getCarByLicensePlate(@PathVariable String licensePlate) {
        return carService.getCarByLicensePlate(licensePlate);
    }

    @PostMapping
    public void addCar(@RequestBody Car car) {
        carService.addCar(car);
    }

    @PutMapping("/{licensePlate}")
    public void updateCar(@PathVariable String licensePlate, @RequestBody Car car) {
        carService.updateCar(licensePlate, car);
    }

    @DeleteMapping("/{licensePlate}")
    public void deleteCar(@PathVariable String licensePlate) {
        carService.deleteCar(licensePlate);
    }

    @GetMapping("/search")
    public List<Car> searchCars(
            @RequestParam(required = false) String licensePlate,
            @RequestParam(required = false) Integer seats,
            @RequestParam(required = false) Integer year) {
        if (licensePlate != null) {
            return carService.searchCarsByLicensePlate(licensePlate);
        } else if (seats != null) {
            return carService.searchCarsByNumberOfSeats(seats);
        } else if (year != null) {
            return carService.searchCarsByYear(year);
        } else {
            throw new RuntimeException("Invalid search criteria");
        }
    }
}
