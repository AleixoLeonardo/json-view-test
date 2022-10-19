package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Caracteristica;

@Repository
public interface CaracteristicaRepository extends CrudRepository<Caracteristica, Integer> {
	public List<Caracteristica> findAll();

}
