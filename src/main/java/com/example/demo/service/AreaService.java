package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Area;

public interface AreaService {
	public Area findById(Integer id);

	public List<Area> findAll();

	public void save(Area area) throws Exception;
}
