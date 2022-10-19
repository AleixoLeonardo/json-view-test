package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Usuario;

public interface UsuarioService {

	public Usuario findById(Integer id);
	
	public List<Usuario> findAll();
	
	public void save(Usuario usuario);
}
