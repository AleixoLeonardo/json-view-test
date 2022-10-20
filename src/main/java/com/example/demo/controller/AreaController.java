package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Area;
import com.example.demo.service.AreaService;
import com.example.demo.view.AreaView;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/area")
public class AreaController {

	@Autowired
	private AreaService areaService;

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody Area area) {
		try {
			areaService.save(area);
			return new ResponseEntity<String>("", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	@JsonView(AreaView.AreaResumida.class )
	public ResponseEntity<List<Area>> findAll() {
		return new ResponseEntity<List<Area>>(areaService.findAll(), HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	@JsonView(AreaView.AreaCompleta.class )
	public ResponseEntity<Area> findById(@PathVariable Integer id) {
		try {
			return new ResponseEntity<Area>(areaService.findById(id), HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
	}
}
