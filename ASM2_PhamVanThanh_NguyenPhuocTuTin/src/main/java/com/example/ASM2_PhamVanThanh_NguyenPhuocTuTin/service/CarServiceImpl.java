package com.example.ASM2_PhamVanThanh_NguyenPhuocTuTin.service;

import com.example.ASM2_PhamVanThanh_NguyenPhuocTuTin.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private List<Car> cars = new ArrayList<>();

    @Override
    public List<Car> getAllCars() {
        return cars;
    }

    @Override
    public Car getCarByLicensePlate(String licensePlate) {
        return cars.stream()
                .filter(car -> car.licensePlate().equals(licensePlate))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Car not found"));
    }

    @Override
    public void addCar(Car car) {
        cars.add(car);
    }

    @Override
    public void updateCar(String licensePlate, Car car) {
        Car existingCar = getCarByLicensePlate(licensePlate);
        cars.set(cars.indexOf(existingCar), car);
    }

    @Override
    public void deleteCar(String licensePlate) {
        Car existingCar = getCarByLicensePlate(licensePlate);
        cars.remove(existingCar);
    }

    @Override
    public List<Car> searchCarsByLicensePlate(String licensePlate) {
        return cars.stream()
                .filter(car -> car.licensePlate().contains(licensePlate))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> searchCarsByNumberOfSeats(int numberOfSeats) {
        return cars.stream()
                .filter(car -> car.numberOfSeats() == numberOfSeats)
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> searchCarsByYear(int year) {
        return cars.stream()
                .filter(car -> car.productionDate().getYear() == year)
                .collect(Collectors.toList());
    }
}
