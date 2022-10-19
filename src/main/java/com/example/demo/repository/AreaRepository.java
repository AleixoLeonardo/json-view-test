package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Area;

@Repository
public interface AreaRepository extends CrudRepository<Area, Integer> {

	public List<Area> findAll();

}
