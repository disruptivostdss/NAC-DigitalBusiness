package br.com.fiap.bo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.axis2.AxisFault;

import br.com.fiap.dao.CoordenadaDAO;
import br.com.fiap.dao.impl.CoordenadaDAOImpl;
import br.com.fiap.entity.Coordenada;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class CoordenadaBO {
	
	private EntityManagerFactory fabrica = 
						EntityManagerFactorySingleton.getInstance();
	
	public void cadastrar(Coordenada c) throws AxisFault{
		EntityManager em = fabrica.createEntityManager();
		CoordenadaDAO dao = new CoordenadaDAOImpl(em);
		try{
		em.persist(c);
		dao.salvar();
		}catch (DBException e) {
			e.printStackTrace();
			throw new AxisFault("Cadastro não realizado");
		}finally {
			em.close();
		}	
	}
	
	public Coordenada findById(int id){
		EntityManager em = fabrica.createEntityManager();
		CoordenadaDAO dao = new CoordenadaDAOImpl(em);
		Coordenada cord = dao.pesquisar(id);
		em.close();
		return cord;		
	}
	
	public List<Coordenada> listar(){
		EntityManager em = fabrica.createEntityManager();
		CoordenadaDAO dao = new CoordenadaDAOImpl(em);
		List<Coordenada> coordenadas = dao.listar();
		return coordenadas;
	}

}
