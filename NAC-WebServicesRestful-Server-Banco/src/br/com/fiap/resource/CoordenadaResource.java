package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.CoordenadaBO;
import br.com.fiap.entity.Coordenada;
import br.com.fiap.exception.DBException;
import br.com.fiap.exception.IdNotFoundException;

@Path("/coordenada")
public class CoordenadaResource {

	private CoordenadaBO bo = new CoordenadaBO();
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON) //Retorna JSON
	public Coordenada buscar(@PathParam("id") int codigo){
		return bo.buscar(codigo);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Coordenada> listar(){
		return bo.listar();
	}
	
	//POST /rest/coordenada
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON) //Recebe JSON
	public Response cadastrar(Coordenada coordenada, 
								@Context UriInfo uriInfo){
		try {
			bo.cadastrar(coordenada);
		} catch (DBException e) {
			e.printStackTrace();
			throw new WebApplicationException();
		}
		//Construir a URL para acessar a coordenada cadastrada
		//localhost:8080/Projeto/rest/coordenada/codigo
		UriBuilder uri = UriBuilder.fromPath(uriInfo.getPath());
		uri.path(String.valueOf(coordenada.getCodigo()));
		
		return Response.created(uri.build()).build();
	}
	
	
	//PUT /rest/coordenada/1
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Coordenada coordenada, 
							@PathParam("id") int codigo){
		try {
			coordenada.setCodigo(codigo);
			bo.atualizar(coordenada);
		} catch (DBException e) {
			e.printStackTrace();
			throw new WebApplicationException();
		}
		return Response.ok().build(); //HTTP STATUS 200 OK
	}
	

	//DELETE /rest/coordenada/1
	@DELETE
	@Path("/{id}")
	public void remover(@PathParam("id") int codigo){
		try {
			bo.remover(codigo);
		} catch (DBException | IdNotFoundException e) {
			e.printStackTrace();
			throw new WebApplicationException();
		}
	}
	
}



