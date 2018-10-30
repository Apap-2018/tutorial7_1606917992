package com.apap.tutorial7.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tutorial7.model.CarModel;
import com.apap.tutorial7.repository.CarDb;

/**
 * CarServiceImpl
 * @author Raihan Mahendra
 *
 */
@Service
@Transactional
public class CarServiceImpl implements CarService {
	@Autowired
	private CarDb carDb;

	@Override
	public CarModel addCar(CarModel car) {
		return carDb.save(car);
	}

	@Override
	public void deleteCar(CarModel car) {
		carDb.delete(car);
	}

	@Override
	public Optional<CarModel> getCarDetailById(Long id) {
		return carDb.findById(id);
	}

	@Override
	public void updateCar(Long oldCarId, CarModel newCar) {
		CarModel car = carDb.findById(oldCarId).get();
		car.setBrand(newCar.getBrand());
		car.setType(newCar.getType());
		car.setPrice(newCar.getPrice());
		car.setAmount(newCar.getAmount());
	}

	@Override
	public List<CarModel> getAllCar() {
		return carDb.findAll();
	}
	
}
