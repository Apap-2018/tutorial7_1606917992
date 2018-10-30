package com.apap.tutorial7.service;

import java.util.List;
import java.util.Optional;

import com.apap.tutorial7.model.CarModel;

/**
 * CarService
 * @author Raihan Mahendra
 *
 */
public interface CarService {
	CarModel addCar(CarModel car);
	
	void deleteCar(CarModel car);
	
	Optional<CarModel> getCarDetailById(Long id);
	
	void updateCar(Long oldCarId, CarModel newCar);
	
	List<CarModel> getAllCar();
}
