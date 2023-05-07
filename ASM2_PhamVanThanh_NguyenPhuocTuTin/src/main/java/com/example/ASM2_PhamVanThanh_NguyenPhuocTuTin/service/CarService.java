package com.example.ASM2_PhamVanThanh_NguyenPhuocTuTin.service;

import com.example.ASM2_PhamVanThanh_NguyenPhuocTuTin.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getAllCars();
    Car getCarByLicensePlate(String licensePlate);
    void addCar(Car car);
    void updateCar(String licensePlate, Car car);
    void deleteCar(String licensePlate);
    List<Car> searchCarsByLicensePlate(String licensePlate);
    List<Car> searchCarsByNumberOfSeats(int numberOfSeats);
    List<Car> searchCarsByYear(int year);
}

