package br.com.fiap.bean;


import javax.faces.bean.ManagedBean;

import org.apache.axis2.AxisFault;

import br.com.fiap.bo.CoordenadaBOStub;
import br.com.fiap.bo.CoordenadaBOStub.Coordenada;

@ManagedBean
public class CoordenadaBean {
	
	private Coordenada c;
	
	private CoordenadaBOStub bo;
	
	@SuppressWarnings("unused")
	private void init() {
		c = new Coordenada();
		try {
			bo = new CoordenadaBOStub();
		} catch (AxisFault e) {
			e.printStackTrace();
		}
	}

	public Coordenada getC() {
		return c;
	}

	public void setC(Coordenada c) {
		this.c = c;
	}

	public CoordenadaBOStub getBo() {
		return bo;
	}

	public void setBo(CoordenadaBOStub bo) {
		this.bo = bo;
	}
	
	

}
