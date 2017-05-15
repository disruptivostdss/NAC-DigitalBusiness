package br.com.fiap.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.CoordenadaRepository;
import br.com.fiap.to.CoordenadaTO;

@ManagedBean
public class CoordenadaBean {
	
	private CoordenadaTO coordenada;
	private CoordenadaRepository rep;
	
	@PostConstruct
	public void init(){
		coordenada = new CoordenadaTO();
		rep = new CoordenadaRepository();
	}
	
	public String cadastrar(){
		FacesMessage msg = null;
		try {
			rep.cadastrar(coordenada);
			coordenada = null;
			msg = new FacesMessage("Coordenada Cadastrada com Sucesso!");
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		return "lista-coordenada??faces-redirect=true";
	}
	
	public List<CoordenadaTO> listar(){
		List<CoordenadaTO> lista = new ArrayList<CoordenadaTO>();
		
		try {
			lista = rep.listar();
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public CoordenadaTO buscar(int codigo){
		try {
			coordenada = rep.buscar(codigo);
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
		return coordenada;
	}

	public CoordenadaTO getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(CoordenadaTO coordenada) {
		this.coordenada = coordenada;
	}
	
	

}
