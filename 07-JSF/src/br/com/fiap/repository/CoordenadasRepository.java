package br.com.fiap.repository;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.xml.ws.WebServiceException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.to.CoordenadasTO;

public class CoordenadasRepository {


	private static final String URL = "http://localhost:8080/05-NAC-WebServicesRestful-Server-Banco/rest/coordenada/";

	private Client client = Client.create();
	
	public List<CoordenadasTO> listar(){
		WebResource resource = client.resource(URL);
		
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if(response.getStatus() != 200){
			throw new WebServiceException("Http Status: " +response.getStatus());
		}
		
		CoordenadasTO[] array = response.getEntity(CoordenadasTO[].class);
		
		return Arrays.asList(array);
	}
	
	public CoordenadasTO buscar(int codigo) {
		WebResource resource = client.resource(URL + codigo);
		
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if(response.getStatus() != 200){
			throw new WebServiceException("Http Status: " +response.getStatus());
		}
		
		return response.getEntity(CoordenadasTO.class);
		
	}
	
	public void cadastrar(CoordenadasTO coordenadas){
		WebResource resource = client.resource(URL);
		
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).post(ClientResponse.class, coordenadas);
		
		if(response.getStatus() != 200){
			throw new WebServiceException("Http Status: " +response.getStatus());
		}
	}
	
	public void atualizar(CoordenadasTO coordenadas){
		WebResource resource = client.resource(URL + coordenadas.getCodigo());
		
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).put(ClientResponse.class, coordenadas);
		
		if(response.getStatus() != 200){
			throw new WebServiceException("Http Status: " +response.getStatus());
		}
	}
	
	public void remover(int codigo){
		WebResource resource = client.resource(URL + codigo);
		
		ClientResponse response = resource.delete(ClientResponse.class);
		
		if(response.getStatus() != 200){
			throw new WebServiceException("Http Status: " +response.getStatus());
		}
		
	}
}