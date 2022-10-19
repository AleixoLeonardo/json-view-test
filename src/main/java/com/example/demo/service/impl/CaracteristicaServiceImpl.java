package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Caracteristica;
import com.example.demo.repository.CaracteristicaRepository;
import com.example.demo.service.CaracteristicaService;

@Service
public class CaracteristicaServiceImpl implements CaracteristicaService {

	@Autowired
	private CaracteristicaRepository caracteristicaRepository;

	@Override
	public Caracteristica findById(Integer id) {
		Optional<Caracteristica> optionalCaracteristica = caracteristicaRepository.findById(id);
		if (optionalCaracteristica.isPresent()) {
			return optionalCaracteristica.get();
		}
		return null;
	}

	@Override
	public List<Caracteristica> findAll() {
		return caracteristicaRepository.findAll();

	}

	@Override
	public void save(Caracteristica caracteristica) {
		caracteristicaRepository.save(caracteristica);
	}

}
