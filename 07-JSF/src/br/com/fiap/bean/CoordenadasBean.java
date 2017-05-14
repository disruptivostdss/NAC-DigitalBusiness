package br.com.fiap.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.fiap.repository.CoordenadasRepository;
import br.com.fiap.to.CoordenadasTO;

@ManagedBean
public class CoordenadasBean {
	
	private CoordenadasRepository rep;
	private CoordenadasTO coordenadas;
	
	@PostConstruct
	public void onInit(){
		rep = new CoordenadasRepository();
		coordenadas = new CoordenadasTO();
	}

	public void cadastrar(){
		try{
			rep.
		}
	}
	
	public CoordenadasTO getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(CoordenadasTO coordenadas) {
		this.coordenadas = coordenadas;
	}
	
	
}
