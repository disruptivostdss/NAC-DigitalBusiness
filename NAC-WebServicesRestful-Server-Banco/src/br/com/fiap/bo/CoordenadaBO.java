package br.com.fiap.bo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.CoordenadaDAO;
import br.com.fiap.dao.impl.CoordenadaDAOImpl;
import br.com.fiap.entity.Coordenada;
import br.com.fiap.exception.DBException;
import br.com.fiap.exception.IdNotFoundException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class CoordenadaBO {

	private EntityManagerFactory fabrica = 
			EntityManagerFactorySingleton.getInstance();
	
	public void cadastrar(Coordenada coordenada) throws DBException {
		EntityManager em = fabrica.createEntityManager();
		CoordenadaDAO dao = new CoordenadaDAOImpl(em);
		dao.cadastrar(coordenada);
		dao.salvar();
		em.close();
	}
	
	public void atualizar(Coordenada coordenada) throws DBException{
		EntityManager em = fabrica.createEntityManager();
		CoordenadaDAO dao = new CoordenadaDAOImpl(em);
		dao.alterar(coordenada);
		dao.salvar();
		em.close();
	}
	
	public void remover(int codigo) throws DBException, IdNotFoundException{
		EntityManager em = fabrica.createEntityManager();
		CoordenadaDAO dao = new CoordenadaDAOImpl(em);
		dao.remover(codigo);
		dao.salvar();
		em.close();
	}
	
	public Coordenada buscar(int codigo){
		EntityManager em = fabrica.createEntityManager();
		CoordenadaDAO dao = new CoordenadaDAOImpl(em);
		Coordenada coordenada = dao.pesquisar(codigo);
		em.close();
		return coordenada;
	}
	
	public List<Coordenada> listar(){
		EntityManager em = fabrica.createEntityManager();
		CoordenadaDAO dao = new CoordenadaDAOImpl(em);
		List<Coordenada> lista = dao.listar();
		em.close();
		return lista;
	}
	
}
