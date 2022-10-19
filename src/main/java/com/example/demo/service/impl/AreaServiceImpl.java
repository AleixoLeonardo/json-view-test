package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Area;
import com.example.demo.repository.AreaRepository;
import com.example.demo.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaRepository areaRepository;

	@Override
	public Area findById(Integer id) {
		Optional<Area> optionalArea = areaRepository.findById(id);
		if (optionalArea.isPresent()) {
			return optionalArea.get();
		}
		return null;
	}

	@Override
	public List<Area> findAll() {
		return areaRepository.findAll();
	}

	@Override
	public void save(Area area) {
		areaRepository.save(area);
	}

}
