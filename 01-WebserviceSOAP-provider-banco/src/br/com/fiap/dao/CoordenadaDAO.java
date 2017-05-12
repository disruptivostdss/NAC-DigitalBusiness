package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Coordenada;

public interface CoordenadaDAO extends GenericDAO<Coordenada, Integer> {
	
	List<Coordenada> listar();

}
