package br.com.fiap.view;

import org.apache.axis2.AxisFault;

import br.com.fiap.bo.CoordenadaBO;
import br.com.fiap.entity.Coordenada;

public class TesteCadastro {
	
	public static void main(String[] args) {
		try {
		Coordenada c = new Coordenada();
		c.setLatidude(123123);
		c.setLongitude(123123);
		c.setNomeLocal("FIAP");
		
		CoordenadaBO bo = new CoordenadaBO();
		
		
			bo.cadastrar(c);
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
