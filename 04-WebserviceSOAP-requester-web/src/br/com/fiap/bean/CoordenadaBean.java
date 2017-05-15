package br.com.fiap.bean;


import java.rmi.RemoteException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.axis2.AxisFault;

import br.com.fiap.bo.CoordenadaBOStub;
import br.com.fiap.bo.CoordenadaBOStub.Cadastrar;
import br.com.fiap.bo.CoordenadaBOStub.Coordenada;
import br.com.fiap.bo.CoordenadaBOStub.FindById;
import br.com.fiap.bo.CoordenadaBOStub.FindByIdResponse;
import br.com.fiap.bo.CoordenadaBOStub.Listar;

@ManagedBean
public class CoordenadaBean {
	
	private Coordenada coordenada;
	
	private CoordenadaBOStub bo;
	
	Coordenada[] coordenadas;
	
	@SuppressWarnings("unused")
	private void init() {
		coordenada = new Coordenada();
		try {
			bo = new CoordenadaBOStub();
		} catch (AxisFault e) {
			e.printStackTrace();
		}
	}
	
	public void Cadastrar(){
		FacesMessage msg;
		try {
			Cadastrar params = new Cadastrar();
			params.setC(coordenada);
			bo.cadastrar(params);
			msg = new FacesMessage("Cadastrado!");
		} catch (RemoteException e) {
			
			e.printStackTrace();
			msg = new FacesMessage("Erro");
		}
		
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	@SuppressWarnings("unused")
	public Coordenada[] listar(){
		try {
			Listar l = new Listar();
			Coordenada[] coordenadas = bo.listar(l).get_return();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return coordenadas;
	}
	
	public Coordenada buscar(int codigo){
		
		
		try {
			FindById param = new FindById();
			param.setId(codigo);
			FindByIdResponse response = bo.findById(param);
			coordenada = response.get_return();
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return coordenada;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Coordenada c) {
		this.coordenada = c;
	}

	public CoordenadaBOStub getBo() {
		return bo;
	}

	public void setBo(CoordenadaBOStub bo) {
		this.bo = bo;
	}
	
	

}
