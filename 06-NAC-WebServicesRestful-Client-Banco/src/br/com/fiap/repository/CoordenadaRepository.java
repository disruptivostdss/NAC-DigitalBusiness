package br.com.fiap.repository;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.exception.WebServiceException;
import br.com.fiap.to.CoordenadaTO;

public class CoordenadaRepository {
	
	//Atenção à porta do localhost ************************************
	private static final String URL = "http://localhost:8081/05-NAC-WebServicesRestful-Server-Banco/rest/coordenada/";
	
	private Client client = Client.create();
	
	
	//Método LISTAR
	public List<CoordenadaTO> listar() throws WebServiceException{
		
		WebResource resource = client.resource(URL);
		
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if(response.getStatus() != 200){
			throw new WebServiceException("Http Status: " + response.getStatus());
		}
		
		CoordenadaTO[] array = response.getEntity(CoordenadaTO[].class);
		
		return Arrays.asList(array);
		
	}
	
	
	//Método BUSCAR
	public CoordenadaTO buscar(int codigo) throws WebServiceException{
		
		WebResource resource = client.resource(URL + codigo);
		
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if (response.getStatus() != 200){
			throw new WebServiceException("Http Status: " + response.getStatus());
		}
		
		return response.getEntity(CoordenadaTO.class);
	}
	
	
	//Método CADASTRAR
	public void cadastrar(CoordenadaTO coordenada) throws WebServiceException{
		
		WebResource resource = client.resource(URL);
		
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class,coordenada);
		
		if(response.getStatus() != 201){
			throw new WebServiceException("Http Status: " + response.getStatus());
		}
			
	}
	
	//Método ATUALIZAR
	public void atualizar(CoordenadaTO coordenada) throws WebServiceException{
		WebResource resource = client.resource(URL + coordenada.getCodigo());
		
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class,coordenada);
		
		if(response.getStatus() != 200){
			throw new WebServiceException("Http Status: " + response.getStatus());
		}
		
	}
	
	//Método REMOVER
	public void remover (int codigo) throws WebServiceException{
		WebResource resource = client.resource(URL + codigo);
		
		ClientResponse response = resource.delete(ClientResponse.class);
		
		if (response.getStatus() != 204){
			throw new WebServiceException("Http Status: " + response.getStatus());
		}
	}
	
	
	
	
	
	
	
}
