package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CoordenadaDAO;
import br.com.fiap.entity.Coordenada;

public class CoordenadaDAOImpl 
			extends GenericDAOImpl<Coordenada, Integer>
									implements CoordenadaDAO{

	public CoordenadaDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Coordenada> listar() {
		return em.createQuery("from Coordenada",
				Coordenada.class).getResultList();
	}

}

