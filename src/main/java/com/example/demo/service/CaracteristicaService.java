package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Caracteristica;

public interface CaracteristicaService {
	public Caracteristica findById(Integer id);

	public List<Caracteristica> findAll();

	public void save(Caracteristica caracteristica);
}
