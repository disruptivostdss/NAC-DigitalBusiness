package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.CoordenadaDAO;
import br.com.fiap.entity.Coordenada;

public class CoordenadaDAOImpl extends GenericDAOImpl<Coordenada, Integer> implements CoordenadaDAO {

	public CoordenadaDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<Coordenada> listar() {
		TypedQuery<Coordenada> query = 
				em.createQuery("from Coordenada",Coordenada.class);
		return query.getResultList();
	}

}
